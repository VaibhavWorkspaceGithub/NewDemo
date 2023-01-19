package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminAccess {

	ConnectionNew cn = new ConnectionNew();
	Connection connection = cn.getConnection();
	ResultSet rs;

	Scanner scan = new Scanner(System.in);

	public void getStock() {

		try {
			PreparedStatement ps5 = connection.prepareStatement("select product_id, qty from  products limit 10");

			ResultSet rs5 = ps5.executeQuery();
			System.out.println("***********************");
			System.out.println("Stock statement:-  ");

			while (rs5.next()) {

				System.out.println("Product ID: " + rs5.getString(1));

				System.out.println("Qty selected: " + rs5.getString(2));
				System.out.println("");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getUserdetails() throws SQLException {
		try {

			PreparedStatement ps6 = connection.prepareStatement("select * from  cart where userid=? limit 10");
			System.out.println("****Product purchase details of user****");
			System.out.println("Enter user id: ");
			int bc = scan.nextInt();
			ps6.setInt(1, bc);
        	ResultSet rs6 = ps6.executeQuery();


			

			int grandTotal = 0;
			while (rs6.next()) {
                System.out.println("");
				System.out.println("First Name: " + rs6.getString(1));
				System.out.println("Product Id: " + rs6.getInt(2));
				System.out.println("Description: " + rs6.getString(3));
				System.out.println("Price: " + rs6.getInt(4));
				System.out.println("Name of product: " + rs6.getString(5));
				System.out.println("Quantity  " + rs6.getInt(6));

				grandTotal = grandTotal + rs6.getInt(8);

				System.out.println("");

			}
			System.out.println("Grand Total is: "+grandTotal);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
