package test.suits;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import javax.swing.*;

public class CheckBoxTestSuit extends TestSuitBase {

    public CheckBoxTestSuit() {
        url = "https://demoqa.com/checkbox";
    }

    @Test
    public void TestCheckBox() {

        var button = driver.findElements(By.tagName("button")).getFirst();
        button.click();

        var treeNode = driver.findElement(By.id("tree-node"));
        var checkBox = treeNode.findElement(By.xpath("//label[@for='checkbox-input']"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", button);

        checkBox.click();

        var notesNode = driver.findElement(By.id("tree-node-notes"));
        var notesCheckBox = notesNode.findElements(By.tagName("input")).getFirst();

        softAssert.assertTrue(notesCheckBox.isEnabled());
        softAssert.assertTrue(notesCheckBox.isSelected());
        softAssert.assertTrue(notesCheckBox.isDisplayed());

        softAssert.assertAll();
    }

}
