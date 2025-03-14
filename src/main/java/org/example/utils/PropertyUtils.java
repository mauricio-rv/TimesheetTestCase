package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    public static String getProperty(String key)  {
        try{
            Properties prop = new Properties();
            InputStream inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream("application.properties");
            prop.load(inputStream);
            return prop.getProperty(key);
        }
        catch(IOException e){
            e.printStackTrace();

            return "";
        }
    }
}