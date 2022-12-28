//JDBC update record example
package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class update {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String jdbcurl = "jdbc:mysql://localhost:3306/demo";
	String username= "root";
	String password= "root";
	String sql = "update credentials set username='Mindtree' where scenario='zerobalancecard'";
	Connection con=DriverManager.getConnection(jdbcurl, username, password);
	Statement s=con.createStatement();
	s.executeUpdate(sql);
	System.out.println("Database updated successfully");
	con.close();
 }
}