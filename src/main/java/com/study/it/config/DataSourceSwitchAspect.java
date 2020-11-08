package com.study.it.config;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
@Order(-100)//这是为了保证AOP在事务注解生效，Order的值越小，优先级越高
public class DataSourceSwitchAspect {
     
	@Pointcut("execution(* com.study.it.dao..*.*(..))")
	public void jarvisAspect() {
		
	}
	
	@Pointcut("execution(* com.study.it.dao..*.*(..))")
    private void jarvisWxAspect() {
    }

    @Before("jarvisAspect()")
    public void jarvisDb() {
        log.info("切换到ted 数据源...");
        DbContextHolder.setDbType("ted");
    }

    @Before("jarvisWxAspect()")
    public void jarvisWxDb () {
        log.info("切换到Wbear 数据源...");
        DbContextHolder.setDbType("bear");
    }
	
}
