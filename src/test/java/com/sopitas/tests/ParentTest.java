package com.sopitas.tests;

import com.sopitas.pages.HomePage;
import com.sopitas.pages.TopicPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystemNotFoundException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String url;

    HomePage homePage;
    TopicPage topicPage;

    public void loadBrowser() {
        String path;
        //path = ".\\src\\test\\java\\resources\\drivers\\chromedriver.exe";

        //System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();


    }


    private void getPropValues() throws IOException {

        Properties prop = new Properties();

        String propFilename = ".\\src\\test\\java\\resources\\configuration\\data.properties";
        InputStream inputStream = new FileInputStream(propFilename);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            FileSystemNotFoundException ex = new FileSystemNotFoundException();
            ex.printStackTrace();
        }
        url = prop.getProperty("url");
    }


    @Before
    public void before() throws IOException {
        //getPropValues();
        loadBrowser();
        homePage = new HomePage(driver);
        topicPage = new TopicPage(driver);
    }


    @After
    public void quit() {
        homePage = null;
        topicPage=null;
        driver.quit();
    }


}
