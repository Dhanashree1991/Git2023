//JDBC - Create Database Example

package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Create_Database {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcurl = "jdbc:mysql://localhost:3306/";
		String username= "root";
		String password= "root";
		String sql = "Create database fusion1";
 
		Connection con=DriverManager.getConnection(jdbcurl, username, password);
		Statement s=con.createStatement();
		s.executeUpdate(sql);
		System.out.println("Database created successfully");
		con.close();
	}
}
