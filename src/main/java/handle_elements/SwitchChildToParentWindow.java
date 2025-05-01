package handle_elements;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchChildToParentWindow extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException, InterruptedException{
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        switchChildToParentWindow();
        tearDown(driver);
    }
    private static void switchChildToParentWindow() throws InterruptedException{
        driver.findElement(By.id("windowButton")).click();
        String mainWindow = driver.getWindowHandle();
        System.out.println("Main window handle: " + mainWindow);
        //Handle all new open window
        Set<String> allWindow = driver.getWindowHandles();
        Iterator<String> iterator = allWindow.iterator();
        while (iterator.hasNext()){
            String childWindow = iterator.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                driver.manage().window().maximize();
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Text in child window is: "+ text.getText());
                Thread.sleep(1000);
                driver.close();
                System.out.println("Child window closed");
            }
        }
        driver.switchTo().window(mainWindow);
        WebElement tabButtonText = driver.findElement(By.id("tabButton"));
        System.out.println("Main window tab button text is: " + tabButtonText.getText());
    }
    private static void tearDown(WebDriver driver){
        driver.close();
    }
}
