package pageFactory;



import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;



public class SQLPFactory {
	WebDriver driver;
	public   SQLPFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	

	//userName
	public void SqlUserName() throws SQLException {
	String host= "localhost";
	String port="3306";
	
	//jdbc:mysql://"+host+":"+port+"/databasename";
	Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+ "/OrangHRM", "root", "November786110");
	Statement s=con.createStatement();
	//s.executeQuery("select *from admincri where UserName='Admin'");
	ResultSet rc= 	s.executeQuery("select *from admincri where UserName='Admin'");
	//increment by 1
	rc.next();
	String un=rc.getString("UserName");
	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(un);
	//System.out.println(rc.getString("UserName"));
	
		
}//end of sql	
	//password
		public void SqlPassword() throws SQLException {
		String host= "localhost";
		String port="3306";
		
		//jdbc:mysql://"+host+":"+port+"/databasename";
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+ "/OrangHRM", "root", "November786110");
		Statement s=con.createStatement();
		//s.executeQuery("select *from admincri where UserName='Admin'");
		ResultSet rc= 	s.executeQuery("select *from admincri where UserName='Admin'");
		//increment by 1
		rc.next();
		String pa=rc.getString("UserName");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(pa);
	
	
		}
		//click login
		//Login button
		@FindBy(how=How.XPATH, using ="//*[@id='btnLogin']")
		@CacheLookup
		WebElement login;
		public WebElement Clicklogin() {
			return login;
		}
		
		//ScreenShot
		public void Screenshot(String result) throws IOException {
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(src, new File("C:\\Users\\rubeldm\\eclipse-workspace\\OrangeDataDriven\\"+result+ "screenshot.png"));
			FileUtils.copyFile(src, new File("C:\\Users\\rubeldm\\eclipse-workspace\\OrangeDataDriven\\"+result+ "screenshot\\login.png"));
		}
		
		
		
		

}//End class
