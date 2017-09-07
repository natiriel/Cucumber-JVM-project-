package cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:report/"},
		features = {"src/features/"},
		glue = {"features", "stepDefs"}
		)
public class CucumberRunner {
	
}
