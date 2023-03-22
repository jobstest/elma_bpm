package com.elma.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.elma.pages.AuthFormPage;
import com.elma.pages.MainFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class AuthPageTest {
    AuthFormPage authFormPage = new AuthFormPage();
    MainFormPage mainFormPage = new MainFormPage();
    Faker faker = new Faker();
    String login = faker.name().username();
    String password = faker.internet().password();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void openElma() {
        open("http://192.168.0.90:7000");
    }

    @AfterEach
    void closeElma() {
        WebDriverRunner.closeWindow();
    }

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
