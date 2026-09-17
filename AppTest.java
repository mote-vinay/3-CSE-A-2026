package com.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

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
    void testFormSubmission() {

        driver.get("http://localhost:8080");

        driver.findElement(By.id("name"))
              .sendKeys("vinay");

        driver.findElement(By.id("email"))
              .sendKeys("vinay@gmail.com");

        driver.findElement(By.id("phone"))
              .sendKeys("1234567890");

        WebElement gender = driver.findElement(By.id("gender"));
        gender.sendKeys("Male");

        WebElement event = driver.findElement(By.id("event"));
        event.sendKeys("coding contest");

        driver.findElement(
            By.cssSelector("button[type='submit']")
        ).click();

        assertTrue(
            driver.getPageSource().contains("Event Registration")
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
