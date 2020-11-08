package com.study.it.controller;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.it.dao.StudentMapper;
import com.study.it.entity.Student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("测试接口")
@RestController
@RequestMapping("/myapp")
public class MyController {
    
	
	@Autowired(required = false)
	private StudentMapper studentMapper;
	
	@GetMapping("/student")
	@ApiOperation("获取学生信息")
	public Student getData() {
		return studentMapper.selectById(1);
	}
}
