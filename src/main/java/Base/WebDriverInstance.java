package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverInstance {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if(driver.get() == null){
            try {
                driver.set(createDriver());

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return driver.get();
    }

    public static WebDriver createDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream data = new FileInputStream("C:\\Users\\user\\Desktop\\QA\\Selenium\\BankApp\\src\\main\\java\\resources\\config.properties");
        prop.load(data);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\QA\\Selenium\\BankApp\\src\\main\\java\\drivers\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }


    public static void cleanUpDriver(){
        driver.get().quit();
        driver.remove();
    }

}
