package handle_elements;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown2 extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(10000);
        getOption();
        getFirstSelectedOption();
        getSelectedOptions();
        tearDown(driver);
    }
    private static void getOption(){
        Select byGetOption = new Select(driver.findElement(By.xpath("//select[@id = 'oldSelectMenu']")));
        //Select and get all options by getOption
        List<WebElement> options = byGetOption.getOptions();
        //Enhanced for loop
        /*for (WebElement option : options) {
            System.out.println("Dropdown option element is: "+ option.getText());
        }*/
        for(int i = 0; i < options.size(); i++){
            System.out.println("Dropdown option at index "+ i +" is: "+ options.get(i).getText());
        }
    }
    private static void getFirstSelectedOption(){
     Select firstOption = new Select(driver.findElement(By.id("cars")));
     try {
         WebElement option = firstOption.getFirstSelectedOption();
         System.out.println("First selected option is " + option.getText());
     } catch (NoSuchElementException e){
         System.out.println("No element is selected");
     }
    }
    private static void getSelectedOptions(){
        Select selectedOptions = new Select(driver.findElement(By.id("cars")));
        List<WebElement> options = selectedOptions.getAllSelectedOptions();
        for(WebElement option : options){
            System.out.println("Selected element " + option.getText());
        }
    }
    private static void tearDown(WebDriver driver){
        driver.close();
    }
}
