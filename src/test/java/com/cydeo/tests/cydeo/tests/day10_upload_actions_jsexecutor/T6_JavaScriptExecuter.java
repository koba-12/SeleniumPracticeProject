package com.cydeo.tests.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.cydeo.Utilities.BrowserUtils;
import com.cydeo.tests.cydeo.Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T6_JavaScriptExecuter {

    @Test
    public void javaScriptExecuterTest1(){
        //TC #6: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //(JavascriptExecutor).Driver.getDriver().executeScrip("");//şeklinde de yazabiliriz.
        //3- Use below JavaScript method and scroll
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();

        //a.  750 pixels down 10 times.
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");//sayı yazan yerler x ve ydir.(düzlem)
        }
        //b.  750 pixels up 10 times
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");//sayı yazan yerler x ve ydir.(düzlem)
        }
        //JavaScript method to use : window.scrollBy(0,0)
    }
}
