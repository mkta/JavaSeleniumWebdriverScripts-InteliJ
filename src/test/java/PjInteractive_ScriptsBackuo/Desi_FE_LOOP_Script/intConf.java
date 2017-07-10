package Desi_FE_LOOP_Script;

/**
 * Created by catalinf on 04-Apr-17
 * ////// Configurations \\\\\\\
 * Please edit this to modify script functions//
 */


class intConf extends DesiFELOOPTest {

    /////////////////////////// Start of configurations //////////////////////////////////////////////////////

    //System.out.println("Start of configurations");

    //Set Gmail user and pass
    static final String username = "catalin.fleancu@pj-interactive.ro";
    static final String password = "Dorel1234";
    //Set intConf.site
    static final String site = "https://tst.bpc-aws.com/"; // ( https://tst.desilacol.com/ ) or ( https://tst.bpc-aws.com/ )
    //Set country
    static final int countryid = 1; // 1 = us ; 2 = jp;
    //Set country loops
    static final int countryloops = 2; // 2 = 1 loop ; 1 = 2 loops
    //Select product
    static final int prods = 7; // plp product number - selects the product order from listing
    //select number of loops
    static final int prodloops = 9; // 9 = 1 loop; 1 = 9 loops
    //Set initial Payment
    static final int payment = 4; // payment number ( 1 - Visa ; 2 - MC ; 3 - AmericaExpress ; 4 - Discover ; 4 - JCB )
    //Set payment loops
    static final int paymentloops = 4; // 4 = 1 payment; 1 = 4 payments
    //set test loops (entire test)
    static final int testloops = 10; // 1 = 10 loops ; 10 = 1 loop
    //set driver
    static final int drvID = 0; // 0 - Chrome ; 1 - Firefox ; 2 - Ghost/PhantomJS Driver ; /// 3 - IE/// not used at this moment
    //Set driver loops
    static final int drvloops = 3; // 3 = 1 loop ; 1 = 3 loops
    //Set Emails configs
    static final String gto = "catalin.fleancu@brandpath.com";
    static final String gcc = "stefan.chiosea@brandpath.com, ionut.delcea@brandpath.com";
    //Skip email? 0 = no 1 = yes
    static final int skipEmail = 0;
    //Screenshot? 0 = no 1 = yes
    static final int ss = 0;
    //Set pdp sleep time milliseconds
    static final int pdpsleep = 2000;
    //Set timeout wait time seconds
    static final int twt = 10;
    //Set listing URL
    static final String listingURL = "/women";
    //////////Paths configs////////////////
    //Set Log Path
    static final String logPath = System.getProperty("user.dir") + "/Logs/";
    //Chrome driver path
    static final String chromeDrvPath = System.getProperty("user.dir") + "/Drivers/" + "chromedriver.exe";
    //Firefox driver path
    static final String fireFoxDrvPath = System.getProperty("user.dir") + "/Drivers/" + "geckodriver.exe";
    //PhantomJS driver path
    static final String phantomJSrvPath = System.getProperty("user.dir") + "/Drivers/" + "phantomjs.exe";
    //Screenshot path
    static final String ssPath = System.getProperty("user.dir") + "/Screenshots/";


    //  System.out.println("End of configurations");

/////////////////////////// End of configurations //////////////////////////////////////////////////////
}
