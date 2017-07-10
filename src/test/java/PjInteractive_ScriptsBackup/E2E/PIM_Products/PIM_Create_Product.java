package PjInteractive_ScriptsBackup.E2E.PIM_Products;

import com.google.common.base.Function;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static PjInteractive_ScriptsBackup.E2E.PIM_Products.PIM_ProductConfigs.*;
import static PjInteractive_ScriptsBackup.E2E.PIM_Products.PIM_ProductEmails.*;
import static PjInteractive_ScriptsBackup.E2E.PIM_Products.PIM_ProductxPaths.*;

/**
 * Created by catalinf on 05-Apr-17. ss
 */
public class PIM_Create_Product {

    @Test
    public void startPIM_Create_Product() throws Exception {

        //Set Log output file
        System.setOut(new PrintStream(new FileOutputStream(logPath + "Pim Product Console Logs " + dateFormatted2 + ".txt")));

        System.out.println("///////     INITIATING PIM PRODUCT CREATION TEST       \\\\\\");


        ///////////////////////          Int Variables               //////////////////////

        System.out.println("Initiate Variables");

        int drvIDi = drvID;
        int drvloop;
        WebDriver driver = null;

        System.out.println("Initiate date");
        // Set date format
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // Get current date and time
        Date date = new Date();
        // Format the date
        String dateFormatted = dateFormat.format(date);

        System.out.println("Initiate drivers array");
        List<String> drvName = new ArrayList<>(3);
        drvName.add(0, "Chrome Driver");
        drvName.add(1, "Firefox Driver");
        drvName.add(2, "PhantomJS Driver");

        List<String> asset = new ArrayList<>(3);
        asset.add(0, "");
        asset.add(1, System.getProperty("user.dir") + "/AssetsImages/" + "Product/" + "DressAqua1.jpg");
        asset.add(2, System.getProperty("user.dir") + "/AssetsImages/" + "Product/" + "DressAqua2.jpg");

        String productDescription = "<center>Script product description test <br><br> <img>https://i.ytimg.com/vi/yaqe1qesQ8c/maxresdefault.jpg</img></center>";

        String pName = null;
        String pSku = null;
        String pID = null;
        String pStatus = null;


        System.out.println("End of variables");

        //////////////////////////        Set SKU Date       //////////////////////////
        // Set date format
        final DateFormat dateFormat3 = new SimpleDateFormat("yyyyMMdd.HHmmss");
        // Get current date and time
        final Date date3 = new Date();
        // Format the date
        final String dateFormatted3 = dateFormat3.format(date3);

        //////////////////////////        End of variables        //////////////////////////

        //////////////////////////        Initiate Email
        System.out.println("Initiate gmail");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        System.out.println("End of initiate email");

        //////////////////////////       End of initiate Email

        System.out.println("Start test");

        ///Stat of Driver loop

        System.out.println("Start of driver loop");

        for (drvloop = drvloops; drvloop < 4; drvloop++) {

            ////////////////////////////////// DRIVER CREATION //////////////////////////////////
            if (drvIDi == 0) {
                System.out.println("Starting Chrome Driver");

                System.setProperty("webdriver.chrome.driver", chromeDrvPath);
                driver = new ChromeDriver();
            }

            if (drvIDi == 1) {
                System.out.println("Starting Firefox Driver ");

                System.setProperty("webdriver.gecko.driver", fireFoxDrvPath);
                driver = new FirefoxDriver();
            }
            if (drvIDi == 2) {

                System.setProperty("webdriver.PhantomJSDriver.driver", phantomJSrvPath);
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setJavascriptEnabled(true);
                caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomJSrvPath);

                driver = new PhantomJSDriver(caps);
            }
            driver.manage().window().maximize();

            System.out.println("Driver creation complete. Driver name is : " + drvName.get(drvIDi));


            //////////////////////// END OF DRIVER CREATIONS ////////////////////

            WebDriverWait wait = new WebDriverWait(driver, 20);

            //Open site
            System.out.println("Open site.");
            driver.get(site);

            //Reach KC

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xkcUser)));
                if (driver.findElements(By.xpath(xkcUser)).size() != 0) {
                    String kctitle = driver.getTitle();
                    System.out.println("KC title is : " + kctitle);
                    System.out.println("PIM KC Login reached");
                } else {
                    System.out.println("PIM KC failed");
                }
                driver.findElement(By.xpath(xkcUser)).sendKeys("catalinf");
                driver.findElement(By.xpath(xkcPsw)).sendKeys("tgvfr123");
                driver.findElement(By.xpath(xkcLogInB)).click();
            } catch (Exception ppe1) {

                //noinspection ThrowablePrintedToSystemOut
                System.out.println(ppe1);
                PPE1(ppe1, session, dateFormatted, drvName, drvIDi, driver);
            }

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpimNavDashboard)));
                if (driver.findElements(By.xpath(xpimNavDashboard)).size() != 0) {
                    String pimtitle = driver.getTitle();
                    System.out.println("Pim title is : " + pimtitle);
                    System.out.println("PIM reached");
                } else {
                    System.out.println("PIM failed");
                }

            } catch (Exception ppe2) {

                //noinspection ThrowablePrintedToSystemOut
                System.out.println(ppe2);
                PPE2(ppe2, session, dateFormatted, drvName, drvIDi, driver);
            }

            //Switch to PIM DESI LA COL

            try {

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xSwtichDL)));
                driver.findElement(By.xpath(xSwtichDL)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xSwtichDLDESI)));
                String desiSelect = driver.findElement(By.xpath(xSwtichDLDESI)).getText();
                driver.findElement(By.xpath(xSwtichDLDESI)).click();
                wait.until(ExpectedConditions.textToBe(By.xpath(xSwithcLabel), desiSelect));
                driver.findElement(By.xpath(xSwtichSUBMIT)).click();

                //wait for page refresh
                Thread.sleep(1500);
                System.out.println("Waiting for pim refresh");
                Wait<WebDriver> pagewait = new WebDriverWait(driver, 30);
                pagewait.until(new Function<WebDriver, Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        System.out.println("PIM Refresh State : "
                                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                        return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")).equals("complete");
                    }
                });
                /// page should be loaded by now ....

                String siteLabel = driver.findElement(By.xpath(xSwithcLabel)).getText();

                if (Objects.equals(desiSelect, siteLabel)) {
                    System.out.println("Site Switched");
                    System.out.println("Site is : " + siteLabel);
                } else {
                    System.out.println("Site Switch failed after 5 seconds");
                    System.out.println("Site is : " + siteLabel);
                }


            } catch (Exception ppe3) {
                //noinspection ThrowablePrintedToSystemOut
                System.out.println(ppe3);
                PPE3(ppe3, session, dateFormatted, drvName, drvIDi, driver);

            }


            //Open PRIM PRODUCT LISTING

            try {
                System.out.println("Opening PIM product Listing");
                driver.findElement(By.xpath(xProdListingDSHNAV)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdListingNAV)));
                driver.findElement(By.xpath(xProdListingNAV)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdListingBC)));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdListingFP)));
            } catch (Exception ppe4) {

                //noinspection ThrowablePrintedToSystemOut
                System.out.println(ppe4);
                PPE4(ppe4, session, dateFormatted, drvName, drvIDi, driver);
            }

            ///Start of product create

            System.out.println("Product creation starting");

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProductCreateAddButton)));
                driver.findElement(By.xpath(xProductCreateAddButton)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdCrName)));
                //Product name
                driver.findElement(By.xpath(xProdCrName)).sendKeys(dateFormatted + " TestScriptProdName");
                //Product Manufacturer
                driver.findElement(By.xpath(xProdCrManufDL)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdCreateManufSelect)));
                driver.findElement(By.xpath(xProdCreateManufSelect)).click();
                //Product Catalogue
                driver.findElement(By.xpath(xProdCrCatalogueDL)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdCrCatalogueSelect1)));
                driver.findElement(By.xpath(xProdCrCatalogueSelect1)).click();
                driver.findElement(By.xpath(xProdCrCatalogueSelect2)).click();
                driver.findElement(By.xpath(xProdCrCatalogueDL)).click();
                //Product Categories
                driver.findElement(By.xpath(xProdCrCategoriesDL)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdCrCategoriesSelect)));
                driver.findElement(By.xpath(xProdCrCategoriesSelect)).click();
                driver.findElement(By.xpath(xProdCrCategoriesDL)).click();
                //Product Type
                driver.findElement(By.xpath(xProdCrTypeDL)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdCrTypeSelect)));
                driver.findElement(By.xpath(xProdCrTypeSelect)).click();
                //SAVE
                driver.findElement(By.xpath(xProdCrSAVE)).click();
                //Get product create date
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdCrDate)));
                System.out.println("Product created. Initiating Draft edits");

            } catch (Exception ppe5) {

                //noinspection ThrowablePrintedToSystemOut
                System.out.println(ppe5);
                PPE5(ppe5, session, dateFormatted, drvName, drvIDi, driver);

            }


            //Draft edit data


            try {
                //Press Edit
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdEditBTN)));
                driver.findElement(By.xpath(xProdEditBTN)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdSaveBTN)));
                //Sku
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xProdSKU)));
                driver.findElement(By.xpath(xProdSKU)).sendKeys("TSP.SKU." + dateFormatted3);
                //Enter description to iframe description
                WebElement iFrame = driver.findElement(By.tagName("iframe"));
                driver.switchTo().frame(iFrame);
                WebElement editable = driver.switchTo().activeElement();
                editable.sendKeys(productDescription);
                driver.switchTo().parentFrame();
                //Teaser
                driver.findElement(By.xpath(xProdTeaser)).sendKeys("Script product teaser test");
                //Go to Details
                System.out.println("Go to details");
                driver.findElement(By.xpath(xProdEDetailsTab)).click();
                //Add details
                System.out.println("Adding details");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdeDetailsWeight)));
                driver.findElement(By.xpath(xProdeDetailsWeight)).sendKeys("5");
                driver.findElement(By.xpath(xProdeDetailsWeightType)).sendKeys("Kg");
                driver.findElement(By.xpath(xProdeDetailsRRP)).sendKeys("777");
                driver.findElement(By.xpath(xProdeDetailsColor)).sendKeys("Aqua");
                driver.findElement(By.xpath(xProdeDetailsColorSelector)).click();
                //setting the color
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdeDetailsColorSelectorColor)));
                driver.findElement(By.xpath(xProdeDetailsColorSelectorColor)).sendKeys(Keys.RETURN);
                driver.findElement(By.xpath(xProdeDetailsColorSelectorColor)).sendKeys(Keys.BACK_SPACE);
                driver.findElement(By.xpath(xProdeDetailsColorSelectorColor)).sendKeys(Keys.BACK_SPACE);
                driver.findElement(By.xpath(xProdeDetailsColorSelectorColor)).sendKeys(Keys.BACK_SPACE);
                driver.findElement(By.xpath(xProdeDetailsColorSelectorColor)).sendKeys(Keys.BACK_SPACE);
                driver.findElement(By.xpath(xProdeDetailsColorSelectorColor)).sendKeys(Keys.BACK_SPACE);
                driver.findElement(By.xpath(xProdeDetailsColorSelectorColor)).sendKeys(Keys.BACK_SPACE);
                driver.findElement(By.xpath(xProdeDetailsColorSelectorColor)).sendKeys("00d5ff");
                driver.findElement(By.xpath(xProdeDetailsColorSelectorColor)).sendKeys(Keys.RETURN);
                //color set
                driver.findElement(By.xpath(xProdeDetailsColorSelector)).click();
                driver.findElement(By.xpath(xProdeDetailsSize)).sendKeys("42");
                driver.findElement(By.xpath(xProdeDetailsSizeGroup)).sendKeys("Men");
                driver.findElement(By.xpath(xProdeDetailsMaterial)).sendKeys("Leather");
                driver.findElement(By.xpath(xProdeDetailsSleeveLenght)).sendKeys("69");

