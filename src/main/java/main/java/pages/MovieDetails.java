package main.java.pages;

import java.io.FileNotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MovieDetails extends BasePage 
{
    	
		@FindBy(css="[id = 'titleCast']")
		WebElement cast_list;
		@FindBy(css="[id = 'titleStoryLine']")
		WebElement plot;
    
        public MovieDetails() {
            PageFactory.initElements(driver, this);
        }
        
        public boolean getCastList() throws FileNotFoundException
        {
            System.out.println(cast_list.getText());
//            js.executeScript("arguments[0].scrollIntoView(true);", cast_list);
            if (cast_list.isDisplayed()) {
            return true;
        }
            else{
            return false;
        }
        }

        public boolean getPlotSummary()
        {
            System.out.println(plot.getText());
//            js.executeScript("arguments[0].scrollIntoView(true);", plot);
            if (plot.isDisplayed())
            {
                return true;
            }
            else{
                return false;
            }
        }
}
