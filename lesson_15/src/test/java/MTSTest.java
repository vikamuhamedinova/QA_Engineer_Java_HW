import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MTSTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        WebElement acceptCookieButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-agree")));
        if (acceptCookieButton != null && acceptCookieButton.isDisplayed()) {
            acceptCookieButton.click();
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void testCheckPaySectionTitle() {
        WebElement paySectionTitle = driver.findElement(By.xpath("//section[@class='pay']//h2[contains(text()," +
                "'Онлайн пополнение') and contains(., 'без комиссии')]"));
        assertTrue(paySectionTitle.isDisplayed());
    }

    @Test
    public void testCheckPartnersLogos() {
        WebElement logos = driver.findElement(By.xpath("//div[@class='pay__partners']//ul"));
        String[] logoNames = {"Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"};
        for (String logoName : logoNames) {
            WebElement logo = logos.findElement(By.xpath(".//img[@alt='" + logoName + "']"));
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    public void testCheckLink(){
        WebElement link = driver.findElement(By.xpath("//div[@class='pay__wrapper']/a"));
        link.click();
        WebElement breadcrumbsLink = driver.findElement(By.xpath("//span[contains(text(), " +
                "'Порядок оплаты и безопасность интернет платежей')]"));
        assertTrue(breadcrumbsLink.isDisplayed());
    }

    @Test
    public void testCheckFormPayConnection(){
        WebElement inputPhone = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        inputPhone.sendKeys("297777777");
        WebElement inputSum = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        inputSum.sendKeys("20");
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='connection-email']"));
        inputEmail.sendKeys("mmm@mail.ru");
        WebElement button = driver.findElement(By.xpath("//form[@id='pay-connection']/button"));
        button.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement payCost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'20.00 BYN')]")));
        assertTrue(payCost.isDisplayed());
    }
}
