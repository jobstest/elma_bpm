package com.elma.tests;

import com.elma.config.CredentialsConfig;
import com.elma.config.WebDriverProvider;
import com.elma.tests.pages.AuthFormPage;
import com.elma.tests.pages.MainFormPage;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

@Owner("parfionov")
@Severity(SeverityLevel.BLOCKER)
@Feature("Aутентификация")
@Story("Возможность войти в ЛК")
@DisplayName("Аутентификация на странице")
@Tag("auth")
public class AuthPageTests extends BaseTests {

    //private WebDriver driver = new WebDriverProvider().get();
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    AuthFormPage authFormPage = new AuthFormPage();
    MainFormPage mainFormPage = new MainFormPage();
    Faker faker = new Faker();
    String login = faker.name().username();
    String password = faker.internet().password();
    String correctlogin = config.correctlogin();
    String correctpassword = config.correctpassword();



    @Test
    @DisplayName("Aутентификация c корректными логином и паролем")
    void authWithCorrectLoginAndPassword() {

        authFormPage.openLogOnPage("/Security/Account/LogOn")
                .setLoginAndPassword(correctlogin, correctpassword)
                .clickLogInButton();
        mainFormPage.checkWelcome("Добро пожаловать в систему ELMA!");
        /*Allure.getLifecycle().addAttachment(
                "Исходники страницы",
                "text/html",
                "html",
                WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
        );*/
    }

    @Test
    @DisplayName("Aутентификация c некорректным логином")
    void authWithIncorrectLogin() {

        authFormPage.openLogOnPage("/Security/Account/LogOn")
                .setLoginAndPassword(login, correctpassword)
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");
    }

    @Test
    @DisplayName("Aутентификация c некорректным паролем")
    void authWithIncorrectPassword() {

        authFormPage.openLogOnPage("/Security/Account/LogOn")
                .setLoginAndPassword(correctlogin, password)
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");
    }

    @Test
    @DisplayName("Aутентификация c некорректными логином и паролем")
    void authWithIncorrectLoginAndPassword() {

        authFormPage.openLogOnPage("/Security/Account/LogOn")
                .setLoginAndPassword(login, password)
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");
    }

    @Test
    @DisplayName("Aутентификация c пустыми логином и паролем")
    void authWithoutLoginAndPassword() {

        authFormPage.openLogOnPage("/Security/Account/LogOn")
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");
    }
}
