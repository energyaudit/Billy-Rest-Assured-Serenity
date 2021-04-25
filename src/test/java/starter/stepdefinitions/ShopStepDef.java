package starter.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class ShopStepDef {
    static Integer budget;
    @Given("^I have (\\d+) in my wallet$")
    public void iHaveInMyWallet(int money) {
        budget = money;
    }

    @When("^I buy milk with (\\d+)$")
    public void iBuyMilkWith(int price) {
        budget -= price;
    }

    @Then("^I should have (\\d+) in my wallet$")
    public void iShouldHaveInMyWallet(int finalBudget) {
        assertEquals(budget.intValue(), finalBudget);
    }

    @When("^I buy rice with (\\d+)$")
    public void iBuyRiceWith(int price) {
        budget -= price;
    }
}
