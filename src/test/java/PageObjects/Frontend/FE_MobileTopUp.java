package PageObjects.Frontend;

import AutomationFramework.CommonTask;
import AutomationFramework.Waiting;
import PageObjects.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.Random;


public class FE_MobileTopUp extends MainPage {

    public FE_MobileTopUp(WebDriver passedDriver) {
        super(passedDriver);
    }


    //-------------------------------------- Locators

    @FindBy(css = "ul.nav.navbar-nav > li:nth-of-type(7) > a.dropdown-toggle")
    public WebElement topUpMenuButton;

    @FindBy(css = "div.topUp > label:nth-of-type(1)")
    public WebElement topUpLabelFrom;

    @FindBy(css = "div.topUp > ui-raiffeisen-select-ng:nth-of-type(1) > div > div.payments-from > p.payment-noSelection")
    public WebElement accountFromFieldText;

    @FindBy(css = "div.topUp > label:nth-of-type(2)")
    public WebElement topUpLabelOperator;

    @FindBy(css = "div.payments-from.contactsList--sidebar > p.payment-noSelection")
    public WebElement topUpLabelOperatorField;

    @FindBy(css = "h2.payments--title.ng-binding")
    public WebElement topUpHeaderLabel;

    @FindBy(css = "div.topUp > ui-raiffeisen-select-ng:nth-of-type(1) > div > div.payments-from > p.payment-noSelection")
    public WebElement topUpFromAccountField;

    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/div/div/div[2]/div/div[1]/div/div[3]/div/div/div/div/div/div/div/div[2]/div/div/ui-raiffeisen-topup-ng/div/div/ui-raiffeisen-select-ng/div/div[2]/div[1]/p/strong")
    public WebElement rechargeValue;

    @FindBy(css = "div.payments-from.contactsList--sidebar > p.payment-noSelection")
    public WebElement operatorName;

    @FindBy(css = "[name=\"phone\"]")
    private WebElement inputPhoneNumberField;

    @FindBy(css = "button.button")
    private WebElement topUpSubmitButton;


    private String topupAccount = "div.payments-hints.payments-hints--opened.payments-hints--more > div:nth-of-type";
    private String accountBalanceList = "> p.fright > strong";
    private String topupOperator = "div.topUp > ui-raiffeisen-select-ng:nth-of-type(2) > div > div.payments-hints.payments-hints--opened > div:nth-of-type";
    private String topUpRecharge = "div.payments-hints.payments-hints--opened > div:nth-of-type";


    //-------------------------------------- Methods

    public String browserTabNameTopUp() {
        return CommonTask.getTitle(driver);
    }

    public String topUpMenuButtonLabel() {
        Waiting.elementToBeClickable(driver, topUpMenuButton, "Top Up");
        return CommonTask.getText(topUpMenuButton, "Top Up menu label");
    }

    public void topUpAccess() {
        Waiting.elementToBeClickable(driver, topUpMenuButton, "Top Up Menu button");
        CommonTask.clickElement(driver, topUpMenuButton, "Top Up");
    }

    public String topUpLabelsPage(String option) {
        String value = "";
        switch (option) {
            case "Header":
                Waiting.visibilityOfElement(driver, topUpHeaderLabel, "Header title label");
                value = CommonTask.getText(topUpHeaderLabel, "Header title");
                break;
            case "FROM":
                Waiting.visibilityOfElement(driver, topUpLabelFrom, "FROM label");
                value = CommonTask.getText(topUpLabelFrom, "FROM label");
                break;
            case "FROM field text":
                Waiting.visibilityOfElement(driver, accountFromFieldText, "FROM field label");
                value = CommonTask.getText(accountFromFieldText, "FROM field label");
                break;
            case "Operator":
                Waiting.visibilityOfElement(driver, topUpLabelOperator, "Operator label");
                value = CommonTask.getText(topUpLabelOperator, "Operator label");
                break;
            case "Operator field text":
                Waiting.visibilityOfElement(driver, topUpLabelOperatorField, "Operator field label");
                value = CommonTask.getText(topUpLabelOperatorField, "Operator field label");
                break;
        }
        return value;
    }
    public String getTitleTopUpPage() {
        return CommonTask.getTitle(driver);
    }

    public void selectAccountWithBalance() {
        Waiting.visibilityOfElement(driver, accountFromFieldText, "FROM field");
        int listlenght = CommonTask.getListSizeAngularCSS(driver, topupAccount);
        int balanceFlag = 1;
        while (balanceFlag == 1) {
            Random randomAccIndex = new Random();
            int index = randomAccIndex.nextInt(listlenght);
            if (index == 0) {
                index++;
            }
            String elementIndex = "(" + String.valueOf(index) + ")";
            String selectedAccBalance = driver.findElement(By.cssSelector(topupAccount + elementIndex + accountBalanceList)).getText().replaceAll("[^0-9]", "");
            if (!selectedAccBalance.equals("000")) {
                balanceFlag = 0;
                CommonTask.clickElement(driver, driver.findElement(By.cssSelector(topupAccount + elementIndex)), "Random account");
                Waiting.elementToBeClickable(driver, operatorName, "Operator Name");
            }
        }
    }

    public void selectRandomOp() {
        int listlenght = CommonTask.getListSizeAngularCSS(driver, topupOperator);
        Random randomOpIndex = new Random();
        int index = randomOpIndex.nextInt(listlenght);
        if (index == 0) {
            index++;
        }
        String elementIndex = "(" + String.valueOf(index) + ")";
        CommonTask.clickElement(driver, driver.findElement(By.cssSelector(topupOperator + elementIndex)), "Random operator");
        Waiting.elementToBeClickable(driver, rechargeValue, "Recharge value 1st option");
    }

    public void selectRandomRec() {
        int listlenght = CommonTask.getListSizeAngularCSS(driver, topUpRecharge);
        Random randomRecIndex = new Random();
        int index = randomRecIndex.nextInt(listlenght);
        if (index == 0) { index++; }
        String elementIndex = "(" + String.valueOf(index) + ")";
        CommonTask.clickElement(driver, driver.findElement(By.cssSelector(topUpRecharge + elementIndex)), "Random recharge value");
    }

    public String inputPhoneNumber() {
        CommonTask.setInputField(driver, inputPhoneNumberField, "0712123123", "Phone Number");
        return CommonTask.getAttributeAsText(inputPhoneNumberField, "value","Phone Number");
    }
    public void submitButtonTopUp() {
        Waiting.elementToBeClickable(driver, topUpSubmitButton, "Transfer");
        CommonTask.clickElement(driver, topUpSubmitButton, "Submit form");
    }
}