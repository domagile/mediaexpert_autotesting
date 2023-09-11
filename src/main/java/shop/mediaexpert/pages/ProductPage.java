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

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAddToCart() {
        WebElement clickButton = getWait().until(ExpectedConditions.presenceOfElementLocated(buttonAddToCart));
        clickButton.click();
    }

    public void closeGuaranteeBanner() throws InterruptedException {

        WebElement closeBanner = getWait().until(ExpectedConditions.presenceOfElementLocated(guaranteeBanner));
        Thread.sleep(5000);
        closeBanner.click();
    }

    public CartPage clickGoToCart() {
        WebElement goToCart = getDriver().findElement(this.goToCart);
        goToCart.click();
        return new CartPage(getDriver(), getWait());
    }

    public void scroll()
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 500)");
    }

    public void setAddToWishListLocator(){

        getWait().until(ExpectedConditions.presenceOfElementLocated(addToWishListLocator));
        WebElement addToFavorites = getDriver().findElement(addToWishListLocator);
        addToFavorites.click();
    }

    public WishListPage clickButtonWishList(){
        WebElement buttonGoToWishList = getDriver().findElement(buttonAddToWishList);
        buttonGoToWishList.click();
        return new WishListPage(getDriver(), getWait());
    }
}
