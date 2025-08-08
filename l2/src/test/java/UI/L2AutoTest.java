package UI;

import UI.FoGamePage.RegisterPage;
import UI.YandexMailPage.LoginYandexMailPage;
import UI.YandexMailPage.MainYandexPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class L2AutoTest extends Base {
    String LoginEmail = "PPlifePainQA@yandex.ru";
    String PassEmail = "Qwert12345!asdfg";
    String pass = "Test12345!!!";

    //@Test
    @ParameterizedTest
    //@ValueSource(strings = {"PPlifePainQA+1@yandex.ru", "PPlifePainQA+2@yandex.ru", "PPlifePainQA+3@yandex.ru", "PPlifePainQA+4@yandex.ru"})
    @MethodSource("emailProvider")
    void L2AuthorizationTest(String email) {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginYandexMailPage loginYandexMailPage = new LoginYandexMailPage(driver);
        MainYandexPage mainYandexPage = new MainYandexPage(driver);

        loginYandexMailPage.loginMail(LoginEmail, PassEmail);
        mainYandexPage.deleteMessageEmail();
        registerPage.createAccountL2(email, pass);
        mainYandexPage.takeMassage();
    }

    private static Stream<String> emailProvider() {
        String baseEmail = "PPlifePainQA+";
        String domain = "@yandex.ru";
        return Stream.iterate(20, i -> i + 1)
                .limit(200)
                .map(i -> baseEmail + i + domain);
    }
}