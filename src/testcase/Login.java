package testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import utility.Utility;

public class Login extends TestBase{
	
	@Test
	void login() throws IOException{
	driver.findElement(By.cssSelector(Utility.fetchLocator("UserName_cssSelector"))).sendKeys("Admin");
	driver.findElement(By.xpath(Utility.fetchLocator("Password_XPATH"))).sendKeys("admin123");
	driver.findElement(By.xpath(Utility.fetchLocator("LoginBtn_XPATH"))).click();
	System.out.println("Login Successful");
		
	}
}
