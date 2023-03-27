package com.elma.tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class MainFormPage {

    //locators
    SelenideElement welcomeText = $("#trPageHeader");
    //actions
    public MainFormPage checkWelcome(String value) {
        step("Проверить приветствие на главной странице", () -> {
            welcomeText.shouldHave(text(value));
        });

        return this;
    }
}
