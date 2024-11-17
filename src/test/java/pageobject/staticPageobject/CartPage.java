package pageobject.staticPageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private static By emptyCartMessage = By.cssSelector("#checkout-cart-wrapper>p>em");


    public static String getEmptyCartMessageText(WebDriver driver) {
        return driver.findElement(emptyCartMessage).getText();
    }


}

