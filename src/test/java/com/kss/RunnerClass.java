package com.kss;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "src/test/java/com/kss"
}, glue = "step_definitions",
   dryRun = false,
   tags = {"@get_pets,@add_pets,@add_vets"}
   )
public class RunnerClass {
    public RunnerClass(){

    }
}
