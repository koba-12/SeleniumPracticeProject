package com.cydeo.tests.cydeo.tests.day05_testNGIntro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    //bu testNG sayesine artık main method kullanmayacağız.açıklamalar class notesta var.

    @Test
    public void test1(){//test1() parantezzinin içine priority=1 veya başka sayı yazarak methodların hangisinin öncelik
//alacağını(outa çıkarken) belirleyebiliriz.priority öncelik demektir.
        System.out.println("test1 is running...");

        //Assert:TestNG ile doğrulama yapmak için Assert sınıfı yöntemleri kullanılır.
        //assertEquals:aynı 2 şeyi karşılaştırır.
        String expected="apple";
        String actual="apple";
        Assert.assertEquals(expected,actual);//expected, actuale eşittir diyor yani.eşit olmalı.olmazsa print.outta hatayı görürürz(failed yazar raporda)

    }

    @Test
    public void test2(){
        System.out.println("test2 is running...");

        //assertTrue
        String expected="apple";
        String actual="apple";
        Assert.assertTrue(expected.equals(actual));//bunun syntaxı da bu.bu da eşit mi diye bakar ancak boolean döndürür.
        //2. argümentten sonra mesaj ekleyebiliriz, developer vs için
    }
    //Assert:TestNG ile doğrulama yapmak için Assert sınıfı yöntemleri kullanılır.
    //assertEquals:aynı 2 şeyi karşılaştırır.
    String expected="apple";
    String actual="apple";


    @BeforeClass
    public void setupMethod(){
        System.out.println("--> Before class is running");
    }//bu çalışan ilk class olacaktır her zaman(before class)
    @AfterClass
    public void tearDownClass(){
        System.out.println("--> After class is running");
    }//bu da bir kere çalışır.kapatmak için kullanılır en sonda.

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("--> before method is running...");
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("--> after method is running");
    }
//bu üstteki 2 methodu 1 kere yazmak yeterlidir. tüm @Test methodlarına yansıyacaktır.methodlar arası
// başlangıç ve bitiş belli olsun diye kullanılmaktadır.



}
