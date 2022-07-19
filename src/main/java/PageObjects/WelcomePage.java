package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class WelcomePage extends BasePage {

    public WebDriver driver;

    By loginBtn = By.xpath("//a[@class='btn']");
    By registerBtn = By.xpath("//a[@class='btn'][2]");
    By loginHeaderBtn = By.xpath("//a[@class='header-btn']");
    By registerHeaderBtn = By.xpath("//a[@class='header-btn'][2]");

    public WelcomePage() throws IOException {
        super();
    }

    public WebElement getLoginBtn(){
        this.driver = getDriver();
        return driver.findElement(loginBtn);
    }
    public WebElement getRegisterBtn(){
        this.driver = getDriver();
        return driver.findElement(registerBtn);
    }
    public WebElement getLoginHeaderBtn(){
        this.driver = getDriver();
        return driver.findElement(loginHeaderBtn);
    }
    public WebElement getRegisterHeaderBtn(){
        this.driver = getDriver();
        return driver.findElement(registerHeaderBtn);
    }
}
