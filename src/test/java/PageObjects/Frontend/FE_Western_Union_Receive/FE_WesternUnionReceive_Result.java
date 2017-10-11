package PageObjects.Frontend.FE_Western_Union_Receive;

import AutomationFramework.CommonTask;
import AutomationFramework.Log4Test;
import AutomationFramework.TestData;
import PageObjects.MainPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FE_WesternUnionReceive_Result extends MainPage {

    public FE_WesternUnionReceive_Result(WebDriver passedDriver) {
        super(passedDriver);
    }

    @FindBy(css ="div.result-block--error > p > span")
    private WebElement errorText;

    @FindBy(css = "a.button.button--white")
    private WebElement transactionHistoryButton;

    @FindBy(css = "div.payments-action > a:nth-of-type(2)")
    private WebElement newPaymentButton;

    @FindBy(css ="a.button.button--gray")
    private WebElement proofPaymentButton;

    @FindBy(css = "h4")
    private WebElement appSuggestionLabel;

    @FindBy(css = "p.payments-finalContentColumns--info")
    private WebElement pdfLabel;

    @FindBy(css ="h2.payments--title")
    private WebElement WUResulPageTitle;

    @FindBy(css ="div.result-block--succes > p > strong")
    private WebElement successMessage;


    public boolean isTransactionHistoryButtonDisplayed(){
        return CommonTask.isElementEnabledAndDisplayed(transactionHistoryButton,"Transaction history button");
    }

    public boolean isNewPaymentButtonDisplayed(){
        return CommonTask.isElementEnabledAndDisplayed(newPaymentButton,"New payment button");
    }

    public boolean isProofPaymentButtonDisplayed(String mtcn){
        boolean value;
            try {
                value = proofPaymentButton.isDisplayed();
            }
            catch (NoSuchElementException e){
                if(!mtcn.contentEquals(TestData.WU_VALID_MTCN)){
                    value = true;
                }
                else {
                    value = false;
                }
            }
        return value;
    }

    public String getErrorText(){

        String value = "";
        try{
           value = errorText.getText();
        }
        catch (NoSuchElementException e){
            Log4Test.info("Error message not displayed, checking for success message");
            value = CommonTask.getText(successMessage,"success message");

        }
        return value;
    }

    public String getTransactionHistoryButtonLabel(){
        return CommonTask.getText(transactionHistoryButton,"Transaction history button");
    }

    public String getNewPaymentLabel(){
        return CommonTask.getText(newPaymentButton,"New payment label");
    }

    public String getPaymentProofLabel(){
        return CommonTask.getText(proofPaymentButton,"Payment proof button label");
    }

    public String getSuggestionsLabels(){
        return CommonTask.getText(appSuggestionLabel,"Suggestions label");
    }

    public String getPDFTextLabel(){
        return CommonTask.getText(pdfLabel,"PDF download text label");
    }

    public String getPageTitleLabel(){
        return CommonTask.getText(WUResulPageTitle,"Result page title");
    }

}

