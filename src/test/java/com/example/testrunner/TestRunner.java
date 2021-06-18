package com.example.testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\Features\\movie_search_research.feature", glue= {"com.example.stepdefinition"})
public class TestRunner {
    
}
