package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
public class PhonePageYandexMarket {
    WebDriver driver;
    // поле ввода "цены до"
    private final By priceToField = By.xpath("//input[starts-with(@id,'range-filter-field-glprice_') and contains(@id,'_max')]");
    // чек-бокс диагонали экрана "3,5-4,9 дюйма"
    private final By screenCheckBox1 = By.cssSelector("[data-filter-value-id='24896372']");
    // чек-бокс диагонали экрана "5-5,4 дюйма"
    private final By screenCheckBox2 = By.cssSelector("[data-filter-value-id='24896370']");
    // чек-бокс диагонали экрана "5,5-5,9 дюйма"
    private final By screenCheckBox3 = By.cssSelector("[data-filter-value-id='24896374']");
    // чек-бокс диагонали экрана "6-6,4 дюйма"
    private final By screenCheckBox4 = By.cssSelector("[data-filter-value-id='24896373']");
    // чек-бокс диагонали экрана "6,5 и больше"
    private final By screenCheckBox5 = By.cssSelector("[data-filter-value-id='24896371']");
    // чек-боксы популярных брендов
    private final By brandCheckBox1 = By.cssSelector("[data-filter-value-id='153043']");
    private final By brandCheckBox2 = By.cssSelector("[data-filter-value-id='7701962']");
    private final By brandCheckBox3 = By.cssSelector("[data-filter-value-id='153061']");
    private final By brandCheckBox4 = By.cssSelector("[data-filter-value-id='16713696']");
    private final By brandCheckBox5 = By.cssSelector("[data-filter-value-id='15292504']");
    // первый товар в списке
    private final By firstProduct = By.xpath("//div[@data-index='1']//h3/a");
    // сортировка по цене
    private final By priceButton = By.xpath("//button[@data-autotest-id='dprice']");

    public PhonePageYandexMarket(WebDriver driver) {
        this.driver = driver;
    }
    public void setPriceToValue(String priceToValue) {
        driver.findElement(priceToField).sendKeys(priceToValue);
    }
    public void scrollScreenCheckBox() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(screenCheckBox5));
    }
    public void chooseScreenCheckBox1() {
        driver.findElement(screenCheckBox1).click();
    }
    public void chooseScreenCheckBox2() {
        driver.findElement(screenCheckBox2).click();
    }
    public void chooseScreenCheckBox3() {
        driver.findElement(screenCheckBox3).click();
    }
    public void chooseScreenCheckBox4() {
        driver.findElement(screenCheckBox4).click();
    }
    public void chooseScreenCheckBox5() {
        driver.findElement(screenCheckBox5).click();
    }
    public void scrollToBrands() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(brandCheckBox5));
    }
    public void chooseFirstBrand() {
        driver.findElement(brandCheckBox1).click();
    }
    public void chooseSecondBrand() {
        driver.findElement(brandCheckBox2).click();
    }
    public void chooseThirdBrand() {
        driver.findElement(brandCheckBox3).click();
    }
    public void chooseFourthBrand() {
        driver.findElement(brandCheckBox4).click();
    }
    public void chooseFifthBrand() {
        driver.findElement(brandCheckBox5).click();
    }
    public String getFirstProductName() {
        return driver.findElement(firstProduct).getText();
    }
    public void choosePriceOrder() {
        driver.findElement(priceButton).click();
    }
    public void setScreenCheckBoxes() {
        scrollScreenCheckBox();
        chooseScreenCheckBox1();
        chooseScreenCheckBox2();
        chooseScreenCheckBox3();
        chooseScreenCheckBox4();
        chooseScreenCheckBox5();
    }
    public void setBrandCheckBoxes() {
        scrollToBrands();
        chooseFirstBrand();
        chooseSecondBrand();
        chooseThirdBrand();
        chooseFourthBrand();
        chooseFifthBrand();

    }
    public void scrollFirstProduct() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(firstProduct));
    }
    public void waitForLoadPhonePage() {
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }
}




