package com.cydeo.tests.cydeo.tests.day04_findElements_chechboxes_radio;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceException {

    public static void main(String[] args) {

        //TC #6: StaleElementReferenceException Task
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //Providing extra wait time for our driver before it throws noSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");
        //3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink=driver.findElement(By.xpath("//a[text()='CYDEO'"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());//true
        //4- Refresh the page.
        driver.navigate().refresh();

        cydeoLink=driver.findElement(By.xpath("//a[text()='CYDEO']"));
        //normalde buraya bu yazılmaz ama bu sefer StaleElementReferenceException olduğu için bu şekilde handle etmiş oluruz.
        //5- Verify it is displayed, again.
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());//true
        //This is a simple StaleElementReferenceException to understand what is this exception and how to handle it.
//anladığım kadarıyla sayfada locator olmazsa StaleElementReferenceException oluyor.
    }
}
