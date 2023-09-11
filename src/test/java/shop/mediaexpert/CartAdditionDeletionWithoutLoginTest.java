package shop.mediaexpert;

import shop.mediaexpert.constants.Constants;
import org.junit.Test;
import shop.mediaexpert.pages.CartPage;
import shop.mediaexpert.pages.MainPage;
import shop.mediaexpert.pages.ProductPage;


public class CartAdditionDeletionWithoutLoginTest {
    @Test
    public void testAdditionDeletion() throws InterruptedException {
        MainPage mainPage = MainPage.open();
        mainPage.closeCookieBanner();
        ProductPage productPage = mainPage.searchProduct(Constants.Products.POCKETBOOK_INKPAD);
        productPage.clickAddToCart();
        productPage.closeGuaranteeBanner();
        CartPage cartPage = productPage.clickGoToCart();
        cartPage.deleteItemFromCart();
        cartPage.confirmDeletion();
        cartPage.waitTextWhenDeleteItem();
    }
}