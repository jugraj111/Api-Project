package handle_elements;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticeTest extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        printDropDown();
        selectDropDownOptions();
        Thread.sleep(2000);
        tearDown(driver);
    }
    private static void printDropDown(){
        Select selectElements = new Select(driver.findElement(By.id("oldSelectMenu")));
        List<WebElement> allElement = selectElements.getOptions();
        for(int i = 0; i < allElement.size(); i++){
            System.out.println("Element at index "+ i + " is: "+ allElement.get(i).getText());
        }
    }
    private static void selectDropDownOptions() throws InterruptedException{
        Select options = new Select(driver.findElement(By.xpath("//select[@id = 'oldSelectMenu']")));
        Thread.sleep(2000);
        //Element Purple is at index 4 will get selected
        options.selectByIndex(4);
        Thread.sleep(3000);
        //Element selected using visible text
        options.selectByVisibleText("Magenta");
        Thread.sleep(3000);
        //Element selected using value
        options.selectByValue("6");
    }
    private static void tearDown(WebDriver driver){
        driver.close();
    }
}
