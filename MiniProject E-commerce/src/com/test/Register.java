package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Register {
	
	String fn;
	
public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	//	 String lastName;
//	 String phone;
//	 String email;
//	
//	
//	public Register(String firstName, String lastName, String phone, String email) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.phone = phone;
//		this.email = email;
//		
//		
//	}
	public String registerUser() {
	Scanner scan = new Scanner(System.in);
	 
	System.out.println("Enter your first name ");
	String fn=scan.next();
	
	System.out.println("Enter your last name ");
	String ln=scan.next();
	
	System.out.println("Enter your phone number ");
	String ph= scan.next();
	
	System.out.println("Enter your email id ");
	String em= scan.next();
	
	
	ConnectionNew cn = new ConnectionNew();
	Connection connection = cn.getConnection();
	
	try {
		String q="INSERT INTO REGISTER (FirstName, LastName, PhoneNo, Email) "
				+ "values ("+"'"+fn+"'"+","+"'"+ln+"'"+","+"'"+ph+"'"+","+"'"+em+"'"+")";
		//System.out.println(q);
		PreparedStatement ps1=connection.prepareStatement(q);
		
		ps1.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
return fn;
	}
}

