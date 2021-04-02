package com.apress.prospring5.ch4;

import org.springframework.beans.factory.annotation.Value;

public class ConfigurableMessageProvider {

    private String message;

    public ConfigurableMessageProvider(@Value("Love on the weekend") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
