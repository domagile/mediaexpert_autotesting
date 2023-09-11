package shop.mediaexpert;

import shop.mediaexpert.constants.Constants;
import org.junit.Test;
import shop.mediaexpert.pages.CartPage;
import shop.mediaexpert.pages.LoginPage;
import shop.mediaexpert.pages.MainPage;
import shop.mediaexpert.pages.ProductPage;


public class CartAdditionDeletionWithPreliminaryLoginTest {
    @Test
    public void testCartAdditionDeletion() throws InterruptedException {
        MainPage mainPage = MainPage.open();
        mainPage.closeCookieBanner();
        LoginPage loginPage = mainPage.clickAccountMenuItem();
        loginPage.setEmail(Constants.Login.EMAIL);
        loginPage.setPasswordField(Constants.Login.PASSWORD);
        loginPage.clickLogin();
        ProductPage productPage = mainPage.searchProduct(Constants.Products.POCKETBOOK_INKPAD);
        productPage.clickAddToCart();
        productPage.closeGuaranteeBanner();
        CartPage cartPage = productPage.clickGoToCart();
        cartPage.deleteItemFromCart();
        cartPage.confirmDeletion();
        cartPage.waitTextWhenDeleteItem();
    }
}