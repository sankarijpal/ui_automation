package com.stepdefination;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
    private com.base.testContext testContext;

    public Hooks(com.base.testContext testContext) {
        this.testContext=testContext;
    }

    @After
    public void tearDown(Scenario scenario) throws Exception{
        try {
            testContext.getWebDriverManager().getScreenshot(scenario,testContext.getTestConfiguration().getUdid());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try {
            testContext.getWebDriverManager().quitDriver();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
