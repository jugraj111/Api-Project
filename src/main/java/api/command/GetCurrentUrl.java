package api.command;

import common.CommonConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GetCurrentUrl extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://skillupautomation.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        currentUrl();
        tearDown(driver);

    }
    private static void currentUrl(){
        String url = driver.getCurrentUrl();
        System.out.println("The current URL is: "+ url);
    }
    private static void tearDown(WebDriver driver){ driver.close(); }
}
