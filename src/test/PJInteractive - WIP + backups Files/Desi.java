import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;


/**
 * Created by catalinf on 29-Mar-17. Vesion 3.0
 */

public class Desi {


    @Test
    public void startTest() throws Exception {
        /////////////////////////// Start of configurations //////////////////////////////////////////////////////

        System.out.println("Start of configurations");

        //Set Gmail user and pass
        final String username = "catalin.fleancu@pj-interactive.ro";
        final String password = "Dorel1234";
        //Set site
        String site = "https://tst.bpc-aws.com/"; // ( https://tst.desilacol.com/ ) or ( https://tst.bpc-aws.com/ )
        //Set country
        int countryid = 1; // 1 = us ; 2 = jp;
        //Set country loops
        int countryloops = 2; // 2 = 1 loop ; 1 = 2 loops
        //Select product
        int prods = 1; // plp product number - selects the product order from listing
        //select number of loops
        int prodloops = 9; // 9 = 1 loop; 1 = 9 loops
        //Set initial Payment
        int payment = 1; // payment number ( 1 - Visa ; 2 - MC ; 3 - AmericaExpress ; 4 - Discover ; 4 - JCB )
        //Set payment loops
        int paymentloops = 4; // 4 = 1 payment; 1 = 4 payments
        //set test loops (entire test)
        int testloops = 10; // 1 = 10 loops ; 10 = 1 loop
        //ser driver
        int drvID = 0; // 0 - Chrome ; 1 - Firefox ; ///2 - Edge ; 3 - IE/// not used at this moment
        //Set driver loops
        int drvloops = 2; // 2 = 1 loop ; 1 = 2 loops
        String gto = "catalin.fleancu@brandpath.com";
        String gcc = "stefan.chiosea@brandpath.com, ionut.delcea@brandpath.com";
        // Set date format
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        // Get current date and time
        Date date2 = new Date();
        // Format the date
        String dateFormatted2 = dateFormat2.format(date2);
        //Set Log output file
        PrintStream out = new PrintStream(new FileOutputStream("/C:/Users/catalinf/Google Drive/IntelliJ Scripts/DesiLaColScripts/Logs/Console Logs " + dateFormatted2 + ".txt"));
        System.setOut(out);
        //Set Filepath for Email logs attachment
        String filename = "/C:/Users/catalinf/Google Drive/IntelliJ Scripts/DesiLaColScripts/Logs/Console Logs " + dateFormatted2 + ".txt";
        //Set Filepath 2 for Email logs attachment
        String filename2 = "/C:/Users/catalinf/Google Drive/IntelliJ Scripts/DesiLaColScripts/Logs/Desi-logs.txt";
        //Chrome driver path
        String chromeDrvPath = "/C:/Users/catalinf/Google Drive/IntelliJ Scripts/chromedriver.exe";
        //Firefox driver path
        String fireFoxDrvPath = "/C:/Users/catalinf/Google Drive/IntelliJ Scripts/geckodriver.exe";
        //Edge driver path
        String edgeDrvPath = "/C:/Users/catalinf/Google Drive/IntelliJ Scripts/MicrosoftWebDriver.exe";
        //Edge driver path
        String ieDrvPath = "/C:/Users/catalinf/Google Drive/IntelliJ Scripts/IEDriverServer.exe";
        //Skip email? 0 = no 1 = yes
        int skipEmail = 0;
        //Screenshot? 0 = no 1 = yes
        int ss = 0;
        //Screenshot path
        String ssPath = "/C:/Users/catalinf/Google Drive/IntelliJ Scripts/Screenshots/";
        //Set pdp sleep time milliseconds
        int pdpsleep = 2000;
        //Set timeout wait time seconds
        int twt = 10;

        System.out.println("End of configurations");
/////////////////////////// End of configurations //////////////////////////////////////////////////////

/////////////////////////// Start of Xpath Configuration ///////////////////////////////////////////////
        System.out.println("Start of xpath settings");
/////////////////////////// Note: country, payment and product selector xpath are set at the beginning of their loops ///////////////////////////

        //Set xpath for Navigation menu
        String xnavmenu = "html/body/section[2]/header/nav/div[2]/ul/li[1]/a/span";
        //Set PDP wait elements
        String xe1 = "html/body/section[3]/router-view/div/div[1]/div[2]/div[1]/span";
        String xe2 = "html/body/section[3]/router-view/div/div[1]/div[2]/h1/a";
        String xe3 = "html/body/section[3]/router-view/div/div[1]/div[2]/div[3]/input";
        //Set xpath add to basket button
        String xabb = "html/body/section[3]/router-view/div/div[1]/div[2]/div[5]/button[1]";
        //Set id for minicart
        String xmcid = "mini-cart";
        //Set xpath for mini basket element
        String xmcp = "html/body/section[2]/header/nav/form/div/div/div/div[1]/table/tbody/tr/td[2]/div/div[1]/span";
        //Set checkout/basket button
        String xcb = "html/body/section[2]/header/nav/form/div/div/div/div[2]/div[3]/a[1]";
        //Set basket product name
        String xbp = "html/body/section[3]/router-view/section[3]/div/div/div[1]/div/table/tbody/tr/td[2]/div/div[1]/span";
        //Set basket continue button
        String xbcb = "html/body/section[3]/router-view/section[3]/div/div/div[2]/div/div[4]/a";
        //Set checkout terms checkbox xpath
        //String xctcb = "html/body/section[3]/router-view/section[2]/div/div/div[2]/div[4]/div[2]/div/label/input";
        //Set proceed to payment button xpath
        String xptp = "html/body/section[3]/router-view/section[2]/div/div/div[2]/div[2]/div[4]/a";
        //Set CC xpath
        String xCC = "html/body/div/form/div[1]/div[2]/table/tbody/tr[2]/td[2]/div/input";
        //Set CVC xpath
        String xCVC = "html/body/div/form/div[1]/div[2]/table/tbody/tr[5]/td[2]/div/input";
        //Set proceed to payment step 2 button
        String xps2b = "html/body/div/form/div[2]/div/div[2]/input";
        //Set xpath of title on payment step 2
        String xps2t = "html/body/div/form/div[1]/div[2]/h2";
        //Set finish payment button
        String xfp = "html/body/div/form/div[2]/div/div[2]/input";
        //Set thank you page product image xpath
        String xtppi = "html/body/section[3]/router-view/section/div/div[2]/div/table/tbody/tr/td[1]/div/div/img";
        //Set order ref xpath
        String xor = "html/body/section[3]/router-view/section/div/div[1]/h1[2]";
        //Set xpath for billing detail title
        String xBillDet = "html/body/section[3]/router-view/section[2]/div/div/div[1]/h2";

        System.out.println("End of xpath settings");

/////////////////////////// End of Xpath Configuration /////////////////////////////////////////////////

        /////////////////////////// Set Drivers
        System.out.println("Set drivers property");
        System.setProperty("webdriver.chrome.driver", chromeDrvPath);
        System.setProperty("webdriver.gecko.driver", fireFoxDrvPath);
        System.setProperty("webdriver.edge.driver", edgeDrvPath);
        System.setProperty("webdriver.ie.driver", ieDrvPath);
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
        List<String> drvName = new ArrayList<String>(6);
        drvName.add(0, "Chrome Driver");
        drvName.add(1, "Firefox Driver");
        drvName.add(2, "Edge Driver");
        drvName.add(3, "IE Driver");

        System.out.println("Initiate contry array");
        List<String> countrys = new ArrayList<String>(6);
        countrys.add(0, "");
        countrys.add(1, "us"); // US
        countrys.add(2, "jp"); // JP

        System.out.println("Initiate payment URLS");
        String payURL = "https://test.adyen.com/hpp/details.shtml";
        String pay2URL = "https://test.adyen.com/hpp/completeCard.shtml";

        System.out.println("Initiate Credit cards array");
        List<String> creditcards = new ArrayList<String>(6);
        creditcards.add(0, "");
        creditcards.add(1, "4111 1111 1111 1111"); // visa
        creditcards.add(2, "5555 5555 5555 4444"); // MAster Card
        creditcards.add(3, "3700 0000 0000 002"); // American Express
        creditcards.add(4, "6011 6011 6011 6611"); // Discover (US)
        creditcards.add(5, "3569 9900 1009 5841"); // JCB (JP)

        System.out.println("Initiate some variables");
        WebDriverWait wait = null;
        JavascriptExecutor js;
        String paymentName = null;
        String orderRef = null;
        String ord2 = null;
        String miniBasketPName = null;
        js = null;

        System.out.println("Initiate order Reference array");
        List<String> orderReferences = new ArrayList<String>();
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
        List<String> productNames = new ArrayList<String>();
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

                            } catch (Exception e1) {

                                //noinspection ThrowablePrintedToSystemOut
                                System.out.println(e1);
                                System.out.println("Sending Error email for e1");

                                Message message1 = new MimeMessage(session);
                                message1.setFrom(new InternetAddress(username));
                                message1.setRecipients(Message.RecipientType.TO,
                                        InternetAddress.parse(gto + "," + gcc));
                                message1.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
                                MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At nav menu " + "script failed : " + "\r\n" + "Error (e1):" + "\r\n" + e1);
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

                                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " e1 " + ".png"));
                                System.out.println("Error Screenshot done at : " + ssPath);
                                MimeBodyPart messageBodyPart4 = new MimeBodyPart();
                                DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " e1 " + ".png");
                                messageBodyPart4.setDataHandler(new DataHandler(source3));
                                messageBodyPart4.setFileName(ssPath + dateFormatted2 + " e1 " + ".png");
                                multipart.addBodyPart(messageBodyPart4);

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

                            } catch (Exception e2) {

                                System.out.println("Sending Error email of e2");
                                //noinspection ThrowablePrintedToSystemOut
                                System.out.println(e2);
                                Message message2 = new MimeMessage(session);
                                message2.setFrom(new InternetAddress(username));
                                message2.setRecipients(Message.RecipientType.TO,
                                        InternetAddress.parse(gto + "," + gcc));
                                message2.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
                                MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At Product Listing " + "script failed : " + "\r\n" + xnavmenu + "\r\n" + "Error (e2):" + "\r\n" + e2);
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

                                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " e2 " + ".png"));
                                System.out.println("Error Screenshot done at : " + ssPath);
                                MimeBodyPart messageBodyPart4 = new MimeBodyPart();
                                DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " e2 " + ".png");
                                messageBodyPart4.setDataHandler(new DataHandler(source3));
                                messageBodyPart4.setFileName(ssPath + dateFormatted2 + " e2 " + ".png");
                                multipart.addBodyPart(messageBodyPart4);


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
                            } catch (Exception e3) {
                                System.out.println("Sending Error email for e3");
                                //noinspection ThrowablePrintedToSystemOut
                                System.out.println(e3);
                                Message message3 = new MimeMessage(session);
                                message3.setFrom(new InternetAddress(username));
                                message3.setRecipients(Message.RecipientType.TO,
                                        InternetAddress.parse(gto + "," + gcc));
                                message3.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
                                MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At Add to basket button " + "script failed : " + "\r\n" + "Error (e3):" + "\r\n" + e3);
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


                                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " e3 " + ".png"));
                                System.out.println("Error Screenshot done at : " + ssPath);
                                MimeBodyPart messageBodyPart4 = new MimeBodyPart();
                                DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " e3 " + ".png");
                                messageBodyPart4.setDataHandler(new DataHandler(source3));
                                messageBodyPart4.setFileName(ssPath + dateFormatted2 + " e3 " + ".png");
                                multipart.addBodyPart(messageBodyPart4);


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

                                } catch (Exception e4) {

                                    System.out.println("Sending Error email for e4");
                                    //noinspection ThrowablePrintedToSystemOut
                                    System.out.println(e4);
                                    Message message4 = new MimeMessage(session);
                                    message4.setFrom(new InternetAddress(username));
                                    message4.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message4.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At mini basket " + "script failed : " + "\r\n" + xnavmenu + "\r\n" + "Error (e4):" + "\r\n" + e4);
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


                                    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                    FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " e4 " + ".png"));
                                    System.out.println("Error Screenshot done at : " + ssPath);
                                    MimeBodyPart messageBodyPart4 = new MimeBodyPart();
                                    DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " e4 " + ".png");
                                    messageBodyPart4.setDataHandler(new DataHandler(source3));
                                    messageBodyPart4.setFileName(ssPath + dateFormatted2 + " e4 " + ".png");
                                    multipart.addBodyPart(messageBodyPart4);


                                    message4.setContent(multipart);

                                    Transport.send(message4);

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
                                    Message message5 = new MimeMessage(session);
                                    message5.setFrom(new InternetAddress(username));
                                    message5.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message5.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At Checkout button from mini basket " + "script failed : " + "Error (e5):" + "\r\n" + e5);
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


                                    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                    FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " e5 " + ".png"));
                                    System.out.println("Error Screenshot done at : " + ssPath);
                                    MimeBodyPart messageBodyPart4 = new MimeBodyPart();
                                    DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " e5 " + ".png");
                                    messageBodyPart4.setDataHandler(new DataHandler(source3));
                                    messageBodyPart4.setFileName(ssPath + dateFormatted2 + " e5 " + ".png");
                                    multipart.addBodyPart(messageBodyPart4);


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

                                } catch (Exception e6) {

                                    System.out.println("Sending Error email for e6");
                                    //noinspection ThrowablePrintedToSystemOut
                                    System.out.println(e6);
                                    Message message6 = new MimeMessage(session);
                                    message6.setFrom(new InternetAddress(username));
                                    message6.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message6.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At  basket page " + "script failed : " + "\r\n" + xnavmenu + "\r\n" + "Error(e6):" + "\r\n" + e6);
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

                                    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                    FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " e6 " + ".png"));
                                    System.out.println("Error Screenshot done at : " + ssPath);
                                    MimeBodyPart messageBodyPart4 = new MimeBodyPart();
                                    DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " e6 " + ".png");
                                    messageBodyPart4.setDataHandler(new DataHandler(source3));
                                    messageBodyPart4.setFileName(ssPath + dateFormatted2 + " e6 " + ".png");
                                    multipart.addBodyPart(messageBodyPart4);


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

                                } catch (Exception e7) {

                                    System.out.println("Sending Error email for e7");
                                    //noinspection ThrowablePrintedToSystemOut
                                    System.out.println(e7);
                                    Message message7 = new MimeMessage(session);
                                    message7.setFrom(new InternetAddress(username));
                                    message7.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message7.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At payment method " + "script failed : " + "\r\n" + xnavmenu + "\r\n" + "Error (e7):" + "\r\n" + e7);
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


                                    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                    FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " e7 " + ".png"));
                                    System.out.println("Error Screenshot done at : " + ssPath);
                                    MimeBodyPart messageBodyPart4 = new MimeBodyPart();
                                    DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " e7 " + ".png");
                                    messageBodyPart4.setDataHandler(new DataHandler(source3));
                                    messageBodyPart4.setFileName(ssPath + dateFormatted2 + " e7 " + ".png");
                                    multipart.addBodyPart(messageBodyPart4);


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

                                } catch (Exception e8) {

                                    System.out.println("Sending Error email for e8");
                                    //noinspection ThrowablePrintedToSystemOut
                                    System.out.println(e8);
                                    Message message8 = new MimeMessage(session);
                                    message8.setFrom(new InternetAddress(username));
                                    message8.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message8.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At proceed to payment button " + "script failed : " + "Error(e8):" + "\r\n" + e8);
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

                                    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                    FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " e8 " + ".png"));
                                    System.out.println("Error Screenshot done at : " + ssPath);
                                    MimeBodyPart messageBodyPart4 = new MimeBodyPart();
                                    DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " e8 " + ".png");
                                    messageBodyPart4.setDataHandler(new DataHandler(source3));
                                    messageBodyPart4.setFileName(ssPath + dateFormatted2 + " e8 " + ".png");
                                    multipart.addBodyPart(messageBodyPart4);


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
                                    Message message9 = new MimeMessage(session);
                                    message9.setFrom(new InternetAddress(username));
                                    message9.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message9.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At payment process" + "script failed : " + "\r\n" + "Error(e9):" + "\r\n" + e9);
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

                                    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                    FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " e9 " + ".png"));
                                    System.out.println("Error Screenshot done at : " + ssPath);
                                    MimeBodyPart messageBodyPart4 = new MimeBodyPart();
                                    DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " e9 " + ".png");
                                    messageBodyPart4.setDataHandler(new DataHandler(source3));
                                    messageBodyPart4.setFileName(ssPath + dateFormatted2 + " e9 " + ".png");
                                    multipart.addBodyPart(messageBodyPart4);


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

                                } catch (Exception e10) {
                                    System.out.println("Sending Error email for e10");
                                    //noinspection ThrowablePrintedToSystemOut
                                    System.out.println(e10);
                                    Message message10 = new MimeMessage(session);
                                    message10.setFrom(new InternetAddress(username));
                                    message10.setRecipients(Message.RecipientType.TO,
                                            InternetAddress.parse(gto + "," + gcc));
                                    message10.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + "- Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
                                    MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                                    messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At thank you page " + "script failed : " + "Error(e10):" + "\r\n" + e10);
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

                                    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                    FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " e10 " + ".png"));
                                    System.out.println("Error Screenshot done at : " + ssPath);
                                    MimeBodyPart messageBodyPart4 = new MimeBodyPart();
                                    DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " e10 " + ".png");
                                    messageBodyPart4.setDataHandler(new DataHandler(source3));
                                    messageBodyPart4.setFileName(ssPath + dateFormatted2 + " e10 " + ".png");
                                    multipart.addBodyPart(messageBodyPart4);


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
                                FileUtils.copyFile(scrFile, new File(ssPath + "Order Reference SS " + orderRef + ".png"));
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
                                message0.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Initiating next payment loop" + "(IntelliJ/JAVA");
                            } else {
                                message0.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " End of payment loops" + "(IntelliJ/JAVA");
                            }
                            MimeBodyPart messageBodyPart1 = new MimeBodyPart();
                            messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "Payment Type(number): " + paymentName + "(" + paymenti + ")" + "\r\n" + "\r\n" + "CC / CVC used: " + CC + " / " + CVC + "\r\n" + "\r\n" + "Product name 1: " + productNames.get(1) + "\r\n" + "Product name 2: " + productNames.get(2) + "\r\n" + "Product name 3: " + productNames.get(3) + "\r\n" + "Product name 4: " + productNames.get(4) + "\r\n" + "Product name 5: " + productNames.get(5) + "\r\n" + "Product name 6: " + productNames.get(6) + "\r\n" + "Product name 7: " + productNames.get(7) + "\r\n" + "Product name 8: " + productNames.get(8) + "\r\n" + "Product name 9: " + productNames.get(9) + "\r\n" + "\r\n" + "Order Reference 1: " + orderReferences.get(1) + "\r\n" + "Order Reference 2: " + orderReferences.get(2) + "\r\n" + "Order Reference 3: " + orderReferences.get(3) + "\r\n" + "Order Reference 4: " + orderReferences.get(4) + "\r\n" + "Order Reference 5: " + orderReferences.get(5) + "\r\n" + "Order Reference 6: " + orderReferences.get(6) + "\r\n" + "Order Reference 7: " + orderReferences.get(7) + "\r\n" + "Order Reference 8: " + orderReferences.get(8) + "\r\n" + "Order Reference 9: " + orderReferences.get(9));
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
        System.out.println("Ending Test");
        driver.quit();
    }
}