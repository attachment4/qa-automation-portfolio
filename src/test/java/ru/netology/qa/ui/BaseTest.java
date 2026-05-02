package ru.netology.qa.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import ru.netology.qa.config.DriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = DriverManager.getDriver();
        driver.get("https://www.demoblaze.com");
    }

    @AfterEach
    void tearDown() {
        DriverManager.quitDriver();
    }
}