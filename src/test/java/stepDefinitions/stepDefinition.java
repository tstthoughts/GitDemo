package stepDefinitions;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {
	
	
		@Given("^Validate the browser$")
	    public void validate_the_browser() throws Throwable {
			System.out.println("Validate the browser");
	    }
	
	    @When("^Browser is triggered$")
	    public void browser_is_triggered() throws Throwable {
	    	System.out.println("Browser is triggered");
	    }
	
	    @Then("^Browser started$")
	    public void browser_started() throws Throwable {
	    	System.out.println("Browser started");
	    }

	 	@Given("^User is on landing page$")
	    public void user_is_on_landing_page() throws Throwable {
	       System.out.println("User is on landing page");
	    }

	    @When("^User login to application for username and password$")
	    public void user_login_to_application_for_username_and_password() throws Throwable {
	    	System.out.println("User login to application with username and password");
	    }
	    
	    @When("^User login to application using \"([^\"]*)\" and \"([^\"]*)\"$")
	    public void user_login_to_application_using_something_and_something(String strArg1, String strArg2) throws Throwable {
	    	System.out.println(strArg1);
	        System.out.println(strArg2);
	    }
	    
	    @When("^User singup with following details$")
	    public void user_singup_with_following_details(DataTable data) throws Throwable {
	        List<List<String>> obj = data.asLists();
	        System.out.println(obj.get(0).get(0));
	        System.out.println(obj.get(0).get(1));
	        System.out.println(obj.get(0).get(2));
	    }
	    
	    @When("^User login to application with (.+) and (.+)$")
	    public void user_login_to_application_with_and(String username, String password) throws Throwable {
	    	System.out.println(username);
	    	System.out.println(password);
	    	
	    }

	    @Then("^home page is populated$")
	    public void home_page_is_populated() throws Throwable {
	    	System.out.println("home page is populated");
	    }

	    @And("^cards are displayed$")
	    public void cards_are_displayed() throws Throwable {
	    	System.out.println("cards are displayed");
	    }
	    
	    @And("^cards are not displayed$")
	    public void cards_are_not_displayed() throws Throwable {
	    	System.out.println("cards are not displayed");
	    }
	
}
