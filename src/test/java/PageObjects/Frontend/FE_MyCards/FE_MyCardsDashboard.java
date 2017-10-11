package PageObjects.Frontend.FE_MyCards;

import AutomationFramework.CommonTask;
import AutomationFramework.Log4Test;
import AutomationFramework.Waiting;
import PageObjects.MainPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class FE_MyCardsDashboard extends MainPage {

    public FE_MyCardsDashboard(WebDriver passedDriver) {
        super(passedDriver);
    }

    //-------------------------------------- Locators

    @FindBy(css = "h2.title.title--dashboard.cards-title")
    private WebElement myCardsDashboardTitle;

    @FindBy(css = "div.cards-cta > button")
    private WebElement moreCardsButton;

    //-------------------------------------- String Locators
    private String IBANfirstSegment = "div.cards-container > div:nth-of-type(";
    private String IBANsecondSegment= ") > ui-raiffeisen-card-tile > div.card-content > div.card-info > div.card-elementContainer > div.card-element.card-element--cardNumber";

    private String cardImageFirstSegment = "div.cards-container > div:nth-of-type(";
    private String cardImageSecondSegment= ") > ui-raiffeisen-card-tile > div.card-content > div.card-element.card-element--image > img";

    private String validUntilFirstSegment = "div.cards-container > div:nth-of-type(";
    private String validUntilSecondSegment= ") > ui-raiffeisen-card-tile > div.card-content > div.card-ownerInfo > div.card-ownerInfoItem.card-ownerInfoItem--expirationDate > div.card-label";

    private String expiryDateFirstSegment = "div.cards-container > div:nth-of-type(";
    private String expiryDateSecondSegment= ") > ui-raiffeisen-card-tile > div.card-content > div.card-ownerInfo > div.card-ownerInfoItem.card-ownerInfoItem--expirationDate > div.card-value";

    //-------------------------------------- Methods
    private boolean areAllCardsDisplayed;
    //-------------------------------------- Methods

    public String getMyCardsDashboardTitleText(){
        return CommonTask.getText(myCardsDashboardTitle,"My cards title");
    }

    public String getMoreCardsButtonText(){
        Waiting.visibilityOfElement(driver,moreCardsButton,"More cards button");
        return CommonTask.getText(moreCardsButton,"More cards Button");
    }

    public void displayAllCards(){
        int index=1;
        try{
            Waiting.visibilityOfElement(driver,moreCardsButton,"more Cards button");
            while (moreCardsButton.isDisplayed()){
            Waiting.visibilityOfElement(driver,driver.findElement(By.cssSelector(cardImageFirstSegment+ String.valueOf(index)+cardImageSecondSegment)),"first card");
            index = index+5;
            moreCardsButton.sendKeys(Keys.ENTER);}
        }catch (NoSuchElementException e){
            System.out.println("All cards are now displayed");
            areAllCardsDisplayed = true;
        }
    }

    public String getNumberOfCards(){
        if(!areAllCardsDisplayed){
        displayAllCards();}

        int index =1;

        try{
            while (driver.findElement(By.cssSelector(cardImageFirstSegment+String.valueOf(index)+cardImageSecondSegment)).isDisplayed()){
            index++;}
        }catch (NoSuchElementException e){
            index--;
            Log4Test.info("Total number of cards: "+ String.valueOf(index));
        }
        return String.valueOf(index);
    }
}
