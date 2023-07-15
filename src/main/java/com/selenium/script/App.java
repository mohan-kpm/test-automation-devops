package com.selenium.script;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        // 1. Initialize web driver
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\mohan\\devops\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(new String[]{"--headless"});
        chromeOptions.addArguments(new String[]{"--no-sandbox"});
        chromeOptions.addArguments(new String[]{"--disable-dev-shm-usage"});
        chromeOptions.addArguments(new String[]{"--remote-allow-origins=*"});
        WebDriver driver = new ChromeDriver(chromeOptions);

        System.out.println("Script Started");

        // 2. Open the browser
        driver.get("https://www.facebook.com/"); 
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.findElement(By.id("email")).sendKeys("abc@def.com");
        driver.findElement(By.id("pass")).sendKeys("dummypassword");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.className("_9lsa")).click();
        driver.findElement(By.name("login")).click();
        TakesScreenshot scrShot = (TakesScreenshot)driver;
        File screenShot = (File)scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("screenshot.png");
        FileUtils.copyFile(screenShot,destFile);
        System.out.println("Screenshot copied to : " + destFile.getAbsolutePath().toString());

    }
}