package com.cydeo.tests.cydeo.tests.day07_webTables_utilities_javaFaker;

import com.cydeo.tests.cydeo.Utilities.BrowserUtils;
import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class T1_windowHandling {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void windowHandlingTest(){
        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");
        //3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");
        //4. Create a logic to switch to the tab where Etsy.com is open
        Set<String> allWindowHandles=driver.getWindowHandles();//burada arrayList haline yani handlesın syntaxına çeviriyoruz.

        for (String each : allWindowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL: "+ driver.getCurrentUrl());//currentUrl bir method oto geldi.bu tarz şeylerde get kullanmamız lazım
//burada pencereler arası geçiş için loop yapıyoruz.aşağıda da if conditionla etsyde kalmasını sağlayacağız.
        if (driver.getCurrentUrl().contains("etsy")){
            break;//basit bir if conditonla etsye gelince break olmasını sağğladık.
        }
        }
        
        //5. Assert: Title contains “Etsy”
        String actualTitle=driver.getTitle();
        String expectedInTitle="Etsy";
        Assert.assertEquals(actualTitle,expectedInTitle);
        //Assert.assertTrue(actualTitle.contains(expectedInTitle));//hem bu hem de üst satırdaki de doğru olur.
        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.


//üstte 4. görevden itibaren başlayan bölüm yerine kolaylık olması için utilies packagede bir class oluşturduk ve
//yazdığımız method sayesinde üstteki tüm işlemleri her yeni taskte yapmak yerine artık aşağıdaki gibi kolayca oluşturabileceğiz.
        BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");
    }
}
