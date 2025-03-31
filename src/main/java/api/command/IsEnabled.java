package api.command;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class IsEnabled extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("Element is enabled: "+ isEnabled());
        tearDown(driver);
    }
    private static boolean isEnabled() throws InterruptedException{
        try {
            if(driver.findElement(By.xpath("//input[@id = 'noRadio']")).isEnabled()) {
                return true;
            }
            else{
                return false;
            }
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
    private static void tearDown(WebDriver driver){
        driver.close();
    }
}
