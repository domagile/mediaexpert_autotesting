package shop.mediaexpert.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import shop.mediaexpert.constants.Constants;

import java.time.Duration;

public class ComparePage extends BasePage {
    By waitBanner = By.xpath("//span[@class=\"is-text close is-regular\"]");
    By discountBanner = By.xpath("//i[@class=\"icon close icon-x01\"]");
    By saveTheComparison = By.xpath("(//span[contains(., 'Zapisz porównanie')])[2]");
    By inputNameCompareProducts = By.xpath("//div[contains(@class, 'spark-input') and @name='title']//input[@type='text']");
    By buttonSaveComparison = By.xpath("(//span[contains(., '   Zapisz')])");
    By comparisonNameDiv = By.xpath("//div[contains(@class, 'spark-input') and @name='title']");

    private final WebDriverWait smallTimeoutWait;

    protected ComparePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        smallTimeoutWait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    private void clickWithBanners(By toBeClicked) {
        for (int i = 0; i < 5; i++) {
            if (waitWithSmallTimeout(waitBanner)) {
                getDriver().findElement(waitBanner).click();
                return;
            } else if (waitWithSmallTimeout(discountBanner)) {
                getDriver().findElement(discountBanner).click();
                return;
            } else if (waitWithSmallTimeout(toBeClicked)) {
                getDriver().findElement(toBeClicked).click();
                return;
            }
        }
    }

    private boolean waitWithSmallTimeout(By locator) {
        try {
            smallTimeoutWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public void scrollUntilElementVisible() {
        int maxScrollAttempts = 5;
        int scrollAttempts = 0;
        WebElement element = null;

        while (scrollAttempts < maxScrollAttempts) {
            try {
                element = getDriver().findElement(saveTheComparison);
                if (element.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, 300);");
                scrollAttempts++;
            }
        }

        if (element == null || !element.isDisplayed()) {
        }
    }

    public LoginPage clickSaveCompare() {
        clickWithBanners(saveTheComparison);
        return new LoginPage(getDriver(), getWait());
    }

    public void clickInputBox() {
        clickWithBanners(inputNameCompareProducts);
    }

    public void inputSaveCompare(String string) {
        clickWithBanners(saveTheComparison);;
        getWait().until(ExpectedConditions.presenceOfElementLocated(inputNameCompareProducts));
        getDriver().findElement(inputNameCompareProducts).sendKeys(Constants.SaveComparison.E_BOOKS);
    }

    public void clickSaveNewCompare() {
        getDriver().findElement(buttonSaveComparison).click();
    }

    public void updateValueAttribute() throws InterruptedException {
        WebElement element = getDriver().findElement(comparisonNameDiv);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].setAttribute('value', '')", element);
        Thread.sleep(5000);
    }
}
