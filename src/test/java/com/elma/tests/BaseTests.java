package com.elma.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.elma.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTests {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browserSize = "1920x1080";
        //Configuration.remote = "http://localhost:8080/#/";

    }

    @BeforeEach
    void openElma() {
        Configuration.baseUrl = "http://192.168.0.90:7000";
    }

    @AfterEach
    void addAttchments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        WebDriverRunner.closeWindow();
    }

}
