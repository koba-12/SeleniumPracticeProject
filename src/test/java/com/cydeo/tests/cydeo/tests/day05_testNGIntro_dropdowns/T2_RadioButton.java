package com.cydeo.tests.cydeo.tests.day05_testNGIntro_dropdowns;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_RadioButton {

    public static void main(String[] args) throws InterruptedException {

        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #2: Radio button handling (handling=kullanımı demeke burada)
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");
        //3. Click to “Hockey” radio button
        Thread.sleep(2000);//optional
        WebElement hockeyButton= driver.findElement(By.xpath("input[@id='hockey']"));
        //4. Verify “Hockey” radio button is selected after clicking.
        if (hockeyButton.isSelected()){
            System.out.println("Button is selected.Verification PASSED");
        }else {
            System.out.println("Button is not selected.Verification FAİLED");
        }
//if condition yerine dümdüz hockeyButton.isSelected() yazıp, boolean da döndürebiliriz.
        //USE XPATH LOCATOR FOR ALL WEB ELEMENT LOCATORS
    }
}
