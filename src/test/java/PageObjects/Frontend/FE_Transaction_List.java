package PageObjects.Frontend;

import AutomationFramework.CommonTask;
import PageObjects.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FE_Transaction_List extends MainPage {

    public FE_Transaction_List(WebDriver passedDriver) {
        super(passedDriver);
    }


    //-------------------------------------- String Locators

    private String firstTransactionHistorySegment = "//*[@id=\"main\"]/div[3]/div/div/div[2]/div/div[1]/div[2]/div[3]/div/div/div/div/div/div[";
    private String secondTransactionHistorySegment= "]/ui-raiffeisen-account-tile/div/div[4]/div[1]/a";






    public void accessAccountHistory(String accountName){
        WebElement element = driver.findElement(By.xpath("//div[contains(text(),'"+ accountName +"')]"));
        String xpathIndex = (String)((JavascriptExecutor)driver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", element);
        xpathIndex = xpathIndex.substring(0,xpathIndex.length()-52);
        xpathIndex = xpathIndex +"  ";
        xpathIndex = xpathIndex.substring(106,108);
        xpathIndex = xpathIndex.trim();
        WebElement accountTransactionHistory = driver.findElement(By.xpath(firstTransactionHistorySegment + xpathIndex + secondTransactionHistorySegment));
        CommonTask.clickByJavascriptExecutor(driver,accountTransactionHistory,"Transaction history for: " + accountName);
    }
}