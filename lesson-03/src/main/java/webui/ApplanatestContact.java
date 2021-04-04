package webui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ApplanatestContact {
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";
    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // Класс настроек Chrome browser https://chromedriver.chromium.org/capabilities
        ChromeOptions options = new ChromeOptions();

        // Полный перечень https://peter.sh/experiments/chromium-command-line-switches/
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(LOGIN_PAGE_URL);

        // ввод в поле логин используем имя тега
        Thread.sleep(2000);
        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        // ввод в поле пароль используем имя класса
        Thread.sleep(2000);
        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        // клик по кнопке вход используя xpath
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();

        // Клик на кнопку "Контрагенты"
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href]//span[text()='Контрагенты']")).click();

        // Клик на выпадашку "Контактные лица"
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href]//span[text()='Контактные лица']")).click();

        // Клик на кнопку "Создать контакное лицо"
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        // ввод в поле "Фамилия"
        sleep(2000);
        driver.findElement(By.xpath("//input[contains(@id, 'lastName')]")).sendKeys("123");

        // ввод в поле "Имя"
        sleep(2000);
        driver.findElement(By.xpath("//input[contains(@id, 'firstName')]")).sendKeys("123");

        // ввод в поле "Укажите организацию"
        sleep(2000);
        driver.findElement(By.xpath(".//span[text()='Укажите организацию']")).click();
        sleep(2000);
        driver.findElement(By.xpath(".//div[@id='select2-drop']/div/input")).sendKeys("1234");
        sleep(2000);
        driver.findElement(By.xpath("//.//span[text()='1234']")).click();

        // ввод в поле "Должность"
        sleep(2000);
        driver.findElement(By.xpath("//input[contains(@id, 'jobTitle')]")).sendKeys("test");

        // Клик на кнопку "Создать и закрыть"
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
