package com.cydeo.tests.cydeo.tests.day12_pomDesign_explicitWait;

import com.cydeo.tests.cydeo.Utilities.Driver;
import com.cydeo.tests.cydeo.pages.LibraryLoginPage;
import com.cydeo.tests.cydeo.tests.day2_locators_getText_getAttribute.T4_LibraryLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;//pagesten geliyor bu.WebDriver driver gibi düşünelim buradaki işevini
//tüm @Testlere etki etmesi için en dışa yazdık.normalde (method içinde)LibraryLoginPage libraryLoginPage=new LibraryLoginPage
//şeklinde yazılıyor yani object oluşturmak için.burada pages bölümündeki LibraryLoginPage sayesinde tek tek findElement yapmadan
//elementleri bulabileceğiz bu sayede

    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://library1.cydeo.com/");
        libraryLoginPage = new LibraryLoginPage();
//elementi bulmak için yazdığımız kod ve tabiki aayar kodumuz burada.
    }

    @Test
    public void required_field_error_message_test(){
        //TC #1: Required field error message test
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com/
        //3- Do not enter any information
        //4- Click to “Sign in” button

        libraryLoginPage.signInButton.click();//burada libraryLoginPage classtan sign in button methodu(findBy) bulup(kısayol).clicliyoruz.

        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());//doğruluk kontrol

        Driver.closeDriver();//close
    }

    @Test
    public void invalid_email_format_error_message_test(){
        //TC #2: Invalid email format error message test
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com/
        //3- Enter invalid email format

        libraryLoginPage.inputUsername.sendKeys("somethingwrong");//username i bulduruplibraryloginpageden)
//"somethingwrong" yazdırdık

        libraryLoginPage.signInButton.click();//click

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());

        Driver.closeDriver();

    }
    @Test
    public void library_negative_login_test(){
        //TC #3: Library negative login
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        //3- Enter incorrect username or incorrect password

        libraryLoginPage.inputUsername.sendKeys("wrong@username.com");
        libraryLoginPage.inputPassword.sendKeys("wrongpassword");

        libraryLoginPage.signInButton.click();

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());
        Driver.closeDriver();

    }
}
