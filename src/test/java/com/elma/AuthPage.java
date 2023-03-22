package com.elma;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthPage {

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
        $("[id=login]").setValue("admin");
        $("[id=password]").setValue("1");
        $("[id=LogIn]").click();
        $("[id=trPageHeader]").shouldHave(text("Добро пожаловать в систему ELMA!"));
    }

    @Test
    void authWithIncorrectLoginAndCorrectPassword() {
        $("[id=login]").setValue("admi");
        $("[id=password]").setValue("1");
        $("[id=LogIn]").click();
        $("[id=errorMessage]").shouldHave(text("Неверное имя пользователя или пароль."));
    }

    @Test
    void authWithIncorrectPassword() {
        $("[id=login]").setValue("admin");
        $("[id=password]").setValue("2");
        $("[id=LogIn]").click();
        $("[id=errorMessage]").shouldHave(text("Неверное имя пользователя или пароль."));
    }

    @Test
    void authWithIncorrectLoginAndPassword() {
        $("[id=login]").setValue("admi");
        $("[id=password]").setValue("password");
        $("[id=LogIn]").click();
        $("[id=errorMessage]").shouldHave(text("Неверное имя пользователя или пароль."));
    }
}
