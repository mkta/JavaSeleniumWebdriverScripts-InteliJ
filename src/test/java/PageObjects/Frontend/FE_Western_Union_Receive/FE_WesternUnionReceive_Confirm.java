package PageObjects.Frontend.FE_Western_Union_Receive;

import AutomationFramework.CommonTask;
import AutomationFramework.Waiting;
import PageObjects.MainPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FE_WesternUnionReceive_Confirm extends MainPage {

    public FE_WesternUnionReceive_Confirm(WebDriver passedDriver) {
        super(passedDriver);
    }

    public String confirmData[] = new String[6];

    @FindBy(css = ".westernUnion-info > div:nth-child(1) > div:nth-child(1)")
    private WebElement WULogo;

    @FindBy(css = "div.westernUnion-info > p > strong")
    private WebElement WULabel;

    @FindBy(css = "div.payments-confirm > h3")
    private WebElement infoLabelFirst;

    @FindBy(css = "div.payments-confirm > ul > li:nth-of-type(1) > label")
    private WebElement fromAccountLabel;

    @FindBy(css = "div.payments-confirm > ul > li:nth-of-type(2) > label")
    private WebElement toAccountLabel;

    @FindBy(css = "div.payments-confirm > ul > li:nth-of-type(4) > label")
    private WebElement mtcnLabel;

    @FindBy(css = "div.payments-confirm > ul > li:nth-of-type(5) > label")
    private WebElement fromCountryLabel;

    @FindBy(css = "div.payments-confirm > ul > li:nth-of-type(6) > label")
    private WebElement dateLabel;

    @FindBy(css = "div.westernUnion-transfer > h3")
    private WebElement infoLabelSecond;

    @FindBy(css ="div.westernUnion-transfer > small")
    private WebElement infoLabelThird;

    @FindBy(css = "div.westernUnion-transfer > ul > li:nth-of-type(1) > label")
    private WebElement nameLabel;

    @FindBy(css ="div.westernUnion-transfer > ul > li:nth-of-type(2) > label")
    private WebElement seriesAndNumberLabel;

    @FindBy(css = "div.westernUnion-transfer > ul > li:nth-of-type(3) > label")
    private WebElement cnpLabel;

    @FindBy(css ="div.westernUnion-transfer > ul > li:nth-of-type(4) > label")
    private WebElement telephoneLabel;

    @FindBy(css ="div.westernUnion-transfer > ul > li:nth-of-type(5) > label")
    private WebElement addressLabel;

    @FindBy(css = "div.westernUnion-transfer > ul > li:nth-of-type(6) > label")
    private WebElement birthdayLabel;

    @FindBy(css ="ul > li:nth-of-type(7) > label")
    private WebElement originCountryLabel;

    @FindBy(css = "button.button.fright")
    private WebElement confirmButton;

    @FindBy(css ="div.payments-previous-act")
    private WebElement previousPageButton;

    @FindBy(css = "ul > li:nth-of-type(2) > p > strong")
    private WebElement accountName;

    @FindBy(css = "ul > li:nth-of-type(2) > p > span")
    private WebElement IBAN;

    @FindBy(css ="div.contactsList--payments--amount.col-lg-6.col-md-6.col-sm-6.col-xs-6 > ui-raiffeisen-format-amount > span > span:nth-child(3)")
    private WebElement currency;

    @FindBy(css ="ul > li:nth-of-type(4) > p > strong")
    private WebElement mtcn;

    @FindBy(css = "div.payments-confirm > ul > li:nth-of-type(5) > p")
    private WebElement country;

    @FindBy(css = "span.amount")
    private WebElement amountAndCurrency;


    //-------------------------------------- Methods

    public boolean isWUlogoDisplayed(){
        return CommonTask.isDisplayed(WULogo,"WU logo");
    }

    public String getWUlabel(){
        return CommonTask.getText(WULabel,"WU label");
    }

    public String getInfoLabelFirstLabel(){
        return CommonTask.getText(infoLabelFirst,"first info label");
    }
    public String getInfoLabelSecondLabel(){
        return CommonTask.getText(infoLabelSecond,"second info label");
    }
    public String getInfoLabelThirdLabel(){
        return CommonTask.getText(infoLabelThird,"third info label");
    }

    public String getFromAccountLabel(){
        return CommonTask.getText(fromAccountLabel,"from account label");
    }

    public String getToAccountLabel(){
        return CommonTask.getText(toAccountLabel,"to account label");
    }

    public String getMTCNlabel(){
        return CommonTask.getText(mtcnLabel,"MTCN label");
    }

    public String getCountryLabel(){
        return CommonTask.getText(fromCountryLabel,"from country label");
    }

    public String getTransferDateLabel(){
        return CommonTask.getText(dateLabel,"Date label");
    }

    public String getNameLabel(){
        return CommonTask.getText(nameLabel,"name label");
    }

    public String getseriesAndNrlabel(){
        return CommonTask.getText(seriesAndNumberLabel,"series and number label");
    }

    public String getCNPlabel(){
        return CommonTask.getText(cnpLabel,"CNP label");
    }

    public String getTelephoneNumberLabel(){
        return CommonTask.getText(telephoneLabel,"telephone label");
    }

    public String getAddressLabel(){
        return CommonTask.getText(addressLabel,"Address label");
    }

    public String getBirthdayLabel(){
        return CommonTask.getText(birthdayLabel,"birthday label");
    }

    public String getOriginCountry(){
        return CommonTask.getText(originCountryLabel,"Origin country label");
    }

    public String getConfirmButtonLabel(){
        return CommonTask.getText(confirmButton,"Confirm button");
    }

    public void pressConfirm(){
        Waiting.elementToBeClickable(driver,confirmButton,"confirm button");
        confirmButton.sendKeys(Keys.ENTER);
    }


    public void stockConfirmData(){
        confirmData[0] = CommonTask.getText(accountName,"Account name");
        confirmData[1] = CommonTask.getText(IBAN, "IBAN");
        confirmData[2] = CommonTask.getAttributeAsText(currency,"innerHTML","Currency").replaceAll("&nbsp;","");
        confirmData[3] = CommonTask.getText(mtcn, "MTCN number");
        confirmData[4] = CommonTask.getText(country, "Country");
        confirmData[5] = String.valueOf(Integer.parseInt(CommonTask.getText(amountAndCurrency,"Sum field").replaceAll("[^0-9]", ""))/100);

    }
}