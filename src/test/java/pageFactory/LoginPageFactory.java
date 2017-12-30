package pageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	WebDriver driver;
	public  LoginPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	//username not working 
			@FindBy(how=How.XPATH, using ="//input[@name='txtUsername']")
			@CacheLookup
			WebElement user_name;
			public WebElement EnterUserName() throws IOException {
		 FileInputStream fis= new FileInputStream("C:\\Users\\rubeldm\\Desktop\\OrangeHRMSteps\\data.xlsx");
				XSSFWorkbook wb=new XSSFWorkbook(fis);
				//XSSFSheet wb.getSheet("Login");
				XSSFSheet s=wb.getSheet("Login");
				XSSFRow r=s.getRow(1);
				XSSFCell c=r.getCell(0);
				String value=c.getStringCellValue();	
				//System.out.println(value);
				user_name.sendKeys(value);
				return user_name;
				}
			
			//Alternative
			public void userName() throws IOException {
				 FileInputStream fis= new FileInputStream("C:\\Users\\rubeldm\\Desktop\\OrangeHRMSteps\\data.xlsx");
					XSSFWorkbook wb=new XSSFWorkbook(fis);
					//XSSFSheet wb.getSheet("Login");
					XSSFSheet s=wb.getSheet("Login");
					XSSFRow r=s.getRow(1);
					XSSFCell c=r.getCell(0);
					String value=c.getStringCellValue();	
					driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(value);
					
					System.out.println(value);
				
				
			}
			
			
			//password
			
			//alternative passwor
			public void EnterPassword() throws IOException {
				 FileInputStream fis= new FileInputStream("C:\\Users\\rubeldm\\Desktop\\OrangeHRMSteps\\data.xlsx");
					XSSFWorkbook wb=new XSSFWorkbook(fis);
					//XSSFSheet wb.getSheet("Login");
					XSSFSheet s=wb.getSheet("Login");
					XSSFRow r=s.getRow(1);
					XSSFCell c=r.getCell(0);
					String value=c.getStringCellValue();	
					driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(value);
					
					System.out.println(value);
				
				
			}
			
			//Login button
			@FindBy(how=How.XPATH, using ="//*[@id='btnLogin']")
			@CacheLookup
			WebElement login;
			public WebElement Clicklogin() {
				return login;
			}
			//Negative test case
			@FindBy(how=How.XPATH, using ="//input[@name='txtUsername']")
			@CacheLookup
			WebElement un;
			public WebElement unfromcu() {
				return un;
			}
			//password
			@FindBy(how=How.XPATH, using ="//input[@name='txtPassword']")
			@CacheLookup
			WebElement Password;
			public WebElement pwsfromcu() {
				return Password;
			}






	
	
	
	
	

}//end class

