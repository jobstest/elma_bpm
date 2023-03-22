package com.elma.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.readonly;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthFormPage {

    //locators
    SelenideElement loginInput =  $("#login");
    SelenideElement passwordInput = $("#password");
    SelenideElement buttonLogIn = $("#LogIn");
    SelenideElement errorMessage = $("[id=errorMessage]");

    //actions
    public AuthFormPage openPage(String url) {
        open(url);

        return this;
    }

    public AuthFormPage setLogin(String login) {
        loginInput.setValue(login);

        return this;
    }

    public AuthFormPage setPassword(String password) {
        passwordInput.setValue(password);

        return this;
    }

    public AuthFormPage clickLogInButton() {
        buttonLogIn.click();

        return this;
    }

    public AuthFormPage checkErrorMessage(String message){
        errorMessage.shouldHave(text(message));

        return this;
    }
}
