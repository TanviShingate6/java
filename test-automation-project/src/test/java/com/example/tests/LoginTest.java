package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private final String baseUrl = "http://example.com";
    
    @BeforeClass
    public void setUp() {
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tanvi\\Downloads\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless"); // Enable headless mode
            options.addArguments("--disable-gpu"); // Disable GPU acceleration (may be required in headless mode)
            options.addArguments("--window-size=1920,1080"); // Set window size
            options.addArguments("--no-sandbox"); // Bypass OS security model
            options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
            options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.9999.999 Safari/537.36"); // Set user-agent string

            driver = new ChromeDriver(options);
        } catch (Exception e) {
            System.out.println("Failed to initialize WebDriver: " + e.getMessage());
        }
    }

    @Test
    public void testLogin() {
        try {
            driver.get(baseUrl);
            // Simulate login functionality
            // Replace these lines with your actual test steps
            String pageTitle = driver.getTitle();
            Assert.assertEquals(pageTitle, "Example - Login", "Page title mismatch");
        } catch (Exception e) {
            System.out.println("Failed to execute testLogin(): " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Failed to quit WebDriver: " + e.getMessage());
        }
    }
}
