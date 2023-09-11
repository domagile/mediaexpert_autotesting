package shop.mediaexpert;

import shop.mediaexpert.constants.Constants;
import org.junit.Test;
import shop.mediaexpert.pages.LoginPage;
import shop.mediaexpert.pages.MainPage;

//todo: change structure of classes vs test cases
public class LoginTest {
    @Test
    public void testLogin() {
        MainPage mainPage = MainPage.open();
        mainPage.closeCookieBanner();
        LoginPage loginPage = mainPage.clickAccountMenuItem();
        loginPage.setEmail(Constants.Login.EMAIL);
        loginPage.setPasswordField(Constants.Login.PASSWORD);
        loginPage.clickLogin();
        loginPage.waitForGreetingLoginText();
    }
}
