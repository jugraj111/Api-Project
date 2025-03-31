package api.command;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SendKeyClearClick extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        sendClearClick();
        tearDown(driver);
    }
    private static void sendClearClick() throws InterruptedException{
        driver.findElement(By.xpath("//input[@id = 'userName']")).sendKeys("Jugraj Singh");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id = 'userName']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id = 'submit']")).click();
        Thread.sleep(2000);
    }
    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
