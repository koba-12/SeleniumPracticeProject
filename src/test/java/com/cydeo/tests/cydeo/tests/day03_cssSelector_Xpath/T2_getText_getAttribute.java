package com.cydeo.tests.cydeo.tests.day03_cssSelector_Xpath;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {

    public static void main(String[] args) {

        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com");
        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        WebElement rememberMeLabel=driver.findElement(By.className("login-item-chechbox-label"));
        String expectedRememberMeLabel="remember me on this computer";
        String actualRememberMeLabel=rememberMeLabel.getText();

        if (actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("label verification passed");
        }else {
            System.out.println("label verification failed");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        WebElement forgotPasswordLink=driver.findElement(By.className("login-link-forgot-pass"));

        String expectedForgotPasswordLinkText="forgot your password";
        String actualForgotPasswordLinkText=forgotPasswordLink.getText();
//mesela burada webelementle bulduk önce passwordü.sonra beklenen passwordü yazdık.sonra da güncel linki çağırdık
//getText ile(güncel link webElementle bulduğumuz).sonra da aşağıda if condition ile doğru mu yanlış mı kontrol ettik.

        if (actualForgotPasswordLinkText.equals(expectedForgotPasswordLinkText)){
            System.out.println("forgot password link verification passed");
        }else {
            System.out.println("forgot password link verification passed failed");
        }//büyük küçük harf farkından dolayı failed çıukar
        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String expectedInHref="forgot_password=yes";
        String actualHrefAttributeVal=forgotPasswordLink.getAttribute("href");
//burada ise tekrardan password bulmaya gerek yok çünkü zaten bulduk.bekleneni yazdık.sonra da getAttribute ile
//href özelinde kontrol yapmak için hrefi çağırdık.(hrefin içinde yazanı arıyoruz)if condition ile de kontrol ettik.
        System.out.println("actualHrefAttributeVal = " + actualHrefAttributeVal);

        if (actualHrefAttributeVal.equals(expectedInHref)){
            System.out.println("HREF attribute value verification passed");
        }else {
            System.out.println("HREF attribute value verification failed");
        }
        //PS: Inspect and decide which locator you should be using to locate web elements.

    }



}
