package test.suits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TableTestSuit extends TestSuitBase {

    TableTestSuit() {
        url = "https://www.w3schools.com/html/html_tables.asp";
    }

    String[] companyNames = {
            "Alfreds Futterkiste",
            "Centro comercial Moctezuma",
            "Ernst Handel",
            "Island Trading",
            "Laughing Bacchus Winecellars",
            "Magazzini Alimentari Riuniti"
    };

    @Test
    public void VerifyCompanyNames() {
        var table = driver.findElement(By.id("customers"));
        var tbody = table.findElement(By.tagName("tbody"));
        var rows =  tbody.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            var row = rows.get(i);
            var companyName = row.findElements(By.tagName("td")).stream().findFirst().get().getText();
            softAssert.assertEquals(companyName, companyNames[i - 1]);
        }

        softAssert.assertAll();
    }

    @Test
    public void VerifyCompanyNamesFail() {
        try {
            var table = driver.findElement(By.id("customer"));
        }
        catch (NoSuchElementException e) {
            String rootDir = System.getProperty("user.dir");
            File screenshot = new File( rootDir + "/src/test/resources/screenshots/fail.png");
            byte[] bytes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            try (OutputStream os = new FileOutputStream(screenshot)) {
                os.write(bytes);
                System.out.println("Successfully written bytes to file");
            } catch (Exception e2) {
                System.out.println("Exception: " + e2);
            }


        }

    }
}
