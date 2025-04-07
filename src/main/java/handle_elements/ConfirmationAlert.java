package handle_elements;

import common.CommonConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ConfirmationAlert extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver",chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(4000);
        confirmationAlert();
        Thread.sleep(2000);
        tearDown(driver);

    }
    public static void confirmationAlert() throws InterruptedException{
        driver.findElement(By.id("confirmButton")).click();
        Alert confirm = driver.switchTo().alert();
        System.out.println("Alert text is: "+ confirm.getText());
        Thread.sleep(3000);
        confirm.accept();
        //confirm.dismiss();
    }
    public static void tearDown(WebDriver driver){
        driver.close();
    }
}
