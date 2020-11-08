package com.study.it.config;

public class DbContextHolder {
   
	private static final ThreadLocal contextHolder = new ThreadLocal<>();
	
	/**
	 * 设置数据源
	 * @param type
	 */
	public static void setDbType(String type) {
		contextHolder.set(type);
	}
	
	/**
	 * 取得当前数据源
	 * @return
	 */
	public static String getDbType() {
		return (String) contextHolder.get();
	}
	
	/**
	 * 清除上下文
	 */
	public static void clearDbType() {
		contextHolder.remove();
	}
}
