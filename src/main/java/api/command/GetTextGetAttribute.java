package api.command;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GetTextGetAttribute extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        getTextGetAttribute();
        tearDown(driver);
    }
    private static void getTextGetAttribute() throws InterruptedException{
        String textName = driver.findElement(By.xpath("//label[@id= 'userEmail-label']")).getText();
        System.out.println("Email label text is: "+ textName);
        Thread.sleep(2000);
        String placeHolder = driver.findElement(By.xpath("//input[@placeholder='Full Name']")).getAttribute("placeholder");
        System.out.println("Placeholder name is: "+ placeHolder);
        Thread.sleep(2000);
    }
    private static void tearDown(WebDriver driver) { driver.close();}
}
