package test.suits;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ButtonWaitTestSuit extends TestSuitBase {

    ButtonWaitTestSuit() {
        url = "https://demoqa.com/dynamic-properties";
    }

    @Test
    public void ClickButtonTest() {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        var enableAfterButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        var visibleAfterButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("visibleAfter")));
        var colorChangeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("colorChange")));

        enableAfterButton.click();
        visibleAfterButton.click();
        colorChangeButton.click();
    }
}
