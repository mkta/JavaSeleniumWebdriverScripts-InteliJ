package AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Waiting {


    // --------------------------------------- Explicit Waits
    

    public static void elementToBeClickable(WebDriver driver, WebElement element, String elementName){
        try {
            Log4Test.info("- waiting for element : " + elementName + " : to be clickable");
            new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Element is not clickable within : " + TestData.SHORT_WAIT + " seconds"));
        }

    }

    public static void elementToBeClickable(WebDriver driver, WebElement element, int seconds, String elementName){
        try {
            Log4Test.info("- waiting for element : " + elementName + " : to be clickable");
            new WebDriverWait(driver, seconds).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Element is not clickable within : " + seconds +  " seconds"));
        }
    }


    public static void elementToBeSelected(WebDriver driver, WebElement element, String elementName){
        try {
            Log4Test.info("- waiting for element : " + elementName + " : to be selected");
            new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.elementToBeSelected(element));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Element is not selected within : " + TestData.SHORT_WAIT + " seconds"));
        }
    }

    public static void elementToBeSelected(WebDriver driver, WebElement element, int seconds, String elementName){
        try {
            Log4Test.info("- waiting for element : " + elementName + " : to be selected");
            new WebDriverWait(driver, seconds).until(ExpectedConditions.elementToBeSelected(element));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Element is not selected within : " + seconds + " seconds"));
        }
    }

    public static void textToBePresentInElement(WebDriver driver, WebElement element, String text, String elementName){
        try {
            Log4Test.info("- waiting for text : " + text +  " : to be present in " +  elementName );
            new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Text is not present in element within : " + TestData.SHORT_WAIT + " seconds"));
        }
    }

    public static void textToBePresentInElement(WebDriver driver, WebElement element, String text, int seconds, String elementName){
        try {
            Log4Test.info("- waiting for text : " + text +  " : to be present in " +  elementName );
            new WebDriverWait(driver, seconds).until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Text is not present in element within : " +seconds + " seconds"));
        }
    }


    public static boolean textToContain(WebDriver driver, String id, String text) {
        return new WebDriverWait(driver, TestData.SHORT_WAIT).until(textContains(id, text));
    }

    public static boolean textToContain(WebDriver driver, String id, String text, int seconds) {
        return new WebDriverWait(driver ,seconds).until(textContains(id, text));
    }

    public static void titleContains(WebDriver driver, String title){
        try {
            Log4Test.info("- waiting for title to contain : " + title );
            new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.titleContains(title));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Title does not contain expected text within : " + TestData.SHORT_WAIT + " seconds"));
        }
    }

    public static void titleContains(WebDriver driver, String title, int seconds){
        try {
            Log4Test.info("- waiting for title to contain : " + title );
            new WebDriverWait(driver, seconds).until(ExpectedConditions.titleContains(title));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Title does not contain expected text within : " + seconds + " seconds"));
        }
    }


    public static void titleIs(WebDriver driver, String title){
        try {
            Log4Test.info("- waiting for title to be : " + title );
            new WebDriverWait(driver, TestData.LONG_WAIT).until(ExpectedConditions.titleIs(title));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Title is not what expected within : " + TestData.LONG_WAIT + " seconds"));
        }
    }

    public static void titleIs(WebDriver driver, String title, int seconds){
        try {
            Log4Test.info("- waiting for title to be : " + title );
            new WebDriverWait(driver, seconds).until(ExpectedConditions.titleIs(title));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Title is not what expected within : " + seconds + " seconds"));
        }
    }

    public static void visibilityOfElement(WebDriver driver, WebElement element, String elementName){
        try {
            Log4Test.info("- waiting for element : " + elementName + " : to be visible");
            new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Element is not visible within : " + TestData.SHORT_WAIT + " seconds"));
        }
    }

    public static void visibilityOfElement(WebDriver driver, WebElement element, int seconds, String elementName){
        try {
            Log4Test.info("- waiting for element : " + elementName + " : to be visible");
            new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Element is not visible within : " + seconds + " seconds"));
        }
    }

    public static void invisibilityOfElement(WebDriver driver, WebElement element, String elementName){
        try {
            Log4Test.info("- waiting for element : " + elementName + " : to be invisible");
            new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Element is not invisible within : " + TestData.SHORT_WAIT + " seconds"));
        }
    }

    public static void invisibilityOfElement(WebDriver driver, WebElement element, int seconds, String elementName){
        try {
            Log4Test.info("- waiting for element : " + elementName + " : to be invisible");
            new WebDriverWait(driver, seconds).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Element is not invisible within : " + seconds + " seconds"));
        }
    }
    public static void selectionStateToBe(WebDriver driver, WebElement element, boolean selected, String elementName){
        try {
            Log4Test.info("- waiting for selection state to be : " + selected + " : for element : " + elementName);
            new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.elementSelectionStateToBe(element, selected));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("State of element is not : " + selected + " within : " + TestData.SHORT_WAIT + " seconds"));
        }
    }

    public static void selectionStateToBe(WebDriver driver, WebElement element, int seconds, boolean selected, String elementName){
        try {
            Log4Test.info("- waiting for selection state to be : " + selected + " : for element : " + elementName);
            new WebDriverWait(driver, seconds).until(ExpectedConditions.elementSelectionStateToBe(element, selected));
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("State of element is not : " + selected + " within : " + TestData.SHORT_WAIT + " seconds"));
        }
    }


    public static void forAlert(WebDriver driver){
        try {
            Log4Test.info("- waiting for alert to be present");
            new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Alert is not present within : " + TestData.SHORT_WAIT + " seconds"));
        }
    }

    public static void forAlert(WebDriver driver, int seconds){
        try {
            Log4Test.info("- waiting for alert to be present");
            new WebDriverWait(driver,seconds).until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException toe){
            Assert.fail(Log4Test.error("Alert is not present within : " + seconds + " seconds"));
        }
    }

    public static void  forFrame(WebDriver driver, By locator) {
       new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public static void  forFrame(WebDriver driver, By locator, int seconds) {
        new WebDriverWait(driver, seconds).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public static void checkboxToBeChecked(WebDriver driver, By locator) {
       new WebDriverWait(driver, TestData.SHORT_WAIT).until(boxIsChecked(driver.findElement(locator)));
    }

    public static void checkboxToBeChecked(WebDriver driver, By locator, int seconds) {
        new WebDriverWait(driver,seconds).until(boxIsChecked(driver.findElement(locator)));
    }

    public static void checkboxToBeUnchecked(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, TestData.SHORT_WAIT).until(boxIsUnchecked(element));
    }

    public static void checkboxToBeUnchecked(WebDriver driver, WebElement element, int seconds) {
        new WebDriverWait(driver, seconds).until(boxIsUnchecked(element));
    }

    public static void urlPathContains (WebDriver driver, String urlPath){
        new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.urlContains(urlPath));
    }

    public static void urlPathContains (WebDriver driver, String urlPath, int seconds){
        new WebDriverWait(driver, seconds).until(ExpectedConditions.urlContains(urlPath));
    }

    public static void urlPathTobe (WebDriver driver, String urlPath){
        new WebDriverWait(driver, TestData.SHORT_WAIT).until(ExpectedConditions.urlContains(urlPath));
    }

    public static void urlPathTobe (WebDriver driver, String urlPath, int seconds){
        new WebDriverWait(driver, seconds).until(ExpectedConditions.urlToBe(urlPath));
    }














    public static ExpectedCondition<Boolean> textContains(final String text, final String elementText) {
        //A wait condition which will ensure the elementText variable contains the text variable before continuing
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver f) {
                if (elementText.contains(text)) {
                    return true;
                } else {
                    return false;
                }
            }

        };
    }

    public static ExpectedCondition<Boolean> boxIsChecked(final WebElement element) {
        //A wait condition which will ensure a check box is checked before continuing
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver f) {
                if (element.getAttribute("checked").equals("true")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> boxIsUnchecked(final WebElement element) {
        //A wait condition which will ensure a checkbox is unchecked before continuing
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver f) {
                if (element.getAttribute("checked").equals("false")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
    }

}
