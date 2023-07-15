package com.selenium.script;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        // 1. Initialize web driver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mohan\\devops\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);

        // 2. Open the browser
        driver.get("https://www.facebook.com/"); 
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.findElement(By.id("email")).sendKeys("abc@def.com");
        driver.findElement(By.id("pass")).sendKeys("dummypassword");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.className("_9lsa")).click();
        driver.findElement(By.name("login")).click();
    }
}