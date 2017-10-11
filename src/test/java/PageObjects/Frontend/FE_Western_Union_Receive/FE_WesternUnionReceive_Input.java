package PageObjects.Frontend.FE_Western_Union_Receive;

import AutomationFramework.CommonTask;
import AutomationFramework.TestData;
import AutomationFramework.Waiting;
import PageObjects.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by dbrosteanu on 9/19/2017.
 */
public class FE_WesternUnionReceive_Input extends MainPage {

    public FE_WesternUnionReceive_Input(WebDriver passedDriver) {
        super(passedDriver);
    }

    public String inputData[] = new String[6];


    @FindBy(css = "#btn-append-to-single-button > strong")
    private WebElement firstCurrencyFirstField;

    @FindBy(css = "#btn-append-to-single-button > small")
    private WebElement firstCurrencySecondField;

    @FindBy(css = "li > strong")
    private WebElement secondCurrencyFirstField;

    @FindBy(css = "li > small")
    private WebElement secondCurrencySecondField;

    @FindBy(css = "h2.payments--title")
    private WebElement WUlabel;

    @FindBy(css ="div.westernUnion-head > p > strong")
    private WebElement receiveMoneyLabel;

    @FindBy(css = "div.westernUnion-head > p > small")
    private WebElement receiveMoneyWUlabel;

    @FindBy(css = "div.westernUnion-logo")
    private WebElement WUlogo;

    @FindBy(css = "ui-raiffeisen-account-selection-ng > label.payments--label")
    private WebElement inLabel;

    @FindBy(css = "div.payments-from.payments-fromEmpty > p")
    private WebElement chooseAccString;

    @FindBy(css = "[name=\"form\"] > div:nth-of-type(1) > label.payments--label")
    private WebElement sumLabel;

    @FindBy(css = "[name=\"form\"] > div:nth-of-type(2) > label.payments--label")
    private WebElement currencyLabel;

    @FindBy(css = "label.payments--label.fleft")
    private WebElement mtcnLabel;

    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/div/div/div[2]/div/div[1]/div/div[3]/div/div/div/div/ui-raiffeisen-western-union-ng/div/div[2]/div/div/div/ui-raiffeisen-western-union-details-ng/div[2]/ui-raiffeisen-payments-input-description-ng/form/div/div[2]/div")
    private WebElement mtcnField;

    @FindBy(css = "input.payments-descriptionInputFields")
    private WebElement mtcnFilled;

    @FindBy(css = "div.accountsList-icon.western-union.tooltip.westernUnion-tooltip")
    private WebElement tooltipButton;

    @FindBy(css = "div.tooltiptext")
    private WebElement infoTooltipText;

    @FindBy(css = "div.payments-search.payments-typeahead > label.payments--label")
    private WebElement countryLabel;

    @FindBy(css = "div.payments-typeaheadSearch--label > p > strong")
    private WebElement countryFieldFirstLabel;

    @FindBy(css = "div.payments-typeaheadSearch--label > p > small")
    private WebElement countryFieldSecondLabel;

    @FindBy(css = "div.payments-typeaheadSearch--label > p")
    private WebElement countryFieldBox;

    @FindBy(css = "u")
    private WebElement cancelButton;

    @FindBy(css = "a.payments-action--later")
    private WebElement termsCondButton;

    @FindBy(css = "#main > div.bp-container.template-containerResponsive.contentContainer > div > div > div.raiffeisenGrid-column.raiffeisenGrid-column--cols.columns-9.contentGrid-column--contentColumn > div > div.bp-container.bp-ui-dragRoot.bp-manageableArea.--area.bp-area > div > div.bp-widget-body.ng-scope > div > div > div > div > ui-raiffeisen-western-union-ng > div > div.payments-container > div > div > div > ui-raiffeisen-western-union-details-ng > div.ng-scope > div > button")
    private WebElement receiveButton;

    @FindBy(css = "div.payments-field.payments-error > p.payments-error-label.cf > span")
    private WebElement firstErrorMessage;

