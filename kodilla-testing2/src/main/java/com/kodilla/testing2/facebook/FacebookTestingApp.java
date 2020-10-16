package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_ACCEPT_COOKIES = "//button[contains(@class, \"_42ft _4jy0 _9fws _4jy3 _4jy1 selected _51sy\")]";
    public static final String XPATH_CREATE_NEW_ACCOUNT = "//a[contains(@class, \"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\")]";

    public static final String XPATH_WAIT_FOR_REGISTER_BUTTON = "//div[contains(@class, \"_1lch\")]/button[contains(@class, \"_6j mvm _6wk _6wl _58mi _6o _6v\")]";

    public static final String XPATH_BIRTH_DATE_DAY = "//span[contains(@class, _5k_4)]/select[contains(@class, \"_9407 _5dba _8esg\")][1]";
    public static final String XPATH_BIRTH_DATE_MONTH = "//span[contains(@class, _5k_4)]/select[contains(@class, \"_9407 _5dba _8esg\")][2]";
    public static final String XPATH_BIRTH_DATE_YEAR = "//span[contains(@class, _5k_4)]/select[contains(@class, \"_9407 _5dba _8esg\")][3]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES)).isDisplayed()) ;

        WebElement acceptCookiesButton = driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES));
        acceptCookiesButton.click();

        WebElement accountCreationButton = driver.findElement(By.xpath(XPATH_CREATE_NEW_ACCOUNT));
        accountCreationButton.click();

        Thread.sleep(3000);

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR_REGISTER_BUTTON)).isDisplayed());

        WebElement birthDayComboBox = driver.findElement(By.xpath(XPATH_BIRTH_DATE_DAY));
        Select selectBirthDay = new Select(birthDayComboBox);
        selectBirthDay.selectByIndex(20);

        WebElement birthMonthComboBox = driver.findElement(By.xpath(XPATH_BIRTH_DATE_MONTH));
        Select selectBirthMonth = new Select(birthMonthComboBox);
        selectBirthMonth.selectByValue("7");

        WebElement birthYearComboBox = driver.findElement(By.xpath(XPATH_BIRTH_DATE_YEAR));
        Select selectBirthYear = new Select(birthYearComboBox);
        selectBirthYear.selectByValue("1973");
    }
}
