package com.expense.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpenseTrackerTest {

    private WebDriver driver;

    @Test
    public void testAddExpense() {

        driver = new ChromeDriver();

        // Open Expense Tracker
        driver.get("http://localhost:8081/ExpenseTracker/");

        // Open Add Expense page
        driver.findElement(By.linkText("Add Expense")).click();

        // Enter expense details
        driver.findElement(By.id("expenseName"))
                .sendKeys("Lunch");

        driver.findElement(By.id("amount"))
                .sendKeys("150");

        driver.findElement(By.id("category"))
                .sendKeys("Food");

        driver.findElement(By.id("date"))
                .sendKeys("2026-09-27");

        // Submit expense
        driver.findElement(By.id("addExpenseButton"))
                .click();

        // Check that Lunch appears on the expense page
        String pageText = driver.findElement(By.tagName("body"))
                .getText();

        assertTrue(pageText.contains("Lunch"));
        assertTrue(pageText.contains("150"));
    }

    @AfterEach
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }
}