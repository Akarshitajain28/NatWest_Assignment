package main.java.hooks;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import main.java.pages.BasePage;

public class Hooks extends BasePage{
	
	@Before
	public  void initialization() throws IOException {
		prop = new Properties(); 
		FileInputStream file=new FileInputStream(directorypath + "\\src\\test\\resources\\config\\property.properties");
		prop.load(file);
		System.out.println(directorypath);
		String browser_Name = prop.getProperty("browser");
		System.out.println(browser_Name);
		if (browser_Name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", directorypath + "\\src\\test\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		System.out.println(prop.getProperty("URL"));
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	@After
	public void driverClose() {
		driver.quit();
	}

}
