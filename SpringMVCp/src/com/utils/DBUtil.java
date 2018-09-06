package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/* 工具类
 * 1)对外提供的方法是公开的public
 * 2)不需要创建该类的对象，直接可以调用该类中提供的一些方法
 * 只能用类名进行调用，必须是一个静态的方法
 */
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/base";
	private static final String USER = "root";
	private static final String PWD = "root";
	
	private static Connection conn = null;
	
	//静态代码块，加载资源，加载只需要执行一次的内容
	static{
		//加载数据库驱动，不需要每一次加载，只需要一次
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("数据库驱动加载成功");
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动加载失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库连接对象
	 * @return
	 */
	public static Connection getConn(){
		try {
			//进行数据库连接
			conn = DriverManager
				.getConnection(URL, USER,PWD);
			//System.out.println("数据库连接成功");
		} catch (Exception e) {
			System.out.println("数据库连接出错");
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放数据库的连接资源
	 */
	public static void close(){
		if(conn != null){
			try {
				conn.close();
				System.out.println("关闭数据库连接成功");
			} catch (SQLException e) {
				System.out.println("关闭数据库连接失败");
				e.printStackTrace();
			}
		}
	}
	
}


