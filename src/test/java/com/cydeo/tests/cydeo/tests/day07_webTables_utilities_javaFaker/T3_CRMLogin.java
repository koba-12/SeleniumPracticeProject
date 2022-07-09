package com.cydeo.tests.cydeo.tests.day07_webTables_utilities_javaFaker;

import com.cydeo.tests.cydeo.Utilities.BrowserUtils;
import com.cydeo.tests.cydeo.Utilities.CRMUtilities;
import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import com.cydeo.tests.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRMLogin extends TestBase {//test base e inherit ettik.

    //buradaki before methodu cut edip test base e yapıştırdık.
    //TC #3: Login scenario
    @Test
    public void crmLoginTest(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");
        //3. Enter valid username
        WebElement inputUsername=driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));//burada username bölümğnü bulduk.
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");//burada da bize hazır olarak verilmiş olan username i yazdırdık.(oto)
        //4. Enter valid password
        WebElement inputPassword=driver.findElement(By.xpath("//input[@name='INPUT_PASSWORD']"));
        inputPassword.sendKeys("UserUser");
        //5. Click to `Log In` button
        WebElement loginButton=driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver,"Portal");
        //USERNAME                      PASSWORD
        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser
    }


    @Test
    public void crmLoginTest2(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        //calling my utility method to login helpdesk1
        CRMUtilities.crmLogin(driver);
//bu 2. testi utility clasttan aldığım kısayolla yapıyoruz.

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver,"Portal");
        //USERNAME                      PASSWORD
        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser
    }


    @Test
    public void crmLoginTest3(){

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

        //calling my utility method to login helpdesk
        CRMUtilities.crmLogin(driver, "helpdesk2@cyberschool.com", "UserUser");
//burada da 2.testten farklı bir methodu koyduk.bu daha kullanışlı olacak,parantez içine karşılaştırmak istediğimiz,
//username ya da passwordu yazacağız ve daha garanti sonuç olacak.
//bu 3. testi utility clasttan aldığım kısayolla yapıyoruz.

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.sleep(2000);//optional/bu da utility classtan
        BrowserUtils.verifyTitle(driver,"(2) Portal");
        //USERNAME                      PASSWORD
        //helpdesk1@cybertekschool.com  UserUser
        //Helpdesk2@cybertekschool.com  UserUser
    }
}
