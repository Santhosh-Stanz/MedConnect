package com.MedConnect.Service;

import org.springframework.stereotype.Component;

@Component
public class Input {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
