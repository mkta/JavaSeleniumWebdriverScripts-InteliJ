package DesiLaColScripts;

/**
 * Created by catalinf on 30-Mar-17.
 */
public class initXpaths {
    //public static void initXpaths() throws Exception {
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
        //Set xpath for mini basket elemnt
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
    }
}
