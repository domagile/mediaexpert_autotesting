package shop.mediaexpert.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {
    By buttonAddToCart = By.xpath("(//button/span[contains(., 'koszyka')])[2]");
    By guaranteeBanner = By.xpath("//div[@class=\"close\"]");
    By goToCart = By.xpath("(//span[contains(text(),'Idź do koszyka')])");
    By addToWishListLocator = By.xpath("//span[contains(text(),'Do schowka')]");
    By buttonAddToWishList = By.xpath("//span[contains(text(),'Schowek')]");
    By checkboxCompare = By.xpath("//a//span[contains(text(),'Porównaj')]");
    By clickIconCompare = By.xpath("//a[@href=\"/compare\"]");


    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAddToCart() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(buttonAddToCart)).click();
    }

    public void closeGuaranteeBanner() throws InterruptedException {
        Thread.sleep(5000);
        getWait().until(ExpectedConditions.presenceOfElementLocated(guaranteeBanner)).click();
    }

    public CartPage clickGoToCart() {
        getDriver().findElement(this.goToCart).click();
        return new CartPage(getDriver(), getWait());
    }

    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 500)");
    }

    public void setAddToWishList() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(addToWishListLocator));
        getDriver().findElement(addToWishListLocator).click();
    }

    public WishListPage clickButtonWishList() {
        getDriver().findElement(buttonAddToWishList).click();
        return new WishListPage(getDriver(), getWait());
    }

    public void setAddToCompare() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(checkboxCompare));
        WebElement checkbox = getDriver().findElement(checkboxCompare);

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public ComparePage clickCompare() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(clickIconCompare));
        getDriver().findElement(clickIconCompare).click();
        return new ComparePage(getDriver(), getWait());
    }

}
