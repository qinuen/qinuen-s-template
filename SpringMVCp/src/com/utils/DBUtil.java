package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/* ������
 * 1)�����ṩ�ķ����ǹ�����public
 * 2)����Ҫ��������Ķ���ֱ�ӿ��Ե��ø������ṩ��һЩ����
 * ֻ�����������е��ã�������һ����̬�ķ���
 */
public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/base";
	private static final String USER = "root";
	private static final String PWD = "root";
	
	private static Connection conn = null;
	
	//��̬����飬������Դ������ֻ��Ҫִ��һ�ε�����
	static{
		//�������ݿ�����������Ҫÿһ�μ��أ�ֻ��Ҫһ��
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("���ݿ��������سɹ�");
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ���������ʧ��");
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ���ݿ����Ӷ���
	 * @return
	 */
	public static Connection getConn(){
		try {
			//�������ݿ�����
			conn = DriverManager
				.getConnection(URL, USER,PWD);
			//System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			System.out.println("���ݿ����ӳ���");
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * �ͷ����ݿ��������Դ
	 */
	public static void close(){
		if(conn != null){
			try {
				conn.close();
				System.out.println("�ر����ݿ����ӳɹ�");
			} catch (SQLException e) {
				System.out.println("�ر����ݿ�����ʧ��");
				e.printStackTrace();
			}
		}
	}
	
}


