// JDBC - Create Table Example
package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Create_Table {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	String jdbcurl = "jdbc:mysql://localhost:3306/demo";
	String username= "root";
	String password= "root";
	String sql = "create table Details(roll int, name varchar(255))";
	//step1 load the driver class 
	Class.forName("com.mysql.cj.jdbc.Driver");
	 //step2 create the connection to DB
	Connection con=DriverManager.getConnection(jdbcurl, username, password);
	//step3 create the statement object 
	Statement s=con.createStatement();
	//step4 execute query
	s.executeUpdate(sql);
	System.out.println("table created successfully");
	//step5 close the DB Connection 
	con.close();
  }
}
