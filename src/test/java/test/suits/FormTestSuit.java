package test.suits;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTestSuit extends TestSuitBase {

    TextBoxTestSuit() {
        url = "https://demoqa.com/text-box";
    }

    @Test
    public void textBoxTestSuit() {
        driver.findElement()
    }
}
