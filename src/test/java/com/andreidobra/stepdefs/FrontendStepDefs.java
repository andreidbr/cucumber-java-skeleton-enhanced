package com.andreidobra.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrontendStepDefs {

  protected WebDriver driver;

  @Before("@ui")
  public void startUiSetup() {
    System.out.println("Starting UI scenario setup");
  }

  @After("@ui")
  public void quitDriver() {
    driver.quit();
    System.out.println("Completed UI scenario teardown");
  }

  @Given("User opens {string} browser")
  public void openSpecificBrowser(String browserName) {
    switch (browserName) {
      case "Chrome" -> driver = new ChromeDriver();
      case "Firefox" -> driver = new FirefoxDriver();
      default -> throw new UnsupportedOperationException("Unsupported browser provided");
    }
  }

  @When("User navigates to {string}")
  public void navigateToUrl(String url) {
    driver.get(url);
  }

  @Then("the title of the page should be {string}")
  public void checkPageTitleToBe(String expectedTitle) {
    String actualTitle = driver.getTitle();
    Assertions.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle),
        "Expected title does not match actual title");
  }

}
