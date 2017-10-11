package PageObjects.Backend;

import AutomationFramework.CommonTask;
import AutomationFramework.Waiting;
import PageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by azaharia on 19.09.2017.
 */
public class BE_LoginPage extends MainPage{


    public BE_LoginPage(WebDriver passedDriver) {
        super(passedDriver);
    }

    //-------------------------------------- Locators

    @FindBy(id = "j_username")
    public WebElement usernameField;

    @FindBy(id = "j_password")
    public WebElement passwordField;

    @FindBy(css = "body > div.bd-loginContainer-dashboard > form > div > div.bd-login-button-area > button")
    public WebElement loginButton;

    @FindBy(xpath = "//p[@class='bd-error-message-dashboard bd-login-error']")
    public WebElement authErrorMsg;



    //-------------------------------------- Methods

    public void loginWithUsernameAndPassword(String username, String password){
        CommonTask.setInputField(driver, usernameField, username, "username field");
        CommonTask.setInputField(driver, passwordField, password, "password field");
        CommonTask.clickElement(driver, loginButton, "login button");
    }

    public String getTextWrongAuth(){
        Waiting.elementToBeClickable(driver, authErrorMsg, "auth error msg");
        return authErrorMsg.getText();
    }


}
