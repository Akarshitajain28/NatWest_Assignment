package com.example.stepdefinition;
import io.cucumber.java.en.*;
import main.java.pages.Basepage;
import main.java.pages.Homepage;
import main.java.pages.Movie_details;
import main.java.pages.Yamlreader;

import java.io.FileNotFoundException;

import org.junit.Assert;
public class Movie_research_steps extends Basepage 

{	public Yamlreader yamlread = new Yamlreader();
	public Homepage home_page = new Homepage();
	public Movie_details details = new Movie_details();

	
	@Given("^User open imdb website on browser$")
	public void user_open_imdb_website_on_browser() {
		
		System.out.println(prop.getProperty("URL"));
		driver.get(prop.getProperty("URL"));
		Assert.assertTrue(driver.getTitle().contains("IMDb"));
	}
	
	
	@When ("^User enter search value in search bar$")
	public void user_enter_search_value_in_search_bar() throws FileNotFoundException
	{
		home_page.submit_search_value();
		
	}
	
	@Then ("^User get the related suggestion list$")
	public void user_get_the_related_suggestion_list()
	{
		Assert.assertTrue("Movie name not found", home_page.verify_suggestion_list());
	}
	
	
	@And ("^User select a suggestion from the suggestion list$")
	public void user_select_a_suggestion_from_the_suggestion_list()
	{
		home_page.select_suggestion_from_list();
	}
	
	@Then ("^User get navigated to the selected suggestion page$")
	public void user_get_navigated_to_the_selected_suggestion_page() throws FileNotFoundException
	{
		Assert.assertTrue("User is navigated to wrong page",driver.getTitle().contains(yamlread.yamlreader("search value")));
	}
	
	@And ("^User get the plot of the searched value$")
	public void user_get_the_plot_of_the_searched_value()
	{
		Assert.assertTrue("Plot not found",details.get_plot_summary());
		
	}
	
	@And ("^User get the cast of the searched value$")
	public void user_get_the_cast_of_the_searched_value() throws FileNotFoundException
	{
		Assert.assertTrue("Cast not found",details.get_cast_list());
		
	}
}
