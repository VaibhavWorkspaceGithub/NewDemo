package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class Cart {
	ConnectionNew cn = new ConnectionNew();
	Connection connection = cn.getConnection();
	ResultSet rs;
	int us;
	public void addToCart() {

		// To add products into the cart user need to put product_id
		Register r = new Register();
		String name = r.registerUser();
		Products p = new Products();
		p.getProducts();
		for(int i=1; i<=10;i++) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter the Product id to add the products in the cart");
			System.out.println("To proceed to cart please enter 0 (zero) ");
			int x = scan.nextInt();
			
			if(x>0 && x<=10) {
		

				System.out.println("Enter Quantity ");
				int y = scan.nextInt();

		try {
			PreparedStatement ps1 = connection.prepareStatement("select FirstName,UserId from register;");
			 rs = ps1.executeQuery();
			while (rs.next()) {
				if (name.equalsIgnoreCase(rs.getString(1))) {
					PreparedStatement ps2 = connection.prepareStatement("select * from products Where product_id=?");
					ps2.setInt(1, x);
					ResultSet rs1 = ps2.executeQuery();
					while (rs1.next()) {
						
						//adding products in cart
						PreparedStatement ps3 = connection.prepareStatement("insert into cart (first_name,product_id,description,price,name,qty,userid,totalPrice)"
										+ "values (?,?,?,?,?,?,?,?)");
						ps3.setString(1, rs.getString(1));
						ps3.setInt(2, rs1.getInt(1));
						ps3.setString(3, rs1.getString(2));
						ps3.setInt(4, rs1.getInt(3));
						ps3.setString(5, rs1.getString(4));
						ps3.setInt(6, y);
						 us=rs.getInt(2);
						ps3.setInt(7, us);
						int totalPrice= rs1.getInt(3)*y;
						ps3.setInt(8, totalPrice);
						ps3.execute();
						PreparedStatement ps4 = connection
								.prepareStatement("update products set qty=? where product_id=?");
						int qty1 = rs1.getInt(5) - y;
						ps4.setInt(1, qty1);
						ps4.setInt(2, rs1.getInt(1));
						ps4.executeUpdate();

					}

				}
			}
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
			}
			else if(x==0) {
				proccedToCart();
				i=11;
			}
			else if (x>10) {
				System.out.println(" Invalid Product Id Please Enter Valid Product ID ");
			}
	}
	}
	
	
	
	public void proccedToCart() {
		try {
			PreparedStatement ps4 = connection.prepareStatement("select * from cart Where USERID="+us +" order by product_id asc");
			  // ps4.setInt(1,rs.getInt(2));
			 ResultSet rs4 = ps4.executeQuery();
			 System.out.println("************************************");
			 System.out.println("Dear Customer Your Cart is Here!....");
			 int totalCartprice=0;
			 while (rs4.next()) {
				 
				 System.out.println("Product ID: "+rs4.getString(2));
				 System.out.println("Description: "+rs4.getString(3));
				 System.out.println("Price: "+rs4.getString(4));
				 System.out.println("Type of Product: "+rs4.getString(5));
				 System.out.println("Qty selected: "+rs4.getString(6));
				 System.out.println("");
				 
				 totalCartprice=totalCartprice + rs4.getInt(8);
			 }
			System.out.println("Total Cart Price  Is :"+totalCartprice);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void getStock() {
		
		try {
			PreparedStatement ps5 = connection.prepareStatement("select product_id, qty from  products");
			 
			 ResultSet rs5 = ps5.executeQuery();
			 System.out.println("Stock statement:-  ");
			
			 while (rs5.next()) {
				 
				 System.out.println("Product ID: "+rs5.getString(1));
				
				 System.out.println("Qty selected: "+rs5.getString(2));
				 System.out.println("");
				 
				 
			 }
			
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}
}
