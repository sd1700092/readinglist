package com.eastmoney.readinglist;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = ReadingListApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServerWebTests {
    private static ChromeDriver browser;
    
    @Value("${local.server.port}") //注入端口号
    private int port;
    
    @BeforeClass
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        browser = new ChromeDriver();
        browser.manage().timeouts()
            .implicitlyWait(10, TimeUnit.SECONDS); //配置Firefox驱动
    }
    
    @AfterClass
    public static void closeBrowser() {
        browser.quit();
    }
    
    @Test
    public void addBookToEmptyList() {
        String baseUrl = "http://localhost:" + port;
        browser.get(baseUrl);
        assertEquals("You have no books in your book list", browser.findElementByTagName("div").getText());
        browser.findElementByName("title").sendKeys("BOOK TITLE");
        browser.findElementByName("author").sendKeys("BOOK AUTHOR");
        browser.findElementByName("isbn").sendKeys("1234567890");
        browser.findElementByName("description").sendKeys("DESCRIPTION");
        browser.findElementByName("form").submit();
        WebElement dl = browser.findElementByCssSelector("dt.bookHeadline");
        assertEquals("BOOK TITLE by BOOK AUTHOR (ISBN: 1234567890)",
            dl.getText());
        WebElement dt = browser.findElementByCssSelector("dd.bookDescription");
        assertEquals("DESCRIPTION", dt.getText());
    }
}
