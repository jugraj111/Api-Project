package api.command;

import common.CommonConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TryAndCatch extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException, ArrayIndexOutOfBoundsException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //Thread.sleep(2000);
        System.out.println("Is displayed: "+ tryCatch());
        System.out.println("Is displayed: "+ tryCatch1());
        tryCatch3();
        tryCatch2();
        tearDown(driver);
    }
    private static void tearDown(WebDriver driver){
        driver.close();
    }
    private static boolean tryCatch(){
        try {
            if(driver.findElement(By.xpath("//label[@for = 'yesRadio']")).isDisplayed()) {
                return true;
            } else {
                return false;
            }
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
    private static boolean tryCatch1(){
        try {
            if(driver.findElement(By.xpath("//label[@for = 'yesRadi']")).isDisplayed()) {
                return true;
            } else {
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }
    }
    private static void tryCatch2(){
        try{
            int ary[] = {2,4};
            for(int i = 0 ; i < 5; i++ ){
                System.out.println("Array number at inder  "+ i +" is : "+ ary[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bound");
        } catch (NoSuchElementException b){
            System.out.println("Unknown exception");
        }
    }
    private static void tryCatch3() throws ArrayIndexOutOfBoundsException {
        int ary[] = {1,3,5};
        for(int i = 0; i < 5; i++){
            System.out.println("Number at index "+ i +" is :" + ary[i]);
        } 
    }

}
