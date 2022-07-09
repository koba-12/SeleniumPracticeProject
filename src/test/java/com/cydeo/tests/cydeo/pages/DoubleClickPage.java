package com.cydeo.tests.cydeo.pages;

import com.cydeo.tests.cydeo.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoubleClickPage {

    public DoubleClickPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "demo")
    public WebElement textToDoubleClick;
}
