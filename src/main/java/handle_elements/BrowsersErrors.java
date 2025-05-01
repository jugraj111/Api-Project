package handle_elements;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BrowsersErrors extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        browsersErrors();
        tearDown(driver);
    }
    private static void browsersErrors() throws InterruptedException{
        //Click on new window button to open new window
        driver.findElement(By.id("windowButton")).click();
        Thread.sleep(3000);
        //Get text from new window and print
        WebElement text = driver.findElement(By.id("sampleHeading"));
        System.out.println("Text on new window is:" + text.getText());
    }
    private static void tearDown(WebDriver driver){
        driver.quit();
    }
}
