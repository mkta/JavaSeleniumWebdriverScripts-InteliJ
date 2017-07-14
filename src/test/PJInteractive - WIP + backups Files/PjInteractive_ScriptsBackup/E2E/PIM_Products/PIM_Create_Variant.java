package PjInteractive_ScriptsBackup.E2E.PIM_Products;

import com.google.common.base.Function;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
 * Created by catalinf on 07-Apr-17
 */
public class PIM_Create_Variant {

    @Test
    public void startPIM_Create_Variant() throws Exception {

        if (createVariant == 1) {

            //Set Log output file
            System.setOut(new PrintStream(new FileOutputStream(logPath + "Pim Product Variant Console Logs " + dateFormatted2 + ".txt")));

            System.out.println("///////     INITIATING PIM PRODUCT Variant CREATION TEST       \\\\\\");


            ///////////////////////          Int Variables               //////////////////////

            System.out.println("Initiate Variables");

            int drvIDivar = drvID;
            int drvloopvar;
            WebDriver drivervar = null;

            System.out.println("Initiate date");
            // Set date format
            DateFormat dateFormatvar = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            // Get current date and time
            Date datevar = new Date();
            // Format the date
            String dateFormattedvar = dateFormatvar.format(datevar);

            System.out.println("Initiate drivers array");
            List<String> drvNamevar = new ArrayList<>(3);
            drvNamevar.add(0, "Chrome Driver");
            drvNamevar.add(1, "Firefox Driver");
            drvNamevar.add(2, "PhantomJS Driver");

            List<String> assetvar = new ArrayList<>(3);
            assetvar.add(0, "");
            assetvar.add(1, System.getProperty("user.dir") + "/AssetsImages/" + "Product/" + "DressRed1.jpg");
            assetvar.add(2, System.getProperty("user.dir") + "/AssetsImages/" + "Product/" + "DressRed2.jpg");

            String pNamevar = null;
            String pSkuvar = null;
            String pIDvar = null;
            String pStatusvar = null;


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

            Session sessionvar = Session.getInstance(props,
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

            for (drvloopvar = drvloops; drvloopvar < 4; drvloopvar++) {

                ////////////////////////////////// DRIVER CREATION //////////////////////////////////
                if (drvIDivar == 0) {
                    System.out.println("Starting Chrome Driver");

                    System.setProperty("webdriver.chrome.driver", chromeDrvPath);
                    drivervar = new ChromeDriver();
                }

                if (drvIDivar == 1) {
                    System.out.println("Starting Firefox Driver ");

                    System.setProperty("webdriver.gecko.driver", fireFoxDrvPath);
                    drivervar = new FirefoxDriver();
                }
                if (drvIDivar == 2) {

                    System.setProperty("webdriver.PhantomJSDriver.driver", phantomJSrvPath);
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setJavascriptEnabled(true);
                    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomJSrvPath);

                    drivervar = new PhantomJSDriver(caps);
                }
                drivervar.manage().window().maximize();

                System.out.println("Driver creation complete. Driver name is : " + drvNamevar.get(drvIDivar));


                //////////////////////// END OF DRIVER CREATIONS ////////////////////

                WebDriverWait wait = new WebDriverWait(drivervar, 20);

                //Open site
                System.out.println("Open site.");
                drivervar.get(site);

                //Reach KC

                try {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xkcUser)));
                    if (drivervar.findElements(By.xpath(xkcUser)).size() != 0) {
                        String kctitle = drivervar.getTitle();
                        System.out.println("KC title is : " + kctitle);
                        System.out.println("PIM KC Login reached");
                    } else {
                        System.out.println("PIM KC failed");
                    }
                    drivervar.findElement(By.xpath(xkcUser)).sendKeys("catalinf");
                    drivervar.findElement(By.xpath(xkcPsw)).sendKeys("tgvfr123");
                    drivervar.findElement(By.xpath(xkcLogInB)).click();
                } catch (Exception ppVe1) {

                    //noinspection ThrowablePrintedToSystemOut
                    System.out.println(ppVe1);
                    PPVE1(ppVe1, sessionvar, dateFormattedvar, drvNamevar, drvIDivar, drivervar);
                }

