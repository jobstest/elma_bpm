package com.elma.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthFormPage {

    //locators
    SelenideElement loginInput = $("#login");
    SelenideElement passwordInput = $("#password");
    SelenideElement buttonLogIn = $("#LogIn");
    SelenideElement errorMessage = $("[id=errorMessage]");

    //actions
    public AuthFormPage openPage(String url) {
        open(url);

        return this;
    }

    public AuthFormPage setLoginAndPassword(String login, String password) {
        loginInput.setValue(login);
        passwordInput.setValue(password);
        return this;
    }

    public AuthFormPage clickLogInButton() {
        buttonLogIn.click();

        return this;
    }

    public AuthFormPage checkErrorMessage(String message) {
        errorMessage.shouldHave(text(message));

        return this;
    }
}
