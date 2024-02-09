package com.task.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static String url ="jdbc:mysql://@localhost:3306/cruddb";
	public static String username = "root";
	public static String password = "Manasa@46";
	public static Connection connection = null;
	public static Connection getDBConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
		
	}
    public static void  getDBDestroyConnection() throws SQLException {
		connection.close();
		
	}

}
