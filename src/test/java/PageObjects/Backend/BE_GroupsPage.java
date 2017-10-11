package PageObjects.Backend;

/**
 * Created by azaharia on 20.04.2017.
 */


import AutomationFramework.CommonTask;
import PageObjects.MainPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class BE_GroupsPage extends MainPage {

    public BE_GroupsPage(WebDriver passedDriver) {
            super(passedDriver);
        }

    // ------------------------------------    Paths


    private static final String groupPath = "#widget-GroupMgmt > div > ul > li.bc-1-3.bd-columnsContainer.bd-grid1 > div > div > div.bd-viewportWrapper.bd-AllUsers-Label > div > div.bd-listDataholder.bd-groupManagement-groupList > a.bd-listItem.bd-autoTest-groupList-";
    private static final String usersPath = "#widget-GroupMgmt > div > ul > li.bd-columnsContainer.bc-1-3.bd-grid2 > div > div > div.bd-tabs > div.bd-tab.bd-tab1.bd-users.bd-activeTab > div > div > div.bd-listDataholder > a.bd-listItem.bd-autoTest-userList-";
    private static final String editUserPath = "#widget-GroupMgmt > div > ul > li.bd-columnsContainer.bc-1-3.bd-grid3 > div > div > div.bd-tabs.bd-groupMgmt-column3Body > div.bd-tab.bd-tab1.bd-details.bd-userDetails.bd-activeTab > div.bd-viewportWrapper.bd-user-details > div > div > ul:nth-child(1) > li.bc-2-3 > div";


    // ------------------------------------    Locators

        // -------- Groups

    @FindBy(css = "#widget-GroupMgmt > div > ul > li.bc-1-3.bd-columnsContainer.bd-grid1 > div > div > div.bd-columnHeader.bd-tabLabels.bd-groupManagement-column2Container-columnHeader.bd-Groups-Label > div > button > div")
    private WebElement addGroupButton;


    @FindBy(css = "#groupDetailsViewport > div.bc-button-row.bd-buttons > button")
    private WebElement editGrupDetailsButton;

            // ---- New Group Form

            @FindBy(id = "groupCreateForm_name")
            private WebElement newGroupName;

            @FindBy(id = "groupCreateForm_description")
            private WebElement newGroupDescription;

            @FindBy(css = "body > ul > form > li:nth-child(5) > div > p.bc-i.bc-button-row > button.bc-modal-ok.bc-button.bc-roundcorner-3.bc-primary.bc-green")
            private WebElement saveNewGroupButton;

            // ---- Edit Group

            @FindBy(id = "groupEditForm_description")
            private WebElement editGroupDescription;

            @FindBy(id = "bd-groupForm-role-dropdownbox")
            private WebElement dashboardAccessDropDown;

            @FindBy(id = "#groupEditForm > div.bc-button-row.bd-buttons.bc-align-right > button.bd-saveButton.bd-button.bd-gradient-green.bd-roundcorner-3.bd-groupmanagement-editSave.bd-autoTest-group-editGroupSaveButton.bd-user-font")
            private WebElement saveEditGroupButton;

            @FindBy(id = "#groupEditForm > div.bc-button-row.bd-buttons.bc-align-right > button.bd-cancelButton.bd-buttonText.bd-user-font")
            private WebElement cancelEditGroupButton;



        // -------- Users

    @FindBy(css = "#addUserTag-Wrapper > ul:nth-child(2) > div > button > div")
    private WebElement addUserButton;

    @FindBy(css = "#widget-GroupMgmt > div > ul > li.bd-columnsContainer.bc-1-3.bd-grid2 > div > div > div.bd-columnHeader.bd-tabLabels.bd-groupManagement-column2Container-columnHeader > div > div.bd-tabLabel.bd-tab1.bd-autoTest-header2Tab-user.bd-activeTab")
    private WebElement usersTab;

    @FindBy(css = "#widget-GroupMgmt > div > ul > li.bd-columnsContainer.bc-1-3.bd-grid2 > div > div > div.bd-columnHeader.bd-tabLabels.bd-groupManagement-column2Container-columnHeader > div > div.bd-tabLabel.bd-tab2.bd-autoTest-header2Tab-groupDetails")
    private WebElement groupDetailsTab;

            // ---- New User Form

            @FindBy(id = "userCreateForm_username")
            private WebElement newUserNameTextField;

            @FindBy(id = "userCreateForm_password")
            private WebElement newUserPasswordTextField;

            @FindBy(id = "userCreateForm_passwordAgain")
            private WebElement newUserPasswordAgainTextField;

            @FindBy(css = "body > ul > form > li:nth-child(6) > div > p.bc-i.bc-button-row > button.bc-modal-ok.bc-button.bc-roundcorner-3.bc-primary.bc-green")
            private WebElement saveNewUserButton;



    // ------------------------------------    Methods



    public void openGroup (String groupName) {
            WebElement groupLocator = driver.findElement(By.cssSelector(groupPath + groupName));
            CommonTask.clickElement(driver, groupLocator, groupName + " group");
    }

    public void openGroupDetails (String groupName){
        openGroup(groupName);
        CommonTask.clickElement(driver, groupDetailsTab, "group details");
    }


    public void openUserFromGroup (String group, String user){
        openGroup(group);
        WebElement userName = driver.findElement(By.cssSelector(usersPath + user));
        CommonTask.clickElement(driver, userName, user + " username");
    }

    public void createNewUser(String groupName, String groupPassword){
        CommonTask.clickElement(driver, addUserButton, "add new user buton");
        CommonTask.setInputField(driver, newUserNameTextField, groupName, groupName);
        CommonTask.setInputField(driver, newUserPasswordTextField, groupPassword, groupPassword);
        CommonTask.setInputField(driver, newUserPasswordAgainTextField, groupPassword, groupPassword);
        CommonTask.clickElement(driver, saveNewUserButton, "save new user button");
    }



}



