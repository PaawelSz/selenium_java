package locators;

import org.openqa.selenium.By;

public class Locators {

    public static By anyHavingId(final String id) {
        return By.xpath("//*[@id='" + id + "']");
    }

    public static By buttonByText(final String buttonText) {
        return By.xpath("//button[normalize-space(text())='" + buttonText + "']/ancestor::button");
    }

    public static By anyHavingTextValue(final String text) {
        return By.xpath("//*[normalize-space(text())='" + text + "']");
    }

    public static By mainHeader() {
        return By.xpath("//h1)");
    }
}
