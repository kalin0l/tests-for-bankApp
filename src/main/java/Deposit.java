import Base.Hooks;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.WelcomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Deposit extends Hooks {
    static HomePage home;

    static {
        try {
            home = new HomePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    boolean depositString;
//    boolean totalSum;
//    boolean addTransactions;
    static ArrayList<String> depositTransactions = new ArrayList<>();



    public Deposit() throws IOException {
        super();
    }

    private static void addTransactions() throws InterruptedException {
        home.getDeposit().sendKeys("2");
        home.getDepositBtn().click();
        Thread.sleep(2000);

        String firstDep = home.getDepTransaction().getText();
        System.out.println(firstDep);
        depositTransactions.add(firstDep);
        home.getDeposit().clear();

        home.getDeposit().sendKeys("1");
        home.getDepositBtn().click();
        Thread.sleep(2000);

        String secondDep = home.getDepTransaction().getText();
        depositTransactions.add(secondDep);
        home.getDeposit().clear();

        home.getDeposit().sendKeys("3");
        home.getDepositBtn().click();
        Thread.sleep(2000);

        String thirdDep = home.getDepTransaction().getText();
        depositTransactions.add(thirdDep);
        home.getDeposit().clear();

        home.getDeposit().sendKeys("4");
        home.getDepositBtn().click();
        Thread.sleep(2000);

        String fourthDep = home.getDepTransaction().getText();
        depositTransactions.add(fourthDep);
        home.getDeposit().clear();

        home.getDeposit().sendKeys("5");
        home.getDepositBtn().click();
        Thread.sleep(2000);

        String fifth = home.getDepTransaction().getText();
        depositTransactions.add(fifth);
        home.getDeposit().clear();

        Assert.assertEquals(depositTransactions.size(),5);
    }
    private static void depositString() throws InterruptedException {
        home.getDeposit().sendKeys("qwe");
        home.getDepositBtn().click();
        Thread.sleep(2000);

        String[] singleDeposit = home.getDepositMov().getText().split(" ");
        System.out.println(singleDeposit[0]);

        Assert.fail("You cannot deposit a string");
    }
    private static void totalSum() throws InterruptedException {
        String[] totalBefore = home.getSum().getText().split(".5");
        int newTotalBefore = Integer.parseInt(totalBefore[0]);

        home.getDeposit().sendKeys("5");
        home.getDepositBtn().click();
        Thread.sleep(2000);

        String[] singleDeposit = home.getDepositMov().getText().split(" ");
        System.out.println(singleDeposit[0]);

        String[] dateOfDep = home.getDateOfDeposit().getText().split(" ");
        System.out.println(dateOfDep[0]);

        String depositTransaction = home.getDepTransaction().getText();
        System.out.println("transaction: " + depositTransaction);


        String[] total = home.getSum().getText().split(".5");
        int newTotal = Integer.parseInt(total[0]);

        Assert.assertEquals(singleDeposit[0],"Deposit");
        Assert.assertNotEquals(totalBefore,total);
        Assert.assertNotSame(newTotalBefore,newTotal);

        LocalDate myObj = LocalDate.now();
        int day = myObj.getDayOfMonth();
        int month = myObj.getMonthValue();
        int year = myObj.getYear();

        System.out.println(day);
        System.out.println(month);
        System.out.println(year);
        System.out.println(newTotal);


        String todayDate = day + "/" + month + "/" + year;


        Assert.assertEquals(dateOfDep[0],todayDate);
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
    public void addDepositTransactions() throws IOException, InterruptedException {


        loginMethod("testkala@test.com","123456");
        Thread.sleep(1000);

        String name = home.getName().getText();
        Assert.assertEquals(name,"Hello and welcome!testkala");

        addTransactions();


    }

    @Test
    public void tryToDepositString() throws IOException, InterruptedException {


        loginMethod("testkala@test.com","123456");
        Thread.sleep(1000);

        String name = home.getName().getText();
        Assert.assertEquals(name,"Hello and welcome!" + "testkala");
        depositString();

    }

    @Test
    public void depositSum() throws IOException, InterruptedException {

        loginMethod("testkala@test.com","123456");
        Thread.sleep(1000);


        String name = home.getName().getText();
        Assert.assertEquals(name,"Hello and welcome!" + "testkala");
        totalSum();

//        depositMethod(false,false,true);


    }
}