    @FindBy(css = "div.payments-descriptionInput.cf > p.payments-error-label.cf > span")
    private WebElement secondErrorMessage;

    @FindBy(css = "div.payments-search.payments-typeahead > p.payments-error-label.cf > span")
    private WebElement thirdErrorMessage;

    @FindBy(css = "h3")
    private WebElement willReceiveLabel;

    @FindBy(css = "ul > li:nth-of-type(1) > label")
    private WebElement fromAccountLabel;

    @FindBy(css = "ul > li:nth-of-type(1) > p > strong" )
    private WebElement fromAccountFirstField;

    @FindBy(css = "ul > li:nth-of-type(1) > p > span")
    private WebElement fromAccountSecondField;

    @FindBy(css = "ul > li:nth-of-type(2) > label")
    private WebElement toAccountLabel;

    @FindBy(css ="ul > li:nth-of-type(3) > label")
    private WebElement toCountrylabel;

    @FindBy(css = "[name=\"amount\"]")
    private WebElement sumField;

    @FindBy(css = "ui-raiffeisen-western-union-dropdown-selection-ng > div.payments-hints.payments-hints--more.payments-hints--opened")
    private WebElement accountList;

    @FindBy(css = "ui-raiffeisen-western-union-dropdown-selection-ng > div.payments-to.contactsList--sidebar > p:nth-of-type(1) > strong")
    private WebElement selectedAccount;

    @FindBy(css ="ul > li:nth-of-type(2) > p > strong")
    private WebElement displayedAccInfoArea;

    @FindBy(css ="ui-raiffeisen-western-union-dropdown-selection-ng > div.payments-to.contactsList--sidebar > p:nth-of-type(1) > small")
    private WebElement selectedAccIBAN;

    @FindBy(css = "ul > li:nth-of-type(2) > p > span")
    private WebElement displayedIBANinfoArea;

    @FindBy(css = "ui-raiffeisen-western-union-dropdown-selection-ng > div.payments-to.contactsList--sidebar > p.fright > strong")
    private WebElement accountBalance;

    @FindBy(xpath = "//*[@id=\"main\"]/div[3]/div/div/div[2]/div/div[1]/div/div[3]/div/div/div/div/ui-raiffeisen-western-union-ng/div/div[2]/div/div/ui-raiffeisen-account-selection-ng/ui-raiffeisen-western-union-dropdown-selection-ng/div[1]")
    private WebElement listDropdown;

    @FindBy(css ="ul > li:nth-of-type(3) > p > strong")
    private WebElement infoAreaSum;

    @FindBy(css="#inputTypeahed")
    private WebElement countryInputField;

    @FindBy(css="div.payments-confirm > ul > li:nth-of-type(4) > p")
    private WebElement infoAreaCountry;

    @FindBy(css = "ul > li:nth-of-type(4) > label")
    private WebElement mtcnInfoLabel;

    @FindBy(css = "span.payments-counter.fright")
    private WebElement mtcnCounter;

    private String account = "div.payments-hints.payments-hints--more.payments-hints--opened > div:nth-of-type";
    private String accountBalanceList = "> p.fright > strong";
    private String country = "#containerHints > ul > li:nth-of-type";



    //-------------------------------------- Methods
    public void accessWUreceiveURL (String URL, String URLname){
        CommonTask.accessDirectLink(driver,URL, WUlabel, URLname);
    }

    public String getWUogoText(){
        return CommonTask.getText(WUlabel,"WU label");}

    public String getReceiveMoneyLabelText(){
        return CommonTask.getText(receiveMoneyLabel, "Receive money label");
    }

    public boolean checkWUlogoVisiblity() {
        return CommonTask.isElementEnabledAndDisplayed(WUlogo,"WU Logo");
    }

    public String getInText(){return CommonTask.getText(inLabel,"'In' label");}

    public String getChooseAccText(){
        return CommonTask.getText(chooseAccString,"Choose account string");
    }

    public String getSumText(){
        return CommonTask.getText(sumLabel,"Sum label");
    }

