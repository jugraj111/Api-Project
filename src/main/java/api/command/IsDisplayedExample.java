package api.command;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class IsDisplayedExample extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver =new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("Element selected: "+ selectRadioButton());
        tearDown(driver);
    }
    private static boolean selectRadioButton() throws InterruptedException {
        WebElement webElement = driver.findElement(By.id("yesRadio"));
        if(!webElement.isSelected()){
            //webElement.click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", webElement);
            Thread.sleep(1000);
        }
        return true;
    }
    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
