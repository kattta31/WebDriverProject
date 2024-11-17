package pageobject.staticPageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest extends TestBase {

    @Test
    public void checkEmptyCartTest() {

        LoginPage.clickCart(driver);
        Assert.assertEquals(CartPage.getEmptyCartMessageText(driver), "There are no items in your cart.");

    }

    @Test
    public void checkAddToCartTest() {

        LoginPage.clickPurpleDuckLink(driver);
        LoginPage.clickAddToCartButton(driver);
        LoginPage.waitForTextToBe(driver, "1");
        Assert.assertEquals(LoginPage.getTextFromCartQuantityLabel(driver), "1");

    }
}
