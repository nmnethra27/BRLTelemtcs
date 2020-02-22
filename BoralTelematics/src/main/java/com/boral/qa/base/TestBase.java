package com.boral.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	
	public static WebDriver driver;
	static Properties prop;
	WebDriver wait;
	
	public TestBase() {
	prop =new Properties();
	FileInputStream fis;
	try {
		fis = new FileInputStream(".\\src\\main\\java\\com\\boral\\qa\\config\\Config.properties");
		prop.load(fis);
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static void initialization() {
		if(prop.getProperty("Browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver",".\\src\\main\\java\\com\\boral\\qa\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("Browser").equals("Firefox")){
				System.setProperty("Webdriver.gecko.driver",".\\Drivers");
				driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
		
		
	
}

