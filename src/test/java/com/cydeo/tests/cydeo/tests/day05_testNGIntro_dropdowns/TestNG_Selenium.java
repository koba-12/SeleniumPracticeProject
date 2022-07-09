package com.cydeo.tests.cydeo.tests.day05_testNGIntro_dropdowns;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestNG_Selenium {

    WebDriver driver;//buraya yani en dış paranteze bunu yazmalıyımki driver isteyen yerlerde hata olmasın.Webdriver hepsini kapsasın.

    @BeforeMethod
    public void setupMethod(){
        //do browser driver setup
        //open browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //maximize the page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//işte bu tarz ayar kodları için kullanılıyor bu before method
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void selenium_test(){
        //do browser driver setup
        //open browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //maximize the page
        driver.manage().window().maximize();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get google.com
        driver.get("https://google.com");
        //assert: title is"Google"
        String actualTitle=driver.getTitle();
        String expectedTitle="Google";
        //assertEquals(driver.getTitle());
        Assert.assertEquals(actualTitle,expectedTitle,"title is matching here");//iki şekilde de yazılabilir.
        //2. argümentten sonra mesaj ekleyebiliriz, developer vs için
    }
}
