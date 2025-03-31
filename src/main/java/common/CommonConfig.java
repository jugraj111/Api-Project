package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: Navdeep
 * Date: 2023-06-28
 * Time: 3:10 p.m.
 */

public class CommonConfig {
    public static String chromePath() throws IOException {
        InputStream input = new FileInputStream("src/main/resources/CommonProperties.properties");
        Properties prop = new Properties();
        prop.load(input);
        return prop.getProperty("chrome.driver.path");
    }

}