    public String getCurrencyText(){
        return CommonTask.getText(currencyLabel, "Currency label");
    }

    public String getMTCNLabeltext(){
        return CommonTask.getText(mtcnLabel,"MTCN label");
    }

    public String getFirstCurrency(){
        CommonTask.clickElement(driver,firstCurrencyFirstField, "Currency dropdown");
        String value = CommonTask.getText(firstCurrencyFirstField,"RON currency main label") +" "+
                       CommonTask.getText(firstCurrencySecondField,"RON currency second label");
        return value;
    }

    public String getSecondCurrency(){
        String value = CommonTask.getText(secondCurrencyFirstField, "EUR currency main label") + " " +
                       CommonTask.getText(secondCurrencySecondField,"EUR currency second label");
        CommonTask.clickElement(driver,firstCurrencyFirstField, "Currency dropdown");
        return value;
    }

    public String getInfoTooltipText(){
        Actions action = new Actions(driver);
        action.moveToElement(tooltipButton).build().perform();
        return CommonTask.getText(infoTooltipText,"Info tooltip text");
    }
    public String getMTCNFieldText(){
        return CommonTask.getText(mtcnField,"MTCN Field");
    }

    public String getCountryLabelText(){
        return CommonTask.getText(countryLabel,"Country label");
    }
    public String getCountryFieldText(){
        return CommonTask.getText(countryFieldFirstLabel,"Country field first row") + "\n" +
               CommonTask.getText(countryFieldSecondLabel,"Country field second row");

    }
    public String getTCButtonText(){
        return CommonTask.getText(termsCondButton,"T&C button");
    }
    public String getReceiveButtonText(){
        return CommonTask.getText(receiveButton,"Receive button");
    }
    public String getCancelButtonText(){
        return CommonTask.getText(cancelButton,"Cancel button");
    }

    public String getFirstErrorMessage(){
        return CommonTask.getText(firstErrorMessage,"First error message field");
    }

    public String getSecondErrorMessage(){
        return CommonTask.getText(secondErrorMessage,"Seccond error message");
    }

    public void clickReceive(){
       //needs to be changed to .click
        receiveButton.sendKeys(Keys.ENTER);
    }

    public String getThirdErrorMessage(){
        return CommonTask.getText(thirdErrorMessage,"Third error message");
    }

    public String getWillReceiveText(){
        return CommonTask.getText(willReceiveLabel, "'Will receive' label");
    }

    public String getFromAccText(){
        return CommonTask.getText(fromAccountLabel,"'From account' label");
    }

    public String getRemainingCharsLabel(){ return CommonTask.getText(mtcnCounter,"MTCN Remaining characters lalbel");}

    public String getFromAccFields(){
        return CommonTask.getText(fromAccountFirstField,"First 'From account' field") + "\n" +
               CommonTask.getText(fromAccountSecondField,"Second 'From account' field");
    }

    public String getToAccText(){
        return CommonTask.getText(toAccountLabel,"'To account' label");
    }

    public boolean verifyValidation(String input) {
        CommonTask.sendKeys(driver, sumField, input, "Sum field");
        return CommonTask.getAttributeAsText(sumField, "value", "sum field").equals(input);
    }


    public void setAmount(String sum){
        CommonTask.setInputField(driver, sumField, sum , "Sum Field");
    }

    public void selectAccountWithBalance() {
        int listlenght = CommonTask.getListSizeAngularCSS(driver,account);
        int balanceFlag = 1;
        while(balanceFlag==1) {
            Random randomAccIndex = new Random();
            int index = randomAccIndex.nextInt(listlenght);
            String elementIndex = "(" + String.valueOf(index)+")";
            String selectedAccBalance = driver.findElement(By.cssSelector(account + elementIndex + accountBalanceList)).getText().replaceAll("[^0-9]", "");
            if(Integer.parseInt(selectedAccBalance) >1){
                balanceFlag =0;
                CommonTask.clickElement(driver,driver.findElement(By.cssSelector(account+elementIndex)),"Random account");
            }
        }
    }

