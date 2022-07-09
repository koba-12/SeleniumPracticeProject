package com.cydeo.tests.cydeo.tests.day05_testNGIntro_dropdowns;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementsRefEx {

    public static void main(String[] args) throws InterruptedException {

        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        //3. Click to “Add Element” button
        //button[@onclick='addElement()']
        WebElement addElementBtn=driver.findElement(By.xpath("//button[.='Add Element']"));
//burada xpath kullanarak add element buttonı bulduk
        Thread.sleep(2000);
        addElementBtn.click();
        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton=driver.findElement(By.xpath("//button[@class='added-manually']"));
//burada da delete buttonı bulduk-üstteki parantez içi yerine "//button[.='Delete']" yazsak da aynı sonuç çünkü ikisi de deletein elementi
        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());//displayed istedi onu yaptık.
        //5. Click to “Delete” button.
        deleteButton.click();
//tıkladıktan sonra silindiği için StaleElementEXception olur(kural)
        //6. Verify “Delete” button is NOT displayed after clicking.
//tıkladıktan sonra silindiği için StaleElementEXception olur(kural).bu sebeple exceptionı handle etmek için try-catch yapacağız.
        try {
            System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("--> StaleElementReferenceException exception is thrown");
            System.out.println("--> This means the web element is completely deleted from the page");
            //Bu, web öğesinin sayfadan tamamen silindiği anlamına gelir
            System.out.println("deleteButton.isDisplayed()=false");
        }


        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    }
}
