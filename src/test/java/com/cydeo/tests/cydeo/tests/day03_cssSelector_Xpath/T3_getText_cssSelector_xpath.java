package com.cydeo.tests.cydeo.tests.day03_cssSelector_Xpath;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getText_cssSelector_xpath {


    public static void main(String[] args) {

        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com");
        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        //WebElement signInButton=driver.findElement(By.className("login-btn"));bunun yerine aşağıda css Selector kullanacağız

        //farklı attribute değerleri kullanarak aynı web öğesini bulma
                                    //tagName[attribute='value']-yani alt satırdaki anlamına geliyor.
                                    //input[class='login-btn']/bunu yani inspect bölümündeki alan bu,bunu aşağıdaki gibi yazmamız lazım.
        //located using class attribute--- class attribute kullanılarak bulunur
        //WebElement signInButton= driver.findElement(By.cssSelector("input[class='login-btn']"));
        //ilk webElement yerine bunu kullanmış olduk, yazım şekli bu şekildedir, kuraldır.daha genel bir kapsam olmuş oluyor.
        //located using type attribute
        //WebElement signInButton= driver.findElement(By.cssSelector("input[type='submit']"));
        //located using value attribute
        WebElement signInButton= driver.findElement(By.cssSelector("input[value='Log In']"));
//bu şekilde üçü de yazılabilir.Hepsi de "login buttonla" alakalı olduğu için hepsi de bize sonucu buldurur.hepsi de kabul
        //hepsi de farklı şekilde bulma yolları.yani hepsi sayesinde de signInButton'ı buluyoruz.diğer locatorlere göre daha çok imkan sağlar.
        //!!UNUTMAYALIM!!! CSS SELECTOR DE SADECE BİR LOCATOR
        String expectedButton="Log In";
        //getting the value  of the attribute "value"------"değer" özniteliğinin değerini almak
        String actualButton=signInButton.getAttribute("value");

        System.out.println("actualButton = " + actualButton);

        if (actualButton.equals(expectedButton)){
            System.out.println("Log in button test verification passed");
        }else {
            System.out.println("Log in button test verification failed");
        }
        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from
    }
}
