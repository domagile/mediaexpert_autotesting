package shop.mediaexpert;

import shop.mediaexpert.constants.Constants;
import org.junit.Test;
import shop.mediaexpert.pages.LoginPage;
import shop.mediaexpert.pages.MainPage;
import shop.mediaexpert.pages.ProductPage;
import shop.mediaexpert.pages.WishListPage;


public class AdditionToWishListTest {
    @Test
    public void testAdditionToWishList() {
        MainPage mainPage = MainPage.open();
        mainPage.closeCookieBanner();
        LoginPage loginPage = mainPage.clickAccountMenuItem();
        loginPage.setEmail(Constants.Login.EMAIL);
        loginPage.setPasswordField(Constants.Login.PASSWORD);
        loginPage.clickLogin();
        ProductPage productPage = mainPage.searchProduct(Constants.Products.POCKETBOOK_INKPAD);
        productPage.scroll();
        productPage.setAddToWishListLocator();
        WishListPage wishListPage = productPage.clickButtonWishList();
        wishListPage.waitNameItemText();
    }
}