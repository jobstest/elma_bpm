package com.elma.tests;

import com.elma.pages.AuthFormPage;
import com.elma.pages.MainFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class AuthPageTests extends BaseTests{
    AuthFormPage authFormPage = new AuthFormPage();
    MainFormPage mainFormPage = new MainFormPage();
    Faker faker = new Faker();
    String login = faker.name().username();
    String password = faker.internet().password();

    @Test
    void authWithCorrectLoginAndPassword() {
        authFormPage.setLogin("admin")
                .setPassword("1")
                .clickLogInButton();
        mainFormPage.checkWelcome("Добро пожаловать в систему ELMA!");
    }

    @Test
    void authWithIncorrectLogin() {
        authFormPage.setLogin(login)
                .setPassword("1")
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");

    }

    @Test
    void authWithIncorrectPassword() {
        authFormPage.setLogin("admin")
                .setPassword(password)
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");

    }

    @Test
    void authWithIncorrectLoginAndPassword() {
        authFormPage.setLogin(login)
                .setPassword(password)
                .clickLogInButton()
                .checkErrorMessage("Неверное имя пользователя или пароль.");
    }
}