////////////////////////// ASSET CODE Start /////////////////////////////////////////////////

                //Asset
                int assetNR = 1;
                System.out.println("Adding first asset");
                //first asset
                driver.findElement(By.xpath(xProdEAssetsTab)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdEAssetsAddButton)));
                driver.findElement(By.xpath(xProdEAssetsAddButton)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(xProdEAssetsName)));
                driver.findElement(By.id(xProdEAssetsName)).sendKeys(Keys.RETURN);
                driver.findElement(By.id(xProdEAssetsName)).sendKeys(assetNR + "Asset" + dateFormatted3);
                driver.findElement(By.id(xProdEAssetsName)).sendKeys(Keys.RETURN);
                Thread.sleep(2000);
                wait.until(ExpectedConditions.numberOfElementsToBe(By.id(String.valueOf(xProdEAssetsUPLOADpath)), 1));
                driver.findElement(By.id(xProdEAssetsUPLOADpath)).sendKeys(asset.get(assetNR));
                wait.until(ExpectedConditions.elementToBeClickable(By.id(xProdEAssetsSAVEBtn)));
                driver.findElement(By.id(xProdEAssetsSAVEBtn)).click();
                System.out.println("First asset added");
                assetNR++;

                //asset 2

                System.out.println("Adding second asset");
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xProdEAssetsSAVEBtn)));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xProdOVERLAY)));
                Thread.sleep(5000);
                wait.until(ExpectedConditions.elementToBeClickable(By.id(xProdEAssetsAddButton2)));
                driver.findElement(By.id(xProdEAssetsAddButton2)).click();
                Thread.sleep(1000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(xProdEAssetsName)));
                driver.findElement(By.id(xProdEAssetsName)).sendKeys(Keys.RETURN);
                driver.findElement(By.id(xProdEAssetsName)).sendKeys(assetNR + "Asset" + dateFormatted3);
                driver.findElement(By.id(xProdEAssetsName)).sendKeys(Keys.RETURN);
                Thread.sleep(3000);
                wait.until(ExpectedConditions.numberOfElementsToBe(By.id(String.valueOf(xProdEAssetsUPLOADpath)), 1));
                driver.findElement(By.id(xProdEAssetsUPLOADpath)).sendKeys(asset.get(assetNR));
                wait.until(ExpectedConditions.elementToBeClickable(By.id(xProdEAssetsSAVEBtn)));
                driver.findElement(By.id(xProdEAssetsSAVEBtn)).click();
                System.out.println("Second asset added");


