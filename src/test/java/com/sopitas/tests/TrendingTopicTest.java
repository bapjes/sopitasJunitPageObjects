package com.sopitas.tests;

import org.junit.Test;

public class TrendingTopicTest extends ParentTest {
    String url = "https://www.sopitas.com/";
   @Test
    public void testTrendingTopic() throws Exception {
        homePage.goToPage(url);
        homePage.isHomePageDisplayed();
        homePage.printHashTagelements();
    }

    @Test
    public void searchTopic() throws Exception {
        int topic = 2;
        homePage.goToPage(url);
        homePage.isHomePageDisplayed();
        String hashtagSeleccionado = homePage.selectaHashTag(topic);
        topicPage.verifyHashtagTopic(hashtagSeleccionado);
    }


    @Test
    public void validateOtherNews() throws Exception {
        int topic = 2;
        homePage.goToPage(url);
        homePage.isHomePageDisplayed();
        homePage.selectaHashTag(topic);
        topicPage.isTopicSelected();
        topicPage.displayTopics();
    }
}
