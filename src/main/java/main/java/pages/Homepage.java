package main.java.pages;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Basepage {
    Yamlreader yamlread=new Yamlreader();
    @FindBy(id = "suggestion-search")
	WebElement searchbox;

    public Homepage() {
		PageFactory.initElements(driver, this);
	}
    
    public void submit_search_value() throws FileNotFoundException
    {
        searchbox.click();
        searchbox.sendKeys(yamlread.yamlreader("search value"));
    }
    
    public Boolean verify_suggestion_list()
    {
    	Boolean condition = false;
    	List<WebElement> myElements = driver.findElements(By.cssSelector("[class=\"searchResults__ResultTextItem-sc-1pmqwbq-2 lolMki _26kHO_8bFBduUIYADnVHFY\"]"));
    	for(WebElement e : myElements) {
    		String movie_name =  e.getText();
    		if (movie_name.contains("Conjuring")) {
    			System.out.println(movie_name);
    			condition = true;	
    		}
    	}
    	return condition;
    }

    public void select_suggestion_from_list() {
    	List<WebElement> myElements = driver.findElements(By.cssSelector("[class=\"searchResults__ResultTextItem-sc-1pmqwbq-2 lolMki _26kHO_8bFBduUIYADnVHFY\"]"));
    	for(WebElement e : myElements) {
    		String movie_name =  e.getText();
    		if (movie_name.equalsIgnoreCase(yamlread.yamlreader("search value"))) {
    			e.click();
    			System.out.println(movie_name+"is selected");
    			break;
    		}
    	}
    	
    }
    
    }

