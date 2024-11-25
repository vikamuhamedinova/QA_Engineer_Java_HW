import io.qameta.allure.Severity;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.MTSMainPageSteps;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static steps.SingleDriver.*;

public class MTSMainPageTest {
    private MTSMainPageSteps steps;
    private Actions builder;
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
            MTSMainPageTestSteps.acceptCookie(acceptCookieButton);
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    @Test
    @DisplayName("Проверка плейсхолдеров в полях 'Услуги связи'")
    @Severity(SeverityLevel.MINOR)
    public void testCheckPayConnectionPlaceholders() {
        MTSMainPageTestSteps.clickButtonSelectStep(steps.getButtonSelect());
        MTSMainPageTestSteps.clickSelectStep(builder, steps.getPayConnectionSelect());
        List<String> expectedPlaceholders = Arrays.asList("Номер телефона", "Сумма", "E-mail для отправки чека");
        List<String> actualPlaceholders = steps.getInputPayConnectionPlaceholders();
        for (int i = 0; i < expectedPlaceholders.size(); i++) {
            MTSMainPageTestSteps.checkPlaceholderStep(expectedPlaceholders.get(i), actualPlaceholders.get(i));
        }
    }

    @Test
    @DisplayName("Проверка плейсхолдеров в полях 'Домашний интернет'")
    @Severity(SeverityLevel.MINOR)
    public void testCheckPayInternetPlaceholders() {
        MTSMainPageTestSteps.clickButtonSelectStep(steps.getButtonSelect());
        MTSMainPageTestSteps.clickSelectStep(builder, steps.getHomeInternetSelect());
        List<String> expectedPlaceholders = Arrays.asList("Номер абонента", "Сумма", "E-mail для отправки чека");
        List<String> actualPlaceholders = steps.getInputPayInternetPlaceholders();
        for (int i = 0; i < expectedPlaceholders.size(); i++) {
            MTSMainPageTestSteps.checkPlaceholderStep(expectedPlaceholders.get(i), actualPlaceholders.get(i));
        }
    }

    @Test
    @DisplayName("Проверка плейсхолдеров в полях 'Рассрочка'")
    @Severity(SeverityLevel.MINOR)
    public void testCheckPayInstalmentPlaceholders() {
        MTSMainPageTestSteps.clickButtonSelectStep(steps.getButtonSelect());
        MTSMainPageTestSteps.clickSelectStep(builder, steps.getInstallmentPlanSelect());
        List<String> expectedPlaceholders = Arrays.asList("Номер счета на 44", "Сумма", "E-mail для отправки чека");
        List<String> actualPlaceholders = steps.getInputPayInstalmentPlaceholders();
        for (int i = 0; i < expectedPlaceholders.size(); i++) {
            MTSMainPageTestSteps.checkPlaceholderStep(expectedPlaceholders.get(i), actualPlaceholders.get(i));
        }
    }

    @Test
    @DisplayName("Проверка плейсхолдеров в полях 'Задолженность'")
    @Severity(SeverityLevel.MINOR)
    public void testCheckPayArrearsPlaceholders() {
        MTSMainPageTestSteps.clickButtonSelectStep(steps.getButtonSelect());
        MTSMainPageTestSteps.clickSelectStep(builder, steps.getDebtSelect());
        List<String> expectedPlaceholders = Arrays.asList("Номер счета на 2073", "Сумма", "E-mail для отправки чека");
        List<String> actualPlaceholders = steps.getInputPayArrearsPlaceholders();
        for (int i = 0; i < expectedPlaceholders.size(); i++) {
            MTSMainPageTestSteps.checkPlaceholderStep(expectedPlaceholders.get(i), actualPlaceholders.get(i));
        }
    }

    @Test
    @DisplayName("Проверка номера телефона в окне оплаты")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckFormPayConnectionPhone() {
        MTSMainPageTestSteps.sendPhoneStep(steps.getInputPhone(), phone);
        MTSMainPageTestSteps.sendSumStep(steps.getInputSum(), sum);
        MTSMainPageTestSteps.sendEmailStep(steps.getInputEmail(), email);
        MTSMainPageTestSteps.clickButtonContinueStep(steps.getButtonPayConnection());
        steps.setFocusIframe();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        steps.setWait(wait);
        steps.waitElement(steps.getPayCost());
        MTSMainPageTestSteps.checkPhoneStep(steps.getPayLabelText(), phone);
    }

    @Test
    @DisplayName("Проверка суммы в окне оплаты")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckFormPayConnectionSum() {
        MTSMainPageTestSteps.sendPhoneStep(steps.getInputPhone(), phone);
        MTSMainPageTestSteps.sendSumStep(steps.getInputSum(), sum);
        MTSMainPageTestSteps.sendEmailStep(steps.getInputEmail(), email);
        MTSMainPageTestSteps.clickButtonContinueStep(steps.getButtonPayConnection());
        steps.setFocusIframe();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        steps.setWait(wait);
        steps.waitElement(steps.getPayCost());
        MTSMainPageTestSteps.checkSumStep(steps.getPayCostText(), sum);
        MTSMainPageTestSteps.checkSumOnButtonStep(steps.getPayCostInButtonText(), sum);
    }

    @Test
    @DisplayName("Проверка плейсхолдеров в полях в окне оплаты")
    @Severity(SeverityLevel.MINOR)
    public void testCheckFormPayConnectionLabel() {
        List<String> exLabels = Arrays.asList("Номер карты", "Срок действия", "CVC", "Имя держателя (как на карте)");
        MTSMainPageTestSteps.sendPhoneStep(steps.getInputPhone(), phone);
        MTSMainPageTestSteps.sendSumStep(steps.getInputSum(), sum);
        MTSMainPageTestSteps.sendEmailStep(steps.getInputEmail(), email);
        MTSMainPageTestSteps.clickButtonContinueStep(steps.getButtonPayConnection());
        steps.setFocusIframe();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        steps.setWait(wait);
        steps.waitElement(steps.getPayCost());
        MTSMainPageTestSteps.checkPlaceholderStep(exLabels.get(0), steps.getCardNumberLabels());
        MTSMainPageTestSteps.checkPlaceholderStep(exLabels.get(1), steps.getValidityPeriodLabels());
        MTSMainPageTestSteps.checkPlaceholderStep(exLabels.get(2), steps.getCVCLabels());
        MTSMainPageTestSteps.checkPlaceholderStep(exLabels.get(3), steps.getNameLabels());
    }

    @Test
    @DisplayName("Проверка логотипов платежных систем в окне оплаты")
    @Severity(SeverityLevel.CRITICAL)
    public void testCheckFormPayConnectionLogos() {
        MTSMainPageTestSteps.sendPhoneStep(steps.getInputPhone(), phone);
        MTSMainPageTestSteps.sendSumStep(steps.getInputSum(), sum);
        MTSMainPageTestSteps.sendEmailStep(steps.getInputEmail(), email);
        MTSMainPageTestSteps.clickButtonContinueStep(steps.getButtonPayConnection());
        steps.setFocusIframe();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        steps.setWait(wait);
        steps.waitElement(steps.getPayCost());
        for (WebElement logo : steps.getLogos()) {
            MTSMainPageTestSteps.checkLogoStep(logo);
        }
    }
}
