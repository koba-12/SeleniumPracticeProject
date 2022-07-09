package com.cydeo.tests.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cydeo.com/dropdown
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/dropdown");
//bu ayar kodlarını ayrı beforemethodta toplamalıyız.
    }

    @Test
    public void dropdown_task5() throws InterruptedException {
        //TC #5: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cydeo.com/dropdown
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/dropdown");
        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
//burada önceki seferlerde yaptığımız gibi ama farklı şekilde buluyoruz selectten(açılır pencere(dropdown olduğu için)).
//we located the dropdown and it is ready to use
        //3. Select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");//illinois i seçtik.
        //4. Select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");//bu sefer value ile aynı işlemi yaptık.
        //5. Select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);//californiaanın indexini yazdık.
        //6. Verify final selected option is California.
        String expectedOptionText="California";
        String actualOptionText=stateDropdown.getFirstSelectedOption().getText();//getText eklememiz gerek çünkü
//getFirstSelectedOption() ın return type ı, webElement o yüzden web elemente döndürmek için yazıyoruz.
        Assert.assertEquals(expectedOptionText, actualOptionText);//ve uyuşuyor mu diye kontrol ettil.
        //Use all Select options. (visible text, value, index)
    }


    @Test//her testi ayrı runlayabiliriz.
    public void task6(){
        //3. Select “December 1st, 1923” and verify it is selected.
        Select yearDropdown=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown=new Select(driver.findElement(By.xpath("//select[@id='day']")));
//3 farklı açılır pencere olduğu için üçüne de farklı ayrı kod yazdık.
        //Select year using  : visible text
        yearDropdown.selectByVisibleText("1923");
        //Select month using   : value attribute
        monthDropdown.selectByValue("11");
        //Select day using : index number
        dayDropdown.selectByIndex(0);//california örneğinde 5 yazmıştık.çünkü orada select state yazan yer de sayılıyor.

        //creating expected values
        String expectedYear="1923";
        String expectedMonth="December";
        String expectedDay="1";

        //getting actual values from browser
        String actualYear=yearDropdown.getFirstSelectedOption().getText();
        String actualMonth=monthDropdown.getFirstSelectedOption().getText();
        String actualDay=dayDropdown.getFirstSelectedOption().getText();

        //create assertions

        Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertTrue(actualMonth.equals(expectedMonth));
        Assert.assertTrue(actualDay.equals(expectedDay));
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();//en son bunu yazarak bitirmeliyiz.
    }
}
