package shop.mediaexpert.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListPage extends BasePage {
    By waitNameFirstProduct = By.xpath("//h5[contains(text(), \"Czytnik E-Booków POCKETBOOK InkPad Lite Szary\")]");
    By waitNameSecondProduct = By.xpath("//h5[contains(text(), \"Czytnik E-Booków AMAZON Kindle Oasis 3 Złoty \")]");
    By buttonRemove = By.xpath("//span[contains(text(),'Usuń wszystkie')]");
    By textEmptyWishList = By.xpath("//h3[contains(text(),'Mój schowek jest pusty')]");

    protected WishListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void waitNameItemTextFirstProduct() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(waitNameFirstProduct)).getText();
    }

    public void waitNameItemTextSecondProducts() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(waitNameSecondProduct)).getText();
    }

    public void removeProduct() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(buttonRemove));
        WebElement buttonRemoveAllWishList = getDriver().findElement(buttonRemove);
        buttonRemoveAllWishList.click();
    }

    public void waitEmptyWishListText() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(textEmptyWishList));
    }
}
