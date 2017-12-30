package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageFactory.LoginPageFactory;
import pageFactory.SQLPFactory;

public class LoginStep {
WebDriver driver;
@Given("^Admin Navigate to HRM Login page$")
public void admin_Navigate_to_HRM_Login_page() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\rubeldm\\Documents\\workspace_driver\\chromedriver2.33.exe" );
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("http://opensource.demo.orangehrmlive.com/");

  
}

@When("^Admin Enter valid userName and password$")
public void admin_Enter_valid_userName_and_password() throws Throwable {
	//LoginPageFactory d= new LoginPageFactory(driver);
	SQLPFactory d= new SQLPFactory(driver);
	d.SqlUserName();
	System.out.println("Successfully pull from sql");
	d.SqlPassword();
	
   
}

@When("^click on LOGIN Button$")
public void click_on_LOGIN_Button() throws Throwable {
	//LoginPageFactory d= new LoginPageFactory(driver);
	SQLPFactory d= new SQLPFactory(driver);
	d.Clicklogin().click();

}

@Then("^Admin will Land in Admin HomePage$")
public void admin_will_Land_in_Admin_HomePage() throws Throwable {
	String Act=driver.getTitle();
	System.out.println("Page titel for this page is " + Act);
	String Exp="OrangeHRM";
	
 
}

@Then("^Close The Browser$")
public void close_The_Browser() throws Throwable {
	driver.close();
   
}

@When("^Admin Enter Invalid userName\"([^\"]*)\" and Invalidpassword\"([^\"]*)\"$")
public void admin_Enter_Invalid_userName_and_Invalidpassword(String arg1, String arg2) throws Throwable {
	LoginPageFactory d= new LoginPageFactory(driver);
	d.unfromcu().sendKeys(arg1);
	d.pwsfromcu().sendKeys(arg2);
}

@Then("^InvalidCredenTial Message will Apear$")
public void invalidcredential_Message_will_Apear() throws Throwable {
	System.out.println("I force to pass this test ");

	 WebElement ac=driver.findElement(By.xpath("//*[@id='spanMessage']"));
	 String ex= "Invalid credentials";
	 if (ac.equals(ex)) {
		 driver.quit();
		 Assert.assertEquals(ac, ex);
		 
	 }
	 else {
		 driver.close();
	 }
	 
	 Assert.assertEquals(ac, ex);
}






}//end class
