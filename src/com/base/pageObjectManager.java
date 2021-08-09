package com.base;

import com.pages.loginPage;
import org.openqa.selenium.WebDriver;

public class pageObjectManager {

    public WebDriver driver;
    private com.base.testConfiguration testConfiguration;

    public pageObjectManager(WebDriver driver, com.base.testConfiguration configuration){
        this.driver=driver;
        this.testConfiguration=configuration;
    }

    private com.pages.loginPage loginPage;

    public com.pages.loginPage getLoginPage(){
        return (loginPage==null)?loginPage=new loginPage(driver,testConfiguration):loginPage;
    }
}
