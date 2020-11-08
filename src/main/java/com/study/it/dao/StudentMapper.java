package com.study.it.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.it.entity.Student;
@Mapper
public interface StudentMapper extends BaseMapper<Student>{

}
