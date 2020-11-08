package com.study.it.controller;

import java.util.ArrayList;
import java.util.List;

public class Test {
   
	public static void main(String[] args) {
		
		
	}
	
   private List<List<Integer>> handleData(Integer[] a){
	   List<List<Integer>> list = new ArrayList<List<Integer>>();
	   List<Integer> group =null;
	   int len = a.length;
	   int previous =-1;
	   for(int i=0;i<len;i++) {
		 if(previous != a[i]-1) {
			 if(group != null) {
				 list.add(group);
			 }
			 group = new ArrayList<>();
		 } 
		 previous = a[i];
		 group.add(a[i]);
		 
		 if(i == len-1) {
			list.add(group); 
		 }
	  }
	   
	   return list;
   }
	
	
	
}
