package com.cydeo.tests.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {

        //1.Set up the "browser driver"
        WebDriverManager.chromedriver().setup();
        //2.Create instance of the Selenium WebDriver
        //This is the line opening empty browser
        WebDriver driver=new ChromeDriver();
        //3.Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");
    }
}
