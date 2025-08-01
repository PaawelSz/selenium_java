
package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FirefoxDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();

        try {
            Path profileDir = Files.createTempDirectory("firefox-profile-");
            FirefoxProfile profile = new FirefoxProfile(profileDir.toFile());
            options.setProfile(profile);
        } catch (IOException e) {
            throw new RuntimeException("Cannot create temp directory for Firefox profile", e);
        }

        options.setHeadless(true);

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
