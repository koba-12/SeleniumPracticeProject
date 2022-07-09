package com.cydeo.tests.cydeo.tests.day11_actions_jsexecutor_practice;

import com.cydeo.tests.cydeo.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_CircleDragAndDrop {

    @Test
    public void dragAndDropTest(){
        //TC #: Drag and drop
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //Locate "Accept Cookies" button and click
        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();

        //Locate small and big circles to be able to drag them around
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));


        //2. Drag and drop the small circle to bigger circle.
        Actions actions=new Actions(Driver.getDriver());
        //actions.dragAndDrop(smallCircle,bigCircle).perform();//draganddrop methoddur.önce tutulacak olan elementi sonra da gideceği elementi yazmalıyız.
        //.perform() asla unutmayalım!!!

        actions.clickAndHold(smallCircle)
                .pause(2000)
                .moveToElement(bigCircle)
                .pause(2000)
                .release()//release demezsek bırakmaz.
                .perform();
//bu da dragAndDropa alternatif ama dragAndDrop daha kullanışlı olur.

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        String actualBigCircleText = bigCircle.getText();
        String expectedBigCircleText = "You did great!";

        Assert.assertEquals(actualBigCircleText, expectedBigCircleText);
    }
}
