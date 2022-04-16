package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.DriverListner;

public class DriverFactory {
	
	
	public WebDriver  driver;
	public static ThreadLocal <WebDriver>tlDrvier = new ThreadLocal<WebDriver>();
	
	
	private DriverFactory() {
		
	}
	
	private static class ObjectHOLDER{
		private static final DriverFactory driverObj = new DriverFactory();
	}
	
	public static DriverFactory getInstance() {
		return ObjectHOLDER.driverObj;
	}
	
	public void initDriver(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			tlDrvier.set(driver);
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			tlDrvier.set(driver);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	public static  synchronized WebDriver getDriver() {
		return tlDrvier.get();
	}
	
	public static  EventFiringWebDriver getEventDriver() {
		EventFiringWebDriver eDriver = new EventFiringWebDriver(tlDrvier.get());
		DriverListner listner = new DriverListner();
		eDriver.register(listner);	
		return eDriver;
	}

}
