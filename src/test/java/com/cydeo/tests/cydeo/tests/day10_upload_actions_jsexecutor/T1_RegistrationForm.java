package com.cydeo.tests.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.cydeo.Utilities.ConfigurationReader;
import com.cydeo.tests.cydeo.Utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T1_RegistrationForm {

    @Test
    public void registrationFormTest(){
        //TC#1: Registration form confirmation
        //Note: Use JavaFaker OR read from configuration.properties file when possible.
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        //Driver.getDriver()--> driver //yani Driver.getDriver(), artık driver yerine geçiyor.(driver utility class sebebiyle)
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
//driver utility class sayesinde sadece Driver.getDriver diyerek tüm browser açma,maximize etme,süre koyma vs hepsini yapabiliyoruz.
//sonra da linki açmak için de configurationReadera eklediğimiz url bölümünün keyini yazıyoruz. ve bu sayede birkaç satır
//süren ve vakit alan bu işi kolaylıkla yapmış oluyoruz.
        //create javaFaker object//aşağıda bir isim vs... girmemiz gerektiği için javaFaker kütüphanemizi kullanıyoruz.
        Faker faker=new Faker();
        //3. Enter first name
        WebElement inputFirstName=Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys(faker.name().firstName());//first name atamış olduk javaFaker sayesinde
        //4. Enter last name
        WebElement inputLastName=Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());
        //5. Enter username
        WebElement inputuserName=Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        //inputuserName.sendKeys(faker.name().username().replaceAll(".",""));//usernamede araya oto nokta koyuyor ama site
//kabul etmiyor.o yüzden böyle bir şey yapılabilir. ya da aşağıdaki gibi de yapılabilir daha garanti
        //inputuserName.sendKeys(faker.bothify("helpdesk###"));
//ya da emaille birlikte kullanmak için aşağıdaki gibi de yapabiliriz.
        String user=faker.bothify("helpdesk###");
        inputuserName.sendKeys(user);
        //6. Enter email address
        WebElement inputEmail=Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(user+"@email.com");
//usernamele birlikte kullandığımız için örneğin username=helpdesk123 ise email de helpdesk123@email.com olur.
        //7. Enter password
        WebElement inputPassword=Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys(faker.numerify("#######"));
        //faker.internet().password();//bu da bir alternatif
        //8. Enter phone number
        WebElement inputPhoneNumber=Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        //inputPhoneNumber.sendKeys(faker.phoneNumber().cellPhone());//bu da alternatif
        inputPhoneNumber.sendKeys(faker.numerify("###-###-####"));
        //9. Select a gender from radio buttons
        WebElement inputGender=Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        inputGender.click();
        //10. Enter date of birth
        WebElement inputBirthday=Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        faker.number().numberBetween(1,12);//bu şekilde yazabiliriz hepsini tek tek ama örneğin 30 şubat vs gibi sonuçlar çıkabilir güvenilirdeğil.
        inputBirthday.sendKeys("15/12/1995");//bu daha garanti yani manuel yazmak
        //11. Select Department/Office
        Select departmentDropdown=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
//dropdown olduğu için webElement olarak değil, select olarak bulduk.
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));
//dropdownun indexlerinden bulmak istedik ve selectByIndex dedik.sonra da 9 a kadar indexi olduğu için number of between dedik.
//bildiğimiz üzere htmlde de indexler 0 dan başlıyor ancak 0'da select department olduğu ve biz bunu seçmek istemediğimiz için 0'ı yazmadık.
        //12. Select Job Title
        //13. Select programming language from checkboxes
        //14. Click to sign up button
        //15. Verify success message “You’ve successfully completed registration.” is displayed
        //Note:
        //1. Use new Driver utility class and method
        //2. User JavaFaker when possible
        //3. User ConfigurationReader when it makes sense
    }
}
