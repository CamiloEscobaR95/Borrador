package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/youtube.feature",
        glue = "definitions",
        tags="@CP_002",
        snippets = SnippetType.CAMELCASE
        //plugin = "json:target/cucumber_report.json"
)
public class Runner {
}
