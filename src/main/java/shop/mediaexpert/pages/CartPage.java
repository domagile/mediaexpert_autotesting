package shop.mediaexpert.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    By nextButton = By.xpath("//span[contains(., 'Dalej')]");
    By selectBlik = By.xpath("//span[contains(., 'BLIK')]");
    By bannerSoftProduct = By.xpath("//span[@class='is-text close is-regular' and text()='x']");
    By deleteFromCart = By.xpath("//a[@title=\"Usuń\"]");
    By deletionConfirmation = By.xpath("//span[contains(text(), \"Tak, usuń\")]");
    By textForGreetingCart = By.xpath("//h3[contains(., 'Dane klienta')]");
    By textOnDeliveryStep = By.xpath("//div[contains(text(), \"Dostawa\")]");
    By emptyCartText = By.xpath("//h3[contains(text(), \"Twój koszyk jest pusty\")]");


    protected CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void scrollDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, 2000)");
        Thread.sleep(5000);
    }

    public void closeBannerSoftProduct() {
        try {
            getWait().until(ExpectedConditions.presenceOfElementLocated(bannerSoftProduct));
            WebElement closeBannerSoftProduct = getDriver().findElement(bannerSoftProduct);
            closeBannerSoftProduct.click();
        } catch (TimeoutException e) {
            //banner could be absent and we just catch exception and continue in this case
        }
    }

    public void selectPaymentMethod() throws InterruptedException {
        getWait().until(ExpectedConditions.presenceOfElementLocated(selectBlik));
        getDriver().findElement(selectBlik).click();
        Thread.sleep(5000);
    }

    public LoginPage clickNextAtCartStep() throws InterruptedException {
        getWait().until(ExpectedConditions.presenceOfElementLocated(nextButton));
        getDriver().findElement(nextButton).click();
        Thread.sleep(5000);
        return new LoginPage(getDriver(), getWait());
    }

    public void waitTextForGreetingCart() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(textForGreetingCart));
    }

    public void waitTextOnDeliveryStep() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(textOnDeliveryStep));
    }

    public void waitTextWhenDeleteItem() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(emptyCartText));
    }

    public void deleteItemFromCart() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(deleteFromCart));
        getDriver().findElement(deleteFromCart).click();
    }

    public void confirmDeletion() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(deletionConfirmation));
        getDriver().findElement(this.deletionConfirmation).click();
    }
}
