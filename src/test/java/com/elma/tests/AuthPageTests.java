package com.elma.tests;

import com.elma.pages.AuthFormPage;
import com.elma.pages.MainFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Класс аутентификации на странице")
public class AuthPageTests extends BaseTests{
    AuthFormPage authFormPage = new AuthFormPage();
    MainFormPage mainFormPage = new MainFormPage();
    Faker faker = new Faker();
    String login = faker.name().username();
    String password = faker.internet().password();

    @Test
    @DisplayName("Aутентификация c корректными логином и паролем")
    void authWithCorrectLoginAndPassword() {
        authFormPage.setLoginAndPassword("admin", "1")
                .clickLogInButton();
        mainFormPage.checkWelcome("Добро пожаловать в систему ELMA!");
    }

    @Test
    @DisplayName("Aутентификация c некорректным логином")
    void authWithIncorrectLogin() {
        authFormPage.setLoginAndPassword(login, "1")
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");

    }

    @Test
    @DisplayName("Aутентификация c некорректным паролем")
    void authWithIncorrectPassword() {
        authFormPage.setLoginAndPassword("admin", password)
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");

    }

    @Test
    @DisplayName("Aутентификация c некорректными логином и паролем")
    void authWithIncorrectLoginAndPassword() {
        authFormPage.setLoginAndPassword(login, password)
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");
    }

    @Test
    @DisplayName("Aутентификация c пустыми логином и паролем")
    void authWithoutLoginAndPassword(){
        authFormPage.clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");
    }
}
