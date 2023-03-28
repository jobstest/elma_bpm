package com.elma.config;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverConfig extends Config {

    // зачитываем данные из командной строки
    @Key("baseUrl")
    // обрабатываем дефолтное значение
    @DefaultValue("http://192.168.0.90:7000")
    // конвертируем в возвращаемый тип
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("remoteUrl")
    @DefaultValue("http://192.168.0.90:4444/wd/hub")
    URL getRemoteUrl();
}
