package com.study.it.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;

@Configuration
@MapperScan("com.study.it.dao.*.mapper")
public class MybatisPlusConfig {
    
	
	@Bean
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		
		//SQL是否格式化，默认false
		performanceInterceptor.setFormat(true);
		return performanceInterceptor;
	}
	
	
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor page = new PaginationInterceptor();
		page.setDialectType("mysql");
		return page;
	}
	
	@Bean(name="ted")
	@ConfigurationProperties(prefix ="spring.datasource.druid.ted")
	public DataSource ted() {
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean(name="bear")
	@ConfigurationProperties(prefix ="spring.datasource.druid.bear")
	public DataSource bear() {
		return DruidDataSourceBuilder.create().build();
	}
	
	/**
	 * 动态数据源配置
	 */
	@Bean
	@Primary
	public DataSource multipleDataSource(@Qualifier("ted") DataSource ted,
			@Qualifier("bear") DataSource bear) {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		Map<Object,Object> targetDataSource = new HashMap<>();
		targetDataSource.put("ted", ted);
		targetDataSource.put("bear", bear);
		dynamicDataSource.setTargetDataSources(targetDataSource);
		dynamicDataSource.setDefaultTargetDataSource(ted);
		return dynamicDataSource;
	}
	
	@Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(multipleDataSource(ted(),bear()));
        //sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*/*Mapper.xml"));

        MybatisConfiguration configuration = new MybatisConfiguration();
        //configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setPlugins(new Interceptor[]{ //PerformanceInterceptor(),OptimisticLockerInterceptor()
                paginationInterceptor() //添加分页功能
        });
//        sqlSessionFactory.setGlobalConfig(globalConfiguration());
        return sqlSessionFactory.getObject();
    }
	
	
	
}
