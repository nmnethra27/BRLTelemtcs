package com.boral.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.boral.qa.Utilities.TestUtil;
import com.boral.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	TestUtil util=new TestUtil();

	//object repository
	
	@FindBy(name="username")
	WebElement EmailID;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy(id="select-buIdSelected")
	WebElement BusnsDropdown;
	
	@FindBy(xpath="//li[@data-value ='Cement']")
	WebElement Business;
	
	@FindBy(xpath="//span[contains(text(),'Ok')]")
	WebElement Ok;

	@FindBy(xpath="//div[contains(text(),'Cement')]")
	WebElement selectedBusiness;
	
	@FindBy(xpath="//*[@id=\"bt-ui-root\"]/div/div/div/div/div[1]/span")
	WebElement errormsg;

	
	public LoginPage(){
		PageFactory.initElements(driver,this);
	}
	
	public void LoginUse(String Username,String Passwd) throws InterruptedException {
		
		EmailID.sendKeys(Username);
		Password.sendKeys(Passwd);
		LoginBtn.click();
		BusnsDropdown.click();
		TestUtil.Clickof(driver, Business, 70);
		Thread.sleep(1000);
		TestUtil.Clickof(driver, Ok, 70);
	//	return new HomePage();
	}
	
	public boolean Login(String username,String pwd) throws InterruptedException {
		EmailID.sendKeys(username);
		Password.sendKeys(pwd);
		LoginBtn.click();
		//TestUtil.Clickof(driver, BusnsDropdown, 70);
		BusnsDropdown.click();
		TestUtil.Clickof(driver, Business, 70);
		Thread.sleep(1000);
		TestUtil.Clickof(driver, Ok, 70);
		System.out.println(selectedBusiness.isDisplayed());
		return selectedBusiness.isDisplayed();	
	}
	
	public String invalidLogin(String username,String pwd) {
		EmailID.sendKeys(username);
		Password.sendKeys(pwd);
		LoginBtn.click();
		return errormsg.getText();
	}

	
}
