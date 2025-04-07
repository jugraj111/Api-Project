package handle_elements;

import common.CommonConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UnExpectedAlerts extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        unExpectedAlert();
        tearDown(driver);
    }
    public static void unExpectedAlert() throws InterruptedException{
        try{
            driver.findElement(By.id("timerAlertButton")).click();
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert simpleAlert = driver.switchTo().alert();
            Thread.sleep(2000);
            simpleAlert.accept();
            System.out.println("Unexpected alert accepted");
        }
        catch (Exception e) {
            System.out.println("Unexpected alert is not present");
        }

    }
    public static void tearDown(WebDriver driver) {
        driver.close();
    }
}
