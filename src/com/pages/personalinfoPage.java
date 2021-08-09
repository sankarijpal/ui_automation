package com.pages;

import com.base.actionMethods;
import com.base.testConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class personalinfoPage extends actionMethods {

    private WebDriver driver;
    private com.base.testConfiguration testConfig;

    public personalinfoPage(WebDriver driver, com.base.testConfiguration configuration) {
        super(driver, configuration);
        this.driver = driver;
        this.testConfig = configuration;
    }

    public synchronized void  getURL() throws Exception {
        driver.get(testConfig.getcurrentURL());
        waitForPageLoad();
    }

    public static void main(String[] args) throws Exception {
        WebDriver driver;
        WebDriverManager.chromedriver().driverVersion("90.0.4430.24").setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:58736");
        driver = new ChromeDriver(options);
        personalinfoPage obj=new personalinfoPage(driver,new testConfiguration());
    }

    private By hdrPage=By.xpath("//*[@id='header_logo']//img[@src]");
    private By btnAddToCart=By.xpath("//a[normalize-space()='Add to cart' and contains(@class,'button')]");
    private By btnProceedToCheckOut=By.xpath("//a[normalize-space()='Proceed to checkout' and contains(@class,'button')]");
    private By hdrSummary=By.xpath("//text()[normalize-space()='Summary']/..");
    private By price=By.xpath("//h5//following-sibling::div//span[contains(@class,'price') and @itemprop]/..");
    private By btnCart=By.xpath("//a[@title='View my shopping cart']");
    private By btnInstock=By.xpath("//text()[normalize-space()='In stock']/..//span");


    private String PRODUCT_PRICE;

    public void i_verify_the_home_screen_displayed() throws Exception {
        waitForVisibilityOfElement(hdrPage);
        System.out.println("Header displayed successfully.");
        Assert.assertTrue(isElementDisplayed(hdrPage),"Failed to load the Header.");
    }

    public void i_click_on_tshirt_link_verify_tshirt_page_is_displayed(String category,String item) throws Exception {
        String itmcategory=Character.toUpperCase(category.charAt(0)) + category.substring(1).toLowerCase();
        By locitem=By.xpath("//ul[not(contains(@style,'none')) and @class]/li/a[text()='"+itmcategory+"']");
        waitForVisibilityOfElement(locitem);
        click(locitem);
        By productItem=By.xpath("//img[@title='"+item+"']");
        waitForVisibilityOfElement(productItem);
        scrollDown(btnInstock);
        PRODUCT_PRICE=getText(price);
        System.out.println("---------"+PRODUCT_PRICE);
        clickUsingJavaScriptExcuter1(btnAddToCart);
    }

    public void i_click_on_proceed_to_check_out_button() throws Exception {
        waitForVisibilityOfElement(btnProceedToCheckOut);
        click(btnProceedToCheckOut);
    }

    public void i_verify_shopping_cart_summary_page_is_displayed() throws Exception {
        waitForVisibilityOfElement(hdrSummary);
        System.out.println("Header summary displayed successfully.");
        Assert.assertTrue(isElementDisplayed(hdrSummary),"Failed to load the Summary header.");
    }

    public void i_verify_whether_the_actual_order_tshirt_details_is_displayed_in_the_order_history_summary_page() throws Exception {
        By price=By.xpath("//td[@class='cart_unit']//span[@class='price' and not(@id) and normalize-space()='"+PRODUCT_PRICE+"']");
        waitForVisibilityOfElement(price);
        System.out.println("Price verified successfully.");
        Assert.assertTrue(isElementDisplayed(price),"Failed to verify the price.");
    }

    public void i_take_screenshot() throws Exception{
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
        Date date = new Date();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(".\\Test_Screenshot\\"+"Screenshot-"+""+dateFormat.format(date)+".png"));
    }

    public void iVerifyTshirtDisplayedInCart(String s) throws Exception {
        waitForVisibilityOfElement(btnCart);
        moveToElement(btnCart);
        By price=By.xpath("//div[@class='cart_block_list']//span[normalize-space()='"+PRODUCT_PRICE+"']");
        waitForVisibilityOfElement(price);
        System.out.println("Price verified successfully.");
        Assert.assertTrue(isElementDisplayed(price),"Failed to verify the price.");

        By tShirtName=By.xpath("//a[contains(@class,'_product_name') and @title='"+s+"']");
        waitForVisibilityOfElement(tShirtName);
        System.out.println("The product verified successfully under cart.");
        Assert.assertTrue(isElementDisplayed(tShirtName),"Failed to verify the product under cart.");

    }

    By inpEmailAddress=By.xpath("//*[@id='email']");
    By inpPassword=By.xpath("//*[@id='passwd']");
    By btnSignIn=By.xpath("//a[@class='login']");
    By btnMypersonalInfo=By.xpath("//a[@title='Information']");
    By btnLogin=By.xpath("//*[@id=\"SubmitLogin\"]");
    By inpLastName=By.xpath("//*[@id=\"lastname\"]");
    By inpOldPwd=By.xpath("//*[@id=\"old_passwd\"]");
    By btnSave=By.xpath("//button[@name='submitIdentity']");



    public void iLoginIntoTheApplication() throws Exception {
      waitForVisibilityOfElement(btnSignIn);
      click(btnSignIn);
      waitForVisibilityOfElement(inpEmailAddress);
      waitForVisibilityOfElement(inpPassword);
      enterValue(inpEmailAddress,"sanktestuser007@gmail.com");
      enterValue(inpPassword,"password!");
      waitForVisibilityOfElement(btnLogin);
      click(btnLogin);
    }



    public void iUpdateTheLastname(String arg0) throws Exception{
        waitForVisibilityOfElement(btnMypersonalInfo);
        click(btnMypersonalInfo);
        waitForVisibilityOfElement(inpLastName);
        clearAndEnterValue(inpLastName,arg0);
        waitForVisibilityOfElement(inpOldPwd);
        clearAndEnterValue(inpOldPwd,"password!");
        click(btnSave);
    }
}