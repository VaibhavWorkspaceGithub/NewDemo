package com.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionNew {
	

	public  Connection getConnection() {
	
	Connection con = null;
	
	try {
		// load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// connection Established
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project_e-commerce", "root", "root");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;

	}
}
