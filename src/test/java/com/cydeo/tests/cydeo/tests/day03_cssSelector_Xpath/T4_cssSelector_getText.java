package com.cydeo.tests.cydeo.tests.day03_cssSelector_Xpath;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {

    public static void main(String[] args) {


        //TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password
                                //tagName[attribute='attribute']
        //locating reset password button using class attribute and its value-class attribute and value kullanarak parolayı sıfırla düğmesini bulma
        //WebElement resetPassword= driver.findElement(By.cssSelector("button['value=Reset password']"));
        WebElement resetPassword=driver.findElement(By.cssSelector("button[value='Reset password']"));

        String expectedResertPasswordButtonText="Reset password";
        String actualResertPasswordButtonText=resetPassword.getText();

        if (actualResertPasswordButtonText.equals(expectedResertPasswordButtonText)){
            System.out.println("Button text verification passed");
        }else {
            System.out.println("Button text verification failed");
        }
        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from
    }
}
