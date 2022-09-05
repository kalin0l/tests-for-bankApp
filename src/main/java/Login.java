import Base.Hooks;
import PageObjects.ForgotPassPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.WelcomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login extends Hooks {
    WelcomePage welcome = new WelcomePage();
    static HomePage home;

    static {
        try {
            home = new HomePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    ForgotPassPage fPass = new ForgotPassPage();


    public Login() throws IOException {
        super();
    }

    private static LoginPage goToLogin() throws IOException, InterruptedException {
        WelcomePage welcomePage = new WelcomePage();
        Thread.sleep(1000);
        welcomePage.getLoginBtn().click();
        LoginPage login = new LoginPage();
        Thread.sleep(1000);
        return login;
    }

    private static void loginMethod(String email,String password,String uName) throws IOException, InterruptedException {
        LoginPage login = goToLogin();
        Thread.sleep(2000);
        login.getEmail().sendKeys(email);
        login.getPass().sendKeys(password);
        Thread.sleep(3000);
        login.getLoginFormBtn().click();
        Thread.sleep(3000);

        String name = home.getName().getText();
        Assert.assertEquals(name,"Hello and welcome!" + uName);
    }
    private static void errorMsg(String email,String password,boolean emailErr,boolean passErr) throws IOException, InterruptedException {
        LoginPage login = goToLogin();
        Thread.sleep(2000);

        if(emailErr){
            login.getEmail().sendKeys("");
            login.getPass().sendKeys(password);
            String emailError = login.getEmailErr().getText();
            Thread.sleep(1000);
            Assert.assertEquals(emailError,"Email is not valid");
        }
        if(passErr){
            login.getEmail().sendKeys(email);
            login.getPass().sendKeys("");
            Thread.sleep(3000);


            login.getLoginFormBtn().click();
            Thread.sleep(2000);
            String passError =  login.getPassErr().getText();
            Assert.assertEquals(passError,"Wrong password!");
        }

    }

    @Test
    private void forgotPassFunc() throws IOException, InterruptedException {
        LoginPage login = goToLogin();

        login.getForgotPassLink().click();
        Thread.sleep(1000);


        fPass.getEmail().sendKeys("testfpass@test.com");
        fPass.getContinueBtn().click();
        Thread.sleep(1000);

        fPass.getPass().sendKeys("1234567");
        fPass.getconfirmPass().sendKeys("1234567");
        fPass.getResetBtn().click();
        Thread.sleep(3000);

        String name = home.getName().getText();
        Assert.assertEquals(name,"Hello and welcome!" + "lala");

        home.getIcons().click();
        home.getLogout().click();

        welcome.getLoginHeaderBtn().click();
        Thread.sleep(1000);

        login.getForgotPassLink().click();
        Thread.sleep(1000);

        fPass.getEmail().sendKeys("testfpass@test.com");
        fPass.getContinueBtn().click();
        Thread.sleep(1000);

        fPass.getPass().sendKeys("123456");
        fPass.getconfirmPass().sendKeys("123456");
        fPass.getResetBtn().click();
        Thread.sleep(3000);

        Assert.assertEquals(name,"Hello and welcome!" + "lala");


    }
    @Test
    private void checkUser() throws IOException, InterruptedException {
        loginMethod("testkala@test.com","123456","testkala");

       String color = home.getOnlineUser().getCssValue("background-color");
        String originalColor = Color.fromString("green").asHex();
        System.out.println(originalColor);

       String newColor = Color.fromString(color).asHex();
        System.out.println(newColor);
        Assert.assertEquals(newColor,originalColor);
    }

    @Test
    private void loginWithExistingUser() throws IOException, InterruptedException {
        loginMethod("testkala@test.com","123456","testkala");

        String name = home.getName().getText();
        Assert.assertEquals(name,"Hello and welcome!" + "testkala");

    }

    @Test
    private void tryToLoginWithoutEmail() throws IOException, InterruptedException {
        errorMsg("","123456",true,false);

    }
    @Test
    private void tryToLoginWithoutPass() throws IOException, InterruptedException {
        errorMsg("testkala@test.com","",false,true);

    }
}
