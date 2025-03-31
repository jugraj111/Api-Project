package api.command;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.util.concurrent.TimeUnit;

public class IsDisplayed extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        isDisplayed();
        tearDown(driver);

    }
    private static void isDisplayed() throws InterruptedException {
        //boolean displayed = driver.findElement(By.xpath("//a[@id='close-fixedban']")).isDisplayed();
        try{
            if(driver.findElement(By.xpath("//a[@id='close-fixedban']")).isDisplayed()) {
                System.out.println("Element displayed is: True");

            }
            else {
                System.out.println("Element displayed is: False");
            }
        }
        catch(NoSuchElementException e) {
            System.out.println("No such element found");
        }
    }
    private static void tearDown(WebDriver driver) {
        driver.close();
    }

}
