package Desi_FE_LOOP_Script;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import static Desi_FE_LOOP_Script.Assert.*;
import static Desi_FE_LOOP_Script.Emails.*;
import static Desi_FE_LOOP_Script.intConf.*;
import static Desi_FE_LOOP_Script.intXpath.*;

//import org.junit.Test;


/**
 * Created by catalinf on 04-Apr-17. Vesion 4.0
 * Made for WebDriver
 * \\\\\\\\\\\\\\\\\\\\\\\\\
 * /////////////////////////
 * Check intConf before run
 * /////////////////////////
 * \\\\\\\\\\\\\\\\\\\\\\\\\
 * Script Contains:
 * *** Emails for exceptions
 * *** Email for all orders created with details
 * *** PLP+PDP+AddToBasket+Payment
 * *** Payment loop (goes through all payments) (max 4 / only CC configured)
 * *** Product loop (goes through all products (max 9)
 * *** Country loop (goes through all country (max 2 US and JP)
 */

public class DesiFELOOPTest {

    @Test
    public void startTest() throws Exception {

        //Set Log output file
        System.setOut(new PrintStream(new FileOutputStream(logPath + "Console Logs " + dateFormatted2 + ".txt")));

        /////////////////////////// Set Drivers
        System.out.println("Set drivers property");
        System.setProperty("webdriver.chrome.driver", chromeDrvPath);
        System.setProperty("webdriver.gecko.driver", fireFoxDrvPath);
        System.setProperty("webdriver.PhantomJSDriver.driver", phantomJSrvPath);

        WebDriver driver = null;

        System.out.println("End of drivers property");


        /////////////////////////Initiate Email
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

/////////////////////////// Initiate variables
        System.out.println("Initiate Variables");

        int testloop;
        int countryloop;
        int paymentloop;
        int prodloop;
        int drvloop;

        System.out.println("Initiate date");
        // Set date format
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // Get current date and time
        Date date = new Date();
        // Format the date
        String dateFormatted = dateFormat.format(date);

        System.out.println("Initiate drivers array");
        List<String> drvName = new ArrayList<>(6);
        drvName.add(0, "Chrome Driver");
        drvName.add(1, "Firefox Driver");
        drvName.add(2, "PhantomJS Driver");
        drvName.add(3, "IE Driver");

        System.out.println("Initiate contry array");
        List<String> countrys = new ArrayList<>(6);
        countrys.add(0, "");
        countrys.add(1, "us"); // US
        countrys.add(2, "jp"); // JP

        System.out.println("Initiate payment URLS");
        String payURL = "https://test.adyen.com/hpp/details.shtml";
        String pay2URL = "https://test.adyen.com/hpp/completeCard.shtml";

        System.out.println("Initiate Credit cards array");
        List<String> creditcards = new ArrayList<>(6);
        creditcards.add(0, "");
        creditcards.add(1, "4111 1111 1111 1111"); // visa
        creditcards.add(2, "5555 5555 5555 4444"); // MAster Card
        creditcards.add(3, "3700 0000 0000 002"); // American Express
        creditcards.add(4, "6011 6011 6011 6611"); // Discover (US)
        creditcards.add(5, "3569 9900 1009 5841"); // JCB (JP)

        System.out.println("Initiate some variables");
        WebDriverWait wait;
        JavascriptExecutor js;
        String paymentName = null;
        String orderRef;
        String ord2 = null;
        String miniBasketPName = null;
        js = null;

        System.out.println("Initiate order Reference array");
        List<String> orderReferences = new ArrayList<>();
        orderReferences.add(0, "null");
        orderReferences.add(1, "null");
        orderReferences.add(2, "null");
        orderReferences.add(3, "null");
        orderReferences.add(4, "null");
        orderReferences.add(5, "null");
        orderReferences.add(6, "null");
        orderReferences.add(7, "null");
        orderReferences.add(8, "null");
        orderReferences.add(9, "null");

        System.out.println("Initiate product names array");
        List<String> productNames = new ArrayList<>();
        productNames.add(0, "null");
        productNames.add(1, "null");
        productNames.add(2, "null");
        productNames.add(3, "null");
        productNames.add(4, "null");
        productNames.add(5, "null");
        productNames.add(6, "null");
        productNames.add(7, "null");
        productNames.add(8, "null");
        productNames.add(9, "null");

        System.out.println("end of variables");
/////////////////////////// End of variables

        System.out.println("Starting Test");


        /////////////////////// Start of the Test loop

        for (testloop = testloops; testloop < 11; testloop++) {

            System.out.println("Test Loop number : " + testloop);


            int drvIDi = drvID;

            ///Stat of Driver loop

            for (drvloop = drvloops; drvloop < 4; drvloop++) {

                System.out.println("Driver loop number : " + drvloop);

                if (drvIDi == 0) {
                    System.out.println("Starting Chrome Driver");

                    driver = new ChromeDriver();
                }

                if (drvIDi == 1) {
                    System.out.println("Starting Firefox Driver ");

                    driver = new FirefoxDriver();
                }

                if (drvIDi == 2) {
                    System.out.println("Starting Ghost/PhantomJS Driver ");

                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setJavascriptEnabled(true);
                    caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomJSrvPath);

                    driver = new PhantomJSDriver(caps);
                }


                driver.manage().window().maximize();

                int countryidi = countryid;

                /////////////////////// Start of the country loop

                for (countryloop = countryloops; countryloop < 3; countryloop++) {

                    //set country and country based URLs

                    String country = countrys.get(countryidi);
                    String plpURL = site + country + listingURL;
                    String ckURL = site + country + "/checkout";
                    String tpURL = site + country + "/complete";
                    String bURL = site + country + "/basket";

                    System.out.println("Country Loop number : " + countryloop);
                    System.out.println("Country number :" + country);
                    System.out.println("Country name :" + countrys.get(countryidi));

                    int paymenti = payment;

                    /////////////////////// Start of the payment loop

                    for (paymentloop = paymentloops; paymentloop < 5; paymentloop++) {

                        System.out.println("Payment Loop number : " + paymentloop);
                        System.out.println("Payment number :" + paymenti);

                        //Set Payment selector xpath
                        String xpm = "html/body/section[3]/router-view/section[2]/div/div/div[2]/div[2]/div[3]/div/div[" + paymenti + "]/label/img";

                        //Set CC and CVC

                        String CC = creditcards.get(paymenti);
                        if (country.equals("jp")) {
                            if (paymenti == 4) {
                                CC = creditcards.get(5);
                            }
                        }
                        String CVC;
                        if (paymenti != 3) {
                            CVC = "737";
                        } else {
                            CVC = "7373"; // For AE
                        }

                        int prodsi = prods;

                        //Start of the product loop

                        for (prodloop = prodloops; prodloop < 10; prodloop++) {

                            System.out.println("Product Loop number : " + prodloop);
                            System.out.println("Product number :" + prodsi);

                            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

                            wait = new WebDriverWait(driver, twt);

                            //Set Product Xpath

                            String pxp = "html/body/section[3]/router-view/div/section[5]/div/div[2]/div/div/div[" + prodsi + "]/div/div[2]/h3/a";

                            //open url

                            driver.get(site + country);

                            //Thread.sleep(30000);
                            //String title = driver.getTitle();
                            //System.out.println("------------------------------------------------" + title);


                            //wait for navigation


                            try {
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xnavListing)));

                                //Call method for HP assertion

                                aHP(driver, country);
                            } catch (Exception e1) {

                                //noinspection ThrowablePrintedToSystemOut
                                System.out.println(e1);
                                System.out.println("Sending Error email for e1");

                                E1(e1, session, dateFormatted, countryidi, countrys, drvName, drvIDi, country, driver);


                                System.out.println("Error email sent");


                                //driver.quit();
                                //throw (e1);
                            }

                            //open listing

                            driver.findElement(By.xpath(xnavListing)).click();

                            //wait for PLP product

                            try {

                                //Call Asset method for for PLP
                                aPLP(driver, plpURL);

                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pxp)));

                            } catch (Exception e2) {

                                System.out.println("Sending Error email of e2");
                                //noinspection ThrowablePrintedToSystemOut
                                System.out.println(e2);
                                E2(e2, session, dateFormatted, countryidi, countrys, drvName, drvIDi, country, driver);


                                System.out.println("Error email sent");


                                //driver.quit();
                                //throw (e2);
                            }

                            //store product name

                            String pname = driver.findElement(By.xpath(pxp)).getText();
                            System.out.println("Product Name for product loop : " + prodloop + " = " + pname);

                            //Add to Product names Array

                            productNames.set(prodloop, pname);

                            //open pdp

                            driver.findElement(By.xpath(pxp)).click();

                            //Call PDP assert
                            aPDP(driver, country, pname);

                            //wait for pdp stuff

                            try {
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xe1)));

                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xe2)));
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xe3)));

                                Thread.sleep(pdpsleep);

                                //check if add to basket button is enabled

                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xabb)));
                            } catch (Exception e3) {
                                System.out.println("Sending Error email for e3");
                                //noinspection ThrowablePrintedToSystemOut
                                System.out.println(e3);

                                E3(e3, session, dateFormatted, countryidi, countrys, drvName, drvIDi, country, driver);


                                System.out.println("Error email sent");


                                //driver.quit();
                                // throw (e3);
                            }

                            if (driver.findElement(By.xpath(xabb)).isEnabled()) {

                                // add to basket

                                System.out.println("Product on stock");
                                driver.findElement(By.xpath(xabb)).click();

                                //open mini basket

                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(xmcid)));
                                driver.findElement(By.id(xmcid)).click();

                                //verify add to basket


                                try {
                                    if (driver.findElements(By.xpath(xmcp)).size() != 0) {
                                        System.out.println("Basket Element is Present");
                                    } else {
                                        System.out.println("Basket Element is Absent, try add to basket again");
                                        driver.findElement(By.xpath(xabb)).click();
                                        driver.findElement(By.id(xmcid)).click();
                                    }

                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xmcp)));
                                    miniBasketPName = driver.findElement(By.xpath(xmcp)).getText();

                                } catch (Exception e4) {

                                    System.out.println("Sending Error email for e4");
                                    //noinspection ThrowablePrintedToSystemOut
                                    System.out.println(e4);
                                    E4(e4, session, dateFormatted, countryidi, countrys, drvName, drvIDi, country, driver);


                                    System.out.println("Error email sent");


                                    // driver.quit();
                                    // throw (e4);
                                }


                                //go to basket/checkout

                                try {
                                    driver.findElement(By.xpath(xcb)).click();

                                } catch (Exception e5) {

                                    System.out.println("Sending Error email for e5");
                                    //noinspection ThrowablePrintedToSystemOut
                                    System.out.println(e5);
                                    E5(e5, session, dateFormatted, countryidi, countrys, drvName, drvIDi, country, driver);


                                    System.out.println("Error email sent");


                                    // driver.quit();
                                    // throw (e5);
                                }

                                //Basket page

                                String obUrl = driver.getCurrentUrl();

                                if (obUrl.equals(bURL)) {
                                    System.out.println("Basket Opened");
                                } else {
                                    System.out.println("Basket failed");
                                }
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xbp)));
                                if (miniBasketPName.equals(xbp)) {
                                    System.out.println("Product check complete");
                                } else {
                                    System.out.println("Product check failed");
                                }

                                try {
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xbcb)));
                                    driver.findElement(By.xpath(xbcb)).click();

                                } catch (Exception e6) {

                                    System.out.println("Sending Error email for e6");
                                    //noinspection ThrowablePrintedToSystemOut
                                    System.out.println(e6);
                                    E6(e6, session, dateFormatted, countryidi, countrys, drvName, drvIDi, country, driver);


                                    System.out.println("Error email sent");


                                    // driver.quit();
                                    // throw (e6);
                                }

                                //verify Checkout url

                                String ockUrl = driver.getCurrentUrl();

                                if (ockUrl.equals(ckURL)) {
                                    System.out.println("Checkout Opened");
                                } else {
                                    System.out.println("Checkout failed");
                                }

                                //fill checkout

                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xBillDet)));

                                if (driver instanceof JavascriptExecutor) {
                                    js = (JavascriptExecutor) driver;
                                }

                                js.executeScript("var d=document;function i(a){return d.getElementById(a)}function n(a){return d.getElementsByName(a)[0]}function e(a){t='change';if(window.navigator.userAgent.match(/Trident|MSIEs/g)!=null){x=d.createEvent('Events');x.initEvent(t,1,0);}else{x=new Event(t);}a.dispatchEvent(x);}function v(a,v){a.value=v;e(a)}function c(a){a.checked=true;e(a)}v(i(\"firstName\"),\"geani test first name script\");v(i(\"lastName\"),\"geani test last name\");v(i(\"billing_postalCode\"),\"SS1 7NN\");v(i(\"billing_address_1\"),\"geani test address 1\");v(i(\"billing_address_2\"),\"geani test address 2\");v(i(\"billing_town\"),\"geani test town\");v(i(\"billing_region\"),\"geani test region\");v(i(\"email\"),\"catalin.fleancu@brandpath.com\");v(i(\"confirmEmail\"),\"catalin.fleancu@brandpath.com\");v(i(\"phone\"),\"424242342323\");v(i(\"delivery_postalCode\"),\"SS1 8NN\");v(i(\"delivery_address_1\"),\"geani test address 1 shipping\");v(i(\"delivery_address_2\"),\"geani test address 2 shipping\");v(i(\"delivery_town\"),\"geani test town shipping\");v(i(\"delivery_region\"),\"geani test region shipping\");c(i(\"terms\"));void(0)");

                                //select terms (inserted in JS above)

                                //driver.findElement(By.xpath(xctcb)).click();


                                //select payment

                                try {
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpm)));
                                    driver.findElement(By.xpath(xpm)).click();
                                    paymentName = driver.findElement(By.xpath(xpm)).getText();

                                } catch (Exception e7) {

                                    System.out.println("Sending Error email for e7");
                                    //noinspection ThrowablePrintedToSystemOut
                                    System.out.println(e7);
                                    E7(e7, session, dateFormatted, countryidi, countrys, drvName, drvIDi, country, driver);


                                    System.out.println("Error email sent");


                                    // driver.quit();
                                    // throw (e7);
                                }

                                //Go to payment

                                try {
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xptp)));
                                    driver.findElement(By.xpath(xptp)).click();

                                } catch (Exception e8) {

                                    System.out.println("Sending Error email for e8");
                                    //noinspection ThrowablePrintedToSystemOut
                                    System.out.println(e8);
                                    E8(e8, session, dateFormatted, countryidi, countrys, drvName, drvIDi, country, driver);


                                    System.out.println("Error email sent");


                                    // driver.quit();
                                    // throw (e8);
                                }


                                try {
                                    //verify payment page


                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xCC)));
                                    String opayUrl = driver.getCurrentUrl();

                                    if (opayUrl.equals(payURL)) {
                                        System.out.println("Payment redirect ok");
                                    } else {
                                        System.out.println("payment redirect failed");
                                    }

                                    //fill payment

                                    js.executeScript("var d=document;function i(a){return d.getElementById(a)}function n(a){return d.getElementsByName(a)[0]}function e(a){t='change';if(window.navigator.userAgent.match(/Trident|MSIEs/g)!=null){x=d.createEvent('Events');x.initEvent(t,1,0);}else{x=new Event(t);}a.dispatchEvent(x);}function v(a,v){a.value=v;e(a)}function c(a){a.checked=true;e(a)};v(i(\"card.cardHolderName\"),\"geani test\");v(i(\"card.expiryMonth\"),\"08\");v(i(\"card.expiryYear\"),\"2018\");void(0);");

                                    //Add CC and CVC

                                    driver.findElement(By.xpath(xCC)).sendKeys(CC);
                                    driver.findElement(By.xpath(xCVC)).sendKeys(CVC);

                                    //go to step 2 of payment

                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xps2b))).isEnabled();
                                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xps2b)));
                                    driver.findElement(By.xpath(xps2b)).click();

                                    //verify step 2 payment page

                                    String opay2Url = driver.getCurrentUrl();

                                    if (opay2Url.equals(pay2URL)) {
                                        System.out.println("Payment step 2 ok");
                                    } else {
                                        System.out.println("payment step 2 failed");
                                    }

                                    //finish payment

                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xps2t)));
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xfp))).isEnabled();
                                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xfp)));
                                    driver.findElement(By.xpath(xfp)).click();

                                } catch (Exception e9) {
                                    System.out.println("Sending Error email for e9");
                                    //noinspection ThrowablePrintedToSystemOut
                                    System.out.println(e9);
                                    E9(e9, session, dateFormatted, countryidi, countrys, drvName, drvIDi, country, driver);


                                    System.out.println("Error email sent");


                                    // driver.quit();
                                    // throw (e9);
                                }

                                try {
                                    //verify thank you page


                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xtppi)));

                                    String otpUrl = driver.getCurrentUrl();


                                    if (otpUrl.equals(tpURL)) {
                                        System.out.println("Order complete");
                                    } else {
                                        System.out.println("order failed");
                                    }

                                    String orderReffull = driver.findElement(By.xpath(xor)).getText();

                                    //System.out.println(orderRef);
                                    //Trim order ref text

                                    String[] ord1 = orderReffull.split("Order #");

                                    for (String timord1 : ord1) {
                                        ord2 = timord1;
                                    }
                                    orderRef = ord2.replace(" summary", "");

                                    System.out.println("Order Reference for product loop : " + prodloop + " = " + orderRef);
                                    orderReferences.set(prodloop, orderRef);

                                } catch (Exception e10) {
                                    System.out.println("Sending Error email for e10");
                                    //noinspection ThrowablePrintedToSystemOut
                                    System.out.println(e10);
                                    E10(e10, session, dateFormatted, countryidi, countrys, drvName, drvIDi, country, driver);

                                    System.out.println("Error email sent");


                                    // driver.quit();
                                    // throw (e10);
                                }

                            } else {
                                System.out.println("Out of stock");
                                orderReferences.set(prodloop, "Out of stock");
                            }


                            //increment prodsi +1

                            prodsi++;

                            //delete cookies

                            driver.manage().deleteAllCookies();


                            if (drvIDi != 2) {


                                if (ss == 1) {
                                    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                    FileUtils.copyFile(scrFile, new File(ssPath + "Order Reference SS " + orderRef + ".png"));
                                    System.out.println("Screenshot done at : " + ssPath);
                                } else {
                                    System.out.println("No Screenshot");
                                }
                            } else {
                                System.out.println("Headless Browser. No SS");
                            }

                            if (prodloop < 9) {
                                System.out.println("Initiating next product");
                            } else {
                                System.out.println("End of product loops");
                            }


                            ///////////////////////////End of the prodloop
                        }


                        //Print product names

                        System.out.println("All order numbers = " + orderReferences);
                        System.out.println("All products = " + productNames);
                        System.out.println("Test product loops done");


                        // Send Email

                        if (skipEmail != 1) {

                            System.out.println("Sending email");

                            FinalMail(session, dateFormatted, productNames, countryidi, countrys, drvName, drvIDi, country, paymenti, paymentloop, paymentName, orderReferences, CC, CVC);


                            System.out.println("Email sent");

                        } else {
                            System.out.println("No Email");
                        }
                        // increment payment loops

                        paymenti++;

                        if (paymentloop < 4) {
                            System.out.println("Initiating next payment loop");
                        } else {
                            System.out.println("End of payment loops");
                        }

                        //////////////////////////End of the payment loop
                    }

                    //increase country id

                    countryidi++;

                    if (countryloop < 2) {
                        System.out.println("Initiating next country loop");
                    } else {
                        System.out.println("End of country loops");
                    }
                    //////////////////////////End of the country loop

                }
                drvIDi++;

                if (drvloop < 2) {
                    System.out.println("Initiating next driver loop");
                } else {
                    System.out.println("End of driver loops");
                }

                driver.quit();

                //////////////////////////End of the driver loop
            }
        }
        if (testloop < 10) {
            System.out.println("Initiating next test loop");
        } else {
            System.out.println("End of test loops");
            //////////////////////////End of the test loop
        }
        //close EVERYTHING
        System.out.println("Ending Test");
        driver.quit();
    }

}