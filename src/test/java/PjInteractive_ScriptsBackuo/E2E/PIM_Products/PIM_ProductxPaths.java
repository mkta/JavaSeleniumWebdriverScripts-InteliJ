package PjInteractive_ScriptsBackuo.E2E.PIM_Products;

/**
 * Created by catalinf on 07-Apr-17
 */
class PIM_ProductxPaths extends PIM_Create_Product {

    //Set KC user and Pass xpath
    final static String xkcUser = "html/body/div[2]/div/div[3]/div/div/div/form/div[1]/div[2]/input";
    final static String xkcPsw = "html/body/div[2]/div/div[3]/div/div/div/form/div[2]/div[2]/input";
    final static String xkcLogInB = "html/body/div[2]/div/div[3]/div/div/div/form/div[3]/div[2]/div/input";
    //Set xpath for site switch
    final static String xSwtichDL = "html/body/div[1]/div[2]/div[1]/form/div/div[1]/div[3]/div/div/div[3]/span";
    final static String xSwtichDLDESI = "html/body/div[9]/div/ul/li[2]";
    final static String xSwtichSUBMIT = "html/body/div[1]/div[2]/div[1]/form/div/div[1]/div[3]/div/button";
    final static String xSwithcLabel = "html/body/div[1]/div[2]/div[1]/form/div/div[1]/div[3]/div/div/label";
    //set xpath for product listing
    final static String xpimNavDashboard = "html/body/div[2]/div[1]/div/form/div/div/div/div/div/ul/li[1]/a/span";
    final static String xProdListingDSHNAV = "html/body/div[2]/div[1]/div/form/div/div/div/div/div/ul/li[2]/a/span[3]";
    final static String xProdListingNAV = "html/body/div[2]/div[1]/div/form/div/div/div/div/div/ul/li[2]/ul/li[1]/a/span";
    final static String xProdListingBC = "html/body/div[2]/div[2]/form/div[1]/ul/li[5]/a/span";
    final static String xProdListingFP = "html/body/div[2]/div[2]/form/div[3]/div[2]/table/tbody/tr[1]/td[4]";
    //set xpath for product create
    final static String xProductCreateAddButton = "html/body/div[2]/div[2]/form/div[2]/div/div[2]/button[1]";
    final static String xProdCrName = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/div/div[1]/input[1]";
    final static String xProdCrManufDL = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[3]/span";
    final static String xProdCreateManufSelect = "html/body/div[14]/div/ul/li[14]";
    //geani test
    final static String xProdCrCatalogueDL = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[3]/span";
    final static String xProdCrCatalogueSelect1 = "html/body/div[15]/div[2]/ul/li[1]/div/div[2]/span";
    final static String xProdCrCatalogueSelect2 = "html/body/div[15]/div[2]/ul/li[3]/div/div[2]/span";
    //geani test listing-test
    final static String xProdCrCategoriesDL = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/div/div[1]/div[3]/div[3]/span";
    final static String xProdCrCategoriesSelect = "html/body/div[16]/div[2]/ul/li[1]/div/div[2]/span";
    //shoes
    final static String xProdCrTypeDL = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/div/div[1]/div[4]/div[3]/span";
    final static String xProdCrTypeSelect = "html/body/div[17]/div/ul/li[35]";
    //Save first draft
    final static String xProdCrSAVE = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/div/div[3]/button";
    //product creation date
    final static String xProdCrDate = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/ul/li[2]/p[2]/label";
    //Draft edit
    final static String xProdEditBTN = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/div/div[3]/button[2]/span[2]";
    //Save button
    final static String xProdSaveBTN = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/div/div[3]/button[2]/span[2]";
    //Prod SKU
    final static String xProdSKU = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/div/div[1]/input[2]";
    //Prod Tesaser
    final static String xProdTeaser = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/div/div[1]/table[2]/tbody/tr[2]/td/input";
    //Prod details tab
    final static String xProdEDetailsTab = "html/body/div[2]/div[2]/form/div[2]/div[1]/ul/li[2]/a";
    final static String xProdeDetailsWeight = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[2]/div/table/tbody/tr/td/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[2]/input";
    final static String xProdeDetailsWeightType = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[2]/div/table/tbody/tr/td/div[2]/div/div/div[2]/div/table/tbody/tr[2]/td[2]/input";
    final static String xProdeDetailsRRP = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[2]/div/table/tbody/tr/td/div[3]/div/div/div[2]/div/table/tbody/tr[2]/td[2]/input";
    final static String xProdeDetailsColor = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[2]/div/table/tbody/tr/td/div[5]/div/div/div[1]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input";
    final static String xProdeDetailsColorSelector = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[2]/div/table/tbody/tr/td/div[5]/div/div/div[1]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/span/button";
    final static String xProdeDetailsColorSelectorColor = "html/body/div[30]/div[4]/input";
    final static String xProdeDetailsSize = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[2]/div/table/tbody/tr/td/div[5]/div/div/div[1]/div/table/tbody/tr[3]/td[2]/input";
    final static String xProdeDetailsSizeGroup = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[2]/div/table/tbody/tr/td/div[5]/div/div/div[2]/div/table/tbody/tr[4]/td[2]/input";
    final static String xProdeDetailsMaterial = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[2]/div/table/tbody/tr/td/div[5]/div/div/div[1]/div/table/tbody/tr[5]/td[2]/input";
    final static String xProdeDetailsSleeveLenght = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[2]/div/table/tbody/tr/td/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[2]/input";
    //assets tab
    final static String xProdEAssetsTab = "html/body/div[2]/div[2]/form/div[2]/div[1]/ul/li[3]/a";
    final static String xProdEAssetsAddButton = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[3]/div/table/tbody/tr/td[1]/button";
    final static String xProdEAssetsName = "setCreateDialogForm:sourceFileNameInput";
    final static String xProdEAssetsSAVEBtn = "setCreateDialogForm:editCreate";
    final static String xChooseBTNspans = "html/body/div[23]/div[2]/form/table/tbody/tr/td[1]/div/div[2]/div[1]/span";
    final static String xProdEAssetsUPLOADpath = "setCreateDialogForm:fileUpload_input";
    final static String xProdEAssetsAddButton2 = "productTabsForm:tabViewId:addNewAssetBtn";
    final static String xProdOVERLAY = "html/body/div[32]";
    //general tab
    final static String xProdGeneralTab = "html/body/div[2]/div[2]/form/div[2]/div[1]/ul/li[1]/a";
    final static String xProdPublishBTN = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[1]/div/div[3]/button[1]/span[2]";
    final static String xProductStatus = "html/body/div[2]/div[2]/h1";
    final static String xProductName = "productTabsForm:tabViewId:name";
    final static String xProductSKU = "productTabsForm:tabViewId:code";
    final static String xProductID = "productTabsForm:tabViewId:publicId";
    //////////////////////////////////////////////////////////////////////////
    //Variant xpaths
    final static String xProdSearchName = "html/body/div[2]/div[2]/form/div[2]/div/div[1]/div[6]/span/input";
    final static String xProdSeachBTN = "html/body/div[2]/div[2]/form/div[2]/div/div[2]/button[2]";
    final static String xProdSeachResultName = "html/body/div[2]/div[2]/form/div[3]/div[2]/table/tbody/tr/td[4]";
    final static String xProdSearchResultOpenBRN = "html/body/div[2]/div[2]/form/div[3]/div[2]/table/tbody/tr/td[10]/a/img";
    final static String xProdVariantTAB = "html/body/div[2]/div[2]/form/div[2]/div[1]/ul/li[4]/a";
    final static String xidProdVarCreateVarinatBTN = "productTabsForm:tabViewId:createVariantButton";
    final static String xidProdVarCreateVarName = "createVariantForm:createVariantName";
    final static String xidProdVarCreateVarBaseName = "createVariantForm:createVariantBaseName";
    final static String xidProdVarCreateVarSKU = "createVariantForm:createVariantCode";
    //var propertyies
    final static String xProdVarCreateColor = "html/body/div[23]/div[2]/form/table[2]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input";
    final static String xProdVarCreateColorSelector = "html/body/div[23]/div[2]/form/table[2]/tbody/tr/td/div/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/span/button";
    final static String xProdVarCraeteColorSelectorColor = "html/body/div[27]/div[4]/input";
    final static String xProdVarCreateSize = "html/body/div[23]/div[2]/form/table[2]/tbody/tr/td/div/div/table/tbody/tr[2]/td[2]/input";
    final static String xProdVarCreateGroup = "html/body/div[23]/div[2]/form/table[2]/tbody/tr/td/div/div/table/tbody/tr[3]/td[2]/input";
    final static String xidProdVarCreateCREATEBUTN = "createVariantForm:createVariantButtonId";
    final static String xProdVarOPENbtn = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[4]/table[1]/tbody/tr[2]/td/div/div/div/div/div[1]/table/tbody/tr/td[7]/table/tbody/tr/td[1]/a/img";
    //remove assets
    final static String xProdREMOVEasset = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[3]/div/table/tbody/tr[1]/td[1]/div/div/ul/li[1]/table/tbody/tr/td[2]/a";
    final static String xProdREMOVEassetCONFIRM = "html/body/div[18]/div[2]/form/button[1]";
    final static String xProdREMOVEasset2 = "html/body/div[2]/div[2]/form/div[2]/div[2]/div[3]/div/table/tbody/tr[1]/td[1]/div/div/ul/li/table/tbody/tr/td[2]/a";


}
