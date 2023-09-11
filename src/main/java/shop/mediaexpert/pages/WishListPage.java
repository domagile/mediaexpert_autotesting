package shop.mediaexpert.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListPage extends BasePage {
    By waitNameItemInWishList = By.xpath("//h5[contains(text(), \"Czytnik E-Booków POCKETBOOK InkPad Lite Szary\")]");
    protected WishListPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitNameItemText()
    {
        getWait().until(ExpectedConditions.presenceOfElementLocated(waitNameItemInWishList)).getText();
    }
}
