package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/test/resources/Features",
            glue = "APIStepDefinitions",
            dryRun = false,
            tags = " @updateemployee",
            plugin = {"pretty", "html:target/Cucumber.html","json:target/Cucumber.json"}
    )// you can tag either one tag or multiple tags depends on how many test


    public class APIRunner {

    }

