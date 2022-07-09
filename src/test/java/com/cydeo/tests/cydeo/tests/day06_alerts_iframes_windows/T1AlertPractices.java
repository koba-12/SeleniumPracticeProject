package com.cydeo.tests.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1AlertPractices {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //TC #1: Information alert practice
        //1. Open browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }
    @Test
    public void alertTest1() throws InterruptedException {
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton=driver.findElement(By.xpath("//button[.=click for JS Alert"));
        //bu syntaxle bu butonla alakalı tüm texti alıp yazmış olduk.bu sayede tüm butonu seçmiş olduk.(diğer syntaxle aynı işe yarıyor)
        informationAlertButton.click();
        Thread.sleep(2000);

        //to be able to click to alert OK button we need to switch driver's focus to alert itself
        Alert alert=driver.switchTo().alert();//syntaxi budur.!!!
        //4. Click to OK button from the alert
        alert.accept();//accept(kabul et) denmesinin sebebi sayfada başka bir şeye tıklayamıyoruz zaten gelen uyarıyı kabul ediyoruz.
//ancak diğer alert türlerine göre .dismis(reddetmek için) ya da alert.sendKeys(text yazmak için) kullanılabilir.

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText=driver.findElement(By.xpath("p[@id='result']"));

        //failure message will only be displayed if assertion fails:/hata iletisi yalnızca onaylama işlemi başarısız olursa görüntülenir:
        Assert.assertTrue(resultText.isDisplayed(), "result text is not displayed");

        String  expectedText="You successfully clicked an alert";
        String actualText=resultText.getText();

        Assert.assertEquals(expectedText,actualText, "Actual result test is not expected!!!");
    }
}
