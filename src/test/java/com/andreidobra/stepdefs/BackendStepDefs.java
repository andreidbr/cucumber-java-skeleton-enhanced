package com.andreidobra.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class BackendStepDefs {

  //  Using class-level field since you can't share data from one step to the other
  Response currentResponse;

  @When("User/I successfully log(s) in")
  public void logInSuccessfully() {
    currentResponse = RestAssured
        .get("https://httpbin.org/uuid")
        .then()
        .assertThat()
        .statusCode(200)
        .extract().response();
    System.out.println(currentResponse.asPrettyString());
  }

  @Then("A unique user ID is assigned of length {int}")
  public void checkUUIDLength(int length) {
    String returnedUUID = currentResponse.path("uuid");
    Assertions.assertEquals(length, returnedUUID.length(),
        "Expected returned UUID to have length of: " + length);
  }

}
