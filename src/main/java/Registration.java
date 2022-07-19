import Base.Hooks;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import PageObjects.WelcomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Registration extends Hooks {

    static RegisterPage registration;

    static {
        try {
            registration = new RegisterPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static HomePage home;

    static {
        try {
            home = new HomePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    static WelcomePage welcome;

    static {
        try {
            welcome = new WelcomePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected String username = "testname";
    protected static String newUser = "testname" + Math.random() + 100;

    protected String email = "testlala@test.com";
    protected static String newEmail = "testlala" + Math.random() + 100 + "@test.com";
    protected static String pass = "123456";
    protected static String confirmPassword = pass;


    public Registration() throws IOException {
        super();
    }

    private static void registerBtnClick() throws IOException, InterruptedException {
    }
    private static RegisterPage registrationObject() throws IOException, InterruptedException {


        return registration;
    }
    private static void register(String user,String email,String password,String confirm) throws InterruptedException {
        welcome.getRegisterBtn().click();


        Assert.assertTrue(registration.getUsername() instanceof WebElement);
        Thread.sleep(1000);

        if(user != newUser || user == ""){
            String userErr = registration.getUsernameErr().getText();
            registration.getPassword().sendKeys(user);
            Assert.assertEquals(userErr,"Username is not valid");
        } else {
            registration.getUsername().sendKeys(user);
        }

        if(email != newEmail || email == "") {
            registration.getEmail().sendKeys(email);
            registration.getConfirmPassword().sendKeys("");
            Thread.sleep(2000);
            String emailErr = registration.getEmailErr().getText();
            Assert.assertEquals(emailErr,"Email is not valid");
        } else {
            registration.getEmail().sendKeys(email);
            Thread.sleep(2000);
        }

        if(password != pass || password == ""){
            registration.getPassword().sendKeys(password);
            registration.getConfirmPassword().click();

            String passErr = registration.getPassErr().getText();
            Thread.sleep(1000);

            Assert.assertEquals(passErr,"Password is not valid");
            Thread.sleep(1000);
        } else {
            registration.getPassword().sendKeys(password);
        }
        if(confirm != password || confirm == ""){
            registration.getConfirmPassword().sendKeys(confirm);
            registration.getSignUpBtn().click();
            String confirmPassErr = registration.getConfirmPassErr().getText();
            Assert.assertEquals(confirmPassErr,"Passwords are not the same");
            Thread.sleep(1000);
        } else {
            registration.getConfirmPassword().sendKeys(confirm);
            registration.getSignUpBtn().click();
            Thread.sleep(5000);

            String name = home.getName().getText();
            Assert.assertEquals(name,"Hello and welcome!" + user);
        }

    }
    private static void errorMessages(String name,String email,String password,boolean confirmPassError,boolean passError,boolean emailError,boolean usernameErr) throws InterruptedException {
        welcome.getRegisterBtn().click();
        if(confirmPassError){
            registration.getUsername().sendKeys(name);
            registration.getEmail().sendKeys(email);
            Thread.sleep(2000);
            registration.getPassword().sendKeys(password);
            registration.getConfirmPassword().sendKeys("");
            Thread.sleep(2000);

            registration.getSignUpBtn().click();
            String confirmPassErr = registration.getConfirmPassErr().getText();
            Assert.assertEquals(confirmPassErr,"Passwords are not the same");
        }
        if(passError){
            registration.getUsername().sendKeys(name);
            registration.getEmail().sendKeys(email);
            Thread.sleep(2000);
            registration.getPassword().sendKeys("");
            registration.getConfirmPassword().sendKeys("");
            Thread.sleep(2000);

            registration.getSignUpBtn().click();
            String passErr = registration.getPassErr().getText();
            Assert.assertEquals(passErr,"Password is not valid");
        }
        if(emailError){
            registration.getUsername().sendKeys(name);
            Thread.sleep(2000);
            registration.getEmail().sendKeys("");
            registration.getPassword().sendKeys(pass);
            Thread.sleep(2000);
            registration.getConfirmPassword().sendKeys(pass);

            String emailErr = registration.getEmailErr().getText();

            Assert.assertEquals(emailErr,"Email is not valid");

            registration.getSignUpBtn().click();
        }
        if(usernameErr){
            registration.getUsername().sendKeys("");
            Thread.sleep(2000);

            registration.getEmail().sendKeys(email);
            registration.getPassword().sendKeys(password);
            Thread.sleep(2000);
            registration.getConfirmPassword().sendKeys(password);

            String userErr = registration.getUsernameErr().getText();

            Assert.assertEquals(userErr,"Username is not valid");

            registration.getSignUpBtn().click();
        }

    }
    @Test
    public void registerUser() throws IOException, InterruptedException {
        register(newUser,newEmail,pass,confirmPassword);
    }


    @Test
    public void tryToRegisterWithoutConfirmPass() throws IOException, InterruptedException {
        errorMessages(newUser,newEmail,pass,true,false,false,false);
    }

    @Test
    public void tryToRegisterUserWithoutPass() throws IOException, InterruptedException {
        errorMessages(newUser,newEmail,pass,false,true,false,false);
    }

    @Test
    public void tryToRegisterUserWithoutEmail() throws IOException, InterruptedException {
        errorMessages(newUser,newEmail,pass,false,false,true,false);
    }

    @Test
    public void tryToRegisterUserWithoutUsername() throws IOException, InterruptedException {
        errorMessages(newUser,newEmail,pass,false,false,false,true);
    }

    @Test
    public void registerWithInvalidCredentials() throws IOException, InterruptedException {
        register("","lala","12345","123456");
    }

}
