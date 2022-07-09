package com.cydeo.tests.cydeo.tests.day13_review_and_practices;

import com.cydeo.tests.cydeo.Utilities.BrowserUtils;
import com.cydeo.tests.cydeo.Utilities.Driver;
import com.cydeo.tests.cydeo.pages.DynamicControlsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ExplicitWaitPractice {

    DynamicControlsPage dynamicControlsPage;//bu class level objecttir.bunu yazmalıyız object oluşturacağımızda.tüm classa etki edecektir.
//before method yazacağımızda WebDriver driver; yaptığımız gibi bunu da böyle yazıyoruz.her seferinde yeni object oluşturup
//vakit kaybetmmek için.

    @BeforeMethod
    public void setupMethod(){

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();//object oluşturduk ve page e bağlandık.

    }

    @Test
    public void remove_button_test(){
        //3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();//pageden gelenle.click yaptık

        //4- Wait until “loading bar disappears”
//        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
//bunun utilsini yaptık ve kısaca oradan aldık alttakini

        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed

        try {
            //assertFalse method will pass the test if the boolean value returned is: false
            Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            Assert.assertTrue(!dynamicControlsPage.checkbox.isDisplayed());//not displayed dediği için ya böyle yazarız ya da alttaki gibi assertFalse
            Assert.assertFalse(dynamicControlsPage.checkbox.isDisplayed());
        }catch (NoSuchElementException n){
            Assert.assertTrue(true);
        }
//remove tıkladıktan sonra checkbox kayboluyor ve bu yüzden noSuchElementException oluyor.Bu yüzden burayı try catch yaptık.

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's gone!"));
    }
}
