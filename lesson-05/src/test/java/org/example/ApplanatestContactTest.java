package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ApplanatestContactTest {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static WebDriver driver;



    @Test
    void testApplanatestContact() {

        WebDriverManager.chromedriver().setup();

        // Класс настроек Chrome browser https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();

        // Полный перечень https://peter.sh/experiments/chromium-command-line-switches/
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--headless");


        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(LOGIN_PAGE_URL);

        // ввод в поле логин используем имя тега

        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        // ввод в поле пароль используем имя класса

        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        // клик по кнопке вход используя xpath

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();

        // Клик на кнопку "Контрагенты"

        driver.findElement(By.xpath("//a[@href]//span[text()='Контрагенты']")).click();

        // Клик на выпадашку "Контактные лица"

        driver.findElement(By.xpath("//a[@href]//span[text()='Контактные лица']")).click();

        // Клик на кнопку "Создать контакное лицо"

        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        // ввод в поле "Фамилия"

        driver.findElement(By.xpath("//input[contains(@id, 'lastName')]")).sendKeys("123");

        // ввод в поле "Имя"

        driver.findElement(By.xpath("//input[contains(@id, 'firstName')]")).sendKeys("123");

        // ввод в поле "Укажите организацию"

        driver.findElement(By.xpath(".//span[text()='Укажите организацию']")).click();

        driver.findElement(By.xpath(".//div[@id='select2-drop']/div/input")).sendKeys("1234");

        driver.findElement(By.xpath("//.//span[text()='1234']")).click();

        // ввод в поле "Должность"

        driver.findElement(By.xpath("//input[contains(@id, 'jobTitle')]")).sendKeys("test");

        // Клик на кнопку "Создать и закрыть"

        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='extra-actions-panel']")).isDisplayed());

        driver.manage().logs().get(LogType.BROWSER).getAll().forEach(System.out::println);
        driver.quit();
    }
}
