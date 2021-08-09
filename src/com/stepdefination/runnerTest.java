package com.stepdefination;


import io.cucumber.core.options.RuntimeOptions;
import io.cucumber.tagexpressions.Expression;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CucumberOptions(
        features = "resources/feature",
        glue = {"/src/com/stepdefination/","com.pages","com.stepdefination"},
        plugin = { "pretty", "json:target/cucumberDefault.json" },
        monochrome = true,
        dryRun = false
)
public class runnerTest extends AbstractTestNGCucumberTests {

    private String dateString;

    public static final boolean test = false;

    @Override
    @DataProvider(parallel = test)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
