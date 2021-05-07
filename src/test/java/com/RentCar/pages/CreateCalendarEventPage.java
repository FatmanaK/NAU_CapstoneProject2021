package com.RentCar.pages;

import com.RentCar.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.RentCar.utils.Driver;

import java.util.concurrent.TimeUnit;


public class CreateCalendarEventPage {
   // @FindBy(css = "[title='Create Calendar event']")
    //@FindBy(xpath= "//*[@class='btn main-group btn-primary pull-right']")
    @FindBy(xpath="//div[@class='btn-group']) [1])")
    private WebElement createCalendarEventBtn;

    @FindBy(name = "oro_calendar_event_form[title]")
    private WebElement titleInputBox;

    @FindBy(id = "tinymce")
    private WebElement descriptionInputBox;

    public void enterTitle(String text) {
        BrowserUtils.enterText(titleInputBox, text);
    }

    public void clickOnCreateCalendarEvent() {
        BrowserUtils.clickOnElement(createCalendarEventBtn);
       // Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // createCalendarEventBtn.click();
    }

    public void enterDescription(String text) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        //exit from all frames
        Driver.getDriver().switchTo().defaultContent();
        //wait for frame and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        //enter text
//        BrowserUtils.enterText(descriptionInputBox, text);
        descriptionInputBox.sendKeys(text);
        //exit from the frame
        Driver.getDriver().switchTo().defaultContent();
    }

    public String getDataFromGeneralInfo(String parameterName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        String xpath = "//label[text()='" + parameterName + "']/../div/div";
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element.getText().trim();
    }

}