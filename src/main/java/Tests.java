import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Tests {
    private final static String CHROME_DRIVER_PATH =
            "/Users/pavelpaddubotski/IdeaProjects/OnlinerTest/src/main/resources/chromedriver";

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://catalog.onliner.by");
    }

    @Test
    public void checkCatalogSections() {
        Assertions.assertFalse(
                driver.findElements(By.xpath("//span[contains(text(),'Электроника')]")).isEmpty());
        Assertions.assertFalse(
                driver.findElements(By.xpath("//span[contains(text(),'Компьютеры и сети')]")).isEmpty());
        Assertions.assertFalse(
                driver.findElements(By.xpath("//span[contains(text(),'Бытовая техника')]")).isEmpty());
        Assertions.assertFalse(
                driver.findElements(By.xpath("//span[contains(text(),'Стройка и ремонт')]")).isEmpty());
        Assertions.assertFalse(
                driver.findElements(By.xpath("//span[contains(text(),'Дом и сад')]")).isEmpty());
        Assertions.assertFalse(
                driver.findElements(By.xpath("//span[contains(text(),'Авто и мото')]")).isEmpty());
        Assertions.assertFalse(
                driver.findElements(By.xpath("//span[contains(text(),'Красота и спорт')]")).isEmpty());
        Assertions.assertFalse(
                driver.findElements(By.xpath("//span[contains(text(),'Детям и мамам')]")).isEmpty());
        Assertions.assertFalse(
                driver.findElements(By.xpath("//span[contains(text(),'Детям и мамам')]")).isEmpty());
    }

    @Test
    public void checkComputersAndNetworksList() {
        driver.findElement(By.xpath("//span[contains(text(),'Компьютеры и сети')]")).click();
        Assertions.assertFalse(
                driver.findElements(By.xpath("//div[contains(text(),'Ноутбуки, компьютеры, мониторы')]")).isEmpty());
        Assertions.assertFalse(
                driver.findElements(By.xpath("//div[contains(text(),'Комплектующие')]")).isEmpty());
        Assertions.assertFalse(
                driver.findElements(By.xpath("//div[contains(text(),'Хранение данных')]")).isEmpty());
        Assertions.assertFalse(
                driver.findElements(By.xpath("//div[contains(text(),'Сетевое оборудование')]")).isEmpty());
    }

    @Test
    public void checkAccessoriesList() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Компьютеры и сети')]")).click();
        List<WebElement> accessories = driver
                .findElements(By.xpath("//div[contains(text(),'Комплектующие')]"));
        accessories.get(0).click();
        //Дальше не знаю как найти все элементы списка
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
