package synchronization;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Fluent extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        //implicit wait declaration
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //unconditional wait
        Thread.sleep(5000);
        fluentWait();
        tearDown(driver);
    }
    private static void fluentWait() throws InterruptedException{
        //fluent wait declaration
        Wait<WebDriver> fluentWait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class, TimeoutException.class);
        System.out.println("Fluent wait start for 15 seconds but polling every 5 second until visible of element");
        fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for = 'impressiveRadio']")));
        System.out.println("Fluent wait is over");
    }
    private static void tearDown(WebDriver driver){
        driver.close();
    }
}
