package handle_elements;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DropDown3 extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        deSelectAll();
        deSelectByIndex();
        deSelectByValue();
        deSelectByVisibleText();
        tearDown(driver);
    }
    private static void deSelectAll() throws InterruptedException{
        Select deSelect = new Select(driver.findElement(By.id("cars")));
        deSelect.selectByIndex(0);
        deSelect.selectByValue("saab");
        deSelect.selectByVisibleText("Audi");
        Thread.sleep(3000);
        deSelect.deselectAll();
        Thread.sleep(2000);
    }
    private static void deSelectByIndex() throws InterruptedException{
        Select deByIndex = new Select(driver.findElement(By.id("cars")));
        deByIndex.selectByIndex(2);
        deByIndex.selectByValue("audi");
        deByIndex.selectByVisibleText("Volvo");
        Thread.sleep(5000);
        deByIndex.deselectByIndex(3);
        deByIndex.deselectByIndex(0);
    }
    private static void deSelectByValue() throws InterruptedException{
        Select deByIndex = new Select(driver.findElement(By.id("cars")));
        deByIndex.selectByIndex(2);
        deByIndex.selectByValue("audi");
        deByIndex.selectByVisibleText("Volvo");
        Thread.sleep(5000);
        deByIndex.deselectByValue("volvo");
        deByIndex.deselectByValue("opel");
    }
    private static void deSelectByVisibleText() throws InterruptedException{
        Select deByVisibleText = new Select(driver.findElement(By.id("cars")));
        deByVisibleText.selectByIndex(0);
        deByVisibleText.selectByValue("saab");
        deByVisibleText.selectByVisibleText("Audi");
        Thread.sleep(3000);
        deByVisibleText.deselectByVisibleText("Saab");
        deByVisibleText.deselectByVisibleText("Audi");
    }
    private static void tearDown(WebDriver driver){
        driver.close();
    }
}
