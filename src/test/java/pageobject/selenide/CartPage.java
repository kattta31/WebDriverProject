package pageobject.selenide;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private static By emptyCartMessage = By.cssSelector("#checkout-cart-wrapper>p>em");

    public static void validateEmptyCartMessageText(String expectedText) {
        $(emptyCartMessage).shouldHave(Condition.text(expectedText));
    }
}

