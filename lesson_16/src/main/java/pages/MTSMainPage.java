package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MTSMainPage extends BasePage {
    private final By cookie = By.id("cookie-agree");
    private final By payConnectionSelectLocator = By.xpath("//li[./p[contains(text(), 'Услуги связи')]]");
    private final By homeInternetSelectLocator = By.xpath("//li[./p[contains(text(), 'Домашний интернет')]]");
    private final By installmentPlanSelectLocator = By.xpath("//li[./p[contains(text(), 'Рассрочка')]]");
    private final By debtSelectLocator = By.xpath("//li[./p[contains(text(), 'Задолженность')]]");
    private final By inputsPayConnectionLocator = By.xpath("//form[@id='pay-connection']//input");
    private final By inputsPayInternetLocator = By.xpath("//form[@id='pay-internet']//input");
    private final By inputsPayInstalmentLocator = By.xpath("//form[@id='pay-instalment']//input");
    private final By inputsPayArrearsLocator = By.xpath("//form[@id='pay-arrears']//input");
    private final By buttonSelectLocator = By.xpath("//button[@class='select__header']");
    private final By inputPhoneLocator = By.xpath("//input[@id='connection-phone']");
    private final By inputSumLocator = By.xpath("//input[@id='connection-sum']");
    private final By inputEmailLocator = By.xpath("//input[@id='connection-email']");
    private final By buttonPayConnectionLocator = By.xpath("//form[@id='pay-connection']/button");
    private final By iframeLocator = By.xpath("//iframe[@class='bepaid-iframe']");
    private final By payCostLocator = By.xpath("//div[@class='pay-description__cost']/span[contains(., 'BYN')]");
    private final By payLabelLocator = By.xpath("//div[@class='pay-description__text']/span");
    private final By buttonPayLocator = By.xpath("//button[@class='colored disabled']");
    private final By labelCardNumberLocator = By.xpath("//div[@class='content ng-tns-c46-1']//label");
    private final By labelValidityPeriodLocator = By.xpath("//div[@class='content ng-tns-c46-4']//label");
    private final By labelCVCLocator = By.xpath("//div[@class='content ng-tns-c46-5']//label");
    private final By labelNameLocator = By.xpath("//div[@class='content ng-tns-c46-3']//label");
    private final By logosLocator = By.xpath("//div[@class='cards-brands ng-tns-c46-1']" +
            "//img[@class='ng-tns-c61-0 ng-star-inserted']");

    public MTSMainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    public WebElement getCookie() {
        return driver.findElement(cookie);
    }

    public WebElement getPayConnectionSelect() {
        return driver.findElement(payConnectionSelectLocator);
    }

    public WebElement getHomeInternetSelect() {
        return driver.findElement(homeInternetSelectLocator);
    }

    public WebElement getInstallmentPlanSelect() {
        return driver.findElement(installmentPlanSelectLocator);
    }

    public WebElement getDebtSelect() {
        return driver.findElement(debtSelectLocator);
    }

    public List<WebElement> getInputPayConnection() {
        return driver.findElements(inputsPayConnectionLocator);
    }

    public List<WebElement> getInputPayInternet() {
        return driver.findElements(inputsPayInternetLocator);
    }

    public List<WebElement> getInputPayInstalment() {
        return driver.findElements(inputsPayInstalmentLocator);
    }

    public List<WebElement> getInputPayArrears() {
        return driver.findElements(inputsPayArrearsLocator);
    }

    public WebElement getButtonSelect() {
        return driver.findElement(buttonSelectLocator);
    }

    public WebElement getInputPhone() {
        return driver.findElement(inputPhoneLocator);
    }

    public WebElement getInputSum() {
        return driver.findElement(inputSumLocator);
    }

    public WebElement getInputEmail() {
        return driver.findElement(inputEmailLocator);
    }

    public WebElement getButtonPayConnection() {
        return driver.findElement(buttonPayConnectionLocator);
    }

    public WebElement getIframe() {
        return driver.findElement(iframeLocator);
    }

    public WebElement getPayCost() {
        return driver.findElement(payCostLocator);
    }

    public WebElement getButtonPay() {
        return driver.findElement(buttonPayLocator);
    }

    public WebElement getPayLabel() {
        return driver.findElement(payLabelLocator);
    }

    public WebElement getCardNumberLabels() {
        return driver.findElement(labelCardNumberLocator);
    }

    public WebElement getValidityPeriodLabels() {
        return driver.findElement(labelValidityPeriodLocator);
    }

    public WebElement getCVCLabels() {
        return driver.findElement(labelCVCLocator);
    }

    public WebElement getNameLabels() {
        return driver.findElement(labelNameLocator);
    }

    public List<WebElement> getLogos() {
        return driver.findElements(logosLocator);
    }
}
