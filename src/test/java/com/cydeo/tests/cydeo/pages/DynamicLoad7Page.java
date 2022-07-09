package com.cydeo.tests.cydeo.pages;

import com.cydeo.tests.cydeo.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad7Page {

//burada bir page oluşturacağız ve burada sağladığımız kısayollarla başka classta işlem yapacağız.
    //#1-Create constructor and instantiate driver and object of the class//Sınıfın yapıcısını ve sürücüsünü ve nesnesini oluşturun
    public DynamicLoad7Page(){//classla aynı ad
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//strong[.='Done!']")//sonuna noktalı virgül koymuyoruz dikkat!!!
    public WebElement doneMessage;//done ı bulduk

    @FindBy(xpath = "//img[@alt='square pants']")
    public WebElement spongeBobImage;
}
