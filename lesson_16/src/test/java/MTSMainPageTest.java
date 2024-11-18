import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.MTSMainPageSteps;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static steps.SingleDriver.*;

public class MTSMainPageTest {
    private MTSMainPageSteps steps;
    private Actions builder;
    private static WebDriver driver;
    private String phone = "297777777";
    private String sum = "20";
    private String email = "mmm@mail.ru";

    @BeforeEach
    public void setUp() {
        driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.mts.by/");
        builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        steps = new MTSMainPageSteps(driver, wait);
        WebElement acceptCookieButton = steps.waitElement(steps.getCookie());
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
    public void testCheckPayConnectionPlaceholders() {
        WebElement payConnectionSelect = steps.getPayConnectionSelect();
        steps.getButtonSelect().click();
        builder.moveToElement(payConnectionSelect).click(payConnectionSelect).perform();
        List<String> expectedPlaceholders = Arrays.asList("Номер телефона", "Сумма", "E-mail для отправки чека");
        List<String> actualPlaceholders = steps.getInputPayConnectionPlaceholders();
        for (int i = 0; i < expectedPlaceholders.size(); i++) {
            assertEquals(expectedPlaceholders.get(i), actualPlaceholders.get(i));
        }
    }

    @Test
    public void testCheckPayInternetPlaceholders() {
        WebElement homeInternetSelect = steps.getHomeInternetSelect();
        steps.getButtonSelect().click();
        builder.moveToElement(homeInternetSelect).click(homeInternetSelect).perform();
        List<String> expectedPlaceholders = Arrays.asList("Номер абонента", "Сумма", "E-mail для отправки чека");
        List<String> actualPlaceholders = steps.getInputPayInternetPlaceholders();
        for (int i = 0; i < expectedPlaceholders.size(); i++) {
            assertEquals(expectedPlaceholders.get(i), actualPlaceholders.get(i));
        }
    }

    @Test
    public void testCheckPayInstalmentPlaceholders() {
        WebElement installmentPlanSelect = steps.getInstallmentPlanSelect();
        steps.getButtonSelect().click();
        builder.moveToElement(installmentPlanSelect).click(installmentPlanSelect).perform();
        List<String> expectedPlaceholders = Arrays.asList("Номер счета на 44", "Сумма", "E-mail для отправки чека");
        List<String> actualPlaceholders = steps.getInputPayInstalmentPlaceholders();
        for (int i = 0; i < expectedPlaceholders.size(); i++) {
            assertEquals(expectedPlaceholders.get(i), actualPlaceholders.get(i));
        }
    }

    @Test
    public void testCheckPayArrearsPlaceholders() {
        WebElement debtSelect = steps.getDebtSelect();
        steps.getButtonSelect().click();
        builder.moveToElement(debtSelect).click(debtSelect).perform();
        List<String> expectedPlaceholders = Arrays.asList("Номер счета на 2073", "Сумма", "E-mail для отправки чека");
        List<String> actualPlaceholders = steps.getInputPayArrearsPlaceholders();
        for (int i = 0; i < expectedPlaceholders.size(); i++) {
            assertEquals(expectedPlaceholders.get(i), actualPlaceholders.get(i));
        }
    }

    @Test
    public void testCheckFormPayConnection() {
        WebElement payConnectionSelect = steps.getPayConnectionSelect();
        steps.getButtonSelect().click();
        builder.moveToElement(payConnectionSelect).click(payConnectionSelect).build().perform();
        WebElement inputPhone = steps.getInputPhone();
        inputPhone.sendKeys(phone);
        WebElement inputSum = steps.getInputSum();
        inputSum.sendKeys(sum);
        WebElement inputEmail = steps.getInputEmail();
        inputEmail.sendKeys(email);
        WebElement button = steps.getButtonPayConnection();
        button.click();
        steps.setFocusIframe();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        steps.setWait(wait);
        steps.waitElement(steps.getPayCost());
        String payCost = steps.getPayCostText();
        String payCostInButton = steps.getPayCostInButtonText();
        String phoneInLable = steps.getPayLabelText();
        driver.switchTo().defaultContent();
        assertTrue(payCost.regionMatches(0, sum, 0, sum.length()));
        assertTrue(payCostInButton.regionMatches(payCostInButton.indexOf(sum), sum, 0, sum.length()));
        assertTrue(phoneInLable.regionMatches(phoneInLable.indexOf(phone), phone, 0, phone.length()));
    }

    @Test
    public void testCheckFormPayConnectionLabel() {
        List<String> exLabels = Arrays.asList("Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)");
        WebElement inputPhone = steps.getInputPhone();
        inputPhone.sendKeys(phone);
        WebElement inputSum = steps.getInputSum();
        inputSum.sendKeys(sum);
        WebElement inputEmail = steps.getInputEmail();
        inputEmail.sendKeys(email);
        WebElement button = steps.getButtonPayConnection();
        button.click();
        steps.setFocusIframe();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        steps.setWait(wait);
        steps.waitElement(steps.getPayCost());
        String cardNumberLabel = steps.getCardNumberLabels();
        String validityPeriodLabel = steps.getValidityPeriodLabels();
        String cvcLabels = steps.getCVCLabels();
        String nameLabel = steps.getNameLabels();
        assertEquals(exLabels.get(0), cardNumberLabel);
        assertEquals(exLabels.get(1), validityPeriodLabel);
        assertEquals(exLabels.get(2), cvcLabels);
        assertEquals(exLabels.get(3), nameLabel);
    }

    @Test
    public void testCheckFormPayConnectionLogos() {
        WebElement inputPhone = steps.getInputPhone();
        inputPhone.sendKeys(phone);
        WebElement inputSum = steps.getInputSum();
        inputSum.sendKeys(sum);
        WebElement inputEmail = steps.getInputEmail();
        inputEmail.sendKeys(email);
        WebElement button = steps.getButtonPayConnection();
        button.click();
        steps.setFocusIframe();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        steps.setWait(wait);
        steps.waitElement(steps.getPayCost());
        for (WebElement logo : steps.getLogos()) {
            assertTrue(logo.isDisplayed());
        }
    }
}
