package com.cydeo.tests.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.tests.cydeo.Utilities.BrowserUtils;
import com.cydeo.tests.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T7_Scroll_JSExecutor {

    @Test
    public void task7ScrollTest(){
        //TC #7: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
//bu ikisi özelinde işlem yapacağımız için öncelikle bu ikisini bulduk.

//Sürücü türümüzü JavascriptExecutor'a çeviriyoruz,böylece o arayüzden gelen yöntemleri kullanabiliriz
        JavascriptExecutor js=(JavascriptExecutor) Driver.getDriver();//js ile işlem istendiğinden bunu yazdık.

        //3- Scroll down to “Cydeo” link
        BrowserUtils.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true)",cydeoLink);//argument 0 index cydeolink

        //4- Scroll up to “Home” link
        BrowserUtils.sleep(2);
        //js.executeScript("arguments[1].scrollIntoView(true)", cydeoLink, homeLink);//argument 1 index homelinktir(burası özelinde)
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);

        //objects
        //cydeoLink 0
        //homeLink 1
        //someOtherLink 2

        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)
        //Note: You need to locate the links as web elements and pass them as arguments into executeScript() method
    }
}
