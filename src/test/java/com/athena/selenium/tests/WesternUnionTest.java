package com.athena.selenium.tests;

import AutomationFramework.Log4Test;
import AutomationFramework.TestData;
import PageObjects.Frontend.FE_Western_Union_Receive.FE_WesternUnionReceive_Confirm;
import PageObjects.Frontend.FE_Western_Union_Receive.FE_WesternUnionReceive_Input;
import PageObjects.Frontend.FE_Western_Union_Receive.FE_WesternUnionReceive_Result;
import com.athena.selenium.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by dbrosteanu on 9/19/2017.
 */
public class WesternUnionTest extends DriverBase{

    @Test(groups = {TestData.WESTERN_UNION_GROUP})
    public void WU_01_Receive_RO() throws Exception {

        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive = new FE_WesternUnionReceive_Input(driver);

        setUp(TestData.FE, "WU_01", "Verify Western union - Receive labels" ,TestData.VN_84_VLY, TestData.USER_PASS);

        Log4Test.info("Accessing WU receive URL: "+ TestData.ENV + TestData.FE_WU_RECEIVE_URL);
        WUReceive.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");

        Log4Test.info("Assert sub-page title ");
        softAssert.assertEquals(WUReceive.getWUogoText(),TestData.WESTERN_UNION, TestData.WESTERN_UNION + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert Receive Money header box");
        softAssert.assertEquals(WUReceive.getReceiveMoneyLabelText(), TestData.RO_RECEIVE_MONEY, "TestData.RO_RECEIVE_MONEY" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getWUogoText(), TestData.WESTERN_UNION, "Primeste Bani - " + TestData.WESTERN_UNION + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.checkWUlogoVisiblity(), true, TestData.WESTERN_UNION + TestData.LOGO_IS_NOT_DISPLAYED);

        Log4Test.info("Assert 'In which account' area");
        softAssert.assertEquals(WUReceive.getInText(),"In", "'In' label" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getChooseAccText(), "Alege contul din care vrei sa transferi", "Choose account" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert Sum and currency fields");
        softAssert.assertEquals(WUReceive.getSumText(),"SUMA", "Sum" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getCurrencyText(),"MONEDA","Currency" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert currencies");
        softAssert.assertEquals(WUReceive.getFirstCurrency(),"RON RON", "First currency fields" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getSecondCurrency(), "EUR moneda", "Second currency fields" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert tooltip text");
        softAssert.assertEquals(WUReceive.getInfoTooltipText(),TestData.RO_WU_TOOLTIP_TEXT, "Tooltip" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert MTCN labels");
        softAssert.assertEquals(WUReceive.getMTCNLabeltext(),TestData.RO_MTCN_LABEL,"MTCN" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getMTCNFieldText(),TestData.RO_MTCN_FIELD, "MTCN FIELD" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert remaining characters available - MTCN field");
        softAssert.assertEquals(WUReceive.getRemainingCharsLabel(),"10 caractere disponibile", "MTCN characters left" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert Country labels");
        softAssert.assertEquals(WUReceive.getCountryLabelText(),TestData.RO_COUNTRY_LABEL, "Country " + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getCountryFieldText(), TestData.RO_COUNTRY_FIELD, "Country field" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert button labels");
        softAssert.assertEquals(WUReceive.getCancelButtonText(),"Anuleaza", "Cancel button" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getReceiveButtonText(),"Primeste", "Receive button" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getTCButtonText(),TestData.RO_TC, "T&C button" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert 'From and to' area labels");
        softAssert.assertEquals(WUReceive.getWillReceiveText(), "Urmeaza sa primesti","'Will receive'" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getFromAccText(),"Din contul:","From account" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getFromAccFields(),TestData.WESTERN_UNION + "\n" + TestData.RO_RECEIVE_MONEY ,"From account field");
        softAssert.assertEquals(WUReceive.getToAccText(),"Catre:","'To'"+TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert error messages");
        WUReceive.clickReceive();
        softAssert.assertEquals(WUReceive.getFirstErrorMessage(),TestData.RO_WU_ERROR_MESSAGE, "First error message" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getSecondErrorMessage(),TestData.RO_WU_ERROR_MESSAGE, "Second error message" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive.getThirdErrorMessage(),TestData.RO_WU_ERROR_MESSAGE, "Third error message" + TestData.LABEL_IS_NOT_CORRECT);


        Log4Test.info("Asserting 'To Country' label - info area");
        WUReceive.selectRandomCountry();
        softAssert.assertEquals(WUReceive.getToCountry(),"Tara expediere:","'To country'" + TestData.LABEL_IS_NOT_CORRECT);

        WUReceive.setAmount("10");

        Log4Test.info("Verify that MTCN is updated");
        WUReceive.enterMTCN("1234567890");
        softAssert.assertEquals(WUReceive.getMTCNinfoAreaLabel(),"Numar de control (MTCN):","MTCN label in info area is not displayed");

        softAssert.assertAll();
    }

    @DataProvider(name ="sum of money inputs")
    public static Object[][] getData() {
        Object sumOfMoney[][] = new Object[8][1];
        sumOfMoney[0][0] = "00000000";
        sumOfMoney[1][0] = "text";
        sumOfMoney[2][0] = "1000";
        sumOfMoney[3][0] = "0.1234";
        sumOfMoney[4][0] = "0,1234";
        sumOfMoney[5][0] = "1234567890123456789012345678901234567890";
        sumOfMoney[6][0] = "$@#$@#%^";
        sumOfMoney[7][0] = "312dsa";

        return sumOfMoney;
    }

    @Test(groups = {TestData.WESTERN_UNION_GROUP}, dataProvider = "sum of money inputs")
    public void WU_02_Receive(String sumOfMoney) throws Exception {

        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive = new FE_WesternUnionReceive_Input(driver);

        setUp(TestData.FE, "WU_02", "Verify Western union - Receive - SUM amount input restrictions", TestData.VN_84_VLY, TestData.USER_PASS);

        Log4Test.info("Accessing WU receive URL: "+ TestData.ENV + TestData.FE_WU_RECEIVE_URL);
        WUReceive.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");
        Assert.assertFalse(WUReceive.verifyValidation(sumOfMoney),"Incorrect input accepted for input: " + sumOfMoney);
    }

    @Test(groups = {TestData.WESTERN_UNION_GROUP})
    public void WU_03_Receive() throws  Exception{
        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive = new FE_WesternUnionReceive_Input(driver);

        setUp(TestData.FE, "WU_03", "Verify that info area is updated when the user inputs data.", TestData.VN_84_VLY, TestData.USER_PASS);

        Log4Test.info("Accessing WU receive URL: "+ TestData.ENV + TestData.FE_WU_RECEIVE_URL);
        WUReceive.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");

        Log4Test.info("Selecting a random account");
        WUReceive.selectAccountWithBalance();

        Log4Test.info("Verify that TO account is updated");
        softAssert.assertEquals(WUReceive.getDisplayedAccInfoArea(),WUReceive.getSelectedAccName(),"Account displayed in info area is not correct");
        softAssert.assertEquals(WUReceive.getDisplayedIBANinfoArea(),WUReceive.getSelectedAccountIBAN(),"IBAN displayed in info area is not correct");

        Log4Test.info("Verify that the entered amount is updated");
        WUReceive.enterValidAmount();
        softAssert.assertEquals(WUReceive.getSumInfoArea(), WUReceive.getSumFieldAmount(),"Entered amount is not correctly displayed in infoa area");

        Log4Test.info("Verify that entered country is updated");
        WUReceive.selectRandomCountry();
        softAssert.assertEquals(WUReceive.getInfoAreaCountry(), WUReceive.getEnteredCountry(),"Enter country is not displayed correctly");

        softAssert.assertAll();
    }


    @Test(groups = {TestData.WESTERN_UNION_GROUP})
    public void WU_04_Receive() throws Exception{
        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive = new FE_WesternUnionReceive_Input(driver);

        setUp(TestData.FE, "WU_04", "Verify that remaining characters at the MTCN field is updated when entering strings", TestData.VN_84_VLY, TestData.USER_PASS);

        Log4Test.info("Accessing WU receive URL: "+ TestData.ENV + TestData.FE_WU_RECEIVE_URL);
        WUReceive.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");

        Assert.assertTrue(WUReceive.isMTCNCounterWorking(10), "Counter is broken");
    }



    @Test(groups = {TestData.WESTERN_UNION_GROUP})
    public void WU_05_Receive_RO() throws Exception{

        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive_Input = new FE_WesternUnionReceive_Input(driver);
        FE_WesternUnionReceive_Confirm WUReceive_Confirm = new FE_WesternUnionReceive_Confirm(driver);

        setUp(TestData.FE, "WU_05","Verify confirmation page labels",TestData.VN_84_VLY,TestData.USER_PASS);

        Log4Test.info("Filling form in order to proceed to confirmation page");
        WUReceive_Input.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");
        WUReceive_Input.completeFormWithValidInput("1234567890");
        WUReceive_Input.clickReceive();

        Log4Test.info("Assert WU logo and label");
        softAssert.assertTrue(WUReceive_Confirm.isWUlogoDisplayed(),"WU Logo not displayed");
        softAssert.assertEquals(WUReceive_Confirm.getWUlabel(),"Primeste bani","WU" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert info labels");
        softAssert.assertEquals(WUReceive_Confirm.getInfoLabelFirstLabel(),TestData.RO_CONFIRM_PAGE_FIRST_INFO,"First info" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive_Confirm.getInfoLabelSecondLabel(),TestData.RO_CONFIRM_PAGE_SECOND_INFO,"Second info " + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive_Confirm.getInfoLabelThirdLabel(),TestData.RO_CONFIRM_PAGE_THIRD_INFO,"Third info" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert detail of transactions labels");
        softAssert.assertEquals(WUReceive_Confirm.getFromAccountLabel(),"Din contul:","From account" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive_Confirm.getToAccountLabel(),"Catre:","To" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive_Confirm.getMTCNlabel(),"Numar de control (MTCN):","MTCN label" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive_Confirm.getCountryLabel(),"Tara expediere:","Country" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive_Confirm.getTransferDateLabel(),"Data transferului:","Date " + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert personal information labels");
        softAssert.assertEquals(WUReceive_Confirm.getNameLabel(),"Nume:","Name" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive_Confirm.getseriesAndNrlabel(),"Serie - Nr.:","Series and name" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive_Confirm.getCNPlabel(),"CNP:","CNP:" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive_Confirm.getTelephoneNumberLabel(),"Numar telefon:","Telephone" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive_Confirm.getAddressLabel(),"Domiciliu:","Address" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive_Confirm.getBirthdayLabel(),"Data nasterii:","Birthday" + TestData.LABEL_IS_NOT_CORRECT);
        softAssert.assertEquals(WUReceive_Confirm.getOriginCountry(),"Tara origine:","Origin country" + TestData.LABEL_IS_NOT_CORRECT);

        Log4Test.info("Assert confirm button label");
        softAssert.assertEquals(WUReceive_Confirm.getConfirmButtonLabel(),"Confirma plata","Confirm button" + TestData.LABEL_IS_NOT_CORRECT);

        softAssert.assertAll();
    }

    @DataProvider(name ="MTCN inputs")
    public static Object[][] getMTCN() {
        Object mtcnList[][] = new Object[9][2];

        mtcnList[0][0] = "0000000001";
        mtcnList[0][1] = "A aparut o problema temporara de functionare. Te rugam sa incerci din nou.";

        mtcnList[1][0] = "0000000002";
        mtcnList[1][1] = "Momentan, tranzactia nu poate fi procesata din motive tehnice. Te rugam sa incerci mai tarziu. Daca intampini in continuare dificultati in finalizarea transferului, te rugam sa te adresezi unei agentii Raiffeisen Bank.";

        mtcnList[2][0] = "0000000003";
        mtcnList[2][1] = "Suma asteptata este diferita de suma de incasat de la expeditorul tau. Te rugam sa verifici detaliile si sa incerci din nou, cu atentie. Daca intampini dificultati in finalizarea transferului, te rugam sa te adresezi unei agentii Raiffeisen Bank.";

        mtcnList[3][0] = "0000000004";
        mtcnList[3][1] = "Suma completata depaseste valoarea maxima permisa pentru transferuri Western Union. Te rugam sa verifici corectitudinea datelor introduse si sa incerci din nou. Daca intampini in continuare dificultati in finalizarea transferului, te rugam sa te adresezi bancii";

        mtcnList[4][0] = "0000000005";
        mtcnList[4][1] = "Suma depaseste limita maxima permisa de Western Union pentru retrageri de bani. Te rugam sa completezi cu o suma mai mica. Daca intampini in continuare dificultati in finalizarea transferului, te rugam sa te adresezi unei agentii Raiffeisen Bank.";

        mtcnList[5][0] = "0000000006";
        mtcnList[5][1] = "Tranzactia cu aceste detalii nu a fost gasita. Te rugam sa verifici corectitudinea datelor introduse si sa incerci din nou. Daca intampini in continuare dificultati in finalizarea transferului, te rugam sa te adresezi unei agentii Raiffeisen Bank.";

        mtcnList[6][0] = "0000000007";
        mtcnList[6][1] = "Tranzactia de primire bani cu aceste detalii a fost efectuata deja. Te rugam sa te adresezi unei agentii Raiffeisen Bank pentru mai multe detalii.";

        mtcnList[7][0] = "0000000008";
        mtcnList[7][1] = "Tranzactia ta nu a putut fi procesata pe motiv de fonduri insuficiente.";

        mtcnList[8][0] = "0000000000";
        mtcnList[8][1] ="Incasarea ta de Western union a fost realizata cu succes";

        return mtcnList;
    }

    @Test(groups = TestData.WESTERN_UNION_GROUP,dataProvider = "MTCN inputs")
    public void WU_06_Receive(String mtcn, String  errorMsg) throws Exception{

        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive_Input = new FE_WesternUnionReceive_Input(driver);
        FE_WesternUnionReceive_Confirm WUReceive_Confirm = new FE_WesternUnionReceive_Confirm(driver);
        FE_WesternUnionReceive_Result WUReceive_Result = new FE_WesternUnionReceive_Result(driver);

        setUp(TestData.FE, "WU_06","Verify confirmation page message and buttons",TestData.VN_84_VLY,TestData.USER_PASS);

        Log4Test.info("Filling form in order to proceed to confirmation page");
        WUReceive_Input.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");
        WUReceive_Input.completeFormWithValidInput(mtcn);

        Log4Test.info("Proceeding to the confirmation page");
        WUReceive_Input.clickReceive();
        Log4Test.info("Proceeding to the result page");
        WUReceive_Confirm.pressConfirm();

        Log4Test.info("Checking if the result page message displayed is correct for MTCN: " + mtcn);
        softAssert.assertEquals(WUReceive_Result.getErrorText(),errorMsg,"Result page message is incorrect");

        Log4Test.info("Checking if all buttons are present");
        softAssert.assertTrue(WUReceive_Result.isTransactionHistoryButtonDisplayed(),"Transaction history button not displayed");
        softAssert.assertTrue(WUReceive_Result.isNewPaymentButtonDisplayed(),"New payment button not displayed");
        softAssert.assertTrue(WUReceive_Result.isProofPaymentButtonDisplayed(mtcn),"Proof of payment display problem");

        softAssert.assertAll();
    }

    @Test(groups = TestData.WESTERN_UNION_GROUP)
    public void WU_07_Receive_RO() throws Exception{

        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive_Input = new FE_WesternUnionReceive_Input(driver);
        FE_WesternUnionReceive_Confirm WUReceive_Confirm = new FE_WesternUnionReceive_Confirm(driver);
        FE_WesternUnionReceive_Result WUReceive_Result = new FE_WesternUnionReceive_Result(driver);

        setUp(TestData.FE, "WU_07","Verify confirmation page labels",TestData.VN_84_VLY,TestData.USER_PASS);

        Log4Test.info("Filling form in order to proceed to confirmation page");
        WUReceive_Input.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");
        WUReceive_Input.completeFormWithValidInput(TestData.WU_VALID_MTCN);

        Log4Test.info("Proceeding to the confirmation page");
        WUReceive_Input.clickReceive();
        Log4Test.info("Proceeding to the result page");
        WUReceive_Confirm.pressConfirm();

        Log4Test.info("Assert button labels");
        softAssert.assertEquals(WUReceive_Result.getTransactionHistoryButtonLabel(),"Istoric tranzactii","Transaction history button labe is incorrect");
        softAssert.assertEquals(WUReceive_Result.getNewPaymentLabel(),"Plata noua","New payment label is incorrect");
        softAssert.assertEquals(WUReceive_Result.getPaymentProofLabel(),"Dovada platii","Payment proof label is incorrect");

        Log4Test.info("Assert static texts labels");
        softAssert.assertEquals(WUReceive_Result.getPDFTextLabel(),"Poti descarca dovada platii in format PDF","PDF text label is incorrect");
        softAssert.assertEquals(WUReceive_Result.getSuggestionsLabels(),"Sugestii aplicatie","App suggestion label is incorrect");
        softAssert.assertEquals(WUReceive_Result.getPageTitleLabel(),"Western Union","Result page title header is incorrect");

        softAssert.assertAll();
    }

    @Test(groups = TestData.WESTERN_UNION_GROUP)
    public void WU_08_Receive() throws Exception{
        WebDriver driver = getDriver();
        FE_WesternUnionReceive_Input WUReceive_Input = new FE_WesternUnionReceive_Input(driver);
        FE_WesternUnionReceive_Confirm WUReceive_Confirm = new FE_WesternUnionReceive_Confirm(driver);
        FE_WesternUnionReceive_Result WUReceive_Result = new FE_WesternUnionReceive_Result(driver);

        setUp(TestData.FE, "WU_07","Verify confirmation page labels",TestData.VN_84_VLY,TestData.USER_PASS);


        WUReceive_Input.accessWUreceiveURL(TestData.ENV + TestData.FE_WU_RECEIVE_URL, "WU Receive page");

        Log4Test.info("Filling form in order to proceed to confirmation page");
        WUReceive_Input.completeFormWithValidInput(TestData.WU_VALID_MTCN);

        Log4Test.info("Stocking input page data");
        WUReceive_Input.stockInputData();
        WUReceive_Input.clickReceive();

        Log4Test.info("Stocking confirmation page data");
        WUReceive_Confirm.stockConfirmData();


        Log4Test.info("Verifying if the confirmation data is valid");
        softAssert.assertEquals(WUReceive_Confirm.confirmData[0],WUReceive_Input.inputData[0],"Account name is incorrect");
        softAssert.assertEquals(WUReceive_Confirm.confirmData[1],WUReceive_Input.inputData[1],"IBAN is incorrect");
        softAssert.assertEquals(WUReceive_Confirm.confirmData[2],WUReceive_Input.inputData[2],"Currency is incorrect");
        softAssert.assertEquals(WUReceive_Confirm.confirmData[3],WUReceive_Input.inputData[3],"MTCN is incorrect");
        softAssert.assertEquals(WUReceive_Confirm.confirmData[4],WUReceive_Input.inputData[4],"Country is incorrect");
        softAssert.assertEquals(WUReceive_Confirm.confirmData[5],WUReceive_Input.inputData[5],"Currency is incorrect");
        softAssert.assertAll();
    }

}

