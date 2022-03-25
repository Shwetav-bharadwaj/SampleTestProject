package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstNameText;

    @FindBy(name="lastName")
    private WebElement lastNameText;

    @FindBy(name="email")
    private WebElement userNameText;

    @FindBy(name="password")
    private WebElement passwordText;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordText;

    @FindBy(name="register")
    private WebElement submitButton;


    public registrationPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30 );
        PageFactory.initElements(driver,this);
    }

    public void goToPage()
    {
       // this.driver.get("https://demo.guru99.com/selenium/newtours/register.php");
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameText));

    }

    public void enterUserDetails (String fName , String lName)
    {
        this.firstNameText.sendKeys(fName);
        this.lastNameText.sendKeys(lName);
    }

    public void enteruserCred (String uName , String pwd )
    {
        this.userNameText.sendKeys(uName);
        this.passwordText.sendKeys(pwd);
        this.confirmPasswordText.sendKeys(pwd);
    }

    public void pressSubmit()
    {
        this.submitButton.click();
    }

}
