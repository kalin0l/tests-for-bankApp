import Base.Hooks;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class ChangePassword extends Hooks {
    HomePage home = new HomePage();
    WelcomePage welcomePage = new WelcomePage();
    LoginPage login = new LoginPage();



    public ChangePassword() throws IOException {
        super();
    }

    private void login(String email,String pass,String username) throws IOException, InterruptedException {

        if(welcomePage.getLoginHeaderBtn().getText().equalsIgnoreCase("Login")) {
            welcomePage.getLoginHeaderBtn().click();
        }

        Thread.sleep(5000);

        login.getEmail().sendKeys(email);
        login.getPass().sendKeys(pass);
        login.getLoginFormBtn().click();
        Thread.sleep(5000);

        String name = home.getName().getText();
        Assert.assertEquals(name,"Hello and welcome!" + username);
        Thread.sleep(5000);
    }
    private void goToForgotPass(String oldPass,String confirmPass) throws InterruptedException {
        String user = home.getName().getText();
        home.getIcons().click();

        home.getChangePassword().click();
        Thread.sleep(2000);

        home.getOldPass().sendKeys(oldPass);
        Thread.sleep(2000);
        home.getConfirmPassword().sendKeys(confirmPass);
        Thread.sleep(2000);
    }
    private void populateFields(Boolean input,String newPass,String confirmPass) throws InterruptedException {
        if(input) {
            System.out.println(input);

            home.getNewPass().sendKeys(newPass);
            Thread.sleep(2000);

            String getConfirmPassError = home.getOldPassErr().getText();
            Assert.assertEquals(getConfirmPassError, "Wrong pass");

            String textInput = home.getConfirmPassword().getAttribute("value");
            if (textInput.isEmpty()) {
                home.getConfirmPassword().sendKeys(confirmPass);
                Thread.sleep(2000);
            }

            home.getSubmitBtn().click();
            home.getCancel().click();
            Thread.sleep(2000);

            home.getIcons().click();
            Thread.sleep(2000);

            home.getLogout().click();
            Thread.sleep(2000);
        }
    }
    @Test
    private void changePassWithWrongConfirmPass() throws IOException, InterruptedException {
        login("testkala@test.com","123456","testkala");

        goToForgotPass("123456","123");
        boolean input = home.getNewPass().isEnabled();
        populateFields(input,"1234567","123");

    }

    @Test
    private void changePassWithValidCredentials() throws IOException, InterruptedException {
        login("testkala@test.com","123456","testkala");
        goToForgotPass("123456","");
        boolean input = home.getNewPass().isEnabled();
        populateFields(input,"1234567","1234567");


        login("testkala@test.com","1234567","testkala");
        goToForgotPass("1234567","");
        populateFields(input,"123456","123456");

    }

    @Test
    private void changePassWithInvalidCredentials() throws IOException, InterruptedException {
        login("testkala@test.com","123456","testkala");
        goToForgotPass("1234qwerty567","");
        String user = home.getName().getText();
        boolean input = home.getNewPass().isEnabled();

        if(!input){
            Thread.sleep(3000);
            Assert.assertFalse(input);
            String getError = home.getOldPassErr().getText();


            Assert.assertEquals(getError,"Wrong pass");
            Assert.assertFalse(Boolean.parseBoolean(getError));

            home.getCancel().click();
            home.getIcons().click();
            home.getLogout().click();

            login("testkala@test.com","123456","testkala");
            Thread.sleep(2000);

            boolean toBool = !Boolean.parseBoolean(user);
            System.out.println(toBool);

            if(toBool) {
                Assert.assertEquals(user,"Hello and welcome!testkala");
            } else {
                Assert.fail("User should not be able to login");
            }
        }



    }
}
