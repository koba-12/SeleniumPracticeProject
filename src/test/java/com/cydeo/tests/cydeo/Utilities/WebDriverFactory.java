package com.cydeo.tests.cydeo.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//task:new method creation
//method name:getDriver
//static method
//accept string arg:browserType
//-This arg will determine what type of browser is opened.
//-if"chrome" passed---it will open chrome browser
//-if "firefox" passed--- it willl firefox browser
//return type:"WebDriver"
//bu method bize ilk başa yazdığımız 2 kodu sürekli copy-paste yapmak yerine kısayol olarak yazıldı.
public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){
        if (browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else {
            System.out.println("Given browser type does not exist/or is not currently supported");
            System.out.println("driver = null");
            return null;
        }
    }
}
