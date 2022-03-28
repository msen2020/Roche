package com.test.pages;

import com.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeePage {
    public EmployeePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//span[@class='jqx-tree-grid-expand-button jqx-grid-group-expand jqx-icon-arrow-down'])[1]")
    public WebElement iconArrowDown1;

    @FindBy(xpath = "//tbody//tr/td/span[text()='Steven']/../span[2]")
    public WebElement iconArrowDown2;

    @FindBy(xpath = "//tbody//tr/td/span[2]")
    public List<WebElement> listOfCheckbox;

    @FindBy(tagName = "button")
    public WebElement viewSelectedData;

    @FindBy(xpath = "//div[@id='listBoxContentlistBoxSelected']//span")
    public List<WebElement> listsOfNames;

    public WebElement checkBox(int num){
        return Driver.get().findElement(By.xpath("(//span[@class='jqx-tree-grid-checkbox jqx-tree-grid-indent jqx-checkbox-default jqx-fill-state-normal jqx-rc-all'])["+num+"]"));
    }
}
