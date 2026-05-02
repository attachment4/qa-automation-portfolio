package ru.netology.qa.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.netology.qa.config.DriverManager;
import ru.netology.qa.utils.SeleniumScreenshotExtension;

@ExtendWith(SeleniumScreenshotExtension.class)
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