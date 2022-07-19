package Base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Hooks extends BasePage {



    protected HashSet<String> allTypesOfTransactions = new HashSet<String>();

    public Hooks() throws IOException {
        super();
    }
    @BeforeTest
    public void setup() throws IOException, InterruptedException {
        getDriver().get(getUrl());
    }

    @AfterTest
    public void tearDown(){
        WebDriverInstance.cleanUpDriver();

    }

}
