package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\Ebanking_PrimusBankAutomation\\ApiTesting\\RFB_CucumberBDD\\src\\feature\\Login.feature", glue = "stepDefinition",monochrome=true)
public class Sample {

}
