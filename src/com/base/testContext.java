package com.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class testContext {
    private driverManager webDriverManager;
    private com.base.pageObjectManager pageObjectManager;
    private com.base.testConfiguration testConfiguration;
    private Logger logger;

    public testContext() throws Exception {
        testConfiguration = new testConfiguration();
        webDriverManager = new driverManager(testConfiguration);
        pageObjectManager = new pageObjectManager(webDriverManager.createDriver(), testConfiguration);
        logger = LogManager.getLogger();
    }

    public com.base.testConfiguration getTestConfiguration() {
        return testConfiguration;
    }
    public driverManager getWebDriverManager() {
        return webDriverManager;
    }
    public com.base.pageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
    public Logger getLogger() {
        return logger;
    }

}