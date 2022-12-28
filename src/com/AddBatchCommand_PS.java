package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class AddBatchCommand_PS {
    public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int count = sc.nextInt();
            // loading driver class
          //  Class.forName("com.mysql.cj.jdbc.Driver");
 
            // create connection object
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
            
            // create the table
            String sql1 = "CREATE TABLE STUDENTS(STUDENTID VARCHAR(10) PRIMARY KEY,NAME VARCHAR(20),DEPARTMENT VARCHAR(10))";
            PreparedStatement ps = con.prepareStatement(sql1);
            ps.execute(sql1);
            
            // inserting records
            String sql= "Insert into Students values(?,?,?)";
            PreparedStatement ps1= con.prepareStatement(sql);
            for (int i = 1; i <=count; i++) {
                System.out.println("Enter Student ID:");
                int id = sc.nextInt();
                System.out.println("Enter Student Name:");
                String name = sc.next();
                System.out.println("Enter the Department:");
                String dept = sc.next();
                
                ps1.setInt(1, id);
                ps1.setString(2, name);
                ps1.setString(3, dept);
                // adding to batch
                ps1.addBatch();
            }   
             // executing the batch
                ps1.executeBatch();
              
             // viewing the table
                ResultSet rs
                    = ps.executeQuery("Select * from Students");
                System.out.println(
                    "StudentID\t\tName\t\tDepartment");
                System.out.println(
                    "-------------------------------------------------------");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "\t\t\t"+ rs.getString(2)+ "\t\t\t"+ rs.getString(3));
                }
                con.close();
        }
    }