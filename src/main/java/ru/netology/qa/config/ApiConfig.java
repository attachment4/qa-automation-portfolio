package ru.netology.qa.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class ApiConfig {

    public static final String API_KEY = System.getenv("REQRES_API_KEY");

    public static void setup() {
        String apiKey = System.getenv("REQRES_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            apiKey = "free_user_3D8MrbtBeMXE4jih8xpKF7hQNTG"; // для локального запуска
        }

        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("x-api-key", apiKey)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}