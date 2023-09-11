package shop.mediaexpert.pages;

import shop.mediaexpert.constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    protected LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By loginBox = By.xpath("//div[@class=\"content\"]//input[@type=\"email\"]");
    By passwordBox = By.xpath("//input[@type=\"password\"]");
    By buttonLogin = By.xpath("//span[contains(text(),'Zaloguj się')]");


    public void setEmail(String password) {
        getDriver().findElement(loginBox).sendKeys(Constants.Login.EMAIL);
    }

    public void setPasswordField(String email) {
        getDriver().findElement(passwordBox).sendKeys(Constants.Login.PASSWORD);
    }

    public void clickLogin() {
        getDriver().findElement(buttonLogin).click();
    }

    public void waitForGreetingLoginText() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Witaj Olha Bom')]")));
    }
}


