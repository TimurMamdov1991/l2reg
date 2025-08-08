package UI.YandexMailPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginYandexMailPage {
    private WebDriver driver;

    public LoginYandexMailPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By login = By.xpath("//*[@id='passp-field-login']");
    private final By btnPass = By.xpath("//button[@data-t='button:action:passp:sign-in']");
    private final By pass = By.xpath("//*[@id='passp-field-passwd']");
    private final By btnPass2 = By.xpath("//button[@id='passp:sign-in']");
    private final By btnUndefined = By.xpath("//button[@data-t='button:pseudo:passp:phone:controls:undefined']");

    public void sendEmail(String mail){
        driver.findElement(login).click();
        driver.findElement(login).clear();
        driver.findElement(login).sendKeys(mail);
    }

    public void clickBtnPass(){
        driver.findElement(btnPass).click();
    }

    public void sendPass(String password){
        driver.findElement(pass).click();
        driver.findElement(pass).clear();
        driver.findElement(pass).sendKeys(password);
    }

    public void clickBtnPass2(){
        driver.findElement(btnPass2).click();
    }

    public void clickBtnUndefined(){
        driver.findElement(btnUndefined).click();
    }

    public void loginMail(String mail, String pass) {
        driver.get("https://passport.yandex.ru/auth/add/login");
        sendEmail(mail);
        clickBtnPass();
        sendPass(pass);
        clickBtnPass2();
        clickBtnUndefined();
    }

}


