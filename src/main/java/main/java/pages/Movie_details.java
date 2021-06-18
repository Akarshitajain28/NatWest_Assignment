package main.java.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Movie_details extends Basepage {
    
        
    
        public Movie_details() {
            PageFactory.initElements(driver, this);
        }
        
        public boolean get_cast_list() throws FileNotFoundException
        {
        	WebElement cast_list = driver.findElement(By.cssSelector("[id = 'titleCast']"));
            System.out.println(cast_list.getText());
            if (cast_list.isDisplayed()) {
            return true;
        }
            else{
            return false;
        }
        }

        public boolean get_plot_summary()
        {
            
            WebElement plot = driver.findElement(By.cssSelector("[id = 'titleStoryLine']"));
            System.out.println(plot.getText());
            if (plot.isDisplayed())
            {
                return true;
            }
            else{
                return false;
            }
        }
    

}
