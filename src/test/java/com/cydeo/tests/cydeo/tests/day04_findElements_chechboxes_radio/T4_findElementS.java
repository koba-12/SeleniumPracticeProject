package com.cydeo.tests.cydeo.tests.day04_findElements_chechboxes_radio;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_findElementS {

    public static void main(String[] args) {

        //findElements vs findElements---array vs ArrayList gibi düşünebiliriz.

        // Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //providing extra wait time for our driver before it throws "noSuchElementException"
        //// "noSuchElementException" atmadan önce sürücümüz için ekstra bekleme süresi sağlamak
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");
        //3- Locate all the links in the page.
        //alt+enter---shortcut ile local variable oluşturabiliriz kolaylıkla--List<WebElement> allLink gibi
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        //4- Print out the number of the links on the page.
        allLinks.size();//2
        //5- Print out the texts of the links.
        for (WebElement each : allLinks) {
            System.out.println("text of link: "+ each.getText());//kural olarak getText yazmam gerek yoksa hashCode verir.
            //outa cydeo ve home çıkar.kodu yürütünce de chromedan bu iki home ve cydeo bölümleri çıkar.
            //6- Print out the HREF attribute values of the links
            System.out.println("HREF Values: "+each.getAttribute("href"));//yine kural gereği getAttribute yaptık ve sadece
            //"href" value istendiği için parantez içine href yazdık.
        }
        //çok değerli shortcut!!! copy-sil-paste yerine control(alt da olur)+shift+up-down ile o satırdaki yazıları başka satıra taşıyabiliyoruz.
        //gürkanın sık yaptığı gibi.

    }
}