                try {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpimNavDashboard)));
                    if (drivervar.findElements(By.xpath(xpimNavDashboard)).size() != 0) {
                        String pimtitle = drivervar.getTitle();
                        System.out.println("Pim title is : " + pimtitle);
                        System.out.println("PIM reached");
                    } else {
                        System.out.println("PIM failed");
                    }

                } catch (Exception ppVe2) {

                    //noinspection ThrowablePrintedToSystemOut
                    System.out.println(ppVe2);
                    PPVE2(ppVe2, sessionvar, dateFormattedvar, drvNamevar, drvIDivar, drivervar);
                }

                //Switch to PIM DESI LA COL

                try {

                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xSwtichDL)));
                    drivervar.findElement(By.xpath(xSwtichDL)).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xSwtichDLDESI)));
                    String desiSelect = drivervar.findElement(By.xpath(xSwtichDLDESI)).getText();
                    drivervar.findElement(By.xpath(xSwtichDLDESI)).click();
                    wait.until(ExpectedConditions.textToBe(By.xpath(xSwithcLabel), desiSelect));
                    drivervar.findElement(By.xpath(xSwtichSUBMIT)).click();

                    //wait for page refresh
                    Thread.sleep(1500);
                    System.out.println("Waiting for pim refresh");
                    Wait<WebDriver> pagewait = new WebDriverWait(drivervar, 30);
                    pagewait.until(new Function<WebDriver, Boolean>() {
                        public Boolean apply(WebDriver drivervar) {
                            System.out.println("PIM Refresh State : "
                                    + String.valueOf(((JavascriptExecutor) drivervar).executeScript("return document.readyState")));
                            return String.valueOf(((JavascriptExecutor) drivervar).executeScript("return document.readyState")).equals("complete");
                        }
                    });
                    /// page should be loaded by now ....

                    String siteLabel = drivervar.findElement(By.xpath(xSwithcLabel)).getText();

                    if (Objects.equals(desiSelect, siteLabel)) {
                        System.out.println("Site Switched");
                        System.out.println("Site is : " + siteLabel);
                    } else {
                        System.out.println("Site Switch failed after 5 seconds");
                        System.out.println("Site is : " + siteLabel);
                    }


                } catch (Exception ppVe3) {
                    //noinspection ThrowablePrintedToSystemOut
                    System.out.println(ppVe3);
                    PPVE3(ppVe3, sessionvar, dateFormattedvar, drvNamevar, drvIDivar, drivervar);

                }


                //Open PRIM PRODUCT LISTING

                try {
                    System.out.println("Opening PIM product Listing");
                    drivervar.findElement(By.xpath(xProdListingDSHNAV)).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdListingNAV)));
                    drivervar.findElement(By.xpath(xProdListingNAV)).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdListingBC)));
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xProdListingFP)));
                } catch (Exception ppVe4) {

                    //noinspection ThrowablePrintedToSystemOut
                    System.out.println(ppVe4);
                    PPVE4(ppVe4, sessionvar, dateFormattedvar, drvNamevar, drvIDivar, drivervar);
                }

                
                //Send final email

                PPVFinal(pNamevar, pSkuvar, pStatusvar, pIDvar, sessionvar, dateFormattedvar, drvNamevar, drvIDivar);


                ///////////////////////////////////////// End of test code ////////////////////////////////////////////////
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////
                drvIDivar++;

                if (drvloopvar < 3) {
                    System.out.println("Initiating next driver loop");
                } else {
                    System.out.println("End of driver loops");
                    System.out.println("End test");
                }

                System.out.println("///////     PIM PRODUCT CREATION TEST COMPLETED       \\\\\\");
                //drivervar.quit();

                //////////////////////////End of the driver loop
            }
        } else {
            System.out.println("Variant creation disabled in PIM_ProductConfigs");
        }


    }
}



