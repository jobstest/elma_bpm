package com.elma.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainFormPage {

    //locators
    SelenideElement welcomeText = $("#trPageHeader");
    //actions
    public MainFormPage checkWelcome(String value) {
        welcomeText.shouldHave(text(value));

        return this;
    }
}
