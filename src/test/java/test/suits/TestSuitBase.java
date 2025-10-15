package test.suits;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class TestSuitBase {

    protected String url = "";
    protected SoftAssert softAssert = new SoftAssert();
    protected WebDriver driver = new EdgeDriver();

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        driver.get(url);
    }

}
