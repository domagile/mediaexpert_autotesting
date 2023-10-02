package shop.mediaexpert;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import shop.mediaexpert.constants.Constants;
import org.junit.Test;
import shop.mediaexpert.pages.LoginPage;
import shop.mediaexpert.pages.MainPage;
import shop.mediaexpert.pages.ProductPage;
import shop.mediaexpert.pages.WishListPage;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class AdditionToWishListTest {

    @Test
    @Order(1)
    public void loginAndAdditionToWishListTest() {
        MainPage mainPage = MainPage.open();
        mainPage.closeCookieBanner();
        LoginPage loginPage = mainPage.clickAccountMenuItem();
        loginPage.setEmail(Constants.Login.EMAIL);
        loginPage.setPasswordField(Constants.Login.PASSWORD);
        loginPage.clickLogin();
        ProductPage productPage = mainPage.searchProduct(Constants.Products.POCKETBOOK_INKPAD);
        productPage.scroll();
        productPage.setAddToWishList();
        WishListPage wishListPage = productPage.clickButtonWishList();
        wishListPage.waitNameItemTextFirstProduct();
    }

    @Test
    @Order(2)
    public void additionToWishListAndLoginTest() {
        MainPage mainPage = MainPage.open();
        mainPage.closeCookieBanner();
        ProductPage productPage = mainPage.searchProduct(Constants.Products.AMAZON_KINDLE);
        productPage.scroll();
        productPage.setAddToWishList();
        LoginPage loginPage = mainPage.clickAccountMenuItem();
        loginPage.setEmail(Constants.Login.EMAIL);
        loginPage.setPasswordField(Constants.Login.PASSWORD);
        loginPage.clickLogin();
        WishListPage wishListPage = productPage.clickButtonWishList();
        wishListPage.refreshPage();
        wishListPage.waitNameItemTextSecondProducts();
    }

    @Test
    @Order(3)
    public void deleteFromWishListTest() {
        MainPage mainPage = MainPage.open();
        mainPage.closeCookieBanner();
        LoginPage loginPage = mainPage.clickAccountMenuItem();
        loginPage.setEmail(Constants.Login.EMAIL);
        loginPage.setPasswordField(Constants.Login.PASSWORD);
        loginPage.clickLogin();
        WishListPage wishListPage = mainPage.clickButtonWishList();
        wishListPage.refreshPage();
        wishListPage.removeProduct();
        wishListPage.waitEmptyWishListText();
    }
}