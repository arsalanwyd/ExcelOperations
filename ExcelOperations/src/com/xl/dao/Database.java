package com.xl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	public Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/";
		String db = "goldenelite";
		String username = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url + db, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
