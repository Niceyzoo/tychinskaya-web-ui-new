package webui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ApplanatestOrg {
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

        // используем имя тега
        Thread.sleep(2000);
        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        // используем имя класса
        Thread.sleep(2000);
        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        // используя xpath
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();

        // Клик на кнопку "Проекты"
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//ul[@class='nav nav-multilevel main-menu']/li[@class='dropdown']/a[@class='unclickable']/span[text()='Проекты']")).click();

        // Клик на выпадашку "Мои проекты"
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//span[@class='title' and text()='Мои проекты']")).click();

        // Клик на кнопку "Создать проект"
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//div[@class='pull-left btn-group icons-holder']//a[text()='Создать проект']")).click();


        // ввод в поле "Укажите организацию"
        sleep(2000);
        driver.findElement(By.xpath(".//span[text()='Укажите организацию']")).click();
        sleep(2000);
        driver.findElement(By.xpath(".//div[@id='select2-drop']/div/input")).sendKeys("1234");
        sleep(2000);
        driver.findElement(By.xpath("//.//span[text()='1234']")).click();

        // выбрать "Подразделение"
        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");

        // ввод в поле "Куратор проекта"
        sleep(2000);
        Select selectСurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        selectСurator.selectByVisibleText("Applanatest Applanatest Applanatest");

        // ввод в поле "Руководитель проекта"
        sleep(2000);
        Select selectRP = new Select(driver.findElement(By.name("crm_project[rp]")));
        selectRP.selectByVisibleText("Applanatest Applanatest Applanatest");

        // ввод в поле "Администратор проекта"
        sleep(2000);
        Select selectAdmin = new Select(driver.findElement(By.name("crm_project[administrator]")));
        selectAdmin.selectByVisibleText("Амелина Светлана");

        // ввод в поле "Менеджер"
        sleep(2000);
        Select selectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        selectManager.selectByVisibleText("Applanatest Applanatest Applanatest");

        // клик на "Сохранить и закрыть" ОСТАВИЛА ЗАКОМ. ПОТОМУ ЧТО НЕ ДАСТ СОХРАНИТЬ БЕЗ ТОГО, ЧТО НИЖЕ
        // sleep(2000);
        //driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();


        // ввод в поле "Основное контактное лицо" НЕ РАБОТАЕТ :(

        // Actions action = new Actions(driver);
        //action.moveToElement(driver.findElement(By.xpath("//div[contains(@id, 'contactMain')]"))).click().build().perform();
        //driver.findElement(By.xpath("//div[contains(@id, 'contactMain')]")).click();
        //driver.findElement(By.xpath(".//span[text()='123 123']")).click();


        Thread.sleep(5000);
        driver.quit();
    }
}

