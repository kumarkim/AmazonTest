package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.SearchPage;
import io.cucumber.java.en.Then;

public class SearchPageSteps
{
	
	private Logger logger = LogManager.getLogger();
	
	WebDriver driver = DriverFactory.getDriver();
	EventFiringWebDriver edriver = DriverFactory.getEventDriver();
	private SearchPage searchPage = new SearchPage(edriver); 

	@Given("user is on amazon search Page")
	public void user_is_on_amazon_search_page() {
		logger.info("User is on amazon search page");
		edriver.get("https://www.amazon.in/");

	}

	@When("user types {string} on the search box")
	public void user_types_on_the_search_box(String searchItem) {
		searchPage.searchFor(searchItem);

	}

	@When("User clicks on search")
	public void user_clicks_on_search() {
		searchPage.clickOnSearch();

	}

	@Then("The book {string} by {string} is displayed")
	public void the_book_by_is_displayed(String name, String author) {
		
	}
	
	@Then("User clicks on the searched Item")
	public void user_clicks_on_the_searched_item() {
		searchPage.clickOnSearchedItem();
	}
}
