// JDBC - SELECT

package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class jdbc_first {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcurl = "jdbc:mysql://localhost:3306/demo";
		String username= "root";
		String password= "root";
// String sql = "select * from credentials where scenario ='rewardscard'";
 
		String sql = "select * from credentials";
		Connection con=DriverManager.getConnection(jdbcurl, username, password);
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(sql);
		while(rs.next())
		{
			System.out.print("Scenario: "+rs.getString("scenario"));
			System.out.print(", Username:"+rs.getString("username"));
			System.out.println(", Password: "+rs.getString("password"));
		}
	}
}