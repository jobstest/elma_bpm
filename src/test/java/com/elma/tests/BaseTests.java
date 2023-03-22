package com.elma.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTests {
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
}
