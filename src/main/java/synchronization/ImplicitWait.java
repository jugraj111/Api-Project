package synchronization;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ImplicitWait extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        //implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //Unconditional synchronization wait
        Thread.sleep(5000);
        System.out.println("Element is enabled : "+ implicitWait());
        tearDown(driver);
    }
    private static boolean implicitWait(){
       if(driver.findElement(By.xpath("//input[@id = 'noRadio']")).isEnabled()) {
                return true;
            } else {
                return false;
            }
    }
    private static void tearDown(WebDriver driver){
        driver.close();
    }
}
