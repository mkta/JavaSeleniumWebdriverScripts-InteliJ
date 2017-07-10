package Desi_FE_Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by catalinf on 04-Apr-17.
 * ////// Assertion classes \\\\\\\
 * Modify this if assertion problems
 */
class Assert extends _Desi_FE_Test {


    //Set Home page promo items title
    static String hppiTe = "listing.title";


    static void aHP(WebDriver driver, String country) throws Exception {

        //store url

        String oUrl = driver.getCurrentUrl();

        //store title

        String title = driver.getTitle();

        //verify url

        if (oUrl.equals(intConf.site + country)) {
            System.out.println(intConf.site + " Initiated");
        } else {
            System.out.println("Sie failed");
        }

        //Echo site name

        String navTitle = driver.findElement(By.xpath(intXpath.xnavTitle)).getText();
        System.out.println(" Site name is : " + title);
        System.out.println("Expected Site name is : " + navTitle);

    }

    static void aPLP(WebDriver driver, String plpURL) {

        //verify PLP url
        String oplpUrl = driver.getCurrentUrl();

        if (oplpUrl.equals(plpURL)) {
            System.out.println("PLP Opened");
        } else {
            System.out.println("PLP failed");
        }
    }
}
