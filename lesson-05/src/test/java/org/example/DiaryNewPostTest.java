package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;

import java.util.concurrent.TimeUnit;

public class DiaryNewPostTest {
    private static final String LOGIN_PAGE_URL = "https://www.diary.ru/";
    private static final String STUDENT_LOGIN = "niceyzoo";
    private static final String STUDENT_PASSWORD = "geekbrains21";
    private static WebDriver driver;

    @Test
    void testDiaryNewPost() {

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


        //клик по кнопке вход
        driver.findElement(By.xpath("//a[contains(text(),'Вход')]")).click();

        // вводим логин

        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='loginform-username']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        // вводим пароль

        WebElement passwordTextInput = driver.findElement(By.cssSelector("input[id='loginform-password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        // клик по кнопке войти

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Войти')]"));
        loginButton.click();

        // Создадим экземпляр класса Actions
        Actions builder = new Actions(driver);

        // Построим цепочку действий
        builder
                .click(driver.findElement(By.xpath("//a[@title='Новая запись']")))
                .click(driver.findElement(By.xpath("//input[@id='postTitle']")))
                .sendKeys("Это тест")
                .click(driver.findElement(By.xpath("//textarea[@id='message']")))
                .sendKeys("маленький тест завершен, ура!")
                .click(driver.findElement(By.xpath("//a[@id='smile_all']")))
                .click(driver.findElement(By.xpath("//div[@data-code=':bravo:']")))
                .click(driver.findElement(By.xpath("//input[@value='Опубликовать']")))
                .build()
                .perform();

        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='TagL']")).isDisplayed());

        driver.manage().logs().get(LogType.BROWSER).getAll().forEach(System.out::println);
        driver.quit();

    }
}