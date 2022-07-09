package com.cydeo.tests.cydeo.tests.day03_cssSelector_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Locators_getText {

    public static void main(String[] args) {

        //TC #1: Next Base CRM, locators and getText() practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com");
        //3- Enter incorrect username: “incorrect”
        WebElement inputUserName=driver.findElement(By.className("login-inp"));//classname,id,name bunların hepsi login buttonı ile ilgili
//farklı veriler.buraya bunların hangisini yazarsak yazalım bize login buttonını verecek.
        inputUserName.sendKeys("incorrect");//kutuya bunu yazdırdık.
        //driver.findElement(By.className("login-inp")).sendKeys("incorrect");üsttekinin yerine böyle de yazabiliriz,ikisi aynı şey.
        //4- Enter incorrect password: “incorrect”
        //to auto generate local variable
        WebElement inputPassword=driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("incorrect");
        //5- Click to login button.
        WebElement loginButton=driver.findElement(By.className("login-btn"));
        loginButton.click();
        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
        WebElement errorMessage=driver.findElement(By.className("errortext"));//error message'ı bulduk.

        String expectedErrorMessage="Incorrect login or password";
        String actualErrorMessage=errorMessage.getText();//buraya kural gereği getText() yazmam lazım,yoksa comp err verir.

        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("error message verification passed");
        }else {
            System.out.println("error message verification failed");
        }
        //PS: Inspect and decide which locator you should be using to locate web elements.
    }
}
