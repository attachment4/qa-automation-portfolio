package ru.netology.qa.runner;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.plugin", value = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm,pretty")
@ConfigurationParameter(key = "cucumber.glue", value = "ru.netology.qa.steps")
public class CucumberRunner {
}