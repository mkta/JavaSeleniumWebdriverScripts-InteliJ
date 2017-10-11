package PageObjects.Backend;

/**
 * Created by azaharia on 20.04.2017.
 */


import AutomationFramework.CommonTask;
import PageObjects.MainPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class BE_PortalPage extends MainPage {

    public BE_PortalPage(WebDriver passedDriver) {
        super(passedDriver);
    }

    // ------------------------------------    Locators

    // -------- Main Navigation

    // -------- Not In Navigation

    // -------- Footer Navigation



    // ------------------------------------    Methods

    public void openPortalPage(String portalPageName){
        WebElement portalPage = driver.findElement(By.cssSelector("a[title='" + portalPageName + "']"));
        CommonTask.clickElement(driver, portalPage, portalPageName);
    }



}



