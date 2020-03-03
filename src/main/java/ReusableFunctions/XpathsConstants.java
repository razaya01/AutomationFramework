package ReusableFunctions;

import org.openqa.selenium.By;

public class XpathsConstants {
 
	//***********************************allocation xpaths***************************************
	public static String BQUK_ALLOCATION_ORDER_BUTTON = "//a[contains(text(),'Stock allocation')]";
    public static String AFA_STOCK_ALLOCATION_ORDER = "//*[@id='tabs-collection-orders']/section/div[1]/p/span/strong";
    public static String AFA_ORDER_NUMBER_ALLOCATION ="//table[@class='tablesorter table-align-middle form stockTable js-allocate-stock stickyHeader tablesorter-default']/tbody/tr[1]/td[1]/strong";
    public static String AFA_ALLOCATE_STOCK = "//table[@class='tablesorter table-align-middle form stockTable js-allocate-stock stickyHeader tablesorter-default']/tbody/tr[1]/td[10]/a";
    public static String AFA_PICKING = "//input[@value='Picking']";
    public static String AFA_PICKED_QTY = "(//input[@data-header='picked-qty'])[3]";
    public static String BQUK_STOCK_ALLOCATION_MANUAL_PICKING_BUTTON  = "//*[@value='Manually allocate stock']";
    public static String AFA_CHECK_ITEM_BUTTON = "//*[@id='uniform-chk-item']/span";
    public static String BQUK_STOCK_ALLOCATION_PROCESS_ALLOCATION = "//input[@value='Process allocation']";
    public static String AFA_FINISH_DROPDOWN = "//select[@id='finish-dropdown']";
    public static String AGENT_DROPDOWN = "//select[@id='agent-dropdown']";
    public static String SIGN_BACK = "//input[@value='Sign Back In']";
    public static String BQUK_COMPLETE_COLLECTION_YES_BUTTON = "/html/body/div[2]/div[2]/div/form/div/input[2]";
    //*************************************collection xpaths*****************************************
    public static String BQUK_MAINPAGE_STOCK_COLLECTION_DELIVERY_LINK = "//a[@data-title='Store collection']";
    public static String BQUK_STORE_COLLECTION_ORDER_NUMBER_INPUT = "//input[@class='form-med js-validator_digits js-order-search js-validator_order-search']";
    public static String BQUK_STORE_COLLECTION_FIND_BUTTON = "//input[@class='btn btn-primary' and @value='Find']";
    public static String BQUK_STORE_COLLECTION_PROCESS_COLLECTION_BUTTON = "//a[contains(@class,'btn btn-primary js-confirm-collection')]|//a[contains(text(),'Process collection')]";
    public static String BQUK_STORE_COLLECTION_PAYMENT_VERIFIED_BUTTON = "//input[@class='btn btn-primary pull-right js-payment-verification' and @id='verified']";
    public static String BQUK_STORE_COLLECTION_COLLECTOR_NAME_INPUT = "//input[@class='form-medium js-validator_alphanumeric js-collector-name']";
    public static String BQUK_STORE_COLLECTION_ID_SHOWN_DROPDOWN = "//select[@class='tertiary js-idshown-drpdwn' and @name='idshown']";
    public static String AFA_CONFIRM_COLLECTION = "//input[@value='Confirm & Collect']";
    public static String BQUK_FINISH_CUSTOMER_COLLECTION_PAGE = "//input[@type='submit' and @value='Finish with this customer']";
    public static String BQUK_COLLECTION_CONTINUE_BUTTON = "//input[@class='btn btn-primary pull-right js-complete-refund']";
    public static String AFA_PROCEED_CHECKOUT = "//input[@class='btn js-proceed-checkout-btn x2']";
    public static String AFA_REFUND_PLACE_ORDER = "(//input[@class='btn btn-primary pull-right js-modal-place-order'])[1]";
    public static String BQUK_FINISH_CUSTOMER_NEW = "//input[@type='submit' and @value='Finish with customer']";
    //************************************BASIC AFA XPATHS UPTO BASKET PAGE*****************************
    public static String BQUK_PROCESS_COLLECTION_MODEL = "//div[@class='modal-container']";
    public static String AGENT_PASSWORD = "//input[@id='pwd']";
    public static String VALIDER = "//input[@id='confirmLocation']";
    public static String CONTINUER = "//input[@value='Continuer']|//input[@value='Continue']";
    public static String STATUS = "//*[@id='tabs-c-c1010478728']/div[2]/form/div[2]/table/tbody/tr/td[7]";
    public static String USER_ID="//input[@id='form1']";
    public static String SIGN_IN="//input[@name='/kf/csc/navigation/formhandler/AgentLoginFormHandler.login']";
    public static String ACTION_BUTTON="//select[@id='findview-action-select']";
    public static String CUSTOMER_TEXTBOX="//input[@id='details']";
    public static String CUSTOMER_SEARCH_BUTTON=" //input[@type='submit' and @data-title='Customer']";
    public static String PRODUCT_BUTTON_BQUK="//a[contains(text(),'Products')]";
    public static String PRODUCT_BUTTON_BDFR="//a[contains(text(),'Produits')]";
    public static String EAN_SEARCHBOX="//input[@id='quickbuy-search-product']"; 
    public static String EAN_SEARCH_BUTTON="//input[@id='findview-search-submit']";
    public static String PROCEED_BASKET="//input[@id='proceed-basket']";
    public static String PAYER="//input[@class='js-isPurchaseBasketOpen' and @value='true']//following-sibling::input";
    public static String INCOMPLETE_ADDRESS="//span[contains(text(),'Informations incomplètes')] ";
    public static String EDIT_CONTACT_NAME="//input[@id='edit-contact-name']";
    public static String EDIT_LAST_NAME="//input[@id='edit-last-name']";
    public static String ADD_LINE1="//input[@id='addr-line1']";
    public static String SCROLL_DOWN = "//div[@class='modal-container']//following-sibling::a[2]";
    public static String EDIT_MOBILE_NUMBER="//input[@id='edit-contact-num']";
    public static String EDIT_SUBMIT="//div[@id='show-button-edit']//following-sibling::input";
    public static String DELIVERY_ADDRESS_VALIDATION="//dd[@class='w275']";
    public static String SELECT_STORE =  "//a[text()='Select store']";
    public static String SELECT_STORE_TEXTBOX = "//input[@id='find-store']";
    public static String SELECT_STORE_SUBMIT = "//input[@class='btn btn-search store-locator-submit']";
    public static String SELECT_FIRST_STORE = "//input[@name='selectCCStore' and @data-storeid='BQ_BAI154']";
    public static String PLACE_ORDER = "//input[@class='btn btn-secondary js-return-basket' and @value='Save and return to basket']//following-sibling::input";
    public static String SAP_ORDER_ID = "//dd[@id='sapOrderId']";
    public static String PROFILE_ID_TEXTBOX = "//input[@name='/kf/tools/states/ManualMessageSenderFormHandler.profileId' and @type='text']";
    public static String PROFILE_ID_SUBMIT = "//input[@name='/kf/tools/states/ManualMessageSenderFormHandler.profileId' and @type='submit']";
    public static String NEW_STATE = "//select[@name='/kf/tools/states/ManualMessageSenderFormHandler.newState']";
    public static String UPDATE_ALL_ITEM = "//input[@name='/kf/tools/states/ManualMessageSenderFormHandler.dispatchMessage']";
    public static String PRODUCT_TAB = "//span[text()='Products']";
    public static String SEND_COLLECTION_REMINDERS = "//a[text()='sendCollectionReminders']";
    public static String INVOKE_METHOD = "//input[@value='Invoke Method']";
    public static String EXPIRE_ORDER_CHECK = "//input[@id='expired' and @name='allocationDetailedFilter']";
    public static String EXPIRE_ORDER_SEARCH = "//input[@value='Search']";
 
  
  
    
    
    
    
    

   //*****************************JENKINS LOGIN AND OPERATIONS XPATHS***************************************************************
    public static String LOGIN_BUTTON="//*[contains(text(),'log in')]";
    public static String USERID="//input[@id='j_username']";
    public static String PASSWORD="//input[@name='j_password']";
    public static String JENKINS_SIGNIN="//button[contains(text(),'log in')]";
    public static String FAILED_CONSOLE_STATUS=" //img[@alt='Failed > Console Output']";
    public static String PASSED_CONSOLE_STATUS="//img[@alt='Success > Console Output']";
    
    
    
    
    
    
   

  
   
    
}
