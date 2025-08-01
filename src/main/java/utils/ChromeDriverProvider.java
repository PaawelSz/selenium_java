
package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ChromeDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        try {
            Path userDataDir = Files.createTempDirectory("chrome-profile-");
            options.addArguments("--user-data-dir=" + userDataDir.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Cannot create temp directory for Chrome profile", e);
        }
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
