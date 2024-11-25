package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MTSMainPage;

import java.util.ArrayList;
import java.util.List;

import static steps.SingleDriver.*;

public class MTSMainPageSteps {
    private final MTSMainPage mtsMainPage;

    public MTSMainPageSteps(WebDriver driver, WebDriverWait wait) {
        this.mtsMainPage = new MTSMainPage(driver, wait);
    }

    public WebElement waitElement(WebElement element) {
        return mtsMainPage.waitForElement(element);
    }

    public void setWait(WebDriverWait wait) {
        mtsMainPage.setWait(wait);
    }

    public WebElement getCookie() {
        return mtsMainPage.getCookie();
    }

    public WebElement getPayConnectionSelect() {
        return mtsMainPage.getPayConnectionSelect();
    }

    public WebElement getHomeInternetSelect() {
        return mtsMainPage.getHomeInternetSelect();
    }

    public WebElement getInstallmentPlanSelect() {
        return mtsMainPage.getInstallmentPlanSelect();
    }

    public WebElement getDebtSelect() {
        return mtsMainPage.getDebtSelect();
    }

    public List<String> getInputPayConnectionPlaceholders() {
        List<String> placeholders = new ArrayList<>();
        for (WebElement input : mtsMainPage.getInputPayConnection()) {
            placeholders.add(input.getAttribute("placeholder"));
        }
        return placeholders;
    }

    public List<String> getInputPayInternetPlaceholders() {
        List<String> placeholders = new ArrayList<>();
        for (WebElement input : mtsMainPage.getInputPayInternet()) {
            placeholders.add(input.getAttribute("placeholder"));
        }
        return placeholders;
    }

    public List<String> getInputPayInstalmentPlaceholders() {
        List<String> placeholders = new ArrayList<>();
        for (WebElement input : mtsMainPage.getInputPayInstalment()) {
            placeholders.add(input.getAttribute("placeholder"));
        }
        return placeholders;
    }

    public List<String> getInputPayArrearsPlaceholders() {
        List<String> placeholders = new ArrayList<>();
        for (WebElement input : mtsMainPage.getInputPayArrears()) {
            placeholders.add(input.getAttribute("placeholder"));
        }
        return placeholders;
    }

    public WebElement getButtonSelect() {
        return mtsMainPage.getButtonSelect();
    }

    public WebElement getInputPhone() {
        return mtsMainPage.getInputPhone();
    }

    public WebElement getInputSum() {
        return mtsMainPage.getInputSum();
    }

    public WebElement getInputEmail() {
        return mtsMainPage.getInputEmail();
    }

    public WebElement getButtonPayConnection() {
        return mtsMainPage.getButtonPayConnection();
    }

    public void setFocusIframe() {
        driver.switchTo().frame(mtsMainPage.getIframe());
    }

    public WebElement getPayCost() {
        return mtsMainPage.getPayCost();
    }

    public String getPayCostText() {
        return mtsMainPage.getPayCost().getText();
    }

    public String getPayCostInButtonText() {
        return mtsMainPage.getButtonPay().getText();
    }

    public String getPayLabelText() {
        return mtsMainPage.getPayLabel().getText();
    }

    public String getCardNumberLabels() {
        return mtsMainPage.getCardNumberLabels().getText();
    }

    public String getValidityPeriodLabels() {
        return mtsMainPage.getValidityPeriodLabels().getText();
    }

    public String getCVCLabels() {
        return mtsMainPage.getCVCLabels().getText();
    }

    public String getNameLabels() {
        return mtsMainPage.getNameLabels().getText();
    }

    public List<WebElement> getLogos() {
        return mtsMainPage.getLogos();
    }
}