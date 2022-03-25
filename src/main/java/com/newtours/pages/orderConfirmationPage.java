package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class orderConfirmationPage

{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Flight Confirmation')]")
    public WebElement flightConfirmation;

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    public List<WebElement> prices;

    public  orderConfirmationPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public String printConfirmation()
    {
        this.wait.until(ExpectedConditions.visibilityOf(flightConfirmation));
        System.out.println(this.flightConfirmation.getText());
        System.out.println(this.prices.get(0).getText());
        String price = this.prices.get(1).getText();
        System.out.println(this.prices.get(1).getText());
        return price;
    }



}
