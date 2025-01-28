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

    /*
       Note: all of our current codes still works, because this driver is work for quential(singleton) and parallel testing
        */
    private Driver(){}



    //    private static WebDriver driver;
//    1. Use ThreadLocal WebDriver for parallel testing.
//    Type of the driver is still WebDriver, but this driver is now ThreadLocal
//    driver is thread safe variable to make sure each thread can create a copy of its own driver instance



    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    //    2 Driver.getDriver() will be used in the test classes
//    This will return copy of the driver instance for each thread(browser)



    public static WebDriver getDriver(){
        if (driver.get()==null){
            initializeDriver();
        }
        return driver.get();
    }




    //    3. initialize the WebDriver instance


    public static void initializeDriver(){
        switch (ConfigReader.getProperty("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup(); //WebDriverManager, ihtiyaç duyduğunuz tarayıcı sürücüsünün doğru sürümünü otomatik olarak indirir ve ayarlar.
                // Bu, özellikle tarayıcılar ve sürücüler sık sık güncellendiğinde faydalıdır.etup() metodu, tarayıcı sürücülerinin her zaman doğru sürümde ve çalışmaya hazır olmasını sağlayarak, otomasyon testlerinizin sorunsuz bir şekilde çalışmasına yardımcı olur.
//                    driver=new ChromeDriver();
                driver.set(ThreadGuard.protect(new ChromeDriver())); //using ThreadGuard is more protection. it provide to each of this driver is used in different thread
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(ThreadGuard.protect(new FirefoxDriver()));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(ThreadGuard.protect(new EdgeDriver()));
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver.set(ThreadGuard.protect(new SafariDriver()));
                break;
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                driver.set(ThreadGuard.protect(new ChromeDriver(new ChromeOptions().addArguments("--headless=new"))));
                break;
        }
//            driver -> driver.get()
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get().manage().window().maximize();
    }
    //    4. close driver


    public static void closeDriver(){
        if (driver!=null){
            driver.get().quit();
            driver.remove();
        }
    }

}
