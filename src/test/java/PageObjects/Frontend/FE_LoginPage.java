package PageObjects.Frontend;

import AutomationFramework.CommonTask;
import PageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by azaharia on 19.09.2017.
 */
public class FE_LoginPage extends MainPage{

    public FE_LoginPage(WebDriver passedDriver) {
        super(passedDriver);
    }

    //-------------------------------------- Locators

    @FindBy(css = "rf-input-text > div.form-group.rf-form-group > input.form-control.input-lg")
    public WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div[3]/div/div/div/div/form/rf-input-password/div/input")
    public WebElement passwordField;

    @FindBy(css = "button.rf-btn-login")
    public WebElement loginButton;


    //-------------------------------------- Methods

    public void loginWithUsernameAndPassword(String username, String password){
        CommonTask.setInputField(driver, usernameField, username, "username field");
        CommonTask.setInputField(driver, passwordField, password, "password field");
        CommonTask.clickElement(driver, loginButton, "login button");
    }

}
