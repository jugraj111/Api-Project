package synchronization;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExplicitWait extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        //implicit wait declaration
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        explicitWait();
        tearDown(driver);
    }
    private static void explicitWait() throws InterruptedException {
        //explicit wait declaration
        WebDriverWait wait = new WebDriverWait(driver, 15);
        System.out.println("Explicit wait start for maximum 15 second to visible element");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for = 'yesRadio']")));
        System.out.println("Explicit wait is over");
    }
    private static void tearDown(WebDriver driver){
        driver.close();
    }
}
