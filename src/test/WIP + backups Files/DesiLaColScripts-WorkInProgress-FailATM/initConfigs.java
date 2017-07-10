package DesiLaColScripts;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by catalinf on 30-Mar-17.
 */
public class initConfigs {
    public static void initConfigs() throws Exception {
        /////////////////////////// Start of configurations //////////////////////////////////////////////////////

        System.out.println("Start of configurations");

        //Set Gmail user and pass
        final String username = "catalin.fleancu@pj-interactive.ro";
        final String password = "Dorel123";
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
        String dateFormated2 = dateFormat2.format(date2);
        //Set Log output file
        PrintStream out = new PrintStream(new FileOutputStream("/C:/Users/catalinf/Google Drive/IntelliJ Scripts/DesiLaColScripts/Logs/Console Logs " + dateFormated2 + ".txt"));
        System.setOut(out);
        //Set Filepath for Email logs attachment
        String filename = "/C:/Users/catalinf/Google Drive/IntelliJ Scripts/DesiLaColScripts/Logs/Console Logs " + dateFormated2 + ".txt";
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
        int twt = 2;

        System.out.println("End of configurations");
/////////////////////////// End of configurations //////////////////////////////////////////////////////
    }
}
