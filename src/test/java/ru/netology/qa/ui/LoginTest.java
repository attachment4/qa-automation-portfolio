package ru.netology.qa.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.UnhandledAlertException;
import ru.netology.qa.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;


@Feature("Авторизация")
public class LoginTest extends BaseTest {

    @Test
    @Description("Успешный логин с валидными данными")
    void loginWithValidCredentials() {
        driver.findElement(By.id("login2")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("ivan_qa", "1234"); // ← твои данные

        // Ждём либо успешный элемент, либо закрываем alert если появился
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
            String welcomeText = driver.findElement(By.id("nameofuser")).getText();
            assertTrue(welcomeText.contains("ivan_qa"));
        } catch (UnhandledAlertException e) {
            driver.switchTo().alert().dismiss();
            fail("Логин не прошёл — появился alert: " + e.getAlertText());
        }
    }
}