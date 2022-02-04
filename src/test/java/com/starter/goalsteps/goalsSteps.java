package com.starter.goalsteps;

import com.starter.baseTest.baseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class goalsSteps extends baseTest {
    @Given("I am create user")
    public void iAmCreateUser() {
    }

    @When("I am set body request sign")
    public void iAmSetBodyRequestSign() {
        goals.setRequestBody();
    }

    @And("I am hit endpoint signup")
    public void iAmHitEndpointSignup() {
        goals.hitEndpointSignup();
    }

    @Then("I am get a status code {int}")
    public void iAmGetAStatusCode(int statuscode) {
        goals.validateEndpoint(statuscode);
    }

    @And("validate success signup")
    public void validateSuccessSignup() {
        goals.jsonschmeEndpointGoals();
    }

    @And("I am hit endpoint get user")
    public void iAmHitEndpointGetUser() {
        goals.hitEndpointGetUser();
    }

    @And("validate success get user")
    public void validateSuccessGetUser() {
        goals.jsonschmeEndpointGoals();
    }

    @And("I am hit endpoint edit user")
    public void iAmHitEndpointEditUser() {
        goals.hitEndpointEditUser();
    }

    @And("validate success edit user")
    public void validateSuccessEditUser() {
        goals.jsonschmeEndpointGoals();
    }

    @And("I am hit endpoint delete user")
    public void iAmHitEndpointDeleteUser() {
        goals.hitEndpointDeleteUser();
    }
}
