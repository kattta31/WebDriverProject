package pageobject.staticPageobject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CatalogTest extends TestBase {

    @Test
    public void softDuckByName() {
        SoftAssert softAssert = new SoftAssert();
        CatalogPage.clickLinkRubberDuckNavigationPanel(driver);
        CatalogPage.clickSoftByNameButton(driver);
        softAssert.assertEquals(CatalogPage.getFirstItemFromList(driver), "Blue Duck");
        softAssert.assertEquals(CatalogPage.getLastItemFromList(driver), "Yellow Duck");
        softAssert.assertAll();
    }
}
