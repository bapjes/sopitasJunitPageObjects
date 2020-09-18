package com.sopitas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);

    }

   protected  boolean isElementpresent (By locator) throws Exception
    {
        try {
            //wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    protected void scrollToWebElement(WebElement webElement) throws Exception {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected boolean clickonElement(By locator) throws Exception
    {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            scrollToWebElement(driver.findElement(locator));
            driver.findElement(locator).click();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    protected boolean enterText(By locator,String state) throws Exception {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            scrollToWebElement(driver.findElement(locator));
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(state);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

}
