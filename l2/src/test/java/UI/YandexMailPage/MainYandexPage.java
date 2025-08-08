package UI.YandexMailPage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainYandexPage {
    private WebDriver driver;

    public MainYandexPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkbox = By.xpath("//*[@aria-checked='false'][@type='checkbox']");
    private final By deleteMessage = By.xpath("//*[@data-id='delete']");
    private final By message = By.xpath("//*[text()='4game']");
    private final By confirm = By.xpath("//a[contains(@href, 'ru.4game.ru/confirm')]");

    public void  clickMessage(){
        driver.findElement(message).click();
    }

    public void  clickLinc(){
        driver.findElement(confirm).click();
    }

    public void clickCheckbox(){
        driver.findElement(checkbox).click();
    }

    public void clickDeleteMessage(){
        driver.findElement(deleteMessage).click();
    }

    public void deleteMessageEmail() {
        driver.get("https://mail.yandex.ru/");
        try {
            clickCheckbox();
        } catch (TimeoutException | NoSuchElementException | StaleElementReferenceException | ElementClickInterceptedException e) {
            driver.get("https://mail.yandex.ru/");
            clickCheckbox();
        }
        try {
            WebElement deleteButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-id='delete']")));
            deleteButton.click();
        } catch (TimeoutException | NoSuchElementException | StaleElementReferenceException | ElementClickInterceptedException e) {}
    }

    public void takeMassage() {
        driver.get("https://mail.yandex.ru/");
        clickMessage();
        clickLinc();
    }
}
