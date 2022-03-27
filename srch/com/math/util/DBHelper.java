package com.math.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//帮助我们取得数据库的连接
public class DBHelper {
    private static String url="jdbc:mysql://localhost:3306/math?serverTimezone=UTC";
    private static String user="root";
    private static String password="";
    
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("---驱动加载成功---\n\n");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		 try {
			return DriverManager.getConnection(url, user,password);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		 return null;
	}
	
}
