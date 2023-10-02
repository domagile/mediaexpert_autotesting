package shop.mediaexpert;

import org.junit.Test;
import shop.mediaexpert.constants.Constants;
import shop.mediaexpert.pages.ComparePage;
import shop.mediaexpert.pages.LoginPage;
import shop.mediaexpert.pages.MainPage;
import shop.mediaexpert.pages.ProductPage;

public class CompareProductsTest {

    @Test
    public void addToCompareTest() throws InterruptedException {
        MainPage mainPage = MainPage.open();
        mainPage.closeCookieBanner();

        ProductPage productPage = mainPage.searchProduct(Constants.Products.POCKETBOOK_INKPAD);
        productPage.scroll();
        productPage.setAddToCompare();

        mainPage.searchProduct(Constants.Products.AMAZON_KINDLE);
        productPage.scroll();
        productPage.setAddToCompare();
        ComparePage comparePage = productPage.clickCompare();

        comparePage.scrollUntilElementVisible();
        LoginPage loginPage = comparePage.clickSaveCompare();
        loginPage.setEmail(Constants.Login.EMAIL);
        loginPage.setPasswordField(Constants.Login.PASSWORD);
        loginPage.clickLogin();

        Thread.sleep(2000);
        comparePage.clickInputBox();
        comparePage.updateValueAttribute();
        comparePage.inputSaveCompare(Constants.SaveComparison.E_BOOKS);
        comparePage.clickSaveNewCompare();
    }
}
