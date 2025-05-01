package handle_elements;

import com.google.j2objc.annotations.Weak;
import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Frames extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException{
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        switchFrameIndex();
        switchFrameNameId();
        switchFrameWebElement();
        tearDown(driver);
    }
    private static void switchFrameIndex() throws InterruptedException{
        //Switch to frame using index
        driver.switchTo().frame(3);
        WebElement frameHeading1 = driver.findElement(By.id("sampleHeading"));
        String heading1 = frameHeading1.getText();
        //print frame 1 heading
        System.out.println("Frame heading by frame index: "+ heading1);
        driver.switchTo().defaultContent();
    }
    private static void switchFrameNameId(){
        //Switch to frame using Id of frame
        driver.switchTo().frame("frame1");
        WebElement frameHeading2 = driver.findElement(By.id("sampleHeading"));
        String heading2 = frameHeading2.getText();
        System.out.println("Frame heading by frame id: "+ heading2);
        driver.switchTo().defaultContent();
    }
    private static void switchFrameWebElement(){
        //Switch to frame using Web Element
        driver.switchTo().frame(driver.findElement(By.id("frame2")));
        WebElement frameHeading3 = driver.findElement(By.id("sampleHeading"));
        String heading3 = frameHeading3.getText();
        System.out.println("Frame heading by Web element: " + heading3);
        driver.switchTo().defaultContent();
    }
    private static void tearDown(WebDriver driver){
        driver.close();
    }
}
