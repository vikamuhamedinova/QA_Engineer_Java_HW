import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MTSMainPageTestSteps {

    @Step("Обработка cookie")
    public static void acceptCookie(WebElement element) {
        element.click();
    }

    @Step("Нажатие на кнопку выбора услуги")
    public static void clickButtonSelectStep(WebElement button) {
        button.click();
    }

    @Step("Нажатие на услугу")
    public static void clickSelectStep(Actions builder, WebElement select) {
        builder.moveToElement(select).click(select).perform();
    }

    @Step("Проверка отображения плейсхолдера")
    public static void checkPlaceholderStep(String exPlaceholder, String placeholder) {
        assertEquals(exPlaceholder, placeholder);
    }

    @Step("Заполнение поля 'Телефон'")
    public static void sendPhoneStep(WebElement element, String phone) {
        element.sendKeys(phone);
    }

    @Step("Заполнение поля 'Сумма'")
    public static void sendSumStep(WebElement element, String sum) {
        element.sendKeys(sum);
    }

    @Step("Заполнение поля 'E-mail'")
    public static void sendEmailStep(WebElement element, String email) {
        element.sendKeys(email);
    }

    @Step("Нажатие на кнопку продолжить")
    public static void clickButtonContinueStep(WebElement button) {
        button.click();
    }

    @Step("Проверка отображения телефона")
    public static void checkPhoneStep(String element, String phone) {
        assertTrue(element.regionMatches(element.indexOf(phone), phone, 0, phone.length()));
    }

    @Step("Проверка отображения суммы")
    public static void checkSumStep(String element, String sum) {
        assertTrue(element.regionMatches(0, sum, 0, sum.length()));
    }

    @Step("Проверка отображения суммы на кнопке")
    public static void checkSumOnButtonStep(String element, String sum) {
        assertTrue(element.regionMatches(element.indexOf(sum), sum, 0, sum.length()));
    }

    @Step("Проверка отображения логотипа")
    public static void checkLogoStep(WebElement logo) {
        assertTrue(logo.isDisplayed());
    }
}
