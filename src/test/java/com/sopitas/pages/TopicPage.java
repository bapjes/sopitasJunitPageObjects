package com.sopitas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class TopicPage extends Base{

    By labeltopiclocator = By.cssSelector(".mt-4");
    By listoftopiclocator = By.cssSelector("article.card-ticker");

    public TopicPage(WebDriver driver)
    {
        super(driver);
    }

    public void isTopicSelected() throws Exception {
        isElementpresent(labeltopiclocator);
        System.out.println("You are in the topic selected: " + driver.findElement(labeltopiclocator).getText());
    }


    public void displayTopics() throws Exception {
        isElementpresent(listoftopiclocator);
        List<WebElement> topics = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(listoftopiclocator));

        System.out.println("There are " + topics.size() + " topics");
        for (WebElement element : topics) {
            System.out.println(element.getText());
        }
    }

    public void verifyHashtagTopic(String hashtagSeleccionado) {
    }
}


