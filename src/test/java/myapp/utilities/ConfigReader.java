package myapp.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {


    // this class is used to read data from configuration.properties file
    // Selenium can't read this properties file directly, so we use Java logic
    // We will use static block to make the path of the properties file available before anything

    private static Properties properties;




    static {
        String path = "configuration.properties";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);

            fileInputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){
        String value = properties.getProperty(key);
        return value;
    }




}




