package test.suits;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TitleTestSuit extends TestSuitBase {

    TitleTestSuit() {
        url = "https://example.com";
    }

    @Test
    public void TitleSuccess(){
        var title = driver.getTitle();
        softAssert.assertEquals(title, "Example Domain");
        softAssert.assertAll();
    }
}
