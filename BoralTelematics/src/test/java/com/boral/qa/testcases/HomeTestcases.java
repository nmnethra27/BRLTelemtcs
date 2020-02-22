package com.boral.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.boral.qa.Utilities.ExcelReader;
import com.boral.qa.Utilities.ExcelUtility;
import com.boral.qa.base.TestBase;
import com.boral.qa.pages.HomePage;
import com.boral.qa.pages.LoginPage;

public class HomeTestcases extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	ExcelReader reader;
	public String truckID ;
	
	
	
	public HomeTestcases() {
		super();
	}
	
	@BeforeMethod
	public void initialMethod() throws InterruptedException, IOException {
		initialization();
		loginpage=new LoginPage();
		homepage = new HomePage();
		reader = new ExcelReader();
		loginpage.LoginUse("ashwini.nayak@boral.com.au", "Passw0rd!");
		reader.Readexcelfile(".\\src\\main\\java\\com\\boral\\qa\\testdata\\TestData.xlsx");
		truckID =reader.getexcelvalue("homepage", 1, 0);
		System.out.println(truckID);
	}
	
	//@Test
	public void iselementPresent() {
	boolean value=homepage.verifyElements();
	Assert.assertEquals(value, true);
	System.out.println("Home menu is present");	
	}
	
	//@Test
	public void isshowgeofencePresent() {
		boolean value = homepage.verifyShowGeofence();
		Assert.assertEquals(value, true);
		System.out.println("Home menu is present");	
	}
	
	@Test
	public void searchTruck() throws InterruptedException {
		boolean value = homepage.searchTruck(truckID);
		Assert.assertEquals(value, true);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
