package com.cydeo.tests.cydeo.tests.day08_properties_config_reader;

import com.cydeo.tests.cydeo.Utilities.ConfigurationReader;
import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_ConfigPractice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        //We are getting the browserType dynamically from our configuration.properties file
        String browserType= ConfigurationReader.getProperty("browser");//configurationProperties dolayısıyla böyle yaptık,daha kesin sonuç.
        driver = WebDriverFactory.getDriver(browserType);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
    }
    @Test
    public void googleSearchTest(){
        //3-Write "apple" in search box
        WebElement googleSearchBox=driver.findElement(By.xpath("//input[@name='q']"));
        googleSearchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);//yiine property getirttik
        //4-Verify title
        //expected: apple - Google search
        String expectedTitle=ConfigurationReader.getProperty("searchValue")+" - Google search";
        String actualTitle=driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
//benim bilgisayarımın dili türkçe olduğu için eşleşlemem sorunları olabilir ama yazdıklarımız doğru.
    }
}
