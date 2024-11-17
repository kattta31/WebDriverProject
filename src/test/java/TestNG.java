import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import java.util.ArrayList;
import java.util.List;


public class TestNG {

    @Test
    public void clickTenthLinkTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        ArrayList<WebElement> allLinks = (ArrayList<WebElement>) driver.findElements(By.tagName("a"));
        allLinks.get(9).click();
        // ArrayList<WebElement> allLinks = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        //allLinks.get(9).click();

        driver.quit();
    }


    @Test
    public void categoryHomeClickTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement categoryHome = driver.findElement(By.xpath("//li[@class='general-0']//a[@href='https://litecart.stqa.ru/en/']"));
        categoryHome.click();

        Assert.assertEquals(driver.getTitle(), "Online Store | My Store");
        driver.quit();
    }

    @Test
    public void categoryRubberDucksClickTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement categoryRubberDucks = driver.findElement(By.xpath("//nav[@class='twelve-eighty']//" +
                "a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));
        categoryRubberDucks.click();

        Assert.assertEquals(driver.getTitle(), "Rubber Ducks | My Store");

        driver.quit();
    }

    @Test
    public void categorySubcategoryClickTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement categoryRubberDucks = driver.findElement(By.xpath("//nav[@class='twelve-eighty']//" +
                "a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']"));

        Actions builder = new Actions(driver);
        builder.moveToElement(categoryRubberDucks).perform();

        WebElement categorySubcategory = driver.findElement(By.xpath("//li[@class='category-2']//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/'] "));
        categorySubcategory.click();

        Assert.assertEquals(driver.getTitle(), "Subcategory | My Store");

        driver.quit();
    }

    @Test
    public void doubleClickTest() {
        String expectedAlertText = "You double clicked me.. Thank You..";
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), expectedAlertText);
        alert.accept();

        driver.quit();
    }

    @Test
    public void rightClickTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClickButton = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

        Actions actions = new Actions(driver);
        actions.contextClick(rightClickButton).perform();

        WebElement menuListEdit = driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-edit']/span"));
        Assert.assertEquals(menuListEdit.getText(), "Edit");

        driver.quit();
    }

    @Test
    public void inputUnregisteredUserloginTest() {
        String login = "katta@tut.by";
        String password = "123123";

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement loginInput = driver.findElement(By.cssSelector("input[type='text']"));
        loginInput.sendKeys(login);
        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInput.sendKeys(password);

        WebElement loginButton =  driver.findElement(By.cssSelector("button[value='Login']"));
        loginButton.click();

        Assert.assertEquals(driver.getTitle(), "Login | My Store");

        driver.quit();

    }

    @Test
    public void checkAddToCartTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


        driver.get("https://litecart.stqa.ru/en/");

        WebElement purpleDuckLink = driver.findElement(By.cssSelector("[alt='Purple Duck']"));
        purpleDuckLink.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector("[name='add_cart_product'][type='submit']"));
        addToCartButton.click();

        By cartQuantityLabelLocator = By.cssSelector("span[class='quantity']");
        WebElement cartQuantityLabel = driver.findElement(cartQuantityLabelLocator);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span[class='quantity']"), "1"));

        Assert.assertEquals(cartQuantityLabel.getText(), "1");

        driver.quit();
    }

    @Test
    public void checkEmptyCartTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement emptyCart = driver.findElement(By.cssSelector("[src='/includes/templates/default.catalog/images/cart.png']"));
        emptyCart.click();
        Assert.assertEquals(driver.getTitle(), "Checkout | My Store");

        driver.quit();
    }

    @Test
    public void newSuccessfulRegistrationTest() throws InterruptedException {
        String email;
        String password;
        String firstName = "John";
        String lastName = "Johnson";
        String address = "150 5th Avenue";
        String postcode = "10128";
        String city = "New York";
        String phone = "+123456789";
        String password_confirmed = "b123123";
        String randomNumber = String.valueOf((int) (Math.floor(Math.random() * 10000)));
        email = "mail" + randomNumber + "@mail.com";
        System.out.println(randomNumber);
        password = "b123123";
        WriteToFile(email, password);

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        WebElement linkForNewCustomers = driver.findElement(By.cssSelector("#box-account-login " +
                "a[href='https://litecart.stqa.ru/en/create_account']"));
        linkForNewCustomers.click();
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        WebElement addressInput = driver.findElement(By.name("address1"));
        WebElement postcodeInput = driver.findElement(By.name("postcode"));
        WebElement cityInput = driver.findElement(By.name("city"));
        WebElement selectCountry = driver.findElement(By.name("country_code"));
        WebElement emailRegInput = driver.findElement(By.name("email"));
        WebElement phoneInput = driver.findElement(By.name("phone"));
        WebElement passwordRegInput = driver.findElement(By.name("password"));
        WebElement confirmedPasswordInput = driver.findElement(By.name("confirmed_password"));
        WebElement createAccountButton = driver.findElement(By.name("create_account"));
        WebElement newsLetterCheckbox = driver.findElement(By.name("newsletter"));

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        addressInput.sendKeys(address);
        postcodeInput.sendKeys(postcode);
        cityInput.sendKeys(city);
        Select dropDown = new Select(selectCountry);
        dropDown.selectByVisibleText("United States");
        emailRegInput.sendKeys(email);
        phoneInput.sendKeys(phone);
        passwordRegInput.sendKeys(password);
        confirmedPasswordInput.sendKeys(password_confirmed);
        newsLetterCheckbox.click();
        createAccountButton.click();
        Thread.sleep(1000);
        WebElement noticesWrapper = driver.findElement(By.id("notices-wrapper"));
        Assert.assertEquals(noticesWrapper.getAttribute("style"), "");
    }

    public static void WriteToFile(String email, String password) {
        try {
            FileWriter fileWriter = new FileWriter("D:\\Java\\WebDriverProject\\registrationCredentials.txt", true);
            fileWriter.append("\n Email: " + email + " Password: " + password);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Sorry, can't write to file. Full error message: " + e.getMessage());
        }
    }


}