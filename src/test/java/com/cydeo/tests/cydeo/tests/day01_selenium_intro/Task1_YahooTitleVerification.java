package com.cydeo.tests.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {

    public static void main(String[] args) {

        //TC#1 Yahoo title verification
        //do setup for browser driver
        WebDriverManager.chromedriver().setup();

        //1.Open chrome browser
        WebDriver driver=new ChromeDriver();

        //make our page fullscreen
        driver.manage().window().maximize();

        //2.Go to www.yahoo.com
        driver.get("https://yahoo.com");
        //3.Verify title
        //Expected:Yahoo | Mail, Weather, Search, Politics, News, Finance, Sport&Videos
        String expectedTitle="Yahoo | Mail, Weather, Search, Politics, News, Finance, Sport&Videos";

        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title is as EXPECTED.Verification PASSED");
        }else {
            System.out.println("Title is NOT ecpected.Verification FAİLED");
        }
//istenen(beklenen) title ile gerçek(actual) title ın uyuşup uyuşmadığını check etmiş olduk.Sonuç printe çıkacak.
    }
}
