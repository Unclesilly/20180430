package com.study.it.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.it.dao.StudentMapper;
import com.study.it.entity.Student;
import com.study.it.service.StudentService;
@Service
public class StudentServiceImple extends ServiceImpl<StudentMapper, Student>
   implements StudentService{

}
