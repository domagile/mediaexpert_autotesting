package shop.mediaexpert.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class MainPage extends BasePage {
    By accountMenu = By.xpath("//div[@class='account']");
    By cookieBannerLocator = By.xpath("//div[@class=\"ot-sdk-row\"]//button[text()='ZAAKCEPTUJ WSZYSTKIE']");
    By searchBarLocator = By.xpath("//input[@placeholder=\"Wyszukaj w sklepie\" and not(@disabled)]");
    By buttonSearchItem = By.xpath("//button[contains(@class, 'spark-button') and contains(@class, 'search-input-button') and not(@disabled)]");


    private MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static MainPage open() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .withLogOutput(System.out)
                .usingDriverExecutable(new File("D:\\app\\chromedriver\\chromedriver.exe"))
                .build();
        WebDriver driver = new ChromeDriver(service);

        String baseURL = "https://www.mediaexpert.pl/";

        driver.get("http://google.com");
        driver.manage().window().maximize();

        WebElement button = driver.findElement(By.id("L2AGLb"));
        button.click();

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("mediaexpert");
        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(), 'Media Expert | Sklep internetowy RTV, AGD, komputery')]"))).click();

        // driver.get(baseURL);
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        return new MainPage(driver, wait);
    }

    public void closeCookieBanner() {
        WebElement cookieBanner = getWait().until(ExpectedConditions.presenceOfElementLocated(cookieBannerLocator));
        cookieBanner.click();
    }

    public LoginPage clickAccountMenuItem() {
        getDriver().findElement(accountMenu).click();
        return new LoginPage(getDriver(), getWait());
    }

    public ProductPage searchProduct(String searchProduct) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(searchBarLocator));
        WebElement searchInput = getDriver().findElement(searchBarLocator);
        searchInput.sendKeys(searchProduct);
        WebElement clickButton = getWait().until(ExpectedConditions.presenceOfElementLocated(buttonSearchItem));
        clickButton.click();
        return new ProductPage(getDriver(), getWait());
    }
}
