package ru.netology.qa.utils;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.netology.qa.config.DriverManager;

import java.io.ByteArrayInputStream;

public class SeleniumScreenshotExtension implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) {
        if (context.getExecutionException().isPresent()) {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(
                        "Скриншот при падении: " + context.getDisplayName(),
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        "png"
                );
            }
        }
    }
}