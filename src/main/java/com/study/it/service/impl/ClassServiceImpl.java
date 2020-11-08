package com.study.it.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.it.dao.ClassMapper;
import com.study.it.service.ClassService;
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper,Class>
    implements ClassService{

}
