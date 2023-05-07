package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="./src/test/resources/features",
		glue="step_definitions",
<<<<<<< HEAD
		tags="@editCustomer"
=======
		tags="@forgotPasswordErrorMsgs "
>>>>>>> 12587bcae34ec7f3cc4a98e5599f4f2b066d5ba8
		)
public class TestRunner {

}

