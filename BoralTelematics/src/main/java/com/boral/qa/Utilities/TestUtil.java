package com.boral.qa.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.boral.qa.base.TestBase;

public class TestUtil extends TestBase{

	
	public static void sendkeys(WebDriver driver,WebElement element,int timeout,String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated((By) element));
		element.sendKeys(value);;
	}
	
	public static void Clickof(WebDriver driver,WebElement element,int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}
