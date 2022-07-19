package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class HomePage extends BasePage {
    public WebDriver driver;

    By name = By.xpath("//div[@class='login-container']/h2");
    By icons = By.xpath("//button[@class='btn-icons']");
    By changePassword = By.xpath("//div[contains(@class,'btns')]/button");
    By logout = By.xpath("//div[contains(@class,'btns')]/button[2]");
    By date = By.xpath("//div[@class='date-container']/p");
    By sum = By.xpath("//span[@class='money-container']");
    By listOfUsers = By.xpath("//ul");
    By onlineUser = By.xpath("//*[@class='online']");
    By allUsers = By.xpath("//*[@class='false']");
    By deposit = By.xpath("//input[@class='deposit-input']");
    By withdraw = By.xpath("//input[@class='transfer-input']");
    By depositBtn = By.xpath("//input[@class='deposit-input']/following-sibling::button");
    By withDrawBtn = By.xpath("//input[@class='transfer-input']/following-sibling::button");
    By movementContainer = By.xpath("//section[@class='transaction-section']");
    By depositMov = By.xpath("//div[@class='mov-container'][last()]/span[contains(text(),'Deposit')]");
    By AllWithdrawMovs = By.xpath("//div[@class='withdraw']");
    By allDepositMovs = By.xpath("//div[@class='mov-container']");
    By depTransaction = By.xpath("//div[@class='mov-container'][last()]");
    By withdrawMov = By.xpath("//div[@class='withdraw'][last()]/span[contains(text(),'Withdraw')]");
    By dateOfWithDraw = By.xpath("//div[@class='withdraw'][last()]/span");
    By dateOfDeposit = By.xpath("//div[@class='mov-container'][last()]/span");
    By totalDepositAmount = By.xpath("//span[@class='in']");
    By totalWithdrawnAmount = By.xpath("//span[@class='taken']");
    By reverseBtn = By.xpath("//button[contains(text(),'Reverse')]");
    By oldPass = By.xpath("//*[@type='password']");
    By newPass = By.xpath("//span[contains(text(),'New')]/following-sibling::input");
    By confirmPass = By.xpath("//span[contains(text(),'Confirm')]/following-sibling::input");
    By submitBtn = By.xpath("//button[text()='Submit']");
    By cancelBtn = By.xpath("//button[text()='Cancel']");
    By oldPassErr = By.xpath("//*[@class='error']");

    public HomePage() throws IOException {
        super();
    }

    public WebElement getName(){
        this.driver = getDriver();
        return driver.findElement(name);
    }
    public WebElement getOldPassErr(){
        this.driver = getDriver();
        return driver.findElement(oldPassErr);
    }
    public WebElement getCancel(){
        this.driver = getDriver();
        return driver.findElement(cancelBtn);
    }
    public WebElement getSubmitBtn(){
        this.driver = getDriver();
        return driver.findElement(submitBtn);
    }
    public WebElement getConfirmPassword(){
        this.driver = getDriver();
        return driver.findElement(confirmPass);
    }
    public WebElement getOldPass(){
        this.driver = getDriver();
        return driver.findElement(oldPass);
    }
    public WebElement getNewPass(){
        this.driver = getDriver();
        return driver.findElement(newPass);
    }
    public WebElement getDepTransaction(){
        this.driver = getDriver();
        return driver.findElement(depTransaction);
    }
    public WebElement getIcons(){
        this.driver = driver;
        return driver.findElement(icons);
    }
    public WebElement getChangePassword(){
        this.driver = driver;
        return driver.findElement(changePassword);
    }
    public WebElement getLogout(){
        this.driver = driver;
        return driver.findElement(logout);
    }
    public WebElement getDate(){
        this.driver = driver;
        return driver.findElement(date);
    }
    public WebElement getSum(){
        this.driver = driver;
        return driver.findElement(sum);
    }
    public WebElement getListOfUsers(){
        this.driver = driver;
        return driver.findElement(listOfUsers);
    }
    public WebElement getOnlineUser(){
        this.driver = driver;
        return driver.findElement(onlineUser);
    }
    public WebElement getAllUsers(){
        this.driver = driver;
        return driver.findElement(allUsers);
    }
    public WebElement getDeposit(){
        this.driver = driver;
        return driver.findElement(deposit);
    }
    public WebElement getWithDraw(){
        this.driver = driver;
        return driver.findElement(withdraw);
    }
    public WebElement getWithDrawBtn(){
        this.driver = driver;
        return driver.findElement(withDrawBtn);
    }
    public WebElement getMovementContainer(){
        this.driver = driver;
        return driver.findElement(movementContainer);
    }
    public WebElement getDepositMov(){
        this.driver = driver;
        return driver.findElement(depositMov);
    }
    public WebElement getWithdrawMov(){
        this.driver = driver;
        return driver.findElement(withdrawMov);
    }
    public WebElement getAllDepositValues(){
        this.driver = driver;
        return  driver.findElement(allDepositMovs);
    }
    public WebElement getAllWithDrawValues(){
        this.driver = driver;
        return driver.findElement(AllWithdrawMovs);
    }
    public WebElement getDateOfWithDraw(){
        this.driver = driver;
        return driver.findElement(dateOfWithDraw);
    }
    public WebElement getDateOfDeposit(){
        this.driver = driver;
        return driver.findElement(dateOfDeposit);
    }
    public WebElement getTotalDepositAmount(){
        this.driver = driver;
        return driver.findElement(totalDepositAmount);
    }
    public WebElement getTotalWithdrawnAmount(){
        this.driver = driver;
        return driver.findElement(totalWithdrawnAmount);
    }
    public WebElement getReverseBtn(){
        this.driver = driver;
        return driver.findElement(reverseBtn);
    }
    public WebElement getDepositBtn(){
        this.driver = driver;
        return driver.findElement(depositBtn);
    }



}
