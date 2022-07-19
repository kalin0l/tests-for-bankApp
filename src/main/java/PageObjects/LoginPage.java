package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage extends BasePage {

    public WebDriver driver;

    By email = By.xpath("//input[@type='email']");
    By pass = By.xpath("//input[@type='password']");
    By forgotPassLink = By.xpath("//a[@class='forgot-pw']");
    By loginFormBtn = By.xpath("//button[@class='btn']");
    By loginHeaderBtn = By.xpath("//a[@class='header-btn']");
    By registerBtn = By.xpath("//a[@class='header-btn'][2]");
    By emailErr = By.xpath("//input[@type='email']/following-sibling::p");
    By passErr = By.xpath("//input[@type='password']/following-sibling::p");

    public LoginPage () throws IOException {
        super();
    }

    public WebElement getEmail(){
        this.driver = getDriver();
        return driver.findElement(email);
    }
    public WebElement getPassErr(){
        this.driver = getDriver();
        return driver.findElement(passErr);
    }
    public WebElement getEmailErr(){
        this.driver = getDriver();
        return driver.findElement(emailErr);
    }
    public WebElement getPass(){
        this.driver = getDriver();
        return driver.findElement(pass);
    }
    public WebElement getForgotPassLink(){
        this.driver = getDriver();
        return driver.findElement(forgotPassLink);
    }
    public WebElement getLoginFormBtn(){
        this.driver = getDriver();
        return driver.findElement(loginFormBtn);
    }
    public WebElement getLoginHeaderBtn(){
        this.driver = getDriver();
        return driver.findElement(loginHeaderBtn);
    }
    public WebElement getRegisterBtn(){
        this.driver = getDriver();
        return driver.findElement(registerBtn);
    }


}
