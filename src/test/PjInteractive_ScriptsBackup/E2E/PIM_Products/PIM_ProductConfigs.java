package PjInteractive_ScriptsBackup.E2E.PIM_Products;

/**
 * Created by catalinf on 07-Apr-17
 */
class PIM_ProductConfigs extends PIM_Create_Product {

    ////////////////CONFIGS

    //Set site
    final static String site = "https://pim.bpc-aws.com/pim-web/";


    //set driver
    final static int drvID = 0; // 0 - Chrome ; 1 - Firefox ; 2 - Ghost/PhantomJS Driver ; /// 3 - IE/// not used at this moment
    //Set driver loops
    final static int drvloops = 3; // 3 = 1 loop ; 1 = 3 loops
    //Set timeout wait time seconds
    //final static int twt = 20;
    //Set Log Path
    final static String logPath = System.getProperty("user.dir") + "/Logs/";
    //Screenshot path
    static final String ssPath = System.getProperty("user.dir") + "/Screenshots/";
    //Set Drivers PAth
    final static String chromeDrvPath = System.getProperty("user.dir") + "/Drivers/" + "chromedriver.exe";
    final static String fireFoxDrvPath = System.getProperty("user.dir") + "/Drivers/" + "geckodriver.exe";
    final static String phantomJSrvPath = System.getProperty("user.dir") + "/Drivers/" + "phantomjs.exe";
    //Create variant?  // 0 - no; 1 - yes
    static int createVariant = 1;
    //String fireFoxDrvPathLinux = System.getProperty("user.dir") + "/Drivers/Linux/" + "geckodriver";
    //String chromeDrvPathLinux = System.getProperty("user.dir") + "/Drivers/Linux/" + "chromedriver";
}
