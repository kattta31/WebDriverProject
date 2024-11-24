package pageobject.selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {

    private static By linkRubberDucksNavigationPanel = By.cssSelector("#box-category-tree nav a");
    private static By sortByNameButton = By.cssSelector(".filter " +
            "a[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name']");
    private static By ulItem = By.cssSelector("#box-category ul.listing-wrapper.products");
    private static By liItem = By.tagName("li");
    private static By linkItem = By.cssSelector(".listing-wrapper.products li .link");

    public static void clickLinkRubberDuckNavigationPanel() {
        $(linkRubberDucksNavigationPanel).click();
    }

    public static void clickSortByNameButton() {
        $(sortByNameButton).click();
    }

    public static List<String> getListOfTitles() {
        SelenideElement ulElement = $(ulItem);
        List<String> listOfTitles = ulElement.findAll(".listing-wrapper.products li .link")
                .stream()
                .map(card -> card.getAttribute("title"))
                .collect(Collectors.toList());
        System.out.println();
        listOfTitles.forEach(System.out::println);
        return listOfTitles;
    }

    public static boolean CompareLists(List<String> listBefore, List<String> listAfter) {
        Collections.sort(listBefore);
        if (listBefore.equals(listAfter)) {
            System.out.println("Списки равны.");
            return true;
        } else {
            System.out.println("Списки не равны.");
            return false;
        }
    }
}