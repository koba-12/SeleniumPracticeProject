package com.cydeo.tests.cydeo.tests.day08_properties_config_reader;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import com.cydeo.tests.cydeo.Utilities.WebTablesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_webTableOrderVerify {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
    }
    @Test
    public void orderNameVerifyTest(){
        //1. Go to: https://practice.cydeo.com/web-tables
        //locate the cell that has bob martin text in it.
        WebElement bobMartinCell=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        System.out.println("bobMartinCell.getText() = " + bobMartinCell.getText());
        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        String expectedBobName="Bob Martin";
        String actualBobName=bobMartinCell.getText();

        Assert.assertEquals(expectedBobName,actualBobName);

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
        WebElement bobMartinDateCell=
                driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']following-sibling::td[3]"));

        String expectedBobDate = "12/31/2021";
        String actualBobDate = bobMartinDateCell.getText();

        Assert.assertEquals(actualBobDate, expectedBobDate);

    }

    //We use the utility method we created.
    @Test
    public void test2(){

        String costumerOrderDate1 = WebTablesUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("costumerOrderDate1 = " + costumerOrderDate1);


        String costumerOrderDate2 = WebTablesUtils.returnOrderDate(driver, "John Doe");
        System.out.println("costumerOrderDate2 = " + costumerOrderDate2);

    }

    //Using WebTableUtils.orderVerify(); method
    @Test
    public void test3(){

        WebTablesUtils.orderVerify(driver, "Bart Fisher", "01/16/2021");

    }
}
