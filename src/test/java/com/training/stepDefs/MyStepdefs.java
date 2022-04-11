package com.training.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {

    @Given("Text")
    public void textInString() {
    }

    @When("Read the text")
    public void readTheText() {
    }

    @Then("Print Hello Cucumber")
    public void printHelloCucumber() {
        System.out.println("Hello Cucumber");
    }

}
