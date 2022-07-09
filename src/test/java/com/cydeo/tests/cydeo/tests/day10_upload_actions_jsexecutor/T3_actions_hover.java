package com.cydeo.tests.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.cydeo.Utilities.BrowserUtils;
import com.cydeo.tests.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_actions_hover {

    @Test
    public void hoveringTest(){
        //TC #3: Hover Test
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        //Locate all images under here.
        WebElement img1=Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img2=Driver.getDriver().findElement(By.xpath("(//img)[3]"));
        WebElement img3=Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        //locate all the "users" text under here.
        WebElement user1=Driver.getDriver().findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement user2=Driver.getDriver().findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement user3=Driver.getDriver().findElement(By.xpath("//h5[text()='name: user3']"));


        Actions actions=new Actions(Driver.getDriver());//actionslara selenium kütüphanesinden ulaşabilmek için
        // yeni bir actions object oluşturduk.


        //2. Hover over to first image
        BrowserUtils.sleep(2);
        actions.moveToElement(img1).perform();//bu syntaxle img1'e gidiyor mouse

        //3. Assert:
        //a. “name: user1” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(user1.isDisplayed());

        //4. Hover over to second image
        BrowserUtils.sleep(2);
        actions.moveToElement(img2).perform();

        //5. Assert:
        //a. “name: user2” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(user2.isDisplayed());

        //6. Hover over to third image
        BrowserUtils.sleep(2);
        actions.moveToElement(img3).perform();

        //7. Confirm:
        //a. “name: user3” is displayed
        //b. “view profile” is displayed
        Assert.assertTrue(user3.isDisplayed());
    }
}