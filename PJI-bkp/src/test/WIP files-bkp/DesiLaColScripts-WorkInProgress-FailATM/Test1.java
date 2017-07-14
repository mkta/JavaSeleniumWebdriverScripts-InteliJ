package DesiLaColScripts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;

/**
 * Created by catalinf on 30-Mar-17.
 */
public class Test1 {
    public void Test1() throws Exception {

        initConfigs.initConfigs();
        initXpaths.initXpaths();
        initVariables.initVariablesM();
        initVariables.testloop;

        /////////////////////// Start of the Test loop

        for (initVariables.testloop = testloops; testloop < 11; testloop++) {

            System.out.println("Test Loop number : " + testloop);


            int drvIDi = drvID;

            ///Stat of Driver loop

            for (drvloop = drvloops; drvloop < 3; drvloop++) {

                System.out.println("Driver loop number : " + drvloop);

                if (drvIDi == 0) {
                    System.out.println("Starting Chrome Driver");

                    driver = new ChromeDriver();
                }

                if (drvIDi == 1) {
                    System.out.println("Starting Firefox Driver ");

                    driver = new FirefoxDriver();
                }

                driver.manage().window().maximize();

                int countryidi = countryid;

                /////////////////////// Start of the country loop

                for (countryloop = countryloops; countryloop < 3; countryloop++) {

                    //set country and country based URLs

                    String country = countrys.get(countryidi);
                    String plpURL = site + country + "/women";
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
                        String xpm = "html/body/section[3]/router-view/section[2]/div/div/div[2]/div[2]/div[3]/div/div[" + paymenti + "]/label";

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

                            //Set Product Xpath

                            String pxp = "html/body/section[3]/router-view/section[4]/div[2]/div/div/div/div/div[" + prodsi + "]/div/div[2]/h3/a";

                            //open url

                            driver.get(site + country);

                            //store url

                            String oUrl = driver.getCurrentUrl();

                            //store title

                            String title = driver.getTitle();

                            //verify url

                            if (oUrl.equals(site + country)) {
                                System.out.println("Site Initiated");
                            } else {
                                System.out.println("Sie failed");
                            }

                            //Echo site name

                            System.out.println("Site name is : " + title);

                            //wait for navigation

                            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                            try {
                                wait = new WebDriverWait(driver, twt);
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xnavmenu)));

                            } catch (TimeoutException e1) {

                                System.out.println("Sending Error email for e1");

                                Message message1 = new MimeMessage(session);
                                message1.setFrom(new InternetAddress(username));
                                message1.setRecipients(Message.RecipientType.TO,
                                        InternetAddress.parse(gto + "," + gcc));
                                message1.setSubject(dateFormated + " - IntelliJ Script Results" + " Script FAILED");
                                MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At nav menu " + "Xpath failed : " + "\r\n" + xnavmenu);
                                MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                                DataSource source = new FileDataSource(filename);
                                messageBodyPart2.setDataHandler(new DataHandler(source));
                                messageBodyPart2.setFileName(filename);
                                MimeBodyPart messageBodyPart3 = new MimeBodyPart();
                                DataSource source2 = new FileDataSource(filename2);
                                messageBodyPart3.setDataHandler(new DataHandler(source2));
                                messageBodyPart3.setFileName(filename2);
                                Multipart multipart = new MimeMultipart();
                                multipart.addBodyPart(messageBodyPart1);
                                multipart.addBodyPart(messageBodyPart2);
                                multipart.addBodyPart(messageBodyPart3);
                                message1.setContent(multipart);

                                Transport.send(message1);

                                System.out.println("Error email sent");

                                //driver.quit();
                                //throw (e1);
                            }

                            //open listing

                            driver.findElement(By.xpath(xnavmenu)).click();

                            //verify PLP url

                            String oplpUrl = driver.getCurrentUrl();

                            if (oplpUrl.equals(plpURL)) {
                                System.out.println("PLP Opened");
                            } else {
                                System.out.println("PLP failed");
                            }

                            //wait for PLP product


                            try {
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pxp)));

                            } catch (TimeoutException e2) {

                                System.out.println("Sending Error email of e2");

                                Message message2 = new MimeMessage(session);
                                message2.setFrom(new InternetAddress(username));
                                message2.setRecipients(Message.RecipientType.TO,
                                        InternetAddress.parse(gto + "," + gcc));
                                message2.setSubject(dateFormated + " - IntelliJ Script Results" + " Script FAILED");
                                MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At Product Listing " + "Xpath failed : " + "\r\n" + pxp);
                                MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                                DataSource source = new FileDataSource(filename);
                                messageBodyPart2.setDataHandler(new DataHandler(source));
                                messageBodyPart2.setFileName(filename);
                                MimeBodyPart messageBodyPart3 = new MimeBodyPart();
                                DataSource source2 = new FileDataSource(filename2);
                                messageBodyPart3.setDataHandler(new DataHandler(source2));
                                messageBodyPart3.setFileName(filename2);
                                Multipart multipart = new MimeMultipart();
                                multipart.addBodyPart(messageBodyPart1);
                                multipart.addBodyPart(messageBodyPart2);
                                multipart.addBodyPart(messageBodyPart3);
                                message2.setContent(multipart);

                                Transport.send(message2);

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

                            //verify PDP url - disabled because url is lower caps prod name is upper caps and will always fail

                        /*
                        String opdpUrl = driver.getCurrentUrl();
                        String pdpURL = site + country + "/pdp/" + pname;

                        if (opdpUrl.equals(pdpURL)) {
                            System.out.println("PDP Opened");
                        } else {
                            System.out.println("PDP failed");
                        }
                        */

                            //wait for pdp stuff

                            try {
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xe1)));

                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xe2)));
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xe3)));

                                Thread.sleep(pdpsleep);

                                //check if add to basket button is enabled

                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xabb)));
                            } catch (TimeoutException e3) {
                                System.out.println("Sending Error email for e3");

                                Message message3 = new MimeMessage(session);
                                message3.setFrom(new InternetAddress(username));
                                message3.setRecipients(Message.RecipientType.TO,
                                        InternetAddress.parse(gto + "," + gcc));
                                message3.setSubject(dateFormated + " - IntelliJ Script Results" + " Script FAILED");
                                MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At Add to basket button " + "Xpath failed : " + "\r\n" + xabb);
                                MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                                DataSource source = new FileDataSource(filename);
                                messageBodyPart2.setDataHandler(new DataHandler(source));
                                messageBodyPart2.setFileName(filename);
                                MimeBodyPart messageBodyPart3 = new MimeBodyPart();
                                DataSource source2 = new FileDataSource(filename2);
                                messageBodyPart3.setDataHandler(new DataHandler(source2));
                                messageBodyPart3.setFileName(filename2);
                                Multipart multipart = new MimeMultipart();
                                multipart.addBodyPart(messageBodyPart1);
                                multipart.addBodyPart(messageBodyPart2);
                                multipart.addBodyPart(messageBodyPart3);
                                message3.setContent(multipart);

                                Transport.send(message3);

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

                                } catch (TimeoutException e4) {

                                    System.out.println("Sending Error email for e4");

                                    Message message4 = new MimeMessage(session);
                                    message4.setFrom(new InternetAddress(username));
                                    message4.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message4.setSubject(dateFormated + " - IntelliJ Script Results" + " Script FAILED");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At mini basket " + "Xpath failed : " + "\r\n" + xmcp);
                                    MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                                    DataSource source = new FileDataSource(filename);
                                    messageBodyPart2.setDataHandler(new DataHandler(source));
                                    messageBodyPart2.setFileName(filename);
                                    MimeBodyPart messageBodyPart3 = new MimeBodyPart();
                                    DataSource source2 = new FileDataSource(filename2);
                                    messageBodyPart3.setDataHandler(new DataHandler(source2));
                                    messageBodyPart3.setFileName(filename2);
                                    Multipart multipart = new MimeMultipart();
                                    multipart.addBodyPart(messageBodyPart1);
                                    multipart.addBodyPart(messageBodyPart2);
                                    multipart.addBodyPart(messageBodyPart3);
                                    message4.setContent(multipart);

                                    Transport.send(message4);

                                    System.out.println("Error email sent");

                                    // driver.quit();
                                    // throw (e4);
                                }


                                //go to basket/checkout

                                try {
                                    driver.findElement(By.xpath(xcb)).click();

                                } catch (TimeoutException e5) {

                                    System.out.println("Sending Error email for e5");

                                    Message message5 = new MimeMessage(session);
                                    message5.setFrom(new InternetAddress(username));
                                    message5.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message5.setSubject(dateFormated + " - IntelliJ Script Results" + " Script FAILED");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At Checkout button from mini basket " + "Xpath failed : " + "\r\n" + xcb);
                                    MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                                    DataSource source = new FileDataSource(filename);
                                    messageBodyPart2.setDataHandler(new DataHandler(source));
                                    messageBodyPart2.setFileName(filename);
                                    MimeBodyPart messageBodyPart3 = new MimeBodyPart();
                                    DataSource source2 = new FileDataSource(filename2);
                                    messageBodyPart3.setDataHandler(new DataHandler(source2));
                                    messageBodyPart3.setFileName(filename2);
                                    Multipart multipart = new MimeMultipart();
                                    multipart.addBodyPart(messageBodyPart1);
                                    multipart.addBodyPart(messageBodyPart2);
                                    multipart.addBodyPart(messageBodyPart3);
                                    message5.setContent(multipart);

                                    Transport.send(message5);

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

                                } catch (TimeoutException e6) {

                                    System.out.println("Sending Error email for e6");

                                    Message message6 = new MimeMessage(session);
                                    message6.setFrom(new InternetAddress(username));
                                    message6.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message6.setSubject(dateFormated + " - IntelliJ Script Results" + " Script FAILED");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At  basket page " + "Xpath failed : " + "\r\n" + xbcb);
                                    MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                                    DataSource source = new FileDataSource(filename);
                                    messageBodyPart2.setDataHandler(new DataHandler(source));
                                    messageBodyPart2.setFileName(filename);
                                    MimeBodyPart messageBodyPart3 = new MimeBodyPart();
                                    DataSource source2 = new FileDataSource(filename2);
                                    messageBodyPart3.setDataHandler(new DataHandler(source2));
                                    messageBodyPart3.setFileName(filename2);
                                    Multipart multipart = new MimeMultipart();
                                    multipart.addBodyPart(messageBodyPart1);
                                    multipart.addBodyPart(messageBodyPart2);
                                    multipart.addBodyPart(messageBodyPart3);
                                    message6.setContent(multipart);

                                    Transport.send(message6);

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

                                } catch (TimeoutException e7) {

                                    System.out.println("Sending Error email for e7");

                                    Message message7 = new MimeMessage(session);
                                    message7.setFrom(new InternetAddress(username));
                                    message7.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message7.setSubject(dateFormated + " - IntelliJ Script Results" + " Script FAILED");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At payment method " + "Xpath failed : " + "\r\n" + xpm);
                                    MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                                    DataSource source = new FileDataSource(filename);
                                    messageBodyPart2.setDataHandler(new DataHandler(source));
                                    messageBodyPart2.setFileName(filename);
                                    MimeBodyPart messageBodyPart3 = new MimeBodyPart();
                                    DataSource source2 = new FileDataSource(filename2);
                                    messageBodyPart3.setDataHandler(new DataHandler(source2));
                                    messageBodyPart3.setFileName(filename2);
                                    Multipart multipart = new MimeMultipart();
                                    multipart.addBodyPart(messageBodyPart1);
                                    multipart.addBodyPart(messageBodyPart2);
                                    multipart.addBodyPart(messageBodyPart3);
                                    message7.setContent(multipart);

                                    Transport.send(message7);

                                    System.out.println("Error email sent");

                                    // driver.quit();
                                    // throw (e7);
                                }

                                //Go to payment

                                try {
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xptp)));
                                    driver.findElement(By.xpath(xptp)).click();

                                } catch (TimeoutException e8) {

                                    System.out.println("Sending Error email for e8");

                                    Message message8 = new MimeMessage(session);
                                    message8.setFrom(new InternetAddress(username));
                                    message8.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message8.setSubject(dateFormated + " - IntelliJ Script Results" + " Script FAILED");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At proceed to payment button " + "Xpath failed : " + "\r\n" + xptp);
                                    MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                                    DataSource source = new FileDataSource(filename);
                                    messageBodyPart2.setDataHandler(new DataHandler(source));
                                    messageBodyPart2.setFileName(filename);
                                    MimeBodyPart messageBodyPart3 = new MimeBodyPart();
                                    DataSource source2 = new FileDataSource(filename2);
                                    messageBodyPart3.setDataHandler(new DataHandler(source2));
                                    messageBodyPart3.setFileName(filename2);
                                    Multipart multipart = new MimeMultipart();
                                    multipart.addBodyPart(messageBodyPart1);
                                    multipart.addBodyPart(messageBodyPart2);
                                    multipart.addBodyPart(messageBodyPart3);
                                    message8.setContent(multipart);

                                    Transport.send(message8);

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

                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xps2b)));
                                    driver.findElement(By.xpath(xps2b)).click();

                                    //verify step 2 payment page

                                    String opay2Url = driver.getCurrentUrl();

                                    if (opay2Url.equals(pay2URL)) {
                                        System.out.println("Payment step 2 ok");
                                    } else {
                                        System.out.println("payment step 2 failed");
                                    }

                                    //finish payment

                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xfp)));
                                    driver.findElement(By.xpath(xfp)).click();

                                } catch (TimeoutException e9) {
                                    System.out.println("Sending Error email for e9");

                                    Message message9 = new MimeMessage(session);
                                    message9.setFrom(new InternetAddress(username));
                                    message9.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message9.setSubject(dateFormated + " - IntelliJ Script Results" + " Script FAILED");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At payment process" + "Xpath failed : " + "\r\n" + "check attached logs");
                                    MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                                    DataSource source = new FileDataSource(filename);
                                    messageBodyPart2.setDataHandler(new DataHandler(source));
                                    messageBodyPart2.setFileName(filename);
                                    MimeBodyPart messageBodyPart3 = new MimeBodyPart();
                                    DataSource source2 = new FileDataSource(filename2);
                                    messageBodyPart3.setDataHandler(new DataHandler(source2));
                                    messageBodyPart3.setFileName(filename2);
                                    Multipart multipart = new MimeMultipart();
                                    multipart.addBodyPart(messageBodyPart1);
                                    multipart.addBodyPart(messageBodyPart2);
                                    multipart.addBodyPart(messageBodyPart3);
                                    message9.setContent(multipart);

                                    Transport.send(message9);

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

                                } catch (TimeoutException e10) {
                                    System.out.println("Sending Error email for e10");

                                    Message message10 = new MimeMessage(session);
                                    message10.setFrom(new InternetAddress(username));
                                    message10.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message10.setSubject(dateFormated + " - IntelliJ Script Results" + " Script FAILED");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At thank you page " + "Xpath failed : " + "\r\n" + xor);
                                    MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                                    DataSource source = new FileDataSource(filename);
                                    messageBodyPart2.setDataHandler(new DataHandler(source));
                                    messageBodyPart2.setFileName(filename);
                                    MimeBodyPart messageBodyPart3 = new MimeBodyPart();
                                    DataSource source2 = new FileDataSource(filename2);
                                    messageBodyPart3.setDataHandler(new DataHandler(source2));
                                    messageBodyPart3.setFileName(filename2);
                                    Multipart multipart = new MimeMultipart();
                                    multipart.addBodyPart(messageBodyPart1);
                                    multipart.addBodyPart(messageBodyPart2);
                                    multipart.addBodyPart(messageBodyPart3);
                                    message10.setContent(multipart);

                                    Transport.send(message10);

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


                            if (ss == 1) {
                                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                FileUtils.copyFile(scrFile, new File(ssPath + "Order Refference SS " + orderRef + ".png"));
                                System.out.println("Screenshot done at : " + ssPath);
                            } else {
                                System.out.println("No Screenshot");
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

                            Message message0 = new MimeMessage(session);
                            message0.setFrom(new InternetAddress(username));
                            message0.setRecipients(Message.RecipientType.TO,
                                    InternetAddress.parse(gto + "," + gcc));
                            if (paymentloop < 4) {
                                message0.setSubject(dateFormated + " - IntelliJ Script Results" + " Initiating next payment loop");
                            } else {
                                message0.setSubject(dateFormated + " - IntelliJ Script Results" + " End of payment loops");
                            }
                            MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                            messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "Payment Type(number): " + paymentName + "(" + paymenti + ")" + "\r\n" + "\r\n" + "CC / CVC used: " + CC + " / " + CVC + "\r\n" + "\r\n" + "Product name 1: " + productNames.get(1) + "\r\n" + "Product name 2: " + productNames.get(2) + "\r\n" + "Product name 3: " + productNames.get(3) + "\r\n" + "Product name 4: " + productNames.get(4) + "\r\n" + "Product name 5: " + productNames.get(5) + "\r\n" + "Product name 6: " + productNames.get(6) + "\r\n" + "Product name 7: " + productNames.get(7) + "\r\n" + "Product name 8: " + productNames.get(8) + "\r\n" + "Product name 9: " + productNames.get(9) + "\r\n" + "\r\n" + "Order Refference 1: " + orderReferences.get(1) + "\r\n" + "Order Refference 2: " + orderReferences.get(2) + "\r\n" + "Order Refference 3: " + orderReferences.get(3) + "\r\n" + "Order Refference 4: " + orderReferences.get(4) + "\r\n" + "Order Refference 5: " + orderReferences.get(5) + "\r\n" + "Order Refference 6: " + orderReferences.get(6) + "\r\n" + "Order Refference 7: " + orderReferences.get(7) + "\r\n" + "Order Refference 8: " + orderReferences.get(8) + "\r\n" + "Order Refference 9: " + orderReferences.get(9));
                            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
                            DataSource source = new FileDataSource(filename);
                            messageBodyPart2.setDataHandler(new DataHandler(source));
                            messageBodyPart2.setFileName(filename);
                            MimeBodyPart messageBodyPart3 = new MimeBodyPart();
                            DataSource source2 = new FileDataSource(filename2);
                            messageBodyPart3.setDataHandler(new DataHandler(source2));
                            messageBodyPart3.setFileName(filename2);
                            Multipart multipart = new MimeMultipart();
                            multipart.addBodyPart(messageBodyPart1);
                            multipart.addBodyPart(messageBodyPart2);
                            multipart.addBodyPart(messageBodyPart3);
                            message0.setContent(multipart);

                            Transport.send(message0);

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
        driver.quit();
    }
}
