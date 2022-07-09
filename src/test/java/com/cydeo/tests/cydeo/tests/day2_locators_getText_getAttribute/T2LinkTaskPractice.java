package com.cydeo.tests.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2LinkTaskPractice {

    public static void main(String[] args) {


        //TC #2: Back and forth navigation
//1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//2- Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");
//3- Click to A/B Testing from top of the list.
        driver.findElement(By.linkText("A/B Testing")).click();//burada web sayfasına gelip, incele diyip A/B testing bulup açıcaz ve
        //oradan A/B testing yazan yere double click copy.
//bu yöntem bize sayfada istediğimiz elementi bulmamızı(tıklamamızı)sağlar.(click method sayesine)
        //WebElement abTestLink=driver.findElement(By.linkText("A/B Testing"));
        //abTestLink.click();-bu da bir başka yöntem

//4- Verify title is:
 // Expected: No A/B Test
        String expectedTitle="No A/B Test";
        String actualTitle=driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("title verification passed");
        }else {
            System.out.println("title verification failed");
        }
//5- Go back to home page by using the .back();
        driver.navigate().back();
//6- Verify title equals:
//  Expected: Practice
        expectedTitle="practice";
        actualTitle= driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("title verification passed");
        }else {
            System.out.println("title verification failed");
        }//burada tekrardan kontrol ettik title ı

    }
}
