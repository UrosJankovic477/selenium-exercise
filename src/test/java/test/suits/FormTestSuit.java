package test.suits;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormTestSuit extends TestSuitBase {

    WebElement userName;
    WebElement userEmail;
    WebElement currentAddress;
    WebElement permanentAddress;
    WebElement submitButton;

    String[] expectedOutput = {
            "Name:Uros",
            "Email:uros.jankovic@testmail.com",
            "Current Address :Here St.",
            "Permananet Address :Somewhere Else Blvd"
    };

    FormTestSuit() {
        url = "https://demoqa.com/text-box";
    }

    @Test
    public void FillingTheForm() {
        userName = driver.findElement(By.id("userName"));
        userEmail = driver.findElement(By.cssSelector("input[type='email']"));
        currentAddress = driver.findElement(By.xpath("//textarea[@id=\"currentAddress\"]"));
        permanentAddress = driver.findElement(By.id("permanentAddress"));
        submitButton = driver.findElement(By.id("submit"));

        userName.sendKeys("Uros");
        userEmail.sendKeys("uros.jankovic@testmail.com");
        currentAddress.sendKeys("Here St.");
        permanentAddress.sendKeys("Somewhere Else Blvd");

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", currentAddress);

        submitButton.click();

        var div = driver.findElement(By.className("border"));
        var paragraphs = div.findElements(By.xpath(".//p"));
        for( int i = 0; i < paragraphs.size(); i++ ) {
            WebElement element = paragraphs.get(i);
            softAssert.assertEquals(element.getText(), expectedOutput[i]);
        }

        softAssert.assertAll();
    }
}
