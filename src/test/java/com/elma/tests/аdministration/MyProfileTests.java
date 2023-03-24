package com.elma.tests.аdministration;

import com.elma.pages.AuthFormPage;
import com.elma.tests.BaseTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;

public class MyProfileTests extends BaseTests {
    AuthFormPage authFormPage = new AuthFormPage();

    @Test
    @Disabled
    void downloadvCard() throws IOException, InterruptedException {
        authFormPage.setLoginAndPassword("admin", "1")
                .clickLogInButton();
        open("http://192.168.0.90:7000/Security/User/CurrentProfile");
        sleep(1000);
        File textFile = $(By.linkText("Экспорт vCard")).download();
        try (InputStream is = new FileInputStream(textFile)) {
            byte[] fileContent = is.readAllBytes();
            String strContent = new String(fileContent, StandardCharsets.UTF_8);
            assertThat(strContent).contains("");
        }
    }
}
