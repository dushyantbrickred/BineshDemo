package com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeClass
    public void setupApplication()
    {

        System.out.println("=====Browser Session Started=====");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,60);
        driver.get("https://www.saucedemo.com/");
        System.out.println("=====Application Started=====");
    }



    @AfterClass
    public void closeApplication()
    {
        driver.quit();
        System.out.println("=====Browser Session End=====");

    }
}
