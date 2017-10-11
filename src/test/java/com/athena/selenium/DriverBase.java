package com.athena.selenium;

import AutomationFramework.CommonTask;
import AutomationFramework.Log4Test;
import AutomationFramework.TestData;
import AutomationFramework.Waiting;
import PageObjects.Backend.BE_LoginPage;
import PageObjects.Frontend.FE_LoginPage;
import com.athena.selenium.config.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DriverBase{

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverFactory;
    public SoftAssert softAssert = new SoftAssert();

    @BeforeMethod(alwaysRun = true)
    public static void instantiateDriverObject() {
        driverFactory = new ThreadLocal<DriverFactory>() {
            @Override
            protected DriverFactory initialValue() {
                DriverFactory driverFactory = new DriverFactory();
                webDriverThreadPool.add(driverFactory);
                return driverFactory;
            }
        };
    }

    public static WebDriver getDriver() throws Exception {
        return driverFactory.get().getDriver();
    }




    // ----------------- SETUP


    public void selectENV(String env) throws Exception{
        if (env.equals(TestData.FE)) CommonTask.getUrl(getDriver(), TestData.FE_BASE_URL);
        else if (env.equals(TestData.BE)) CommonTask.getUrl(getDriver(), TestData.BE_BASE_URL);
        else Assert.fail(Log4Test.error("Selected ENV : " + env + " : is not correct"));
    }


    // ------------------------

    public void setUp(String env, String id, String title) throws Exception{

        Log4Test.info("                                                                                                    ");
        Log4Test.info("------------------- TEST ID : " + id);
        Log4Test.info("------------------- TEST TITLE : " + title);
        //Navigate to QA site
        selectENV(env);
        Log4Test.info("---- User is on Login Page");
        //Maximize browser window
        Log4Test.info("- maximizing browser window");
        getDriver().manage().window().maximize();
    }


    public void setUp(String env, String id, String title, String username, String password) throws Exception {

        Log4Test.info("                                                                                                    ");
        Log4Test.info("------------------- TEST ID : " + id);
        Log4Test.info("------------------- TEST TITLE : " + title);

        selectENV(env);

        Log4Test.info("---- User is on Login Page");
        //Maximize browser window
        Log4Test.info("- maximizing browser window");
        getDriver().manage().window().maximize();
        //Login with valid credentials

        if (env.equals(TestData.FE)){
            FE_LoginPage fe_loginPage = new FE_LoginPage(getDriver());
            fe_loginPage.loginWithUsernameAndPassword(username, password);
            Waiting.titleIs(getDriver(), TestData.FE_LOGIN_TITLE_RO);
        }
        else if (env.equals(TestData.BE)) {
            BE_LoginPage be_loginPage = new BE_LoginPage(getDriver());
            be_loginPage.loginWithUsernameAndPassword(username, password);
            Waiting.titleIs(getDriver(), TestData.FE_LOGIN_TITLE_RO);
        }
        Log4Test.info("---- User is logged in");
    }





    @AfterMethod(alwaysRun = true)
    public static void clearCookies() throws Exception {
        getDriver().manage().deleteAllCookies();
    }


    @AfterMethod(alwaysRun = true)
    public static void closeDriverObjects() {
        for (DriverFactory driverFactory : webDriverThreadPool) {
            driverFactory.quitDriver();
        }
    }


}