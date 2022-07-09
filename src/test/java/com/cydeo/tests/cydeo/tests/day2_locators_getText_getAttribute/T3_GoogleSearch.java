package com.cydeo.tests.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {

    public static void main(String[] args) {

        //TC#3: Google search
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Write “apple” in search box
        WebElement googleSearchBox = driver.findElement(By.name("q"));//bu name i yine web sayfasındaki incele bölümünden bulduk.
//burada googlesearchboxı buldurduk.link.text'ten farkını tam olarak anlayamdım.
//Güncelleme: Sanırım "name" de name attribute valueyu bulduruyoruz.(çok yüksek ihtimalle böyle anladım)
        //4- Click google search button(press enter using Keys.ENTER)
        googleSearchBox.sendKeys("apple"+ Keys.ENTER);//burada sendKeys ile üstte bulduğumuz searchBox'a apple yazdırdık.
//Keys.ENTER ile de entera bastırmış olduk.

        //5- Verify title:
        //Expected: Title should start with “apple” word
        String expectedInTitle="apple";
        String actualTitle=driver.getTitle();
        if (actualTitle.startsWith(expectedInTitle)){
            System.out.println("title verification passed");
        }else {
            System.out.println("title verification failed");
        }
//NOT:id ve className attributesta aynı name gibi ama farkı bunlarda id ve class buluyoruz.(notlarda detay var)
//tagName de ise tag bulur ama fazla kullanılmaz.
    }
}
