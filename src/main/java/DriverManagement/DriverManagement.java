package DriverManagement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.Properties;

public class DriverManagement {
    protected static WebDriver driver;
    private static Properties prop;
    private static String path;
    protected WebDriverWait wait = new WebDriverWait(driver, 10);
    public static void loadProps() {
        System.out.println("initilize props");
        path = System.getProperty("user.dir");
        BufferedReader reader;
        String propertyFilePath = path + "/src/main/java/Config/config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            prop = new Properties();
            try {
                prop.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public static int getWait() {
        String wait = prop.getProperty("WAIT");
        if(wait != null) {
            return Integer.parseInt(wait);
        }
        else throw new RuntimeException("wait not found in properties config");
    }

    public static String getURL() {
        String url = prop.getProperty("URL");
        if(url != null) {
            return url;
        }
        else throw new RuntimeException("URL not found in properties config");
    }

    public static void initializeDriver(){
        if (driver != null) {
            return;
        }
        loadProps();
        System.setProperty("webdriver.chrome.driver",
                path + "/src/main/resources/drivers/chromedriver-mac");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().setScriptTimeout(DriverManagement.getWait(),
                TimeUnit.SECONDS);
    }
    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
