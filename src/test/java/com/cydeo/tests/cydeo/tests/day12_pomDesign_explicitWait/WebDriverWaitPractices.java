package com.cydeo.tests.cydeo.tests.day12_pomDesign_explicitWait;

import com.cydeo.tests.cydeo.Utilities.Driver;
import com.cydeo.tests.cydeo.pages.DynamicLoad1Page;
import com.cydeo.tests.cydeo.pages.DynamicLoad7Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractices {

    @Test
    public void dynamicLoad7Test() {
        //TC#4 : Dynamically Loaded Page Elements 7
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        //2. Wait until title is “Dynamic title”
        //creating the wait object to be able to create certain condition to wait////beklemek için belirli bir koşul oluşturabilmek için wait nesnesi yaratılıyor
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);//webDriverWait seleniumdan gelir. burada wait yapmak için bunu kullanacağız

        //use the "wait" object to create our expected condition//beklenen koşulumuzu oluşturmak için "bekle" nesnesini kullanın
        wait.until(ExpectedConditions.titleIs("Dynamic title"));//dynamic title hariç hepsi syntaxten gelir.wait de oluşturduğumuz wait objectten geliyor.
//burada dynamic title olana kadar bekletmiş oluyoruz.yani titleda "dynamic title" yazana kadar

        ////Create object of DynamicLoad7Page to reach and assert web elements
//Web öğelerine ulaşmak ve doğrulamak için DynamicLoad7Page nesnesi oluşturun
        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        //3. Assert: Message “Done” is displayed.
        Assert.assertTrue(dynamicLoad7Page.doneMessage.isDisplayed());

        //4. Assert: Image is displayed.
        Assert.assertTrue(dynamicLoad7Page.spongeBobImage.isDisplayed());
        //Note: Follow POM
//dynamicload page objectini oluşturduk ve oradan gelen, doneMessage ve spongeBobImage'i kontrol ettik.
    }

    @Test
    public void dynamic_load_1_test() {
        //1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();//dynamicLoad1Page object oluşturduk
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);//loading için wait object oluşturduk.

        //2. Click to start
        dynamicLoad1Page.startButton.click();//önce pagei sonra FindBy ı yazıyoruz işlem için.

        //3. Wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));
//objectini oluşturduğumuz wait methodu loadingBara uyguladık.

        //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoad1Page.inputUsername.isDisplayed());

        //5. Enter username: tomsmith
        dynamicLoad1Page.inputUsername.sendKeys("tomsmith");//tomsmith yazdırdık

        //6. Enter password: incorrectpassword
        dynamicLoad1Page.inputPassword.sendKeys("somethingwrong");//geçersiz password istediği için rastgele herhangi bir şey yazılabilir.

        //7. Click to Submit button
        dynamicLoad1Page.submitButton.click();

        //8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());
    }
}