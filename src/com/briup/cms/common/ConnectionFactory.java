package com.briup.cms.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	static {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://127.0.0.1:3306/cms34?useUnicode=true&amp;characterEncoding=UTF-8";
		user = "root";
		password = "123";
	}

	public static Connection getConn() {
		Connection conn = null;
		try {
			//注册驱动
			Class.forName(driver);
			//获取连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
