package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/main/resources/parallel/seacrhPage.feature"},
		glue = {"stepDefinition", "AppHooks"},
		plugin = {"pretty"},
		monochrome = true,
		dryRun = false
		)
public class BDDRunnerTest {

}
