package com.cydeo.tests.cydeo.tests.day05_testNGIntro_dropdowns;

import com.cydeo.tests.cydeo.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_radioButtonContinue {

    public static void main(String[] args) throws InterruptedException {

        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #2: Radio button handling (handling=kullanımı demeke burada)
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");


        //Create a utility method to handle above logic.
        //Method name: clickAndVerifyRadioButton
        //Return type: void or boolean
        //Method args:
        //1. WebDriver
        //2. Name attribute as String (for providing which group of radio buttons)
        //3. Id attribute as String (for providing which radio button to be clicked)
        //Method should loop through the given group of radio buttons. When it finds the matching option, it should click and verify option is Selected.
        //Print out verification: true

        clickAndVerifyRadioButton(driver, "sport", "hockey");

        clickAndVerifyRadioButton(driver, "sport", "football");//böyle hyapıp futbol da seçebiliriz.
        //ya da aşağıda yazdıklarımız linkteki renk seçimi radio buttonı için de geçerli onda da istediğimizi seçtirebiliriz.
        clickAndVerifyRadioButton(driver, "color", "yellow");
    }

    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue) {
        //Locate name"sports" radio buttons and store them in a list of Web Element-"Spor" radyo düğmelerinin adını bulun ve bunları bir Web Öğesi listesinde saklayın
        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));//name=sport(sportlaarı listeye aldık)

        //Loop through the list of Web element and select matching result "hockey"
        //Web öğesi listesinde dolaşın ve eşleşen sonucu seçin "hokey"-web elementi loopla ve eşleşeni hockey olarak bul diyor
        for (WebElement each : radioButtons) {//web element listi loopa aldık.
            String eachID = each.getAttribute("id");
//each id (herbir id) yi looplanan "id" lere(getAttribute syesinde id özelinde loopladık) eşitledik.

            if (eachID.equals(idValue)) {//tüm sporlar out oluyordu, biz de basit bir if condition ile sadece burada idValue seçtik.
//main methoda clickAndVerifyRadioButton methodunu ekleyip, elle "hockey" yazacağız.(methodlarla yapmış olduk)
                each.click();//sonra da eache click yaptırdık.(eachID olmaz, each olmalı)
                System.out.println(eachID+ " is selected. : " + each.isSelected());//eachten seçilenler,main methodda ne yazarsak yani.
                break;//bunu yazmazsak tekrar tekrar looplar.yazmalıyız.
//kurallara uymak için bu üstte if,loop vs yaptık
            }
        }
    }
}