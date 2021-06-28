package com.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	public static Connection connection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/1lAIHXc8Va?autoReconnect=true&useSSL=false", "1lAIHXc8Va", "TEMA3CTgGO");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
