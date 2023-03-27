package com.elma.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.elma.pages.AuthFormPage;
import com.elma.pages.MainFormPage;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Owner("parfionov")
@Severity(SeverityLevel.BLOCKER)
@Feature("Aутентификация")
@Story("Возможность войти в ЛК")
@DisplayName("Аутентификация на странице")
@Tag("auth")
public class AuthPageTests extends BaseTests {
    AuthFormPage authFormPage = new AuthFormPage();
    MainFormPage mainFormPage = new MainFormPage();
    Faker faker = new Faker();
    String login = faker.name().username();
    String password = faker.internet().password();

    @Test
    @DisplayName("Aутентификация c корректными логином и паролем")
    void authWithCorrectLoginAndPassword() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        authFormPage.openLogOnPage("/Security/Account/LogOn")
                .setLoginAndPassword("admin", "1")
                .clickLogInButton();
        mainFormPage.checkWelcome("Добро пожаловать в систему ELMA!");
        /*Allure.getLifecycle().addAttachment(
                "Исходники страницы",
                "text/html",
                "html",
                WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
        );*/
        attachScreenshot();
    }

    @Test
    @DisplayName("Aутентификация c некорректным логином")
    void authWithIncorrectLogin() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        authFormPage.openLogOnPage("/Security/Account/LogOn")
                .setLoginAndPassword(login, "1")
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");
        attachScreenshot();
    }

    @Test
    @DisplayName("Aутентификация c некорректным паролем")
    void authWithIncorrectPassword() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        authFormPage.openLogOnPage("/Security/Account/LogOn")
                .setLoginAndPassword("admin", password)
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");
        attachScreenshot();
    }

    @Test
    @DisplayName("Aутентификация c некорректными логином и паролем")
    void authWithIncorrectLoginAndPassword() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        authFormPage.openLogOnPage("/Security/Account/LogOn")
                .setLoginAndPassword(login, password)
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");
        attachScreenshot();
    }

    @Test
    @DisplayName("Aутентификация c пустыми логином и паролем")
    void authWithoutLoginAndPassword() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        authFormPage.openLogOnPage("/Security/Account/LogOn")
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");
        attachScreenshot();
    }
}
