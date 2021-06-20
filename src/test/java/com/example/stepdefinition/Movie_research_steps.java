package com.example.stepdefinition;
import io.cucumber.java.en.*;
import main.java.pages.BasePage;
import main.java.pages.HomePage;
import main.java.pages.MovieDetails;
import main.java.pages.YamlReader;

import java.io.FileNotFoundException;

import org.junit.Assert;
public class Movie_research_steps extends BasePage 
{
	public YamlReader yamlread = new YamlReader();
	public HomePage home_page = new HomePage();
	public MovieDetails details = new MovieDetails();
	
	@Given("^I open imdb website on browser$")
	public void i_open_imdb_website_on_browser() 
	{

		Assert.assertTrue(driver.getTitle().contains(yamlread.yamlReader("web_name")));
	}
	
	
	@When ("^I enter search value in search bar$")
	public void i_enter_search_value_in_search_bar() throws FileNotFoundException
	{
		home_page.submitSearchValue();
		
	}
	
	 @Then("I get the related suggestion list according to search value \"([^\"]*)\"$")
	 public void i_get_the_related_suggestion_list_according_to_search_value(String suggestionValue) throws Throwable
	 {	System.out.println(suggestionValue);
		Assert.assertTrue("Movie name not found", home_page.verifySuggestionList(suggestionValue));
	}
	
	
	@And ("^I select a suggestion from the suggestion list$")
	public void i_select_a_suggestion_from_the_suggestion_list()
	{
		home_page.selectSuggestionFromList();
	}
	
	@Then ("^I get navigated to the selected suggestion page$")
	public void i_get_navigated_to_the_selected_suggestion_page() throws FileNotFoundException
	{
		Assert.assertTrue("User is navigated to wrong page",driver.getTitle().contains(yamlread.yamlReader("search value")));
	}
	
	@And ("^I get the plot of the searched value$")
	public void i_get_the_plot_of_the_searched_value()
	{
		Assert.assertTrue("Plot not found",details.getPlotSummary());
		
	}
	
	@And ("^I get the cast of the searched value$")
	public void i_get_the_cast_of_the_searched_value() throws FileNotFoundException
	{
		Assert.assertTrue("Cast not found",details.getCastList());
		
	}
}
