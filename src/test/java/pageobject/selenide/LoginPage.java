package pageobject.selenide;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");
    private static By errorMessageLabel = By.cssSelector(".notice.errors");
    private static By purpleDuckLink = By.cssSelector("[alt='Purple Duck']");
    private static By addToCartButton = By.cssSelector("[name='add_cart_product'][type='submit']");
    private static By cartQuantityLabelLocator = By.cssSelector("span[class='quantity']");
    private static By cartLink = By.cssSelector("[src='/includes/templates/default.catalog/images/cart.png']");
    private static By successMessageLabel = By.cssSelector(".notice.success");

    public static void typeEmail(String email) {

        $(emailInput).sendKeys(email);
    }

    public static void typePassword(String password) {
        $(passwordInput).sendKeys(password);
    }

    public static void clickLoginButton() {
        $(loginButton).click();
    }

    public static void loginWithCredentials(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }

    public static void validateErrorMessageIsDisplayed() {
        $(errorMessageLabel).shouldBe(visible);
    }

    public static void validateErrorMessageText(String expectedText) {
        $(errorMessageLabel).shouldHave(Condition.text(expectedText));
    }

    public static void clickPurpleDuckLink() {
        $(purpleDuckLink).click();
    }

    public static void clickAddToCartButton() {
        $(addToCartButton).click();
    }

    public static void validateTextFromCartQuantityLabel(String expectedText) {
        $(cartQuantityLabelLocator).shouldHave(Condition.text(expectedText));
    }

    public static void clickCart() {
        $(cartLink).click();
    }

    public static void valideSuccessMessageIsDisplayed() {
        $(successMessageLabel).shouldBe(visible);
    }

    public static void valideSuccessMessageText(String expectedText) {
        $(successMessageLabel).shouldHave(Condition.text(expectedText));
    }

}
