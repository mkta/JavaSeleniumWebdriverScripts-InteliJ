package DesiLaColScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by catalinf on 30-Mar-17.
 */
public class initVariables {
    //public static void initVariablesM() throws Exception {
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
        String dateFormated = dateFormat.format(date);

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

        System.out.println("Initiate order refference array");
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
    //}
}
