package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//JDBC program to display candidate details and their skils
public class JoinsDemo {
	 public static void main(String[] args) {
	        
	        Connection con;
	        Statement stmt;
	        ResultSet rs;
	                
	        try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");

	 

	            System.out.println("Connecting to databse...");
	            
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc", "root", "98765");
	        
	            stmt=con.createStatement();//
	            rs=stmt.executeQuery("Select c.id, first_name,name from candidates c INNER JOIN candidate_skills o on c.id=o.candidate_id  INNER JOIN  skills sk ON o.skill_id=sk.id ");
	            while(rs.next()) {
	            	System.out.println(rs.getInt(1)+" "+ rs.getString(2)+" "+rs.getString(3));
	            }
	            rs.close();
	            stmt.close();
	            con.close();
}catch(Exception e) {
	System.out.println(e);
}
	 }
}
