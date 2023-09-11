package shop.mediaexpert;

import shop.mediaexpert.constants.Constants;
import org.junit.Test;
import shop.mediaexpert.pages.CartPage;
import shop.mediaexpert.pages.LoginPage;
import shop.mediaexpert.pages.MainPage;
import shop.mediaexpert.pages.ProductPage;


public class CartAdditionWithIntermediateLoginTest {
    @Test
    public void testAdditionToCartWithLogin() throws InterruptedException {
        MainPage mainPage = MainPage.open();
        mainPage.closeCookieBanner();

        ProductPage productPage = mainPage.searchProduct(Constants.Products.TV_SAMSUNG);
        productPage.clickAddToCart();
        productPage.closeGuaranteeBanner();
        CartPage cartPage = productPage.clickGoToCart();
        //todo: check text "TV" or what?
        cartPage.waitTextOnDeliveryStep();

        cartPage.selectPaymentMethod();
        cartPage.closeBannerSoftProduct();
        LoginPage loginPage = cartPage.clickNextAtCartStep();
        loginPage.setEmail(Constants.Login.EMAIL);
        loginPage.setPasswordField(Constants.Login.PASSWORD);
        loginPage.clickLogin();
        cartPage.waitTextForGreetingCart();
    }
}