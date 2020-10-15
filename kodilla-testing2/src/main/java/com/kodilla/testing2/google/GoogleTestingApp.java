package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {
    public static final String SEARCHFIELD = ".gLFyf.gsfi";
    public static final String ACCEPT_COOKIES = "CwaK9";


    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.google.com");

        WebElement searchField = driver.findElement(By.cssSelector(SEARCHFIELD));
        searchField.sendKeys("Kodilla");
        searchField.submit();

    }
}
