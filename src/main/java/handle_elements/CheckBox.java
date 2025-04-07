package handle_elements;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CheckBox extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        checkBoxSelect();
        checkBoxDeSelect();
        tearDown(driver);

    }
    private static void checkBoxSelect() throws InterruptedException{
        WebElement checkBoxElement = driver.findElement(By.xpath("//input[@id = 'hobbies-checkbox-1']"));
        if(!checkBoxElement.isSelected()){
            JavascriptExecutor select = (JavascriptExecutor)driver;
            select.executeScript("arguments[0].click()",checkBoxElement);
            Thread.sleep(2000);
            System.out.println("checkbox selected");
        }
        else{
            System.out.println("checkbox is already selected");
        }
    }
    private static void checkBoxDeSelect() throws InterruptedException {
        WebElement checkBoxElement = driver.findElement(By.xpath("//input[@id = 'hobbies-checkbox-1']"));
        if (checkBoxElement.isSelected()) {
            JavascriptExecutor deSelect = (JavascriptExecutor) driver;
            deSelect.executeScript("arguments[0].click()", checkBoxElement);
            System.out.println("checkbox deSelected");
            Thread.sleep(2000);
        }
    }
    private static void tearDown(WebDriver driver) {
        driver.close();
    }
}
