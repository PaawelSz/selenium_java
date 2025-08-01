
package pageobjects;

import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    private WebDriver driver;

    public static final String EMAIL_FIELD_ID = "email";
    public static final String PASSWORD_FIELD_ID = "password";
    public static final String ALERT_ROLE = "//span[@role='alert']";
    public static final String LOGIN_WITH_PASSWORD_ID = "login-with-password-link";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsernameEmail(final String username) {
        clearEmailField();
        driver.findElement(Locators.anyHavingId(EMAIL_FIELD_ID)).sendKeys(username);
    }

    public void clickLoginWithPasswordButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(LOGIN_WITH_PASSWORD_ID)))
                .click();
    }

    public void enterUsernameEmailAndPassword(final String username, final String password) {
        clearEmailField();
        enterUsernameEmail(username);
        driver.findElement(Locators.anyHavingId(PASSWORD_FIELD_ID)).sendKeys(password);
    }

    public String getAlertText() {
        return driver.findElement(By.xpath(ALERT_ROLE)).getText();
    }

    private void clearEmailField() {
        driver.findElement(Locators.anyHavingId(EMAIL_FIELD_ID)).clear();
    }
}
