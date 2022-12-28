// Selenium+Java+Database Example

package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class jdbcconection{
public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String jdbcurl = "jdbc:mysql://localhost:3306/demo";
		String username= "root";
		String password= "root";
		String sql = "select * from credentials where scenario ='rewardscard'";
		Connection con=DriverManager.getConnection(jdbcurl, username, password);
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(sql);
 
	 while(rs.next())
	 {
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://login.salesforce.com");
		 
		 driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
		 driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));
	 }
	}
}

