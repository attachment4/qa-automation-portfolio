package ru.netology.qa.api;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.qa.config.ApiConfig;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Feature("Users API")
public class UserApiTest {

    @BeforeAll
    static void setup() {
        ApiConfig.setup();
    }

    @Test
    @Description("Получить пользователя по ID — статус 200 и корректный email")
    void getUserById() {
        given()
                .when()
                .get("/users/2")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", notNullValue());
    }

    @Test
    @Description("Создать нового пользователя")
    void createUser() {
        String body = """
            {
                "name": "Ivan",
                "job": "QA Engineer"
            }
            """;

        given()
                .contentType("application/json")
                .body(body)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("Ivan"))
                .body("id", notNullValue());
    }

    @Test
    @Description("Несуществующий пользователь — статус 404")
    void getUserNotFound() {
        given()
                .when()
                .get("/users/9999")
                .then()
                .statusCode(404);
    }
}