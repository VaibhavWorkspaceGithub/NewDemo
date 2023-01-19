package com.test;

import java.sql.SQLException;
import java.util.Scanner;

public class MainTest {
	
	static String Username= "Admin";
	static String password= "1234";
	

	
	public static void main(String[] args) throws SQLException {
		
		Scanner scan = new Scanner(System.in);

		ConnectionNew cnw = new ConnectionNew();

		cnw.getConnection();

		Products p = new Products();
		p.addProductDetails();

		

		System.out.println("Select one of the following option from the following: ");
		System.out.println("I am customer: 1");
		System.out.println("I am Admin: 2");

		int select = scan.nextInt();

		if (select == 1) {

			Cart c = new Cart();
			c.addToCart();

		}

		else if (select == 2) {
			
			System.out.println("Enter Username:- ");
			String user=scan.next();
			
			System.out.println("Enter Password:- ");
			String pass= scan.next();
			
			if(Username.equals(user) && password.equals(pass)) {
			AdminAccess aa = new AdminAccess();
			aa.getStock();
			aa.getUserdetails();
			}else {
				
				System.out.println("Invalid username or password");
			}
		} else {

			System.out.println("Invalid input");
		}

	}
}
