//How to Execute Multiple SQL Commands on a Database Simultaneously in JDBC?
/*Demonstrating execution of multiple SQL commands on a database simultaneously using the addBatch() and executeBatch() commands of JDBC. 
 The addBatch() command is used to queue the SQL statements and executeBatch() command is used to execute the queued SQL statements all at once.
 */
package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_insert_select {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//step:1 load the driver class 
	//	Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step:2 create connection object
 	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
 	   
 	   //step:3 Create a statement
 	   Statement s = conn.createStatement();
 	   
 	   // Create table
 	 String sql1 = "CREATE TABLE STUDENT(STUDENTID VARCHAR(50) PRIMARY KEY,NAME VARCHAR(50),DEPARTMENT VARCHAR(10))";
 	    
 	    //step: 4: Execute a query
 	    // Insert records in the table
 	  	String sql2= "INSERT INTO STUDENT VALUES('S101','JEAN','CSE')";
 	    String sql3= "INSERT INTO STUDENT VALUES('S102','ANA','CSE')";
	    String sql4= "INSERT INTO STUDENT VALUES('S103','ROBERT','ECE')";
	 	String sql5 = "INSERT INTO STUDENT VALUES('S104','ALEX','IT')";
	 	String sql6= "INSERT INTO STUDENT VALUES('S105','DIANA','IT')";
	 	 
	 	s.addBatch(sql1);
        s.addBatch(sql2);
        s.addBatch(sql3);
        s.addBatch(sql4);
        s.addBatch(sql5);
        s.addBatch(sql6);
        
        //step-5 Process the statements
        s.executeBatch();

        ResultSet rs= s.executeQuery("Select * from Student");

        // Print statement
        System.out.println("StudentID\tName\t\tDepartment");
        System.out.println("-------------------------------------------------------");

        // Condition to check pointer pointing which record
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t\t"+ rs.getString(2)+ "\t\t"+ rs.getString(3));
        }
        
        // step-6 : Close the connection
        conn.close();
	}
}
