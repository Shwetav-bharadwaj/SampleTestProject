package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class findFlightPage
{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="reserveFlights")
    private WebElement firstContinueBtn;

    @FindBy(name="buyFlights")
    private WebElement secondContinueBtn;

    public findFlightPage(WebDriver driver)
    {
            this.driver = driver;
            this.wait = new WebDriverWait(driver,30 );
            PageFactory.initElements(driver,this);
    }

    public void tapContinueOnFindFlightspage()
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(firstContinueBtn));
        this.firstContinueBtn.click();
    }

    public void tapContinueOnBillingAddressPage()
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(secondContinueBtn));
        this.secondContinueBtn.click();
    }



}
