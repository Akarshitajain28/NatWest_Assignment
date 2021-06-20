package main.java.pages;

import java.io.FileNotFoundException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    YamlReader yamlread=new YamlReader();
    @FindBy(id = "suggestion-search")
	WebElement searchbox;
    @FindBy(css = "div.searchResults__ResultTextContainer-sc-1pmqwbq-1.khRmvD div")
    List<WebElement> myElements;

    public HomePage() {
	PageFactory.initElements(driver, this);
	}
    
    public void submitSearchValue() throws FileNotFoundException
    {
        searchbox.click();
        searchbox.sendKeys(yamlread.yamlReader("search value"));
    }
    
    public Boolean verifySuggestionList(String suggestionValue)
    {
    	Boolean condition = false;
    	for(WebElement e : myElements) {
    		String movie_name =  e.getText();
    		if (movie_name.contains(suggestionValue)) {
    			System.out.println(movie_name);
    			condition = true;
    		}
    	}
    	return condition;
    }

    public void selectSuggestionFromList() {
    	for(WebElement e : myElements) {
    		String movie_name =  e.getText();
    		if (movie_name.equalsIgnoreCase(yamlread.yamlReader("search value"))) {
    			e.click();
    			System.out.println(movie_name+" is selected ");
    			break;
    		}
    	}
    	
    }
    
    }

