package baseMethods;

import locators.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseMethods {
    private WebDriver driver;

    public BaseMethods(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void waitForPageToBeLoaded() {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10)).until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public void clickButtonByText(final String text) {
        driver.findElement(By.xpath("//button/span[text()='" + text + "']")).click();
    }

    public boolean isButtonClicable(final String buttonText) {
        try {
            final WebElement element = driver.findElement(Locators.buttonByText(buttonText));
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void waitForTextVisible(String text) {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(normalize-space(text()),'" + text + "')]")
                ));
    }
}
