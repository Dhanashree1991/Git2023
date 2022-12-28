//Prepared Statement Example 
package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class PS_Insert {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcurl = "jdbc:mysql://localhost:3306/demo";
		String username= "root";
		String password= "root";
		String sql = "insert into student values (?, ?)";
		Connection con=DriverManager.getConnection(jdbcurl, username, password);
		PreparedStatement s=con.prepareStatement(sql); 
 
		 s.setInt(1, 202);
		 s.setString(2, "Ajay");
		 s.executeUpdate();
		 
		 System.out.println("Data Inserted Successfully");
   }
}

