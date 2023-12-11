import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.HomePageYandexMarket;
import pages.PhonePageYandexMarket;
import pages.ProductPageYandexMarket;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class FirstProductTest extends BaseTest {
    HomePageYandexMarket objHomePage;
    PhonePageYandexMarket objPhonePage;
    ProductPageYandexMarket objProductPage;

    @Before
    public void createUser() {
        objHomePage = new HomePageYandexMarket(driver);
        objPhonePage = new PhonePageYandexMarket(driver);
        objProductPage = new ProductPageYandexMarket(driver);
    }
    @Test
    public void firstProductTest() throws InterruptedException {

        objHomePage.getPhonePage();
        objPhonePage.setPriceToValue("20000");
        objPhonePage.setScreenCheckBoxes();
        objPhonePage.setBrandCheckBoxes();
        Thread.sleep(10000);
        List<WebElement> numberOfProducts = driver.findElements(By.xpath("//div[@data-index]"));
        System.out.println("Количество товаров в списке - " + numberOfProducts.size());
        assertEquals("Количество товаров на странице не соответствует ожидаемому",10,numberOfProducts.size());
        objPhonePage.scrollFirstProduct();
        String firstProductName=objPhonePage.getFirstProductName();
        System.out.println("Первый товар в списке - " + firstProductName);
        objPhonePage.choosePriceOrder();
        objPhonePage.waitForLoadPhonePage();
        WebElement element = driver.findElement(By.xpath("//div//span[contains(text(),'" + firstProductName + "')]"));
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
        javaScriptExecutor.executeScript("arguments[0].click()", element);
        String productRating=objProductPage.getProductRating();
        System.out.println("Рейтинг товара составляет " + productRating);
        }
    }
