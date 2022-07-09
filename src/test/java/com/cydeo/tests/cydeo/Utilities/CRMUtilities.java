package com.cydeo.tests.cydeo.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRMUtilities {

/*
    This method will log in with helpdesk1@cybertekschool.com
     user when it is called
     */


    public static void crmLogin(WebDriver driver){//buraya bunu yazarak driverı oluşturduk.

        //3. Enter valid username
        WebElement inputUsername=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));//burada username bölümğnü bulduk.
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");//burada da bize hazır olarak verilmiş olan username i yazdırdık.(oto)
        //4. Enter valid password
        WebElement inputPassword=driver.findElement(By.xpath("//input[@name='INPUT_PASSWORD']"));
        inputPassword.sendKeys("UserUser");
        //5. Click to `Log In` button
        WebElement loginButton=driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }

    public static void crmLogin(WebDriver driver,String username, String password){//buraya bunu yazarak driverı oluşturduk.

        //3. Enter valid username
        WebElement inputUsername=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));//burada username bölümğnü bulduk.
        inputUsername.sendKeys(username);//buraya bunu yazarak,bunu kullanacağımız classlarda
// yazacağımız username karşılaştırılacak.
        //4. Enter valid password
        WebElement inputPassword=driver.findElement(By.xpath("//input[@name='INPUT_PASSWORD']"));//buraya bunu yazarak,bunu kullanacağımız classlarda
// yazacağımız password karşılaştırılacak.
        inputPassword.sendKeys(password);
        //5. Click to `Log In` button
        WebElement loginButton=driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }
}
