package com.cydeo.tests.cydeo.tests.day09_javaFaker_testBase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFakerPractice {

    @Test
    public void test1(){
        //creating faker object to reach methods
        Faker faker=new Faker();
//slaytta olan github linkinde newLocale bölümü var oradan örneğin tr'yi seçip türkçeyle alakalı print alabiliriz.(türkçe isim mesela)
        //Faker faker2=new Faker(new Locale("tr"));//şeklinde yazıp türkçe özelleştirebiliriz.(başka birçok dil var)
//random isim, numara hatta GoT ile ilgili şeyler bile atıyor.
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));//286-829-0989
//"faker.numerify("554-###-####") şeklinde bir kısmına kendimiz karar verip de yazabiliriz de.

        //letterify() method will return random letters where we pass "?"
        System.out.println("faker.letterify(\"???-????\") = "
                + faker.letterify("???-????"));

        System.out.println("faker.bothify(\"##?#-##?#-#?#?#-##??\") = "
                + faker.bothify("##?#-##?#-#?#?#-##??"));
//bunlarda da bazı yerleri kendimiz belirleyebilriiz.

        System.out.println("faker.finance().creditCard().replaceAll(\"-\",\"\") = " + faker.finance().creditCard().replaceAll("-", ""));
//6767-8123-2783-7851-008 //bu şekilde(replace all yazmadan) credit card formatında yazıyor, istersek replace all ile değişikler de yapabiliriz.
    }
}
