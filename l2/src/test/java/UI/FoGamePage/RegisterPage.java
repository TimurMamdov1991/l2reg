package UI.FoGamePage;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By registerMail = By.xpath("//*[@class='RegisterForm_socialsContainer__J3y6M RegisterForm_theme-dark__WlamP'][2]/*[1]");
    private final By email = By.xpath("//input[@placeholder='email']");
    private final By pass = By.xpath("//input[@type='password']");
    private final By policyCheckbox = By.xpath("//input[@data-locator='register-form-agreement']/..");
    private final By fogameCheckbox = By.xpath("//input[@data-locator='register-form-marketing-agreement']/..");
    private final By BtnRegister = By.xpath("//*[@data-locator='register-form-button']");

    public void sendEmail(String mail){
        driver.findElement(email).click();
        driver.findElement(email).sendKeys(mail);
    }

    public void clearEmail(){
        driver.findElement(email).clear();
    }

    public void sendPass(String password){
        driver.findElement(pass).click();
        driver.findElement(pass).sendKeys(password);
    }

    public void clickPolicyCheckbox(){
        driver.findElement(policyCheckbox).click();
    }

    public void clickFogameCheckbox(){
        driver.findElement(fogameCheckbox).click();
    }

    public void clickBntRegister(){
        driver.findElement(BtnRegister).click();
    }

    public void createAccountL2(String email, String pass) {
        driver.get("https://ru.4game.ru/signup/");
        try {
            WebElement registerMail = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='RegisterForm_socialsContainer__J3y6M RegisterForm_theme-dark__WlamP'][2]/*[1]")));

            registerMail.click();
        } catch  (TimeoutException | NoSuchElementException | StaleElementReferenceException | ElementClickInterceptedException e) {
            WebElement clearEmail = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='email']")));
            clearEmail.clear();
            sendEmail(email);
            sendPass(pass);
            clickPolicyCheckbox();
            clickFogameCheckbox();
            clickBntRegister();
        }
        WebElement clearEmail = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='email']")));
        clearEmail.clear();
        sendEmail(email);
        sendPass(pass);
        clickPolicyCheckbox();
        clickFogameCheckbox();
        clickBntRegister();
    }
}