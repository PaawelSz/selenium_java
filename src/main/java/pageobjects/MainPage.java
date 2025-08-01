
package pageobjects;

import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    private final WebDriver driver;

    public static final String LOGIN_BUTTON_TEXT = "Login";
    public static final String EMIAL_LEFT_TOP_CORNER = "//div[@class='top-left']";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(Locators.anyHavingTextValue(LOGIN_BUTTON_TEXT)).click();
    }


    public String getTextFromLeftTopCornerEmail() {
        return driver.findElement(By.xpath(EMIAL_LEFT_TOP_CORNER)).getText();
    }
}