////////////////////////// ASSET CODE END /////////////////////////////////////////////////

            } catch (Exception ppe6) {

                //noinspection ThrowablePrintedToSystemOut
                System.out.println(ppe6);
                PPE6(ppe6, session, dateFormatted, drvName, drvIDi, driver);

            }

            try {
                System.out.println("Save and publish product");
                //go to general
                ///problem here .....
                Thread.sleep(2000);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xProdEAssetsSAVEBtn)));
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xProdGeneralTab)));
                driver.findElement(By.xpath(xProdGeneralTab)).click();
                //Store stuff
                pName = driver.findElement(By.id(xProductName)).getAttribute("value");
                System.out.println("Product Name " + pName);
                pSku = driver.findElement(By.id(xProductSKU)).getAttribute("value");
                System.out.println("Product Sku " + pSku);
                pID = driver.findElement(By.id(xProductID)).getAttribute("value");
                System.out.println("Product ID " + pID);
                //Save and publish
                System.out.println("Save product ");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdSaveBTN)));
                driver.findElement(By.xpath(xProdSaveBTN)).click();
                wait.until(ExpectedConditions.textToBe(By.xpath(xProdPublishBTN), "PUBLISH"));
                System.out.println("Publish product ");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdPublishBTN)));
                driver.findElement(By.xpath(xProdPublishBTN)).click();
                wait.until(ExpectedConditions.textToBe(By.xpath(xProdPublishBTN), "DRAFT"));
                //Trim and store status
                String pStatusI = driver.findElement(By.xpath(xProductStatus)).getText();
                String[] pStatusII = pStatusI.split(dateFormatted + " TestScriptProdName");
                String pStatusIII = null;
                String pStatusIV;
                for (String timsts1 : pStatusII) {
                    pStatusIII = timsts1;
                }
                pStatusIV = pStatusIII.replace("[", "");
                pStatus = pStatusIV.replace("]", "");
                System.out.println("Product status " + pStatus);
            } catch (Exception ppe7) {

                //noinspection ThrowablePrintedToSystemOut
                System.out.println(ppe7);
                PPE7(ppe7, session, dateFormatted, drvName, drvIDi, driver);

            }

            //Send final email

            PPFinal(pName, pSku, pStatus, pID, session, dateFormatted, drvName, drvIDi);


            ///////////////////////////////////////// End of test code ////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////
            drvIDi++;

            if (drvloop < 3) {
                System.out.println("Initiating next driver loop");
            } else {
                System.out.println("End of driver loops");
                System.out.println("End test");
            }

            System.out.println("///////     PIM PRODUCT CREATION TEST COMPLETED       \\\\\\");
            //driver.quit();

            //////////////////////////End of the driver loop
        }
    }
}

