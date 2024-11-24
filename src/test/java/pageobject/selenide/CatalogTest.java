package pageobject.selenide;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.List;

public class CatalogTest extends TestBase {

    @Test
    public void sortByNameFullComparison() {
        CatalogPage.clickLinkRubberDuckNavigationPanel();
        List<String> listBefore = CatalogPage.getListOfTitles();
        Collections.sort(listBefore);
        CatalogPage.clickSortByNameButton();
        List<String> listAfterClickSortByNameButton = CatalogPage.getListOfTitles();
        Assert.assertTrue(CatalogPage.CompareLists(listBefore, listAfterClickSortByNameButton));
    }
}
