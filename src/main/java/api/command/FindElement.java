package api.command;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElement extends CommonConfig {
    static WebDriver driver;

    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\singh\\OneDrive\\Desktop\\drivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://skillupautomation.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        findElement();
        findElements();
        tearDown(driver);

    }
    public static void findElement(){
        String dropDown = driver.findElement(By.xpath("(//span[@class='wp-block-navigation-item__label'])[2]")).getText();
        System.out.println("Name of navigation bar: "+dropDown);
    }
    public static void findElements() {
        List<WebElement> listElements = driver.findElements(By.xpath("//span[@class='wp-block-navigation-item__label']"));
        for(int i = 0; i < listElements.size(); i++) {
           System.out.println("Available list label name: "+ listElements.get(i).getText());
        }
    }
    public static void tearDown(WebDriver driver){
        driver.close();
    }

}
