package AutomationFramework;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class CommonTask {


    public static void accessDirectLink (WebDriver driver, String URL, WebElement element, String URLname){
        try{
            Log4Test.info("- accessing: " + URLname);
            driver.get(URL);
            Waiting.visibilityOfElement(driver, element, 50, URLname);
        } catch (NoSuchElementException e ){
            Assert.fail(Log4Test.error("Unable to load page"));
        }
    }


    public static void moveToElement(WebDriver driver, WebElement element, String elementName){
        try {
            Actions action = new Actions(driver);
            Log4Test.info("- moving to element : " + elementName);
            action.moveToElement(element).build().perform();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found"));
        }
    }


    public static void clearElement(WebDriver driver, WebElement element, String field) {
        try {
            Log4Test.info("- clearing field : " + field);
            element.clear();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found"));
        }
    }

    public static void sendKeys(WebDriver driver, WebElement element, String text, String field){
        try {
            Log4Test.info("- sending keys : '" + text + "' : to " + field);
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found"));
        }
    }


    public static void getUrl(WebDriver driver, String url){
        Log4Test.info("- navigating to : " + url);
        driver.get(url);
        Waiting.urlPathTobe(driver, url);
    }


    public static void clickElement(WebDriver driver, WebElement element, String elementName){
        try {
            //Waiting for the element to be available
            Waiting.elementToBeClickable(driver, element, elementName);
            //Tap element
            moveToElement(driver, element, elementName);
            Log4Test.info("- clicking element : " + elementName);
            element.click();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found"));
        }
    }

    public static void clickElementByActions(WebDriver driver, WebElement element, String elementName){
        try{
            //Waiting for the element to be available
            Waiting.elementToBeClickable(driver, element, elementName);
            //Tap element
            Log4Test.info("- Moving to and clicking element: "+ elementName);
            Actions actions = new Actions(driver);
            //actions.moveToElement(element).click().build().perform();
            element.sendKeys(Keys.ENTER);
        }
        catch (NoSuchElementException e){
            Assert.fail(Log4Test.error("Element is not found"));
        }
    }


    public static void setTextField(WebDriver driver, WebElement element, String text, String elementName) {
        //Wait for the field to be available
        Waiting.elementToBeClickable(driver, element, elementName);
        //Enter "item" into the field
        sendKeys(driver, element, text, elementName);
        //Waiting text to be present
        Waiting.textToBePresentInElement(driver, element, text, elementName);
    }

    public static void setInputField(WebDriver driver, WebElement element, String text, String elementName) {
        //Wait for the field to be available
        Waiting.elementToBeClickable(driver, element, elementName);
        //Enter "item" into the field
        sendKeys(driver, element, text, elementName);
    }


    public static String getAttributeAsText(WebElement element, String attribute, String elementName) {
        String stringValueOfAttribute = "";
        try {
            //Get element Attribute
            Log4Test.info("- getting attribute as String for : " + elementName);
            stringValueOfAttribute = element.getAttribute(attribute);
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
        }

        return stringValueOfAttribute;
    }



    public static String getText (WebElement element, String elementName) {
        String stringValueOfAttribute = "";
        try {
            //Get element Attribute
            Log4Test.info("- getting text for: " + elementName);
            stringValueOfAttribute = element.getText();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
        }

        return stringValueOfAttribute;
    }


    public static Boolean isElementEnabledAndDisplayed(WebElement element, String elementName){
        try {
            return isDisplayed(element, elementName) && isEnabled(element, elementName);
        } catch (NoSuchElementException e) {
            Log4Test.error("Element is not found : " + elementName);
            return false;
        }
    }

    public static Boolean isEnabled(WebElement element, String elementName){
        try {
            Log4Test.info("- verifying if " + elementName + " is enabled");
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
            return false;
        }
    }

    public static Boolean isDisplayed(WebElement element, String elementName){
        try {
            Log4Test.info("- verifying if " + elementName + " is displayed");
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.fail(Log4Test.error("Element is not found : " + elementName));
            return false;
        }
    }

    public static String getUrlPath(WebDriver driver) throws MalformedURLException {
        URL url = new URL(driver.getCurrentUrl());
        String path = url.getPath();
        Log4Test.info("- getting URL Path : " + path);
        return path;
    }

    public static String getTitle (WebDriver driver){
        Log4Test.info("- getting Tab name : " + driver.getTitle());
        return driver.getTitle();
    }

    public static int getListSizeAngularCSS(WebDriver driver, String rootElement){
        int counter =1;
        int flag = 1;
        while (flag == 1){
            String indexElement = rootElement + "(" + String.valueOf(counter+1)+ ")";

            try {
                driver.findElement(By.cssSelector(indexElement));
                counter++;
            }
            catch (NoSuchElementException e){
                flag = 0;
            }
        }
        return counter;
    }


    public static Boolean isCounterWorking(WebDriver driver, WebElement inputFieldElement, WebElement counterElement, int counterStartsAt, String elementName){

            boolean counterReflectsRemainingChars = true;

            for (int i = counterStartsAt; i >= 0 && counterReflectsRemainingChars; i--){

                Log4Test.test("Test counter for : " + i + " remaining chars");

                //Get lenght of inputed string
                int inputStringLenght = counterStartsAt - CommonTask.getAttributeAsText(inputFieldElement, TestData.VALUE, elementName + " field").length();

                //Get counter int value
                int counterValue = Integer.parseInt(CommonTask.getText(counterElement, elementName+ " counter").replaceAll("[^0-9]", ""));

                //Send new char to input field
                CommonTask.sendKeys(driver, inputFieldElement, "0", elementName+" field");

                //Compare if counter reflects remaining chars
                counterReflectsRemainingChars = counterValue == inputStringLenght;

            }
            return counterReflectsRemainingChars;
        }

    public static void clickByJavascriptExecutor(WebDriver driver, WebElement element, String elementName){
        try{
            //Waiting for the element to be available
            Waiting.elementToBeClickable(driver, element, elementName);
            //Tap element
            Log4Test.info("- Clicking element: "+ elementName);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
        }
        catch (NoSuchElementException e){
            Assert.fail(Log4Test.error("Element is not found"));
        }
    }
}
