package api.command;

import common.CommonConfig;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CloseQuit extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://skillupautomation.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        closeQuit();
        tearDown(driver);
    }
    private static void closeQuit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");

        String originalHandle = driver.getWindowHandle();
        for(String handle : driver.getWindowHandles()) {
            if(!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.get("https://demoqa.com/text-box");
    }
    private static void tearDown(WebDriver driver) {
        driver.close();
        driver.quit();
    }
}
