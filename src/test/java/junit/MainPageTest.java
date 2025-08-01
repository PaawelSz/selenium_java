
package junit;

import baseMethods.BaseMethods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;
import utils.ChromeDriverProvider;
import utils.DriverManager;

public class MainPageTest {
    private WebDriver driver;
    private BaseMethods baseMethods;
    private MainPage mainPage;


    @BeforeEach
    public void setup() {
        DriverManager.setProvider(new ChromeDriverProvider());
        driver = DriverManager.getDriver();
        driver.get("http://localhost:8080/");
        mainPage = new MainPage(driver);
        baseMethods = new BaseMethods(driver);
    }

    @Test
    public void correctLoadMainPageTest() {
        baseMethods.waitForPageToBeLoaded();
        baseMethods.isButtonClicable("Log In");
        baseMethods.isButtonClicable("Register");
        baseMethods.isButtonClicable("Send E-mail");
        Assertions.assertEquals("localTest@email.com", mainPage.getTextFromLeftTopCornerEmail());

    }

    @AfterEach
    public void teardown() {
        DriverManager.quitDriver();
    }
}
