package pageobject.staticPageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CatalogPage {


    private static By linkRubberDucksNavigationPanel = By.cssSelector("#box-category-tree nav a");
    private static By sortByNameButton = By.cssSelector(".filter " +
            "a[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name']");
    private static By ulItem = By.cssSelector("#box-category ul.listing-wrapper.products");
    private static By liItem = By.tagName("li");
    private static By linkItem = By.cssSelector("a.link");


    public static void clickLinkRubberDuckNavigationPanel(WebDriver driver) {
        driver.findElement(linkRubberDucksNavigationPanel).click();
    }

    public static void clickSoftByNameButton(WebDriver driver) {
        driver.findElement(sortByNameButton).click();
    }

    public static List<String> getListOfDucksInCatalog(WebDriver driver) {

        // Поиск элемента <ul> с классом 'listing-wrapper products'
        WebElement ulElement = driver.findElement(ulItem);
        // Получение всех элементов <li> в списке
        List<WebElement> liElements = ulElement.findElements(liItem);
        // Список для хранения значений атрибута title
        List<String> titleList = new ArrayList<>();
        // Извлечение атрибута title из каждого элемента <li> и добавление в список
        for (WebElement li : liElements) {
            // Поиск элемента <a> с классом 'link' внутри <li>
            WebElement linkElement = li.findElement(linkItem);
            String titleValue = linkElement.getAttribute("title");
            titleList.add(titleValue);
        }
        return titleList;
    }

    public static String getFirstItemFromList(WebDriver driver) {
        return CatalogPage.getListOfDucksInCatalog(driver).getFirst();
    }

    public static String getLastItemFromList(WebDriver driver) {
        return CatalogPage.getListOfDucksInCatalog(driver).getLast();
    }
}