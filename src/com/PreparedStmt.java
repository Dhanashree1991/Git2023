// Prepared Statement Example
package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class PreparedStmt {
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the no of student that you want to insert into DB table >>: ");
	int count = sc.nextInt();
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbcurl = "jdbc:mysql://localhost:3306/demo";
		String username= "root";
		String password= "root";
		
		String sql = "insert into student values (?, ?)";
		
		Connection con=DriverManager.getConnection(jdbcurl, username, password);
		
		PreparedStatement s=con.prepareStatement(sql);
		 for(int i=1;i<=count;i++)
		 { 
				 System.out.println("Enter the "+i+" student details");
				 System.out.println("Enter the student Roll no >>:");
				 int no = sc.nextInt();
				 System.out.println("Enter the student name >>:");
				 String name = sc.next();
				 
				 s.setInt(1, no);
				 s.setString(2, name);
				 s.executeUpdate();
         }
 
        System.out.println("Data Inserted Successfully");
     }
}
