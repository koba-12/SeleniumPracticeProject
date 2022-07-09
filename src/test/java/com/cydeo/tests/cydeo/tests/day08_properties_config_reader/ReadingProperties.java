package com.cydeo.tests.cydeo.tests.day08_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

//configuration.properties olarak oluşturduğumuz file ile bağlantılı
    @Test
    public void readingFromPropertiesTest() throws IOException {
        //1-Create the object of properties
        Properties properties=new Properties();

        //2-We need to open the file in java memory:fileInputStream
        FileInputStream file=new FileInputStream("configuration.properties");

        //3-Load the properties object using fileInputStream object
        properties.load(file);

        //4-Use "properties" object to read value
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
//browser,env,username hepsi "key"dir.
//configuration.properties file da # ile "//" nın görevini yapıyoruz.(sanırım tüm filelar için geçerli)ve kelimeden sonra space koymamalıyız.
    }
}
