package pageobject.selenide;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {

    @Test
    public void loginWithCorrectEmailAndWrongPassword() {
        LoginPage.loginWithCredentials("kattta@tut.by", "123111");
        LoginPage.validateErrorMessageIsDisplayed();
        LoginPage.validateErrorMessageText("Wrong password or the account is disabled, or does not exist");
    }

    @Test
    public void InputOfAnUnregisteredUser() {
        LoginPage.loginWithCredentials("katyakarpukhina31@gmail.com", "123111");
        LoginPage.validateErrorMessageIsDisplayed();
        LoginPage.validateErrorMessageText("Wrong password or the account is disabled, or does not exist");
    }

    @Test
    public void RegisteredUserInput() {
        LoginPage.loginWithCredentials("kattta@tut.by", "123123");
        LoginPage.valideSuccessMessageIsDisplayed();
        LoginPage.valideSuccessMessageText("You are now logged in as Katya Karpukhina.");
    }

}
