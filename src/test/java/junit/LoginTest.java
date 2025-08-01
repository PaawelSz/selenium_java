
package junit;

import baseMethods.BaseMethods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;
import pageobjects.LoginPage;
import utils.ChromeDriverProvider;
import utils.DriverManager;

public class LoginTest {
    private WebDriver driver;
    private BaseMethods baseMethods;
    private LoginPage loginPage;
    private MainPage mainPage;


    @BeforeEach
    public void setup() {
        DriverManager.setProvider(new ChromeDriverProvider());
        driver = DriverManager.getDriver();
        driver.get("http://localhost:8080/");
        mainPage = new MainPage(driver);
        baseMethods = new BaseMethods(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void emptyLoginTest() {
        baseMethods.waitForPageToBeLoaded();
        mainPage.clickLoginButton();
        loginPage.enterUsernameEmail("");
        baseMethods.clickButtonByText("Log In");
        Assertions.assertEquals("Cannot be blank", loginPage.getAlertText());
    }

    @Test
    public void invalidLoginTest() {
        baseMethods.waitForPageToBeLoaded();
        mainPage.clickLoginButton();
        loginPage.enterUsernameEmail("test");
        baseMethods.clickButtonByText("Log In");
        Assertions.assertEquals("Invalid email", loginPage.getAlertText());
    }

    @AfterEach
    public void teardown() {
        DriverManager.quitDriver();
    }
}
