package com.boral.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.boral.qa.Utilities.ExcelReader;
import com.boral.qa.base.TestBase;
import com.boral.qa.pages.LoginPage;


public class LoginTestcases extends TestBase{
	LoginPage login;
	static String username;
	static String password;

	public LoginTestcases() {
		super();
	}
	
	//@BeforeTest
	public void initial()
	{
		initialization();
	}
	
	
	@BeforeMethod
	public void setup()
	{
	  initialization();
      login =new LoginPage();
	}
	
	@DataProvider
	public static Object[] [] getExcelData() throws IOException {
		ExcelReader excel=new ExcelReader();
		excel.Readexcelfile(".\\src\\main\\java\\com\\boral\\qa\\testdata\\TestData.xlsx");
		Object data[][]=excel.getcellvalue("login");
		return data;
	}
	

	@Test(dataProvider= "getExcelData",dataProviderClass=LoginTestcases.class ,groups="ValidLoginScenarios",priority=1)
	public void LoginTest(String username,String password) throws InterruptedException { //paremeter count=num of columns in excelfile
		boolean businessvalue=login.Login(username, password);
		Assert.assertEquals(businessvalue, true);
		System.out.println("Login Successful");
	}
	
	@Test(groups="InvalidLoginScenarios")
	public void BlankUsernameTest() {
		String errormessage = login.invalidLogin("","Password!");
		Assert.assertEquals(errormessage, "Username cannot be empty");
	}
	
	@Test(groups="InvalidLoginScenarios")
	public void BlankPasswordTest() {
		String errormessage = login.invalidLogin("ashwini.nayak@boral.com.au","");
		Assert.assertEquals(errormessage, "Custom auth lambda trigger is not configured for the user pool.");
	}
	
	@Test(groups="InvalidLoginScenarios")
	public void BlankCredTest() {
		String errormessage = login.invalidLogin("","");
		Assert.assertEquals(errormessage, "Username cannot be empty");
	}
	
	@Test(groups="InvalidLoginScenarios")
	public void WrongPasswordTest() {
		String errormessage = login.invalidLogin("ashwini.nayak@boral.com.au","dfgdfgfddf");
		Assert.assertEquals(errormessage, "Incorrect username or password");
	}
	
	@Test(groups="InvalidLoginScenarios")
	public void WrongUsernameTest() {
		String errormessage = login.invalidLogin("ashwini.nayak@boral.com.aussd","sgsg");
		Assert.assertEquals(errormessage, "User does not exist");
	}
	
	@AfterMethod
	public void end()
	{
		driver.close();
		driver.quit();
	}
	
}
