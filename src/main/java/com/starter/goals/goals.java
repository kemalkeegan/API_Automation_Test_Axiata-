package com.starter.goals;

import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;

import com.starter.base.baseEndpoint;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class goals {
    baseEndpoint endpoint = new baseEndpoint();
    JSONObject requestparams;
    int id;

    //define request params
    public void setRequestBody() {
        requestparams = new JSONObject();
        requestparams.put("name", "hassimi");
        requestparams.put("email", "hassimi6@axiata.id");
        requestparams.put("gender", "male");
        requestparams.put("status", "inactive");

        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 80ba489c049ae343f21a74049f7cc3574a5fa361b6930ab8de1ca9dcf2a301d5")
                .body(requestparams.toString());
    }

    public void hitEndpointSignup() {
        SerenityRest
                .when()
                .post(endpoint.User)
                .then()
                .statusCode(201);

        id = SerenityRest
                .then()
                .extract()
                .path("data.id");
    }

    public void validateEndpoint(int statuscode) {
        SerenityRest
                .then()
                .statusCode(statuscode);
    }

    public void hitEndpointGetUser() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer 80ba489c049ae343f21a74049f7cc3574a5fa361b6930ab8de1ca9dcf2a301d5")
                .when()
                .get(endpoint.User + id)
                .then()
                .statusCode(200);
    }

    public void hitEndpointEditUser() {
        requestparams = new JSONObject();
        requestparams.put("name", "hassimi");
        requestparams.put("email", "hassimi6@axiata.id");
        requestparams.put("gender", "male");
        requestparams.put("status", "inactive");

        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer d80ba489c049ae343f21a74049f7cc3574a5fa361b6930ab8de1ca9dcf2a301d5")
                .body(requestparams.toString())
                .when()
                .put(endpoint.User + id)
                .then()
                .statusCode(200);
    }

    public void hitEndpointDeleteUser() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer 80ba489c049ae343f21a74049f7cc3574a5fa361b6930ab8de1ca9dcf2a301d5")
                .when()
                .delete(endpoint.User + id)
                .then()
                .statusCode(204);
    }

    //valdate JSONSchema Delete User who currently login
    public void jsonschmeEndpointGoals() {
        SerenityRest
                .then()
                .body(matchesJsonSchemaInClasspath("JSONSchema/goals.json"));
    }
}