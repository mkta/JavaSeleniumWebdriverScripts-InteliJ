package PageObjects;

import AutomationFramework.CommonTask;
import AutomationFramework.Waiting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    //Declare WebDriver
    protected static WebDriver driver;

    public MainPage(WebDriver passedDriver) {
        this.driver = passedDriver;
        PageFactory.initElements(passedDriver, this);
    }

    //-------------------------------------- Locators



    // ---- Menu Buttons

    @FindBy (css = "#main > div > div.bp-area.\\2d -area.z-staticLeftFlexRight-left > div > div.bp-widget-body.ng-scope > div > div.bp-g-model > ul > li > ul > li:nth-child(4) > div > a")
    public WebElement groupsMenuButton;


    @FindBy(name = "cxp-create-portal")
    public WebElement createPortalButton;

    @FindBy(name = "title")
    public WebElement portalTitleField;


    @FindBy(css = "body")
    public WebElement body;


    @FindBy(css = "div.bp-ui-dragRoot.pm-panelCatalogIcon > div:nth-of-type(2) > p")
    public WebElement dragItem;


    public void clickGroupMenuButton(){
        Waiting.elementToBeClickable(driver, groupsMenuButton, "groups menu button");
        groupsMenuButton.click();
        CommonTask.clickElement(driver, groupsMenuButton, "Group Menu Button");
    }


    public void dragItem(){
        Actions action = new Actions(driver);
        action.moveToElement(dragItem).dragAndDrop(dragItem, body).build().perform();
    }



}
