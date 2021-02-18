package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class DeleteDemo {
public static void main(String [] args) {
	Connection con;
	Statement stmt;
	int cnt=0;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connecting to database..");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","98765");
		String sql="DELETE FROM candidates WHERE RTRIM(last_name) LIKE \'Y%g\';";
		System.out.println(" ");
		stmt=con.createStatement();
		cnt=stmt.executeUpdate(sql);
		
		if(cnt>0) {
			System.out.println("Record from table deleted successfully");
		}
		con.close();
		
	}catch(Exception e) {
		System.out.println(e);
	}
}
}
