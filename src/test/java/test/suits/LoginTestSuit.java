package test.suits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTestSuit extends TestSuitBase {

    public LoginTestSuit() {
        url = "https://the-internet.herokuapp.com/login";
    }

    WebElement usernameElement;
    WebElement passwordElement;

    @BeforeMethod(alwaysRun = true)
    public void findLoginFormElements() {
        usernameElement = driver.findElement(By.id("username"));
        passwordElement = driver.findElement(By.id("password"));
    }

    @Test
    public void LoginSuccess() {
        usernameElement.sendKeys("tomsmith");
        passwordElement.sendKeys("SuperSecretPassword!");
        usernameElement.submit();

        var flash = driver.findElement(By.id("flash"));
        softAssert.assertTrue(flash.isDisplayed());
        softAssert.assertTrue(flash.getAttribute("class").contains("success"));

        softAssert.assertAll();
    }

    @Test
    public void LoginFailure() {
        usernameElement.sendKeys("tomsmith");
        passwordElement.sendKeys("tomsmith");
        usernameElement.submit();

        var flash = driver.findElement(By.id("flash"));
        softAssert.assertTrue(flash.isDisplayed());
        softAssert.assertTrue(flash.getAttribute("class").contains("error"));

        softAssert.assertAll();
    }
}
