package com.example;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTestweek11 {

    static WebDriver driver;

    @BeforeAll
    static void setUp() {

        System.setProperty(
            "webdriver.gecko.driver",
            "/home/vaagdevi/Downloads/geckodriver"
        );

        FirefoxOptions options = new FirefoxOptions();

        driver = new FirefoxDriver(options);
    }

    @Test
    void testButtonClickChangesHeading() {

        String filePath =
            Paths.get("index.html").toAbsolutePath().toUri().toString();

        driver.get(filePath);

        WebElement heading =
            driver.findElement(By.id("heading"));

        assertEquals(
            "Original Heading",
            heading.getText()
        );

        driver.findElement(By.id("btn")).click();

        heading = driver.findElement(By.id("heading"));

        assertEquals(
            "Hello, Selenium!",
            heading.getText()
        );

        System.out.println("Test Passed!");
    }

    @AfterAll
    static void tearDown() {

        if (driver != null) {
            //driver.quit();
        }
    }
}

