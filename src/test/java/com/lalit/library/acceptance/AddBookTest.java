package com.lalit.library.acceptance;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},features = "src/test/resources/features/Add-Book" )
public class AddBookTest {

}
