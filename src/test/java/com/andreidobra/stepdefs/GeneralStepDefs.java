package com.andreidobra.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public class GeneralStepDefs {

  Scenario currentScenario;

  String currentScenarioName;

  int numberOfScenarios;

  @Before("@ReadScenarioName")
  public void initializeCurrentScenario(Scenario scenario) {
    currentScenario = scenario;
  }

  @When("I read the current scenario name")
  public void readCurrentScenarioName() {
    currentScenarioName = currentScenario.getName();
    System.out.println("Set current scenario name as: " + currentScenarioName);
  }

  @Then("I should find the following words")
  public void checkScenarioNameForWords(List<String> expectedWords) {
    System.out.println(expectedWords);
    for (String word : expectedWords) {
      Assertions.assertTrue(currentScenarioName.contains(word));
    }
  }

  @Given("I have {int} scenarios")
  public void setNumberOfScenarios(int scenarioCount) {
    numberOfScenarios = scenarioCount;
  }

  @When("I perform the following operations")
  public void performListOfScenarioOperations(List<List<String>> listOfOperations) {
    for (List<String> operation : listOfOperations) {
      System.out.println(operation);
      performScenarioOperation(operation.get(0), operation.get(1));
    }
  }

  @When("I perform the following operations with headers")
  public void performMapOfScenarioOperations(List<Map<String, String>> mapOfOperations) {
    for (Map<String, String> operation : mapOfOperations) {
      System.out.println(operation);
      performScenarioOperation(operation.get("operation"), operation.get("count"));
    }
  }

  @Then("I should have {int} scenarios")
  public void checkNumberOfScenarios(int expectedNumber) {
    Assertions.assertEquals(numberOfScenarios, expectedNumber,
        "Number of expected scenarios doesn't match actual");
  }

  private void performScenarioOperation(String operation, String count) {
    switch (operation) {
      case "add" -> numberOfScenarios += Integer.parseInt(count);
      case "subtract" -> numberOfScenarios -= Integer.parseInt(count);
      default -> throw new UnsupportedOperationException(
          "Unable to perform specified operation");
    }
  }

}
