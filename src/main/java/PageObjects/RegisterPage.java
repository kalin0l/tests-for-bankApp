package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class RegisterPage extends BasePage {
    public WebDriver driver;


    public RegisterPage() throws IOException {
        super();
    }

    By loginHeaderBtn = By.xpath("//a[@class='header-btn']");
    By registerBtn = By.xpath("//a[@class='header-btn'][2]");
    By username = By.xpath("//input[@type='text']");
    By email = By.xpath("//input[@type='email']");
    By pass = By.xpath("//input[@type='password']");
    By confirmPassword = By.xpath("//*[text()='Confirm password']/following-sibling::input[@type='password']");
    By signUpBtn = By.xpath("//button[@class='btn']");
    By usernameErr = By.xpath("//input[@type='text']/following-sibling::p");
    By emailErr = By.xpath("//input[@type='email']/following-sibling::p");
    By passErr = By.xpath("//input[@type='password']/following-sibling::p");
    By confirmPassErr = By.xpath("//input[@type='password']/following-sibling::p[contains(text(),'Passwords')]");

    public WebElement getUsernameErr(){
        this.driver = getDriver();
        return driver.findElement(usernameErr);
    }
    public WebElement getConfirmPassErr(){
        this.driver = getDriver();
        return driver.findElement(confirmPassErr);
    }
    public WebElement getPassErr(){
        this.driver = getDriver();
        return driver.findElement(passErr);
    }
    public WebElement getEmailErr(){
        this.driver = getDriver();
        return driver.findElement(emailErr);
    }

    public WebElement getLoginHeaderBtn(){
        this.driver = getDriver();
        return driver.findElement(loginHeaderBtn);
    }
    public WebElement getRegisterBtn(){
        this.driver = getDriver();
        return driver.findElement(registerBtn);
    }
    public WebElement getUsername(){
        this.driver = getDriver();
        return driver.findElement(username);
    }
    public WebElement getEmail(){
        this.driver = getDriver();
        return driver.findElement(email);
    }
    public WebElement getPassword(){
        this.driver = getDriver();
        return driver.findElement(pass);
    }
    public WebElement getConfirmPassword(){
        this.driver = getDriver();
        return driver.findElement(confirmPassword);
    }
    public WebElement getSignUpBtn(){
        this.driver = getDriver();
        return driver.findElement(signUpBtn);
    }

}
