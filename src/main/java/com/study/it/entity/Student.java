package com.study.it.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("ted.student")
public class Student {
   
	@TableId(value="id",type=IdType.AUTO)
	private int id;
	
	@TableField("name")
	private String name;
	
	@TableField("address")
	private String address;
	
	@TableField("classId")
	private int classId;
}
