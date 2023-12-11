package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPageYandexMarket {
    WebDriver driver;
   // рейтинг
    private final By ratingButton = By.xpath("//div[@data-apiary-widget-id='/content/page/fancyPage/productRating']//span[@class='ybvaC']");
    public ProductPageYandexMarket(WebDriver driver) {
        this.driver = driver;
    }
    public String getProductRating() {
        for (String tab: driver.getWindowHandles()){driver.switchTo().window(tab);}
        return driver.findElement(ratingButton).getText();
    }
}