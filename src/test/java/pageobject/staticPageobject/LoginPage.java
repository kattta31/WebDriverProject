package pageobject.staticPageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");
    private static By errorMessageLabel = By.cssSelector(".notice.errors");
    private static By purpleDuckLink = By.cssSelector("[alt='Purple Duck']");
    private static By addToCartButton = By.cssSelector("[name='add_cart_product'][type='submit']");
    private static By cartQuantityLabelLocator = By.cssSelector("span[class='quantity']");
    private static By cartLink = By.cssSelector("[src='/includes/templates/default.catalog/images/cart.png']");


    public static void typeEmail(WebDriver driver, String email) {

        driver.findElement(emailInput).sendKeys(email);
    }

    public static void typePassword(WebDriver driver, String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public static void clickLoginButton(WebDriver driver) {
        driver.findElement(loginButton).click();
    }

    public static void loginWithCredentials(WebDriver driver, String email, String password) {
        typeEmail(driver, email);
        typePassword(driver, password);
        clickLoginButton(driver);
    }

    public static boolean errorMessageIsDisplayed(WebDriver driver) {
        return driver.findElement(errorMessageLabel).isDisplayed();
    }

    public static String getErrorMessageText(WebDriver driver) {
        return driver.findElement(errorMessageLabel).getText();
    }
    public static void clickPurpleDuckLink(WebDriver driver) {
               driver.findElement(purpleDuckLink).click();
    }

    public static void clickAddToCartButton(WebDriver driver) {
        driver.findElement(addToCartButton).click();
    }

    public static void waitForTextToBe(WebDriver driver, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.textToBe(cartQuantityLabelLocator, expectedText));
    }

    public static String getTextFromCartQuantityLabel(WebDriver driver) {
        return driver.findElement(cartQuantityLabelLocator).getText();
    }

    public static void clickCart(WebDriver driver) {
        driver.findElement(cartLink).click();
    }


}
