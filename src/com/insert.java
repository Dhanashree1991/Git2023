// JDBC Insert Record Example

package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class insert {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String jdbcurl = "jdbc:mysql://localhost:3306/demo";
	String username= "root";
	String password= "root";
	String sql = "insert into credentials values ('PQR','gita', 'nnnn')";
	Connection con=DriverManager.getConnection(jdbcurl, username, password);
	Statement s=con.createStatement();
	s.executeUpdate(sql);
	 System.out.println("Data Inserted Successfully");
	 
	 con.close();
 }
}
