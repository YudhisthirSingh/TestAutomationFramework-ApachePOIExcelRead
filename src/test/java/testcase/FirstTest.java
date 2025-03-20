package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class FirstTest extends BaseTest{

	@Test(dataProviderClass=ReadXLSdata.class,dataProvider="testdata")
	public void LoginTest(String u, String p) throws InterruptedException{
		
		driver.findElement(By.id(loc.getProperty("username"))).sendKeys(u);
		Thread.sleep(4000);
		
		driver.findElement(By.id(loc.getProperty("passwd"))).sendKeys(p);
		Thread.sleep(4000);

		driver.findElement(By.id(loc.getProperty("login_button"))).click();
		Thread.sleep(4000);
		

	}

}
