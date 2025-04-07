package handle_elements;

import common.CommonConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SimpleAlert extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver",chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        simpleAlert();
        tearDown(driver);
    }
    public static void simpleAlert() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id = 'alertButton']")).click();
        Alert simple = driver.switchTo().alert();
        Thread.sleep(3000);
        simple.accept();
    }
    public static void tearDown(WebDriver driver) {
        driver.close();
    }
}
