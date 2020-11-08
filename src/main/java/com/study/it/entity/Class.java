package com.study.it.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("bear.class")
public class Class {
   
	@TableId(value="id",type=IdType.AUTO)
	private int id;
	
	@TableField("name")
	private String name;
}
