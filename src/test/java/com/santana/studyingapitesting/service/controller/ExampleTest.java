package com.santana.studyingapitesting.service.controller;

import com.santana.studyingapitesting.service.base.ServiceTestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ExampleTest extends ServiceTestBase {
    public String prefix = "/v2/..";

    @Test
    public void example_test (){
        given().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                when().
                body(username).
                post(prefix).
                then().
                statusCode(200);
    }
}
