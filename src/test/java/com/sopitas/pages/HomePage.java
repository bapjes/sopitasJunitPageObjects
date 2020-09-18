package com.sopitas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends Base {
    By logoLocator = By.cssSelector("h1 .text-hide.logo-sopitas");
    By searchLocator = By.cssSelector("#s-desktop");
    By buttonLocator = By.cssSelector("#s-desktop+.btn.btn-default");
    By hashtagLocator = By.cssSelector("#trending h5");
    By elementshashtag = By.cssSelector("#trending ol li");

    List<WebElement> elements;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToPage(String url) {
        driver.get(url);
        System.out.println("Sopitas page was loaded");
    }


    public void isHomePageDisplayed() throws Exception {
        isElementpresent(searchLocator);
        isElementpresent(buttonLocator);
        isElementpresent(hashtagLocator);

        if (isElementpresent(logoLocator)) {
            System.out.println("You are in Home Page");
        } else {
            throw new Exception("You are not in home page");
        }
    }

    public void printHashTagelements() {
        elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementshashtag));

        System.out.println("There are " + elements.size() + " elements in the hashTag");
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }

    public String selectaHashTag(int index) throws Exception {
        elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementshashtag));
        WebElement element = elements.get(index);
        System.out.println("The topic selected was : " + element.getText());
        String currentTopic = element.getText();
        element.click();
        return currentTopic;

    }
}
