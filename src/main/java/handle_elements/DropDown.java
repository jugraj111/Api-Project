package handle_elements;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DropDown extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        selectByIndex();
        selectByValue();
        selectByVisibleText();
        tearDown(driver);

    }
    private static void selectByIndex() throws InterruptedException{
        Select byIndex = new Select(driver.findElement(By.xpath("//select[@id = 'oldSelectMenu']")));
        //Select the option by index
        byIndex.selectByIndex(3);
        Thread.sleep(2000);
    }
    private static void selectByValue() throws InterruptedException{
        Select byValue = new Select(driver.findElement(By.xpath("//select[@id = 'oldSelectMenu']")));
        //Select the option by value
        byValue.selectByValue("5");
        Thread.sleep(2000);
    }
    private static void selectByVisibleText() throws InterruptedException{
        Select byVisibleText = new Select(driver.findElement(By.xpath("//select[@id = 'oldSelectMenu']")));
        //Select the option by visible text
        byVisibleText.selectByVisibleText("Indigo");
        Thread.sleep(2000);
    }
    private static void tearDown(WebDriver driver){
        driver.close();
    }
}
