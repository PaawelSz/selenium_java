
package utils;

import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {
    private static WebDriver driver;
    private static WebDriverProvider provider;

    private static String getBrowserFromConfig() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty("browser", "chrome").toLowerCase();
    }

    public static void setProvider(WebDriverProvider p) {
        provider = p;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            if (provider == null) {
                String browser = getBrowserFromConfig();
                switch (browser) {
                    case "firefox":
                        provider = new FirefoxDriverProvider();
                        break;
                    case "chrome":
                    default:
                        provider = new ChromeDriverProvider();
                        break;
                }
            }
            driver = provider.createDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
