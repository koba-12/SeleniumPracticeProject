package com.cydeo.tests.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_iframePrectice {

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe ");
    }
//frame i nested html olarak düşünebiliriz.sayfa içinde sayfa başka sayfalar oluyor.onlarla alakalı çalışacağız.
//sayfa içinde başka sayfalar olduğu için de html içinde başka html ler de oluyor.
    @Test
    public void iframeTask(){
        //we need to switch driver's focus to iframe//ayrıca bu şekilde NoSuchElementException ı engellemiş oluyoruz.
        //yani iç html ye geçmeden web element ararsak bu hatayı alırız.
        //option1-switching to iframe using attribute value
        driver.switchTo().frame("mce_0_ifr");//value attribute un içinde yazan huydu, o yüzden bunu yazdık(value seçmemiz bir tercihtir.)

        //option2-passing index number of iframe
        driver.switchTo().frame(0);

        //option3-locate as web element and pass in frame method()
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));



        //locate he p tag(paragraph)
        WebElement yourContentGoesHereText=driver.findElement(By.xpath("//p"));//p tagde zaten tek bir içerik olduğu için sadece bu kadarlık yazdık.
//bazen üstteki gibi kodlar "NoSuchElementException" hatası verebilir.bunun sebeplerinden biri de TimeUnittir.
//istenen süre içerisinde bulamadığı içindir.özellikle bu framede nested html olduğu için bulma süresi uzar ver bu exception ortaya çıkar.

        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(yourContentGoesHereText.isDisplayed());//boolean döndürür.illa karşılaştırma olmasına gerek yok.

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        //to able to verify the header, we must switch back to "main HTML"//başlığı doğrulayabilmek için "ana HTML" ye geri dönmeliyiz.
//çünkü yukarıda oluşturduğumuz web Elementle ana htmlden içerideki html e yani farklı bir frame geçmiştik.(her taskte olacak diye bir zorunluluk yok
//sadece bazı yerlerdde olur.)şimdi main HTML e geri döneceğiz .parentFrame ile
        driver.switchTo().parentFrame();//döndükten sonra aşağıda 5. adıma devam edeceğiz.

        WebElement headerText=driver.findElement(By.xpath("//h3"));//bu da üstteki webElementteki gibi sadece bunu içeriyor zaten.

        //assertion of header text or not
        Assert.assertTrue(headerText.isDisplayed());
    }

}
