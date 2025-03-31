package api.command;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class IsSelected extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        System.out.println("Is element selected: "+ isSelected());
        selected();
        tearDown(driver);
    }
    private static boolean isSelected(){
        if(driver.findElement(By.xpath("//input[@id = 'yesRadio']")).isSelected()){
           return true;
        }
        else {
            return false;
        }
    }

    private static void selected() throws InterruptedException{
        WebElement radioElement = driver.findElement(By.xpath("//input[@id = 'yesRadio']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", radioElement);
        Thread.sleep(2000);
        System.out.println("Is selected: " + radioElement.isSelected());
    }
    private static void tearDown(WebDriver driver){
        driver.close();
    }
}
