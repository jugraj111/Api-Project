package handle_elements;

import common.CommonConfig;
import net.sourceforge.htmlunit.corejs.javascript.ast.WhileLoop;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.ComboBoxUI;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ChildBrowserHandle extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        childBrowserHandle();
        tearDown(driver);
    }
    public static void childBrowserHandle() throws InterruptedException{
        driver.findElement(By.id("windowButton")).click();
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while(iterator.hasNext()){
            String childWindow = iterator.next();
            if(!mainWindowHandle.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                driver.manage().window().maximize();
                Thread.sleep(3000);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window text is: "+ text.getText());
            }
        }driver.switchTo().window(mainWindowHandle);
        Thread.sleep(3000);
    }
    private static void tearDown(WebDriver driver){
        driver.quit();
    }
}
