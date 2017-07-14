package Desi_FE_Script;

/**
 * Created by catalinf on 04-Apr-17.
 * /////// Xpath settings \\\\\\\
 * Edit this only when xpath fails//
 */


class intXpath extends _Desi_FE_Test {

/////////////////////////// Start of Xpath Configuration ///////////////////////////////////////////////
    //System.out.println("Start of xpath settings");
/////////////////////////// Note: country, payment and product selector xpath are set at the beginning of their loops ///////////////////////////

    //Set xpath for Navigation menu
    static final String xnavmenu = "html/body/section[2]/header/nav/div[2]/ul/li[1]/a/span";
    //Set PDP wait elements
    static final String xe1 = "html/body/section[3]/router-view/div/div[1]/div[2]/div[1]/span";
    static final String xe2 = "html/body/section[3]/router-view/div/div[1]/div[2]/h1/a";
    static final String xe3 = "html/body/section[3]/router-view/div/div[1]/div[2]/div[3]/input";
    //Set xpath add to basket button
    static final String xabb = "html/body/section[3]/router-view/div/div[1]/div[2]/div[5]/button[1]";
    //Set id for minicart
    static final String xmcid = "mini-cart";
    //Set xpath for mini basket element
    static final String xmcp = "html/body/section[2]/header/nav/form/div/div/div/div[1]/table/tbody/tr/td[2]/div/div[1]/span";
    //Set checkout/basket button
    static final String xcb = "html/body/section[2]/header/nav/form/div/div/div/div[2]/div[3]/a[1]";
    //Set basket product name
    static final String xbp = "html/body/section[3]/router-view/section[3]/div/div/div[1]/div/table/tbody/tr/td[2]/div/div[1]/span";
    //Set basket continue button
    static final String xbcb = "html/body/section[3]/router-view/section[3]/div/div/div[2]/div/div[4]/a";
    //Set checkout terms checkbox xpath
    //String xctcb = "html/body/section[3]/router-view/section[2]/div/div/div[2]/div[4]/div[2]/div/label/input";
    //Set proceed to payment button xpath
    static final String xptp = "html/body/section[3]/router-view/section[2]/div/div/div[2]/div[2]/div[4]/a";
    //Set CC xpath
    static final String xCC = "html/body/div/form/div[1]/div[2]/table/tbody/tr[2]/td[2]/div/input";
    //Set CVC xpath
    static final String xCVC = "html/body/div/form/div[1]/div[2]/table/tbody/tr[5]/td[2]/div/input";
    //Set proceed to payment step 2 button
    static final String xps2b = "html/body/div/form/div[2]/div/div[2]/input";
    //Set xpath of title on payment step 2
    static final String xps2t = "html/body/div/form/div[1]/div[2]/h2";
    //Set finish payment button
    static final String xfp = "html/body/div/form/div[2]/div/div[2]/input";
    //Set thank you page product image xpath
    static final String xtppi = "html/body/section[3]/router-view/section/div/div[2]/div/table/tbody/tr/td[1]/div/div/img";
    //Set order ref xpath
    static final String xor = "html/body/section[3]/router-view/section/div/div[1]/h1[2]";
    //Set xpath for billing detail title
    static final String xBillDet = "html/body/section[3]/router-view/section[2]/div/div/div[1]/h2";
    //////////////////////////////////////////////////////////////////////
    /////////////////////////////////Set Assert xPaths

    //Xpath for navigation title
    static final String xnavTitle = "html/body/section[2]/header/nav/div[2]/div/a/span";
    //Xpath for homo page promo items
    static final String hppi = "html/body/section[3]/router-view/page/section[3]/div/h3";

    /////////////////////////// End of Xpath Configuration /////////////////////////////////////////////////
        /*void xPathSet() {
            System.out.println("End of xpath settings");
        }*/

}
