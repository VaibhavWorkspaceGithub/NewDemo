package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Products {
	
	ConnectionNew cn = new ConnectionNew();
	Connection connection = cn.getConnection();
	
	public String addProductDetails() {

		

		try {

			// Adding data into database
			PreparedStatement ps1 = connection.prepareStatement(
					"INSERT INTO Products(description, price, name , qty) values ('OnePlus Nord', 18999, 'Mobile', 70)");

			PreparedStatement ps2 = connection.prepareStatement(
					"INSERT INTO Products(description, price, name , qty) values ('Samsung', 34999, 'TV', 25)");

			PreparedStatement ps3 = connection.prepareStatement(
					"INSERT INTO Products(description, price, name , qty) values ('ASUS', 65000, 'Laptop', 15)");

			PreparedStatement ps4 = connection.prepareStatement(
					"INSERT INTO Products(description, price, name , qty) values ('boAt', 1999, 'Earphone', 85)");

			PreparedStatement ps5 = connection.prepareStatement(
					"INSERT INTO Products(description, price, name , qty) values ('SONY', 79999, 'Camera', 20)");

			PreparedStatement ps6 = connection.prepareStatement(
					"INSERT INTO Products(description, price, name , qty) values ('Philips', 5999, 'Speakers', 15)");

			PreparedStatement ps7 = connection.prepareStatement(
					"INSERT INTO Products(description, price, name , qty) values ('LG', 17999, 'Washing Machine', 10)");

			PreparedStatement ps8 = connection.prepareStatement(
					"INSERT INTO Products(description, price, name , qty) values ('Voltas', 39999, 'AC', 5)");

			PreparedStatement ps9 = connection.prepareStatement(
					"INSERT INTO Products(description, price, name , qty) values ('USHA', 3999, 'Fan', 40)");

			PreparedStatement ps10 = connection.prepareStatement(
					"INSERT INTO Products(description, price, name , qty) values ('Prestige', 6999, 'Owen', 10)");

			// Executing queries
			ps1.executeUpdate();
			ps2.executeUpdate();
			ps3.executeUpdate();
			ps4.executeUpdate();
			ps5.executeUpdate();
			ps6.executeUpdate();
			ps7.executeUpdate();
			ps8.executeUpdate();
			ps9.executeUpdate();
			ps10.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return "All products added";
		
		

	}
	
	public void getProducts() {
		
		try {
			PreparedStatement psm1 =connection.prepareStatement("SELECT * FROM Products ORDER BY product_id asc limit 10");
			
			
			ResultSet rs=psm1.executeQuery();
			while (rs.next()) {
				System.out.println("Product ID:     | Description:      Price:     Name:      Quantity: " );
				System.out.print(rs.getInt(1)+"              ");
				System.out.print(rs.getString(2)+"     ");
				System.out.print(rs.getInt(3)+"        ");
				System.out.print(rs.getString(4)+"      ");
				System.out.print( rs.getInt(5)+"      ");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
