package test.suits;

import org.testng.annotations.Test;

public class LoginTestSuit extends TestSuitBase {
    @Test
    public void loginTest() {
        driver.get("http://localhost/login");
    }
}
