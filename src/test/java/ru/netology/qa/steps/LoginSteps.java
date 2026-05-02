package ru.netology.qa.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginSteps {

    @Before
    public void setUp() {
        // Selenide сам управляет драйвером — не нужен DriverManager
        com.codeborne.selenide.Configuration.browser = "chrome";
        com.codeborne.selenide.Configuration.baseUrl = "https://www.demoblaze.com";
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Дано("я открываю главную страницу")
    public void openHomePage() {
        open("/");
    }

    @Когда("я нажимаю кнопку логина")
    public void clickLoginButton() {
        $("#login2").click();
        $("#loginusername").shouldBe(visible);
    }

    @И("ввожу логин {string} и пароль {string}")
    public void enterCredentials(String username, String password) {
        $("#loginusername").setValue(username);
        $("#loginpassword").setValue(password);
        $("button[onclick='logIn()']").click();
    }

    @Тогда("я вижу приветствие с именем {string}")
    public void checkWelcomeMessage(String username) {
        $("#nameofuser").shouldBe(visible).shouldHave(text(username));
    }

    @Тогда("появляется сообщение об ошибке")
    public void checkErrorAlert() {
        // Selenide умеет работать с алертами
        Selenide.confirm(); // или dismiss()
    }
}