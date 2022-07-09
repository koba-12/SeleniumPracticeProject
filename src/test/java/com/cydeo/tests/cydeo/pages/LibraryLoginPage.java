package com.cydeo.tests.cydeo.pages;

import com.cydeo.tests.cydeo.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {
//bu POM design pattern'dir.

    //#1- initialize the driver instance and object of the class
    public LibraryLoginPage(){
        /*initElements method will create connection in between the current
        driver session (instance) and the object of the current class.
         */
        PageFactory.initElements(Driver.getDriver(), this);//this ile be classın objectini bulmuş(getirmiş oluyoruz)
    }

    //#2- use @FindBy annotation to locate web elements

    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputUsername;

    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[.='This field is required.']/div")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement enterValidEmailErrorMessage;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordErrorMessage;
//buradaki methodları başka classlarda kısayol olarak atayabileceğiz.yani başka classlarda tek tek findElement yazmak yerine
//bu pages sayesinde kolayca bulabileceğiz elementleri!!!

//ps:POM Design modelini uyguladığımızda, varsayılan olarak StaleElementReferenceException'ı çözüyoruz.
//- Nasıl çalışır?
//@FindBy ek açıklaması kullanılarak bulunan WebElement'i her kullanmak istediğimizde, kullandığımız satırda yeniden konumlandırılacaktır.
//Temel olarak, StaleElementReferenceException'ı ortadan kaldıracak bir "yenilik kontrolü" otomatik olarak yapacaktır.
}
