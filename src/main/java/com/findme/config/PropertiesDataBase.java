package com.findme.config;

import org.springframework.beans.factory.annotation.Value;

public class PropertiesDataBase {
    @Value(value = "${url.database}")
    private String urlDatabase;
    @Value(value = "${user.login}")
    private String userLogin;
    @Value(value = "${user.password}")
    private String userPassword;
    @Value(value = "${driver.class.name}")
    private String driverClassName;

    public PropertiesDataBase() {
    }

    public String getUrlDatabase() {
        return urlDatabase;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getDriverClassName() {
        return driverClassName;
    }
}
