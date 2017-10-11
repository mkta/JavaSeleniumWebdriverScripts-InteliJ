package com.athena.selenium.tests;

import AutomationFramework.CommonTask;
import AutomationFramework.Log4Test;
import AutomationFramework.TestData;
import PageObjects.Backend.BE_LoginPage;
import com.athena.selenium.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends DriverBase {

    @DataProvider(name ="credentials")
    public Object[][] getData() {
        Object[][] credentials = new Object[3][3];

        credentials[0][0] = TestData.ADMIN_ACCOUNT;
        credentials[0][1] = "wrongPassword";
        credentials[0][2] = "Correct username and wrong password";

        credentials[1][0] = "wrongUsername";
        credentials[1][1] = TestData.ADMIN_PASSWORD;
        credentials[1][2] = "Wrong username and correct password";

        credentials[2][0] = " ";
        credentials[2][1] = " ";
        credentials[2][2] = "Blank username and empty password";

        return credentials;
    }


    @Test(groups = {TestData.LOGIN_GROUP}, dataProvider = "credentials")
    public void Login_01(String username, String password, String type) throws Exception {
        WebDriver driver = getDriver();

        setUp(TestData.BE, "Verify correct login works", "Login_01");

        Log4Test.test("Verify login with : " + type);
        BE_LoginPage mainPage = new BE_LoginPage(driver);
        mainPage.loginWithUsernameAndPassword(username, password);

        Log4Test.test("Asserting message for incorrect login");
        Assert.assertEquals(mainPage.getTextWrongAuth(), TestData.AUTH_ERROR_MSG, "Wrong message for incorrect username or password");
        Log4Test.test("Asserting page title");
        Assert.assertEquals(CommonTask.getTitle(driver), TestData.LOGIN_TITLE, "Wrong title on Login Page");
    }




}











