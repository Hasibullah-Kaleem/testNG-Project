package myapp.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;

import java.time.Duration;

public class Driver {


    private Driver(){}



//    private static WebDriver driver;

    //1. Use threadlocal Webdriver to run parallel testing and also you can use normal as you do.......
    //2. Type of the driver still webdriver  but this driver is now ThreadLocal.....


    private static  ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static WebDriver getDriver(){

        if(driver.get()==null){

            initializeDriver();

        }

        return driver.get();

    }






    public static void initializeDriver(){


        System.out.println("Initializing WebDriver...");

        switch (ConfigReader.getProperty("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
                driver.set(ThreadGuard.protect(new ChromeDriver()));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
                driver.set(ThreadGuard.protect(new FirefoxDriver()));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
//                    driver = new EdgeDriver();
                driver.set(ThreadGuard.protect(new EdgeDriver()));
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
//                    driver = new SafariDriver();
                driver.set(ThreadGuard.protect(new SafariDriver()));
                break;

            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
                driver.set(ThreadGuard.protect(new ChromeDriver(new ChromeOptions().addArguments("--headless"))));
                break;
        }

        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get().manage().window().maximize();




    }

    public static void closeDriver(){
        if (driver != null){
            driver.get().quit();
            driver = null;
        }
    }

}