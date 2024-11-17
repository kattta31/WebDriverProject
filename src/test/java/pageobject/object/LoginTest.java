package pageobject.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void methodSetup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void methodTeardown() {
        driver.quit();
    }

    @Test
    public void loginWithCorrectEmailAndWrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        SoftAssert softAssert = new SoftAssert();

        loginPage.loginWithCredentials("kattta@tut.by", "123111");
        softAssert.assertTrue(loginPage.errorMessageIsDisplayed(), "Error message is not displayed");
        softAssert.assertEquals(loginPage.getErrorMessageText(), "Wrong password or the account is disabled, or does not exist");
        softAssert.assertAll();
    }
}
