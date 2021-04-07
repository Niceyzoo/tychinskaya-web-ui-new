package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ApplanatestOrgTest {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static WebDriver driver;

    @Test
    void testApplanatestOrg() {

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

        // логинимся
        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();

        // Клик на кнопку "Проекты"

        driver.findElement(By.xpath(".//ul[@class='nav nav-multilevel main-menu']/li[@class='dropdown']/a[@class='unclickable']/span[text()='Проекты']")).click();

        // Клик на выпадашку "Мои проекты"

        driver.findElement(By.xpath(".//span[@class='title' and text()='Мои проекты']")).click();

        // Клик на кнопку "Создать проект"

        driver.findElement(By.xpath(".//div[@class='pull-left btn-group icons-holder']//a[text()='Создать проект']")).click();


        // ввод в поле "Укажите организацию"
        driver.findElement(By.xpath(".//span[text()='Укажите организацию']")).click();

        driver.findElement(By.xpath(".//div[@id='select2-drop']/div/input")).sendKeys("1234");

        driver.findElement(By.xpath("//.//span[text()='1234']")).click();

        // выбрать "Подразделение"
        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");

        // ввод в поле "Куратор проекта"

        Select selectСurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        selectСurator.selectByVisibleText("Applanatest Applanatest Applanatest");

        // ввод в поле "Руководитель проекта"

        Select selectRP = new Select(driver.findElement(By.name("crm_project[rp]")));
        selectRP.selectByVisibleText("Applanatest Applanatest Applanatest");

        // ввод в поле "Администратор проекта"

        Select selectAdmin = new Select(driver.findElement(By.name("crm_project[administrator]")));
        selectAdmin.selectByVisibleText("Амелина Светлана");

        // ввод в поле "Менеджер"

        Select selectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        selectManager.selectByVisibleText("Applanatest Applanatest Applanatest");


        // ввод в поле "Основное контактное лицо"

        driver.findElement(By.xpath("//div[contains(@id, 'contactMain')]")).click();
        driver.findElement(By.xpath("//div[contains(@id, 'contactMain')]")).sendKeys("123 123");
        driver.findElement(By.xpath("//div[contains(@id, 'contactMain')]")).click();

        // клик на "Сохранить и закрыть"
        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='extra-actions-panel']")).isDisplayed());

        driver.quit();
    }
}

