package com.cydeo.tests.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_WindowsPractice {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");
    }
    @Test
    public void multipleWindowPractice(){

//storing the main page's window handle as string is good practice for future re-usable purposes.
//ana sayfanın pencere tanıtıcısını dize olarak saklamak, gelecekteki yeniden kullanılabilir amaçlar için iyi bir uygulamadır.
        String mainHandle=driver.getWindowHandle();//window için önce bu yazılır.
        System.out.println("mainHandle = " + mainHandle);//mainHandle = CDwindow-9FD40802174CD467440B02194C7DF07F şeklinde
        //her zaman fArklı alphanumeratic birimlerle print olu,her zmaan farklı sayı ve harfler

        //4. Assert: Title is “Windows”
        String expectedTitle="Windows";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        System.out.println("title before click: "+actualTitle);

        //5. Click to: “Click Here” link
        WebElement clickHereLink=driver.findElement(By.xpath("Click here"));
        clickHereLink.click();

        System.out.println("title after click: "+actualTitle);

        //6. Switch to new Window.
        for (String each: driver.getWindowHandles()){

            driver.switchTo().window(each);
            System.out.println("current title while switching windows: "+ driver.getTitle());
//burada neden loop yaptık tam anlayamadım ama kural gereğiymiş.burada souta new window çıkar.bu şekilde window değiştiriyoruz.
        }

        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick="New Window";
        actualTitle=driver.getTitle();//actual titleımız üstteki loop ve getWindowHandles ve switchTo işlemlerinden sonra
        //new window oldu.actual titleımız windowstu ama bize değiştirdik pencereyi ve burada da değişen yeni pencereye
        //actual title ı eşitledik.
        Assert.assertEquals(actualTitle,expectedTitleAfterClick);
        System.out.println("title after click: "+actualTitle);

        //driver.switchTo().window(mainHandle);/bunu yazarak da main windowa geri dönebiliriz.

    }

    @AfterMethod
    public void tearDown(){
        driver.close();//.quit yaparsak tüm pencereleri kapatır.
    }
}
