package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class ForgotPassPage extends BasePage {
    public WebDriver driver;

    By email = By.xpath("//input[@type='email']");
    By continueBtn = By.xpath("//a[@class='btn']");
    By pass = By.xpath("//input[@type='password']");
    By confirmPass = By.xpath("//span[contains(text(),'Confirm')]/following-sibling::input");
    By resetBtn = By.xpath("//a[@class='btn']");

    public ForgotPassPage() throws IOException {
        super();
    }

    public WebElement getEmail(){
        this.driver = getDriver();
        return driver.findElement(email);
    }
    public WebElement getResetBtn(){
        this.driver = getDriver();
        return driver.findElement(resetBtn);
    }
    public WebElement getconfirmPass(){
        this.driver = getDriver();
        return driver.findElement(confirmPass);
    }
    public WebElement getPass(){
        this.driver = getDriver();
        return driver.findElement(pass);
    }
    public WebElement getContinueBtn(){
        this.driver = getDriver();
        return driver.findElement(continueBtn);
    }

}
