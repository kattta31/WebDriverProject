package pageobject.selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends TestBase {

    @Test
    public void checkEmptyCartTest() {
        LoginPage.clickCart();
        CartPage.validateEmptyCartMessageText("There are no items in your cart.");
    }

    @Test
    public void checkAddToCartTest() {
        LoginPage.clickPurpleDuckLink();
        LoginPage.clickAddToCartButton();
        LoginPage.validateTextFromCartQuantityLabel( "1");
    }
}
