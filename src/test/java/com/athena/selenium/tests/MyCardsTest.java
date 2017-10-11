package com.athena.selenium.tests;

import AutomationFramework.Log4Test;
import AutomationFramework.TestData;
import PageObjects.Frontend.FE_MyCards.FE_MyCardsDashboard;
import com.athena.selenium.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MyCardsTest extends DriverBase {

    @Test(groups = TestData.MY_CARDS_GROUP)
    public void MyCards_01_RO() throws Exception{

        WebDriver driver = getDriver();
        setUp(TestData.FE, "Verify My Cards label - RO" ,"MyCards_01_RO", TestData.VN_84_VLY, TestData.USER_PASS);

        FE_MyCardsDashboard myCardsDashboard = new FE_MyCardsDashboard(driver);

        Log4Test.info("Verifying dashboard title");
        softAssert.assertEquals(myCardsDashboard.getMyCardsDashboardTitleText(),"Cardurile tale", "My cards title is incorrect");

        Log4Test.info("Verify more cards button label");
        softAssert.assertEquals(myCardsDashboard.getMoreCardsButtonText(),"Mai multe carduri","More cards button label is incorrect");

        Log4Test.info("Displaying all cards");
        myCardsDashboard.displayAllCards();
        System.out.println(myCardsDashboard.getNumberOfCards());
        softAssert.assertAll();

    }


}
