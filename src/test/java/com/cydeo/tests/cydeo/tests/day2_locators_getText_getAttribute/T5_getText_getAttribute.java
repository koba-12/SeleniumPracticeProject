package com.cydeo.tests.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute {

    public static void main(String[] args) {

        //TC #5: getText() and getAttribute() method practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");
        //3- Verify header text is as expected:
        WebElement headerText=driver.findElement(By.tagName("h2"));//burada h2 de olan headerı bulduk
        //  Expected: Registration form
        //burada da beklenenle actualın uyup uymadığını kontrol edeceğizç
        String expectedHeaderText="Registration form";
        String actualHeaderText=headerText.getText();//will return "Registration form" as string
        //getText, opening tag ile closing tag arasını alır.
        if (actualHeaderText.equals(expectedHeaderText)){//burada texti bulmuş oluyoruz
            System.out.println("header text verification passed");
        }else {
            System.out.println("header text verification failed");
        }
        //4- Locate “First name” input box
        //we are locating the web element using "name"  locator-"ad" konumlandırıcısını kullanarak web öğesini buluyoruz
        //name attribute has "firstname" value-name özniteliği "ad" değerine sahiptir
        WebElement firstNameInput=driver.findElement(By.name("firstname"));
        //5- Verify placeholder attribute’s value is as expected:
        //  Expected: first name
        String expectedPlaceHolder="first name";
        String actualPlaceHolder=firstNameInput.getAttribute("placeholder");//burada da attribute'ü(placeholder) bulduk
        //placeholder,name,id,class... hepsi farklı şeyler.Direkt attribute ü veriyor.
        if (actualPlaceHolder.equals(expectedPlaceHolder)){
            System.out.println("placeholder text verification passed");
        }else {
            System.out.println("placeholder text verification failed");
        }
        driver.close();
        //2. ve 3. videoların notlarında getText ve getAttribute la ilgili güzel örnekler var.anlaşılır yapıyor.
    }
}
