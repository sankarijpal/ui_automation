package com.stepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class genericPageSteps {

    private com.pages.loginPage loginPage;
    private com.base.testContext testContext;
    private com.base.testConfiguration testConfiguration;

    public genericPageSteps(com.base.testContext testContext){
        this.testContext=testContext;
        testConfiguration=testContext.getTestConfiguration();
        loginPage=testContext.getPageObjectManager().getLoginPage();
    }

    @Given("^I launch the URL$")
    public void i_am_on_google_page() throws Throwable {
        loginPage.getURL();
    }


    @Given("I verify the home screen displayed")
    public void i_verify_the_home_screen_displayed() throws Exception {
        loginPage.i_verify_the_home_screen_displayed();

    }

    @Given("I Click on tshirt link , verify tshirt page is displayed")
    public void i_click_on_tshirt_link_verify_tshirt_page_is_displayed(io.cucumber.datatable.DataTable dataTable) throws Exception{
        loginPage.i_click_on_tshirt_link_verify_tshirt_page_is_displayed(dataTable.asList().get(0),dataTable.asList().get(1));
    }

    @Given("I Click on proceed to check out button")
    public void i_click_on_proceed_to_check_out_button() throws Exception{
        loginPage.i_click_on_proceed_to_check_out_button();
    }
    @Given("I verify shopping cart summary page is displayed")
    public void i_verify_shopping_cart_summary_page_is_displayed() throws Exception {
        loginPage.i_verify_shopping_cart_summary_page_is_displayed();
    }
    @Given("I verify whether the actual order tshirt details is displayed in the order history summary page")
    public void i_verify_whether_the_actual_order_tshirt_details_is_displayed_in_the_order_history_summary_page() throws Exception{
        loginPage.i_verify_whether_the_actual_order_tshirt_details_is_displayed_in_the_order_history_summary_page();
    }
    @Given("I take screenshot")
    public void i_take_screenshot() throws Exception{
        loginPage.i_take_screenshot();
    }

    @Then("I verify tshirt displayed in cart")
    public void iVerifyTshirtDisplayedInCart(io.cucumber.datatable.DataTable dataTable) throws Exception {
        loginPage.iVerifyTshirtDisplayedInCart(dataTable.asList().get(0));
    }

    @And("I login into the application")
    public void iLoginIntoTheApplication() throws Exception{
        loginPage.iLoginIntoTheApplication();
    }

    @And("I update the lastname {string}")
    public void iUpdateTheLastname(String arg0) throws Exception{
        loginPage.iUpdateTheLastname(arg0);
    }
}