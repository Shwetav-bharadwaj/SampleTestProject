package com.newtours.tests;

import com.newtours.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BookFlightTest extends BaseTest
{
    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setupParameters(String noOfPassengers , String expectedPrice )
    {
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void regPageTest()
    {
        registrationPage regPage = new registrationPage(driver);
        regPage.goToPage();
        regPage.enterUserDetails("spin","selling");
        regPage.enteruserCred("spin","pwd");
        regPage.pressSubmit();
    }

    @Test(dependsOnMethods= "regPageTest")
    public void regConfirmationPageTest()
    {
        regConfirmationPage regconfPage = new regConfirmationPage(driver);
        regconfPage.tapFlights();

    }

    @Test(dependsOnMethods = "regConfirmationPageTest")
    public void flightDetailsPageTest()
    {
        flightDetailsPage fltDetPage = new flightDetailsPage(driver);
        System.out.println("noOfPassengers is : "+noOfPassengers);
        fltDetPage.selectPassenger(noOfPassengers);
        fltDetPage.findFlightsContinueBtn();

    }

    @Test(dependsOnMethods = "flightDetailsPageTest")
    public void findFlightPageTest()
    {
        findFlightPage findFltPage = new findFlightPage(driver);
        findFltPage.tapContinueOnFindFlightspage();
        findFltPage.tapContinueOnBillingAddressPage();
    }

    @Test(dependsOnMethods = "findFlightPageTest")
    public void orderConfirmationPageTest()
    {
        orderConfirmationPage orderConfPage = new orderConfirmationPage(driver);
        String actualPrice = orderConfPage.printConfirmation();
        Assert.assertEquals(actualPrice,expectedPrice);

    }


}
