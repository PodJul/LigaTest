package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageYandexMarket {
    WebDriver driver;
    // кнопка "Каталог"
    private final By catalogButton = By.xpath ("//div[@data-apiary-widget-name='@light/NavigationMenu']");
    // текст "Электроника"
    private final By electronicsButton = By.cssSelector("._1010X[href='/catalog--elektronika/54440']");
    // текст "Смартфоны"
    private final By phoneButton = By.cssSelector("[href='/catalog--smartfony/26893750/list?hid=91491&glfilter=21194330%3A34066443']");
    public HomePageYandexMarket(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForLoadHomePage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(catalogButton));
    }
    public void clickCatalogButton() {
        driver.findElement (catalogButton).click();
    }
    public void moveToElectronicsButton() {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(electronicsButton));
        WebElement webElement = driver.findElement (electronicsButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();}
    public void clickPhoneButton() {
        driver.findElement (phoneButton).click();}
    public void getPhonePage() {
        waitForLoadHomePage();
        clickCatalogButton();
        moveToElectronicsButton();
        clickPhoneButton();}
}
