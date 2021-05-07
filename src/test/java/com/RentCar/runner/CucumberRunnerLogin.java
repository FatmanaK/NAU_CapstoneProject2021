package com.RentCar.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "rerun:target/rerun.txt",
                "json:target/cucumber3.json",
                "timeline:target/timeline-report"
        },
        features = {
                "src/test/resources/features/login/Login.feature"
        },
        glue = "com/RentCar/step_definitions",
        tags = "@negative_scenario_outline",
        publish = true
)
// @with_two_columns
//@negative_login
//@negative_scenario_outline

public class CucumberRunnerLogin {
}
