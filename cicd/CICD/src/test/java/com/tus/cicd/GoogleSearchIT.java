package com.tus.cicd;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;



public class GoogleSearchIT {
	
	
	
	
    @Test
    void verifyGoogleHomePageLoads() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

        assertTrue(driver.getTitle().contains("Google"));
        
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
    	try {
			FileUtils.copyFile(screenshot, new File("target/screenshots/failure.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        driver.quit();
    }
}