    public String getSelectedAccName(){
        return CommonTask.getText(selectedAccount,"selected account");
    }

    public String getDisplayedAccInfoArea(){
        Waiting.elementToBeClickable(driver, displayedAccInfoArea, "Displayed account name in info area" );
        return CommonTask.getText(displayedAccInfoArea, "Displayed account name in info area");
    }

    public String getSelectedAccountIBAN(){
        return CommonTask.getText(selectedAccIBAN,"Selected account iban");
    }

    public String getDisplayedIBANinfoArea(){
        return CommonTask.getText(displayedIBANinfoArea,"Displayed IBAN at info area");
    }

    public void enterValidAmount(){
        int totalAmount = Integer.parseInt(accountBalance.getText().replaceAll("[^0-9]", ""));
        Random randomAmount = new Random();
        sumField.sendKeys(String.valueOf(randomAmount.nextInt(totalAmount)/100));
    }

    public String getSumInfoArea(){
        return CommonTask.getText(infoAreaSum,"Sum from info area").replaceAll("[^0-9]", "");
    }

    public String getSumFieldAmount(){
        String value = "";
        CommonTask.clickElement(driver,mtcnField,"mtcn field");
        value = String.valueOf(Integer.parseInt(CommonTask.getAttributeAsText(sumField,"value","Sum field").replaceAll("[^0-9]", ""))/100);
        return value;
    }

    public void selectRandomCountry(){
        CommonTask.clickElement(driver,countryFieldBox,"Country type area");
        Random randomCountry = new Random();
        CommonTask.clickElementByActions(driver,driver.findElement(By.cssSelector(country + "(" + String.valueOf(randomCountry.nextInt(249)+1) +")")),"random country");
    }

    public String getToCountry(){
        return CommonTask.getText(toCountrylabel,"'To Country' label");
    }

    public String getEnteredCountry(){
        return CommonTask.getAttributeAsText(countryInputField,"value","Country field");
    }
    public String getInfoAreaCountry(){
        return CommonTask.getText(infoAreaCountry,"Info area country");
    }

    public String getMTCNinfoAreaLabel(){
        return CommonTask.getText(mtcnInfoLabel,"MTCN info area label");
    }

    public String getCharsLeft(){
        String value = CommonTask.getAttributeAsText(mtcnFilled, TestData.VALUE, "mtcn field");
        return String.valueOf(value.length());
    }

    public Boolean isMtcnErrorDisplayed(String input){
        boolean value;
        try {
            value = CommonTask.isDisplayed(receiveButton, "Receive button");
        }
        catch (NoSuchElementException e){
            value = false;
        }

        if(input.contentEquals("10") && !value){
            return true;
        }
        return value;
    }


    public boolean isMTCNCounterWorking(int counterStartsAt){
        return CommonTask.isCounterWorking(driver, mtcnFilled, mtcnCounter, counterStartsAt, "mtcn");
    }

    public void enterMTCN(String input){
        Actions actions = new Actions(driver);
        actions.moveToElement(mtcnField).click().build().perform();
        actions.moveToElement(mtcnField).sendKeys(input).build().perform();
    }

    public void completeFormWithValidInput(String mtcn){

        selectAccountWithBalance();
        enterValidAmount();
        enterMTCN(mtcn);
        selectRandomCountry();
        countryInputField.sendKeys(Keys.RETURN);
    }

    public void stockInputData(){
        if(selectedAccount.isDisplayed()){
        inputData[0] = CommonTask.getText(selectedAccount,"Selected account");
        }
        inputData[1] = CommonTask.getText(selectedAccIBAN,"Selected Account IBAN");
        inputData[2] = CommonTask.getText(firstCurrencyFirstField,"Currency");
        inputData[3] = CommonTask.getAttributeAsText(mtcnFilled,"value","Filled mtcn");
        inputData[4] = getEnteredCountry();
        inputData[5] = getSumFieldAmount();
    }



}

