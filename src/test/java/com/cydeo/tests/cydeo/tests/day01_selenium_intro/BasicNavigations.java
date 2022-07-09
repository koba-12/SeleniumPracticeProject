package com.cydeo.tests.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //1.Set up the "browser driver"
        WebDriverManager.chromedriver().setup();

        //2.Create instance of the Selenium WebDriver
        //This is the line opening empty browser
        WebDriver driver=new ChromeDriver();

        //This line will maximize the browser size.(bunu sonradan ekledik, browserı full ekran yapar)
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen(); bu da alternatiftir ama bazı hatalar oluşturabileceği için üstteki yeğdir.

        //3.Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //stop code execution for 3 seconds.(her işlemi 3 saniyede yapması için)
        Thread.sleep(3000);

        //use selenium to navigate back(geri tuşu)
        driver.navigate().back();

        ////stop code execution for 3 seconds.(her işlemi 3 saniyede yapması için)
        Thread.sleep(3000);

        //use selenium to navigate forward
        driver.navigate().forward();

        ////stop code execution for 3 seconds.(her işlemi 3 saniyede yapması için)
        Thread.sleep(3000);

        //use selenium to navigate refresh
        driver.navigate().refresh();

        //stop code execution for 3 seconds.(her işlemi 3 saniyede yapması için)
        Thread.sleep(3000);

        //use navigate ().to()-geri getirme methodu.yani üstteki işlemlerden sonra google.com a geri döndürür.
        driver.navigate().to("https://www.google.com/");


        //bize o an gelinen sayfanın başlığını(title) gösterir.
        String currentTitle= driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //get the current URL using selenium-current=şuanki
        String currentURL=driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);
//örneğin burada son gelmiş olduğumuz sayfa google.eğer to() methodun önüne yani daha tesla.comdayken yazarsak
//teslanın url ini verir.Aynı şey title için de geçerli.

        //this will close the currently opened window.
        driver.close();

        //this will close all of the opened windows.
        driver.quit();
    }
}
