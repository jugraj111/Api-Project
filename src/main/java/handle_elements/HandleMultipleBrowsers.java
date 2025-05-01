package handle_elements;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandleMultipleBrowsers extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        handleMultipleBrowsers();
        Thread.sleep(3000);
        tearDown(driver);
    }
    public static void handleMultipleBrowsers() throws InterruptedException{
        //open all child window
        driver.findElement(By.xpath("//button[@id = 'windowButton']")).click();
        driver.findElement(By.xpath("//button[@id = 'messageWindowButton']")).click();
        String mainWindow = driver.getWindowHandle();
        System.out.println("Main window handle: "+ mainWindow);
        //Handle all window
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("All windows handle is:" + allWindows);
        Iterator<String> iterator = allWindows.iterator();
        while(iterator.hasNext()){
            String childWindow = iterator.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                //driver.manage().window().maximize();
                Thread.sleep(1000);
                driver.close();
                System.out.println("Child window is closed");
            }
        }
    }
    public static void tearDown(WebDriver driver){
        driver.quit();
    }
}
