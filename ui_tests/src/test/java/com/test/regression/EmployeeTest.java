package com.test.regression;

import com.test.BaseTest;
import com.test.pages.EmployeePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTest extends BaseTest {

    @Test
    public void cityOfEmployees() throws IOException {

        EmployeePage employeePage = new EmployeePage();

        employeePage.iconArrowDown2.click();

        for (int i=1; i<=employeePage.listOfCheckbox.size(); i++ ){
            employeePage.checkBox(i).click();
        }

       employeePage.viewSelectedData.click();

        List<String> actualListOfName = new ArrayList<>();

        for (WebElement name : employeePage.listsOfNames) {
            actualListOfName.add(name.getText());
        }

       List<String> expectedListName = new ArrayList<>();
        Files.lines(Paths.get("src/test/resources/Names.txt")).forEach(t -> expectedListName.add(t));

        Assert.assertEquals(expectedListName,actualListOfName,"The names are not matched");
    }
}
