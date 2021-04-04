package webui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DiaryAutorisation {
    private static final String LOGIN_PAGE_URL = "https://www.diary.ru/";
    private static final String STUDENT_LOGIN = "niceyzoo";
    private static final String STUDENT_PASSWORD = "geekbrains21";
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


        //клик по кнопке вход
        driver.findElement(By.xpath("//a[contains(text(),'Вход')]")).click();

        // вводим логин
        Thread.sleep(2000);
        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='loginform-username']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        // вводим пароль
        Thread.sleep(2000);
        WebElement passwordTextInput = driver.findElement(By.cssSelector("input[id='loginform-password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        // клик по кнопке войти
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Войти')]"));
        loginButton.click();

        Thread.sleep(5000);
        driver.quit();

    }
}