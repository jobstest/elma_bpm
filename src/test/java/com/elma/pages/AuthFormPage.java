package com.elma.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AuthFormPage {

    //locators
    SelenideElement loginInput = $("#login");
    SelenideElement passwordInput = $("#password");
    SelenideElement buttonLogIn = $("#LogIn");
    SelenideElement errorMessage = $("[id=errorMessage]");

    //actions
    public AuthFormPage openLogOnPage(String url) {
        step("Открыть страницу аутентификации", () -> {
            open(url);
        });

        return this;
    }

    public AuthFormPage setLoginAndPassword(String login, String password) {
        step("Заполнить поля 'Имя пользователя' и 'Пароль'", () -> {
            loginInput.setValue(login);
            passwordInput.setValue(password);
        });

        return this;
    }

    public AuthFormPage clickLogInButton() {
        step("Нажать на кнопку 'Войти в систему'", () -> {
            buttonLogIn.click();
        });

        return this;
    }

    public AuthFormPage checkErrorMessage(String message) {
        step("Проверить наличие сообщение об ошибке входа", () -> {
            errorMessage.shouldHave(text(message));
        });

        return this;
    }
}
