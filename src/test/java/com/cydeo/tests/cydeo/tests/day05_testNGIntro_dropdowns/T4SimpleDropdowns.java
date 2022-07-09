package com.cydeo.tests.cydeo.tests.day05_testNGIntro_dropdowns;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4SimpleDropdowns {

    WebDriver driver;

    @Test
    public void setupMethod(){
        //TC#4: Verifying “Simple dropdown” and “State selection” dropdown default values
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void simpleDropdownTest(){

        //3. Verify “Simple dropdown” default selected value is correct
        Select simpleDropdown= new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
//syntaxı budur.açılır pencereleri(dropdown,hani seçim için vs kullandığımız) bulmak için kullanılır.
        WebElement currentlySelectedOption=simpleDropdown.getFirstSelectedOption();
//bize hangi optionun(seçeneğin)seçili olduğunu gösterir.syntaxı budur.(“Please select an option”) yazıyorsa
//yani seçilmiş bir şey yoksa da gösterir.

        String actualSimpleDropdownText=currentlySelectedOption.getText();
        String expectedSimpleDropdownText="Please select an option";
        //Expected: “Please select an option”
        Assert.assertEquals(actualSimpleDropdownText,expectedSimpleDropdownText);
        //4. Verify “State selection” default selected value is correct////bu da üstteki gibi aynı.
        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));//select ile dropdownu bulduk
        //Expected: “Select a State”
        String actualStateDropdownText=stateDropdown.getFirstSelectedOption().getText();//statedropdown özelinde
//getFirstSelectedOptiona eşleyip.getText dedik.
        String expectedStateDropdownText="Select a state";//bu da beklenen(istenen)

        Assert.assertEquals(actualStateDropdownText,expectedStateDropdownText);

    }
}
