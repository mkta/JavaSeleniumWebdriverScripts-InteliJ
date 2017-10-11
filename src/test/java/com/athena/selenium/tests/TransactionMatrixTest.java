package com.athena.selenium.tests;

import AutomationFramework.TestData;
import AutomationFramework.TransactionMatrixData;
import PageObjects.Frontend.FE_Transaction_List;
import com.athena.selenium.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TransactionMatrixTest extends DriverBase {



    @Test(groups = {TestData.WESTERN_UNION_GROUP})
    public void TransactionMatrix_GRN() throws Exception {

        WebDriver driver = getDriver();
        FE_Transaction_List FE_TranList = new FE_Transaction_List(driver);
        setUp(TestData.FE, "TransactionMatrix_GRN", "Verify SWF type transactions", TestData.VN_84_VLY, TestData.USER_PASS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        FE_TranList.accessAccountHistory(TransactionMatrixData.GRN_CREDIT_IBAN_Y_ACCOUNT);



    }
}
