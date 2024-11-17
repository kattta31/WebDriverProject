package pageobject.staticPageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginTest extends TestBase {

    @Test
    public void loginWithCorrectEmailAndWrongPassword() {
        SoftAssert softAssert = new SoftAssert();

        LoginPage.loginWithCredentials(driver, "kattta@tut.by", "123111");
        softAssert.assertTrue(LoginPage.errorMessageIsDisplayed(driver), "Error message is not displayed");
        softAssert.assertEquals(LoginPage.getErrorMessageText(driver), "Wrong password or the account is disabled, or does not exist");
        softAssert.assertAll();
    }


}
