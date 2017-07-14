package PjInteractive_ScriptsBackup.E2E.PIM_Products;

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

import static PjInteractive_ScriptsBackup.E2E.PIM_Products.PIM_ProductConfigs.*;

/**
 * Created by catalinf on 07-Apr-17
 */
class PIM_ProductEmails extends PIM_Create_Product {

    //Set Gmail user and pass
    static final String username = "catalin.fleancu@pj-interactive.ro";
    static final String password = "Dorel1234";
    //Set Emails configs
    private final static String gto = "catalin.fleancu@brandpath.com";
    private final static String gcc = "stefan.chiosea@brandpath.com, ionut.delcea@brandpath.com";
    // Set date format
    private static final DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
    // Get current date and time
    private static final Date date2 = new Date();
    // Format the date
    static final String dateFormatted2 = dateFormat2.format(date2);
    //Set Filepath for Email logs attachment
    private static final String filename = logPath + "Pim Product Console Logs " + dateFormatted2 + ".txt";

    static void PPE1(Exception ppe1, Session session, String dateFormatted, List drvName, int drvIDi, WebDriver driver) throws Exception {

        System.out.println("Sending Error email for ppe1");

        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormatted + " " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "KC Login " + "script failed : " + "\r\n" + "Error (ppe1):" + "\r\n" + ppe1);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        if (drvIDi != 2) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " ppe1 " + ".png"));
            System.out.println("Error Screenshot done at : " + ssPath);
            MimeBodyPart messageBodyPart4 = new MimeBodyPart();
            DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " ppe1 " + ".png");
            messageBodyPart4.setDataHandler(new DataHandler(source3));
            messageBodyPart4.setFileName(ssPath + dateFormatted2 + " ppe1 " + ".png");
            multipart.addBodyPart(messageBodyPart4);
        } else {
            System.out.println("Headless Browser. No SS");
        }

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Error email sent");

    }

    static void PPE2(Exception ppe2, Session session, String dateFormatted, List drvName, int drvIDi, WebDriver driver) throws Exception {

        System.out.println("Sending Error email for ppe2");

        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormatted + " " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "PIM Loading " + "script failed : " + "\r\n" + "Error (ppe2):" + "\r\n" + ppe2);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        if (drvIDi != 2) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " ppe2 " + ".png"));
            System.out.println("Error Screenshot done at : " + ssPath);
            MimeBodyPart messageBodyPart4 = new MimeBodyPart();
            DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " ppe2 " + ".png");
            messageBodyPart4.setDataHandler(new DataHandler(source3));
            messageBodyPart4.setFileName(ssPath + dateFormatted2 + " ppe2 " + ".png");
            multipart.addBodyPart(messageBodyPart4);
        } else {
            System.out.println("Headless Browser. No SS");
        }

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Error email sent");

    }

    static void PPE3(Exception ppe3, Session session, String dateFormatted, List drvName, int drvIDi, WebDriver driver) throws Exception {

        System.out.println("Sending Error email for ppe3");

        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormatted + " " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "PIM site changing " + "script failed : " + "\r\n" + "Error (ppe3):" + "\r\n" + ppe3);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        if (drvIDi != 2) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " ppe3 " + ".png"));
            System.out.println("Error Screenshot done at : " + ssPath);
            MimeBodyPart messageBodyPart4 = new MimeBodyPart();
            DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " ppe3 " + ".png");
            messageBodyPart4.setDataHandler(new DataHandler(source3));
            messageBodyPart4.setFileName(ssPath + dateFormatted2 + " ppe3 " + ".png");
            multipart.addBodyPart(messageBodyPart4);
        } else {
            System.out.println("Headless Browser. No SS");
        }

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Error email sent");

    }

    static void PPE4(Exception ppe4, Session session, String dateFormatted, List drvName, int drvIDi, WebDriver driver) throws Exception {

        System.out.println("Sending Error email for ppe4");

        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormatted + " " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "PIM Product Listing Loading " + "script failed : " + "\r\n" + "Error (ppe4):" + "\r\n" + ppe4);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        if (drvIDi != 2) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " ppe4 " + ".png"));
            System.out.println("Error Screenshot done at : " + ssPath);
            MimeBodyPart messageBodyPart4 = new MimeBodyPart();
            DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " ppe4 " + ".png");
            messageBodyPart4.setDataHandler(new DataHandler(source3));
            messageBodyPart4.setFileName(ssPath + dateFormatted2 + " ppe4 " + ".png");
            multipart.addBodyPart(messageBodyPart4);
        } else {
            System.out.println("Headless Browser. No SS");
        }

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Error email sent");

    }

    static void PPE5(Exception ppe5, Session session, String dateFormatted, List drvName, int drvIDi, WebDriver driver) throws Exception {

        System.out.println("Sending Error email for ppe5");

        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormatted + " " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "PIM Product Create " + "script failed : " + "\r\n" + "Error (ppe5):" + "\r\n" + ppe5);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        if (drvIDi != 2) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " ppe5 " + ".png"));
            System.out.println("Error Screenshot done at : " + ssPath);
            MimeBodyPart messageBodyPart4 = new MimeBodyPart();
            DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " ppe5 " + ".png");
            messageBodyPart4.setDataHandler(new DataHandler(source3));
            messageBodyPart4.setFileName(ssPath + dateFormatted2 + " ppe5 " + ".png");
            multipart.addBodyPart(messageBodyPart4);
        } else {
            System.out.println("Headless Browser. No SS");
        }

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Error email sent");

    }

    static void PPE6(Exception ppe6, Session session, String dateFormatted, List drvName, int drvIDi, WebDriver driver) throws Exception {

        System.out.println("Sending Error email for ppe6");

        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormatted + " " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "PIM Product edit " + "script failed : " + "\r\n" + "Error (ppe6):" + "\r\n" + ppe6);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        if (drvIDi != 2) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " ppe6 " + ".png"));
            System.out.println("Error Screenshot done at : " + ssPath);
            MimeBodyPart messageBodyPart4 = new MimeBodyPart();
            DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " ppe6 " + ".png");
            messageBodyPart4.setDataHandler(new DataHandler(source3));
            messageBodyPart4.setFileName(ssPath + dateFormatted2 + " ppe6 " + ".png");
            multipart.addBodyPart(messageBodyPart4);
        } else {
            System.out.println("Headless Browser. No SS");
        }

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Error email sent");

    }

    static void PPE7(Exception ppe7, Session session, String dateFormatted, List drvName, int drvIDi, WebDriver driver) throws Exception {

        System.out.println("Sending Error email for ppe7");

        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormatted + " " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "PIM Product Save and Store " + "script failed : " + "\r\n" + "Error (ppe7" +
                "):" + "\r\n" + ppe7);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        if (drvIDi != 2) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " ppe7 " + ".png"));
            System.out.println("Error Screenshot done at : " + ssPath);
            MimeBodyPart messageBodyPart4 = new MimeBodyPart();
            DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " ppe7 " + ".png");
            messageBodyPart4.setDataHandler(new DataHandler(source3));
            messageBodyPart4.setFileName(ssPath + dateFormatted2 + " ppe7 " + ".png");
            multipart.addBodyPart(messageBodyPart4);
        } else {
            System.out.println("Headless Browser. No SS");
        }

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Error email sent");

    }

    static void PPFinal(String pName, String pSku, String pID, String pStatus, Session session, String dateFormatted, List drvName, int drvIDi) throws Exception {

        System.out.println("Sending Complete Mail");

        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormatted + " " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script COMPLETED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "PIM Product details " + "\r\n" + "Product name : " + pName +
                "\r\n" + "\r\n" + "Product SKU : " + pSku + "\r\n" + "Product ID : " + pID + "\r\n" + "Product status : " + pStatus + "\r\n");
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Complete email sent");

    }

    ///PRODUCT VARIANT EMAILS

    static void PPVE1(Exception ppVe1, Session sessionvar, String dateFormattedvar, List drvNamevar, int drvIDivar, WebDriver drivervar) throws Exception {

        System.out.println("Sending Error email for ppVe1");

        Message message1 = new MimeMessage(sessionvar);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormattedvar + " " + " (" + drvNamevar.get(drvIDivar) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvNamevar.get(drvIDivar) + "(" + drvIDivar + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "KC Login " + "script failed : " + "\r\n" + "Error (ppVe1):" + "\r\n" + ppVe1);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        if (drvIDivar != 2) {
            File scrFile = ((TakesScreenshot) drivervar).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " ppVe1 " + ".png"));
            System.out.println("Error Screenshot done at : " + ssPath);
            MimeBodyPart messageBodyPart4 = new MimeBodyPart();
            DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " ppVe1 " + ".png");
            messageBodyPart4.setDataHandler(new DataHandler(source3));
            messageBodyPart4.setFileName(ssPath + dateFormatted2 + " ppVe1 " + ".png");
            multipart.addBodyPart(messageBodyPart4);
        } else {
            System.out.println("Headless Browser. No SS");
        }

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Error email sent");

    }

    static void PPVE2(Exception ppVe2, Session session, String dateFormatted, List drvName, int drvIDi, WebDriver driver) throws Exception {

        System.out.println("Sending Error email for ppVe2");

        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormatted + " " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "PIM Loading " + "script failed : " + "\r\n" + "Error (ppe2):" + "\r\n" + ppVe2);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        if (drvIDi != 2) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " ppVe2 " + ".png"));
            System.out.println("Error Screenshot done at : " + ssPath);
            MimeBodyPart messageBodyPart4 = new MimeBodyPart();
            DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " ppVe2 " + ".png");
            messageBodyPart4.setDataHandler(new DataHandler(source3));
            messageBodyPart4.setFileName(ssPath + dateFormatted2 + " ppVe2 " + ".png");
            multipart.addBodyPart(messageBodyPart4);
        } else {
            System.out.println("Headless Browser. No SS");
        }

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Error email sent");

    }

    static void PPVE3(Exception ppVe3, Session session, String dateFormatted, List drvName, int drvIDi, WebDriver driver) throws Exception {

        System.out.println("Sending Error email for ppVe3");

        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormatted + " " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "PIM site changing " + "script failed : " + "\r\n" + "Error (ppVe3):" + "\r\n" + ppVe3);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        if (drvIDi != 2) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " ppVe3 " + ".png"));
            System.out.println("Error Screenshot done at : " + ssPath);
            MimeBodyPart messageBodyPart4 = new MimeBodyPart();
            DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " ppVe3 " + ".png");
            messageBodyPart4.setDataHandler(new DataHandler(source3));
            messageBodyPart4.setFileName(ssPath + dateFormatted2 + " ppVe3 " + ".png");
            multipart.addBodyPart(messageBodyPart4);
        } else {
            System.out.println("Headless Browser. No SS");
        }

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Error email sent");

    }

    static void PPVE4(Exception ppVe4, Session session, String dateFormatted, List drvName, int drvIDi, WebDriver driver) throws Exception {

        System.out.println("Sending Error email for ppVe4");

        Message message1 = new MimeMessage(session);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormatted + " " + " (" + drvName.get(drvIDi) + ") " + " - Script Results" + " Script FAILED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvName.get(drvIDi) + "(" + drvIDi + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "PIM Product Listing Loading " + "script failed : " + "\r\n" + "Error (ppVe4):" + "\r\n" + ppVe4);
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        if (drvIDi != 2) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ssPath + dateFormatted2 + " ppVe4 " + ".png"));
            System.out.println("Error Screenshot done at : " + ssPath);
            MimeBodyPart messageBodyPart4 = new MimeBodyPart();
            DataSource source3 = new FileDataSource(ssPath + dateFormatted2 + " ppVe4 " + ".png");
            messageBodyPart4.setDataHandler(new DataHandler(source3));
            messageBodyPart4.setFileName(ssPath + dateFormatted2 + " ppVe4 " + ".png");
            multipart.addBodyPart(messageBodyPart4);
        } else {
            System.out.println("Headless Browser. No SS");
        }

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Error email sent");

    }

    static void PPVFinal(String pNamevar, String pSkuvar, String pIDvar, String pStatusvar, Session sessionvar, String dateFormattedvar, List drvNamevar, int drvIDivar) throws Exception {

        System.out.println("Sending Complete Mail");

        Message message1 = new MimeMessage(sessionvar);
        message1.setFrom(new InternetAddress(username));
        message1.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(gto + "," + gcc));
        message1.setSubject(dateFormattedvar + " " + " (" + drvNamevar.get(drvIDivar) + ") " + " - Script Results" + " Script COMPLETED " + "(IntelliJ/JAVA");
        MimeBodyPart messageBodyPart1 = new MimeBodyPart();
        messageBodyPart1.setText("Results for " + site + ":" + "\r\n" + "\r\n" + "WebDriver (id) : " + drvNamevar.get(drvIDivar) + "(" + drvIDivar + ")"
                + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "PIM Product details " + "\r\n" + "Product name : " + pNamevar +
                "\r\n" + "\r\n" + "Product SKU : " + pSkuvar + "\r\n" + "Product ID : " + pIDvar + "\r\n" + "Product status : " + pStatusvar + "\r\n");
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart2.setDataHandler(new DataHandler(source));
        messageBodyPart2.setFileName(filename);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart1);
        multipart.addBodyPart(messageBodyPart2);

        message1.setContent(multipart);

        Transport.send(message1);

        System.out.println("Complete email sent");

    }

}
