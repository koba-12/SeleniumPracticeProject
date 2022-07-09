package com.cydeo.tests.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.tests.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsPractice {

    @Test
    public void task4_and_task5_test(){
        //TC #4: Scroll practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/ ");
        //3- Scroll down to “Powered by CYDEO”
        //Crete object of Actions and pass our "driver" instance
        Actions actions=new Actions(Driver.getDriver());

        //locating cydeo link to be able to pass in the actions method
        WebElement cydeoLink=Driver.getDriver().findElement(By.linkText("CYDEO"));

        //4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(cydeoLink).perform();

        //TC #5: Scroll practice 2
        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();//2 kere yazdık çünkü tamamen yukarı çıkarmaz bu button,tamamen yukarı çıkmak için 2 kere.

    }
}
