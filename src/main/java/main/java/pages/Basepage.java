package main.java.pages;


import java.util.Properties;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasePage {

	public static WebDriver driver;
	public static Properties prop;
	public static  String directorypath = System.getProperty("user.dir");
	public static String url;
//	JavascriptExecutor js = (JavascriptExecutor) driver;
}

