package AppHooks;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import factory.DriverFactory;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;
import util.DriverListner;

/*
 * just like base Test class in testNG
 * 
 */
public class ApplicationHooks {

	ConfigReader config;
	Properties prop;
	private Logger logger = LogManager.getLogger();

	DriverFactory dFactory = DriverFactory.getInstance();
	static WebDriver driver;
	static EventFiringWebDriver eDriver;

	@Before(order = 0)
	public void getProperty() {
		config = new ConfigReader();
		prop = config.initProperties();
	}

	@Before(order = 1)
	public void launchBrowser() {

		String browser = prop.getProperty("browser");
		dFactory.initDriver(browser);
		eDriver =dFactory.getEventDriver();
		driver = DriverFactory.getDriver();
	}


	@After(order = 1)
	public void quitBrowser() {
		// driver.quit();
	}

	// screenshot taken as bytes because in jenkins it will not take file as the
	// ouput.
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot
			String name = scenario.getName().replaceAll(" ", "_");
			byte[] screenshotPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotPath, "image/png", name);
		}
	}
}
