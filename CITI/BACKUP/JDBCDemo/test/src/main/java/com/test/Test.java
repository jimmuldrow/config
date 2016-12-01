package com.test;
import java.sql.*;

public class Test {
	Test(){
		getConnection();
		Connection conn = getConnection();

		try{
			Statement statement = conn.createStatement();	
			ResultSet resultset = statement.executeQuery("select * from bank_tbl");
			
			while(resultset.next()){
				String bankName = resultset.getString("bank_name");
				String accountName = resultset.getString("account_name");
				String accountDate = resultset.getString("account_date");
				System.out.println(bankName + "   " + accountName + "   " + accountDate);
			}
		}
		catch(Exception e){
			System.out.println("Statement error - " + e);
		}		
	}
	
	public Connection getConnection(){
		try{
			Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();

			try{
				Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/world?profileSQL=true", "root", "Cummings1?");
				return conn;
			}
			catch(Exception e){
				System.out.println("Connection error - " + e);
			}
		}
		catch(Exception e){
			System.out.println("Driver error - " + e);
		}
		
		return null;
	}
	
	
	public static void main(String[] args){
		new Test();
	}
}
