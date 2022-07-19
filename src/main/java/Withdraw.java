import Base.Hooks;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Withdraw extends Hooks {

    ArrayList<String> withdrawTransactions = new ArrayList<>();
    HomePage home = new HomePage();
    public Withdraw() throws IOException {
        super();
    }
    private static void loginMethod(String email,String pass) throws IOException, InterruptedException {
        WelcomePage page = new WelcomePage();
        page.getLoginBtn().click();
        Thread.sleep(1000);

        LoginPage login = new LoginPage();
        login.getEmail().sendKeys(email);
        Thread.sleep(1000);
        login.getPass().sendKeys(pass);
        login.getLoginFormBtn().click();
        Thread.sleep(2000);
    }

    @Test
    public void addWithdrawTransactions() throws IOException, InterruptedException {
        loginMethod("testkala@test.com", "123456");
        Thread.sleep(1000);

        String name = home.getName().getText();
        Assert.assertEquals(name, "Hello and welcome!" + "testkala");

        home.getWithDraw().sendKeys("1");
        home.getWithDrawBtn().click();
        Thread.sleep(1000);

        String first = home.getDepTransaction().getText();
        System.out.println(first);
        withdrawTransactions.add(first);
        home.getWithDraw().clear();

        home.getWithDraw().sendKeys("2");
        home.getWithDrawBtn().click();
        Thread.sleep(1000);

        String second = home.getDepTransaction().getText();
        System.out.println(second);
        withdrawTransactions.add(second);
        home.getWithDraw().clear();

        home.getWithDraw().sendKeys("3");
        home.getWithDrawBtn().click();
        Thread.sleep(1000);

        String third = home.getDepTransaction().getText();
        System.out.println(third);
        withdrawTransactions.add(third);
        home.getWithDraw().clear();

        home.getWithDraw().sendKeys("4");
        home.getWithDrawBtn().click();
        Thread.sleep(1000);

        String fourth = home.getDepTransaction().getText();
        System.out.println(fourth);
        withdrawTransactions.add(fourth);
        home.getWithDraw().clear();

        home.getWithDraw().sendKeys("5");
        home.getWithDrawBtn().click();
        Thread.sleep(1000);

        String fifth = home.getDepTransaction().getText();
        System.out.println(fifth);
        withdrawTransactions.add(fifth);
        home.getWithDraw().clear();

        Assert.assertEquals(withdrawTransactions.size(),5);
    }


    @Test
    public void tryToWithdrawWithString() throws IOException, InterruptedException {
        loginMethod("testkala@test.com","123456");
        Thread.sleep(1000);

        String name = home.getName().getText();
        Assert.assertEquals(name,"Hello and welcome!" + "testkala");

        home.getWithDraw().sendKeys("qwe");
        home.getWithDrawBtn().click();
        Thread.sleep(2000);

        String[] singleWithdraw = home.getWithdrawMov().getText().split(" ");
        System.out.println(singleWithdraw[0]);

        Assert.assertEquals(singleWithdraw[0],false);
    }


    @Test
    public void withdrawMoney() throws IOException, InterruptedException {
        loginMethod("testkala@test.com","123456");
        HomePage home = new HomePage();
        Thread.sleep(1000);


        String name = home.getName().getText();
        Assert.assertEquals(name,"Hello and welcome!" + "testkala");
        String totalBefore = home.getSum().getText();

        home.getWithDraw().sendKeys("5");
        home.getWithDrawBtn().click();
        Thread.sleep(1000);

        String[] getWithMov = home.getWithdrawMov().getText().split(" ");
        System.out.println(getWithMov[0]);

        String[] dateOfWithdaw = home.getDateOfWithDraw().getText().split(" ");
        System.out.println(dateOfWithdaw[0]);

        String total = home.getSum().getText();

        Assert.assertEquals(getWithMov[0],"Withdraw");
        Assert.assertNotEquals(totalBefore,total);

        LocalDate myObj = LocalDate.now();
        int day = myObj.getDayOfMonth();
        int month = myObj.getMonthValue();
        int year = myObj.getYear();

        System.out.println(day);
        System.out.println(month);
        System.out.println(year);
        String todayDate = day + "/" + month + "/" + year;

        Assert.assertEquals(dateOfWithdaw[0],todayDate);
    }
}
