package com.cydeo.tests.cydeo.Utilities;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1-Create the object of properties
    private static Properties properties=new Properties();

    static {

        try {
            //2-We need to open the file in java memory:fileInputStream
            FileInputStream file=new FileInputStream("configuration.properties");

            //3-Load the properties object using fileInputStream object
            properties.load(file);

            //close the file
            file.close();

        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }//try-catch zaten öneriyor bize hep, hata olduğu zaman.
    }

    public static String getProperty(String keyword){////value string olduğu için burayı string yazdık
        return properties.getProperty(keyword);//usernamele eşleşir
    }
}
