package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage extends WebDriverInstance {

    private String url;
    private Properties prop;

    public BasePage () throws IOException {
        prop = new Properties();
        FileInputStream data = new FileInputStream("C:\\Users\\user\\Desktop\\QA\\Selenium\\BankApp\\src\\main\\java\\resources\\config.properties");
        prop.load(data);
    }

    public static WebDriver getDriver(){
        return WebDriverInstance.getDriver();
    }

    public String getUrl(){
        url = prop.getProperty("url");
        return url;
    }
    public static void wait4ElVisible(WebElement el, Duration time) throws IOException {
        WebDriverWait wait = new WebDriverWait(getDriver(),time);
        wait.until(ExpectedConditions.invisibilityOf(el));

    }


}
