package com.cydeo.tests.cydeo.tests.day04_findElements_chechboxes_radio;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T5_checkboxes {

    public static void main(String[] args) throws InterruptedException {

        //Practice: Checkboxes
        //1. Go to http://practice.cydeo.com/checkboxes
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/checkboxes");
        //We have to locate checkboxes
        WebElement checkbox1=driver.findElement(By.xpath("//input[@name='checkbox1']"));
        WebElement checkbox2=driver.findElement(By.xpath("//input[@name='checkbox2']"));
        //2. Confirm checkbox #1 is NOT selected by default
        System.out.println("checkbox1.isSelected(), expecting false= " + checkbox1.isSelected());//false
        //3. Confirm checkbox #2 is SELECTED by default.
        System.out.println("checkbox2.isSelected(), expecting true= " + checkbox2.isSelected());//true
//burada checkbox1 false,checkbox 2 true olmasının sebebi,işlem yaptığımız web sayfasında checkbox2 nin seçili olmasıdır(manuel olarak seçtik)

        //4. Click checkbox #1 to select it.
        Thread.sleep(2000);
        checkbox1.click();
        //5. Click checkbox #2 to deselect it.
        Thread.sleep(2000);
        checkbox2.click();
        //6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());//true

        //if condition yazılmasa da olur
        if (checkbox1.isSelected()){
            System.out.println("verification passed");
        }else {
            System.out.println("verification failed");
        }
        //7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());//false

        if (checkbox2.isSelected()){
            System.out.println("verification passed");
        }else {
            System.out.println("verification failed");
        }
    }
}
