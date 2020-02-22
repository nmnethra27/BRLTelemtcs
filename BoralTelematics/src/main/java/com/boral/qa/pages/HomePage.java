package com.boral.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.boral.qa.Utilities.ExcelReader;
import com.boral.qa.Utilities.TestUtil;
import com.boral.qa.base.TestBase;

public class HomePage extends TestBase{

	ExcelReader reader = new ExcelReader();
	
	@FindBy(xpath="//span[contains(text(),'Show Geofence')]")
	WebElement showgeofence;
	
	@FindBy(xpath="//*[@placeholder='Search for TruckId']")
	WebElement searchTruck;
	
	@FindBy(xpath="//button[@aria-label = 'Search']")
	WebElement searchicon;
	
	@FindBy(id="select-selectedTruckStatus")
	WebElement TruckStatus;
	
	@FindBy(xpath = "//*[contains(text(),'Home')]")
	WebElement Home;
	
	@FindBy(xpath="//*[@id=\"floating-panel\"]/div")
	WebElement Geofence;
	
	public HomePage(){
	
		PageFactory.initElements(driver,this);
		
	}
	
	public boolean verifyElements() {
		return Home.isDisplayed();	
	}
	
	public boolean verifyShowGeofence() {
		return Geofence.isDisplayed();	
	}
	
	public String excelreader(String sheetname,int rownum,int colnum) {
	return	reader.getexcelvalue(sheetname, rownum, colnum);
		
	}
	
	public boolean searchTruck(String truckID) throws InterruptedException {
		Thread.sleep(2000);
		searchTruck.sendKeys(truckID);
		Thread.sleep(2000);
		searchicon.click();
		//String truck =reader.getexcelvalue(sheetname, rownum, colnum);
		return driver.findElement(By.xpath("//span[contains(text()," + truckID+ ")]")).isDisplayed();
		
	}
	
}
