package com.valuemomentum.training.jdbcdemo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchDemo {
	public static void main(String[] args) throws Exception
{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","98765");
		Statement stmt=con.createStatement();
		
		//create batch
		stmt.addBatch("insert into candidate_skills values(100,5)");
		stmt.addBatch("Update skills set name='Ajax' where id=3");
		stmt.addBatch("delete from candidates where id=80");
//disable auto-commit mode
		con.setAutoCommit(false);
		try{
			stmt.executeBatch();
			con.commit();
			System.out.println("Batch is succesfully executed");
			}catch(Exception e) {
				System.out.println(e);
			
		try
        {
            con.rollback();
            System.out.println("batch is failed");
            System.out.println("Execption is"+e);
        }
        catch (Exception e1)
        {
            System.out.println("Exception is"+e1);
        }
        }
        //end of outer catch
        //cleanup
    
    stmt.close();
    con.close();
    
    
    }

 

    
    

 

}