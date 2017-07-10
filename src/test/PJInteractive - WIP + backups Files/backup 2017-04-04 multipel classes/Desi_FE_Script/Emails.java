package Desi_FE_Script;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by catalinf on 04-Apr-17. *
 * ///////Emails code\\\\\\\
 * Modify only if emails content needs to be modified
 */


class Emails extends _Desi_FE_Test {

    // Set date format
    static final DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
    // Get current date and time
    static final Date date2 = new Date();
    // Format the date
    static final String dateFormatted2 = dateFormat2.format(date2);
    //Set Filepath for Email logs attachment
    static final String filename = intConf.logPath + "Console Logs " + dateFormatted2 + ".txt";
    //Set Filepath 2 for Email logs attachment
    static final String filename2 = intConf.logPath + "Desi-logs.txt";

    static void E1(Exception e1, Session session, String dateFormatted, int countryidi, List countrys, List drvName, int drvIDi, String country, WebDriver driver) throws Exception {


        System.out.println("Sending Error email for e1");

        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(intConf.username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(intConf.gto + "," + intConf.gcc));
        message1.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + intConf.site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At nav menu " + "script failed : " + "\r\n" + "Error (e1):" + "\r\n" + e1);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(Emails.filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(Emails.filename);
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        DataSource source2 = new FileDataSource(Emails.filename2);
        messageBodyPart3.setDataHandler(new DataHandler(source2));
        messageBodyPart3.setFileName(Emails.filename2);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        multipart.addBodyPart(messageBodyPart3);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(intConf.ssPath + Emails.dateFormatted2 + " e1 " + ".png"));
        System.out.println("Error Screenshot done at : " + intConf.ssPath);
        MimeBodyPart messageBodyPart4 = new MimeBodyPart();
        DataSource source3 = new FileDataSource(intConf.ssPath + Emails.dateFormatted2 + " e1 " + ".png");
        messageBodyPart4.setDataHandler(new DataHandler(source3));
        messageBodyPart4.setFileName(intConf.ssPath + Emails.dateFormatted2 + " e1 " + ".png");
        multipart.addBodyPart(messageBodyPart4);

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Error email sent");
    }

    static void E2(Exception e2, Session session, String dateFormatted, int countryidi, List countrys, List drvName, int drvIDi, String country, WebDriver driver) throws Exception {
        Message message2 = new MimeMessage(session);
        message2.setFrom(new InternetAddress(intConf.username));
        message2.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(intConf.gto + "," + intConf.gcc));
        message2.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + intConf.site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At Product Listing " + "script failed : " + "\r\n" + "\r\n" + "Error (e2):" + "\r\n" + e2);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(Emails.filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(Emails.filename);
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        DataSource source2 = new FileDataSource(Emails.filename2);
        messageBodyPart3.setDataHandler(new DataHandler(source2));
        messageBodyPart3.setFileName(Emails.filename2);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        multipart.addBodyPart(messageBodyPart3);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(intConf.ssPath + Emails.dateFormatted2 + " e2 " + ".png"));
        System.out.println("Error Screenshot done at : " + intConf.ssPath);
        MimeBodyPart messageBodyPart4 = new MimeBodyPart();
        DataSource source3 = new FileDataSource(intConf.ssPath + Emails.dateFormatted2 + " e2 " + ".png");
        messageBodyPart4.setDataHandler(new DataHandler(source3));
        messageBodyPart4.setFileName(intConf.ssPath + Emails.dateFormatted2 + " e2 " + ".png");
        multipart.addBodyPart(messageBodyPart4);


        message2.setContent(multipart);

        Transport.send(message2);
    }

    static void E3(Exception e3, Session session, String dateFormatted, int countryidi, List countrys, List drvName, int drvIDi, String country, WebDriver driver) throws Exception {
        Message message3 = new MimeMessage(session);
        message3.setFrom(new InternetAddress(intConf.username));
        message3.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(intConf.gto + "," + intConf.gcc));
        message3.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + intConf.site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At Add to basket button " + "script failed : " + "\r\n" + "Error (e3):" + "\r\n" + e3);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(Emails.filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(Emails.filename);
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        DataSource source2 = new FileDataSource(Emails.filename2);
        messageBodyPart3.setDataHandler(new DataHandler(source2));
        messageBodyPart3.setFileName(Emails.filename2);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        multipart.addBodyPart(messageBodyPart3);


        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(intConf.ssPath + Emails.dateFormatted2 + " e3 " + ".png"));
        System.out.println("Error Screenshot done at : " + intConf.ssPath);
        MimeBodyPart messageBodyPart4 = new MimeBodyPart();
        DataSource source3 = new FileDataSource(intConf.ssPath + Emails.dateFormatted2 + " e3 " + ".png");
        messageBodyPart4.setDataHandler(new DataHandler(source3));
        messageBodyPart4.setFileName(intConf.ssPath + Emails.dateFormatted2 + " e3 " + ".png");
        multipart.addBodyPart(messageBodyPart4);


        message3.setContent(multipart);

        Transport.send(message3);
    }

    static void E4(Exception e4, Session session, String dateFormatted, int countryidi, List countrys, List drvName, int drvIDi, String country, WebDriver driver) throws Exception {
        Message message4 = new MimeMessage(session);
        message4.setFrom(new InternetAddress(intConf.username));
        message4.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(intConf.gto + "," + intConf.gcc));
        message4.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + intConf.site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At mini basket " + "script failed : " + "\r\n" + "\r\n" + "Error (e4):" + "\r\n" + e4);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(Emails.filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(Emails.filename);
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        DataSource source2 = new FileDataSource(Emails.filename2);
        messageBodyPart3.setDataHandler(new DataHandler(source2));
        messageBodyPart3.setFileName(Emails.filename2);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        multipart.addBodyPart(messageBodyPart3);


        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(intConf.ssPath + Emails.dateFormatted2 + " e4 " + ".png"));
        System.out.println("Error Screenshot done at : " + intConf.ssPath);
        MimeBodyPart messageBodyPart4 = new MimeBodyPart();
        DataSource source3 = new FileDataSource(intConf.ssPath + Emails.dateFormatted2 + " e4 " + ".png");
        messageBodyPart4.setDataHandler(new DataHandler(source3));
        messageBodyPart4.setFileName(intConf.ssPath + Emails.dateFormatted2 + " e4 " + ".png");
        multipart.addBodyPart(messageBodyPart4);


        message4.setContent(multipart);

        Transport.send(message4);
    }

    static void E5(Exception e5, Session session, String dateFormatted, int countryidi, List countrys, List drvName, int drvIDi, String country, WebDriver driver) throws Exception {
        Message message5 = new MimeMessage(session);
        message5.setFrom(new InternetAddress(intConf.username));
        message5.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(intConf.gto + "," + intConf.gcc));
        message5.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + intConf.site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At Checkout button from mini basket " + "script failed : " + "Error (e5):" + "\r\n" + e5);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(Emails.filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(Emails.filename);
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        DataSource source2 = new FileDataSource(Emails.filename2);
        messageBodyPart3.setDataHandler(new DataHandler(source2));
        messageBodyPart3.setFileName(Emails.filename2);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        multipart.addBodyPart(messageBodyPart3);


        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(intConf.ssPath + Emails.dateFormatted2 + " e5 " + ".png"));
        System.out.println("Error Screenshot done at : " + intConf.ssPath);
        MimeBodyPart messageBodyPart4 = new MimeBodyPart();
        DataSource source3 = new FileDataSource(intConf.ssPath + Emails.dateFormatted2 + " e5 " + ".png");
        messageBodyPart4.setDataHandler(new DataHandler(source3));
        messageBodyPart4.setFileName(intConf.ssPath + Emails.dateFormatted2 + " e5 " + ".png");
        multipart.addBodyPart(messageBodyPart4);


        message5.setContent(multipart);

        Transport.send(message5);
    }

    static void E6(Exception e6, Session session, String dateFormatted, int countryidi, List countrys, List drvName, int drvIDi, String country, WebDriver driver) throws Exception {
        Message message6 = new MimeMessage(session);
        message6.setFrom(new InternetAddress(intConf.username));
        message6.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(intConf.gto + "," + intConf.gcc));
        message6.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + intConf.site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At  basket page " + "script failed : " + "\r\n" + "\r\n" + "Error(e6):" + "\r\n" + e6);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(Emails.filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(Emails.filename);
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        DataSource source2 = new FileDataSource(Emails.filename2);
        messageBodyPart3.setDataHandler(new DataHandler(source2));
        messageBodyPart3.setFileName(Emails.filename2);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        multipart.addBodyPart(messageBodyPart3);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(intConf.ssPath + Emails.dateFormatted2 + " e6 " + ".png"));
        System.out.println("Error Screenshot done at : " + intConf.ssPath);
        MimeBodyPart messageBodyPart4 = new MimeBodyPart();
        DataSource source3 = new FileDataSource(intConf.ssPath + Emails.dateFormatted2 + " e6 " + ".png");
        messageBodyPart4.setDataHandler(new DataHandler(source3));
        messageBodyPart4.setFileName(intConf.ssPath + Emails.dateFormatted2 + " e6 " + ".png");
        multipart.addBodyPart(messageBodyPart4);


        message6.setContent(multipart);

        Transport.send(message6);

    }

    static void E7(Exception e7, Session session, String dateFormatted, int countryidi, List countrys, List drvName, int drvIDi, String country, WebDriver driver) throws Exception {
        Message message7 = new MimeMessage(session);
        message7.setFrom(new InternetAddress(intConf.username));
        message7.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(intConf.gto + "," + intConf.gcc));
        message7.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + intConf.site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At payment method " + "script failed : " + "\r\n" + "\r\n" + "Error (e7):" + "\r\n" + e7);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(Emails.filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(Emails.filename);
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        DataSource source2 = new FileDataSource(Emails.filename2);
        messageBodyPart3.setDataHandler(new DataHandler(source2));
        messageBodyPart3.setFileName(Emails.filename2);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        multipart.addBodyPart(messageBodyPart3);


        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(intConf.ssPath + Emails.dateFormatted2 + " e7 " + ".png"));
        System.out.println("Error Screenshot done at : " + intConf.ssPath);
        MimeBodyPart messageBodyPart4 = new MimeBodyPart();
        DataSource source3 = new FileDataSource(intConf.ssPath + Emails.dateFormatted2 + " e7 " + ".png");
        messageBodyPart4.setDataHandler(new DataHandler(source3));
        messageBodyPart4.setFileName(intConf.ssPath + Emails.dateFormatted2 + " e7 " + ".png");
        multipart.addBodyPart(messageBodyPart4);


        message7.setContent(multipart);

        Transport.send(message7);

    }

    static void E8(Exception e8, Session session, String dateFormatted, int countryidi, List countrys, List drvName, int drvIDi, String country, WebDriver driver) throws Exception {
        Message message8 = new MimeMessage(session);
        message8.setFrom(new InternetAddress(intConf.username));
        message8.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(intConf.gto + "," + intConf.gcc));
        message8.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + intConf.site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At proceed to payment button " + "script failed : " + "Error(e8):" + "\r\n" + e8);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(Emails.filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(Emails.filename);
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        DataSource source2 = new FileDataSource(Emails.filename2);
        messageBodyPart3.setDataHandler(new DataHandler(source2));
        messageBodyPart3.setFileName(Emails.filename2);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        multipart.addBodyPart(messageBodyPart3);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(intConf.ssPath + Emails.dateFormatted2 + " e8 " + ".png"));
        System.out.println("Error Screenshot done at : " + intConf.ssPath);
        MimeBodyPart messageBodyPart4 = new MimeBodyPart();
        DataSource source3 = new FileDataSource(intConf.ssPath + Emails.dateFormatted2 + " e8 " + ".png");
        messageBodyPart4.setDataHandler(new DataHandler(source3));
        messageBodyPart4.setFileName(intConf.ssPath + Emails.dateFormatted2 + " e8 " + ".png");
        multipart.addBodyPart(messageBodyPart4);


        message8.setContent(multipart);

        Transport.send(message8);

    }

    static void E9(Exception e9, Session session, String dateFormatted, int countryidi, List countrys, List drvName, int drvIDi, String country, WebDriver driver) throws Exception {
        Message message9 = new MimeMessage(session);
        message9.setFrom(new InternetAddress(intConf.username));
        message9.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(intConf.gto + "," + intConf.gcc));
        message9.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + intConf.site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At payment process" + "script failed : " + "\r\n" + "Error(e9):" + "\r\n" + e9);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(Emails.filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(Emails.filename);
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        DataSource source2 = new FileDataSource(Emails.filename2);
        messageBodyPart3.setDataHandler(new DataHandler(source2));
        messageBodyPart3.setFileName(Emails.filename2);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        multipart.addBodyPart(messageBodyPart3);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(intConf.ssPath + Emails.dateFormatted2 + " e9 " + ".png"));
        System.out.println("Error Screenshot done at : " + intConf.ssPath);
        MimeBodyPart messageBodyPart4 = new MimeBodyPart();
        DataSource source3 = new FileDataSource(intConf.ssPath + Emails.dateFormatted2 + " e9 " + ".png");
        messageBodyPart4.setDataHandler(new DataHandler(source3));
        messageBodyPart4.setFileName(intConf.ssPath + Emails.dateFormatted2 + " e9 " + ".png");
        multipart.addBodyPart(messageBodyPart4);


        message9.setContent(multipart);

        Transport.send(message9);
    }

    static void E10(Exception e10, Session session, String dateFormatted, int countryidi, List countrys, List drvName, int drvIDi, String country, WebDriver driver) throws Exception {
        Message message10 = new MimeMessage(session);
        message10.setFrom(new InternetAddress(intConf.username));
        message10.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(intConf.gto + "," + intConf.gcc));
        message10.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + "- Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + intConf.site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "At thank you page " + "script failed : " + "Error(e10):" + "\r\n" + e10);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(Emails.filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(Emails.filename);
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        DataSource source2 = new FileDataSource(Emails.filename2);
        messageBodyPart3.setDataHandler(new DataHandler(source2));
        messageBodyPart3.setFileName(Emails.filename2);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        multipart.addBodyPart(messageBodyPart3);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(intConf.ssPath + Emails.dateFormatted2 + " e10 " + ".png"));
        System.out.println("Error Screenshot done at : " + intConf.ssPath);
        MimeBodyPart messageBodyPart4 = new MimeBodyPart();
        DataSource source3 = new FileDataSource(intConf.ssPath + Emails.dateFormatted2 + " e10 " + ".png");
        messageBodyPart4.setDataHandler(new DataHandler(source3));
        messageBodyPart4.setFileName(intConf.ssPath + Emails.dateFormatted2 + " e10 " + ".png");
        multipart.addBodyPart(messageBodyPart4);


        message10.setContent(multipart);

        Transport.send(message10);
    }

    static void FinalMail(Session session, String dateFormatted, List productNames, int countryidi, List countrys, List drvName, int drvIDi, String country, int paymenti, int paymentloop, String paymentName, List orderReferences, String CC, String CVC) throws Exception {

        Message message0 = new MimeMessage(session);

        message0.setFrom(new InternetAddress(intConf.username));
        message0.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(intConf.gto + "," + intConf.gcc));
        if (paymentloop < 4) {
            message0.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Initiating next payment loop" + "(IntelliJ/JAVA");
        } else {
            message0.setSubject(dateFormatted + " (" + countrys.get(countryidi) + ") " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " End of payment loops" + "(IntelliJ/JAVA");
        }
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + intConf.site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")" + "\r\n" + "\r\n" + "Country: " + country + "\r\n" + "\r\n" + "Payment Type(number): " + paymentName + "(" + paymenti + ")" + "\r\n" + "\r\n" + "CC / CVC used: " + CC + " / " + CVC + "\r\n" + "\r\n" + "Product name 1: " + productNames.get(1) + "\r\n" + "Product name 2: " + productNames.get(2) + "\r\n" + "Product name 3: " + productNames.get(3) + "\r\n" + "Product name 4: " + productNames.get(4) + "\r\n" + "Product name 5: " + productNames.get(5) + "\r\n" + "Product name 6: " + productNames.get(6) + "\r\n" + "Product name 7: " + productNames.get(7) + "\r\n" + "Product name 8: " + productNames.get(8) + "\r\n" + "Product name 9: " + productNames.get(9) + "\r\n" + "\r\n" + "Order Reference 1: " + orderReferences.get(1) + "\r\n" + "Order Reference 2: " + orderReferences.get(2) + "\r\n" + "Order Reference 3: " + orderReferences.get(3) + "\r\n" + "Order Reference 4: " + orderReferences.get(4) + "\r\n" + "Order Reference 5: " + orderReferences.get(5) + "\r\n" + "Order Reference 6: " + orderReferences.get(6) + "\r\n" + "Order Reference 7: " + orderReferences.get(7) + "\r\n" + "Order Reference 8: " + orderReferences.get(8) + "\r\n" + "Order Reference 9: " + orderReferences.get(9));
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(Emails.filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(Emails.filename);
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        DataSource source2 = new FileDataSource(Emails.filename2);
        messageBodyPart3.setDataHandler(new DataHandler(source2));
        messageBodyPart3.setFileName(Emails.filename2);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);
        multipart.addBodyPart(messageBodyPart3);
        message0.setContent(multipart);

        Transport.send(message0);


    }
}