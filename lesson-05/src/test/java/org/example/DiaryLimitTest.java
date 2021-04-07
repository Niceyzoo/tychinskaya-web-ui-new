package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DiaryLimitTest {
    private static final String LOGIN_PAGE_URL = "https://www.diary.ru/";
    private static final String STUDENT_LOGIN = "niceyzoo";
    private static final String STUDENT_PASSWORD = "geekbrains21";
    private static WebDriver driver;

    @Test
    void testDiaryLimit() {

        WebDriverManager.chromedriver().setup();
        // Класс настроек Chrome browser https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();

        // Полный перечень https://peter.sh/experiments/chromium-command-line-switches/
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        // options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(LOGIN_PAGE_URL);
        Actions builder = new Actions(driver);

        // вход
        builder
                .click(driver.findElement(By.xpath("//a[contains(text(),'Вход')]")))
                .click(driver.findElement(By.cssSelector("input[id='loginform-username']")))
                .sendKeys(STUDENT_LOGIN)
                .click(driver.findElement(By.cssSelector("input[id='loginform-password']")))
                .sendKeys(STUDENT_PASSWORD)
                .click(driver.findElement(By.xpath("//button[contains(text(),'Войти')]")))
                .build()
                .perform();

        // редактирование ограничений
        List<WebElement> rb = (List<WebElement>) driver.findElement(By.xpath("//input[@type=radio]"));


        builder
                .click(driver.findElement(By.xpath("//span[text()='Настройки']")))
                .click(driver.findElement(By.xpath("//a[text()='Ограничение доступа к дневнику']")))
                .click(rb.get(0))
                .click(rb.get(6))
                .click(driver.findElement(By.xpath("//button[text()='Сохранить']")))
                .build()
                .perform();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text()='Сохранить']")));

        Assert.assertTrue(rb.get(0).isSelected());
        Assert.assertTrue(rb.get(6).isSelected());

        driver.manage().logs().get(LogType.BROWSER).getAll().forEach(System.out::println);
        driver.quit();

    }
}