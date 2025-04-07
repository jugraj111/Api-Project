package handle_elements;

import common.CommonConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PromptAlert extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        promptAlert();
        Thread.sleep(4000);
        tearDown(driver);
    }
    public static void promptAlert() throws InterruptedException{
        driver.findElement(By.id("promtButton")).click();
        Alert prompt = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println("Prompt alert text is: " + prompt.getText());
        prompt.sendKeys("Jugraj Singh");
        prompt.accept();
    }
    public static void tearDown(WebDriver driver) {
        driver.close();
    }
}
