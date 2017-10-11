package com.athena.selenium.tests;

import AutomationFramework.Log4Test;
import AutomationFramework.TestData;
import PageObjects.Frontend.FE_LoginPage;
import PageObjects.Frontend.FE_MobileTopUp;
import com.athena.selenium.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileTopUpTest extends DriverBase{

    @Test(groups = {TestData.LOGIN_GROUP})
    public void Top_Up_01() throws Exception {
        WebDriver driver = getDriver();

        setUp(TestData.FE, "Verify Top Up access", "Top_Up_01");

        FE_LoginPage fe_loginPage = new FE_LoginPage(driver);

        Log4Test.test("Log in");
        fe_loginPage.loginWithUsernameAndPassword(TestData.VN_84_VLY, TestData.USER_PASS);

        FE_MobileTopUp fe_mobileTopUp = new FE_MobileTopUp(driver);

        Log4Test.test("Access Top Up page");
        fe_mobileTopUp.topUpAccess();

        Log4Test.test("Get Top Up Tab name");
        Assert.assertEquals(fe_mobileTopUp.getTitleTopUpPage(), "Top Up", "Top up tab name is not correct");

        Log4Test.test("Selecting a random account");
        fe_mobileTopUp.selectAccountWithBalance();

        Log4Test.test("Selecting a random operator");
        fe_mobileTopUp.selectRandomOp();

        Log4Test.test("Selecting a random recharge value");
        fe_mobileTopUp.selectRandomRec();

        Log4Test.test("Input phone number");
        Assert.assertEquals(fe_mobileTopUp.inputPhoneNumber(), "0712123123", "Wrong number");

        Log4Test.test("Submit Payment");
        fe_mobileTopUp.submitButtonTopUp();

    }
    @Test(groups = {TestData.LOGIN_GROUP})
    public void Top_Up_02() throws Exception {
        WebDriver driver = getDriver();

        setUp(TestData.FE, "Verify Top Up access", "Top_Up_02");

        FE_LoginPage fe_loginPage = new FE_LoginPage(driver);

        Log4Test.test("Log in");
        fe_loginPage.loginWithUsernameAndPassword(TestData.VN_84_VLY, TestData.USER_PASS);

        FE_MobileTopUp fe_mobileTopUp = new FE_MobileTopUp(driver);

        Log4Test.test("Verify Top Up label on homepage");
        Assert.assertEquals(fe_mobileTopUp.topUpMenuButtonLabel(), "Top Up", "Wrong menu button label");

        Log4Test.test("Access Top Up page");
        fe_mobileTopUp.topUpAccess();

        Log4Test.test("Verify browser tab name");
        Assert.assertEquals(fe_mobileTopUp.browserTabNameTopUp(), "Top Up", "Wrong tab name");

        Log4Test.test("Verify labels on page");
        softAssert.assertEquals(fe_mobileTopUp.topUpLabelsPage("Header"), "Reincarcare cartela", "Wrong Header label");
        softAssert.assertEquals(fe_mobileTopUp.topUpLabelsPage("FROM"), "Din contul", "Wrong FROM label");
        softAssert.assertEquals(fe_mobileTopUp.topUpLabelsPage("FROM field text"), "Alege contul", "Wrong FROM field label");
        softAssert.assertEquals(fe_mobileTopUp.topUpLabelsPage("Operator"), "Operator", "Wrong Operator label");
        softAssert.assertEquals(fe_mobileTopUp.topUpLabelsPage("Operator field text"), "Alege operator", "Wrong Operator field label");

        softAssert.assertAll();
    }
}