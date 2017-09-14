package com.spring;

import org.springframework.stereotype.Component;

@Component
public class UserContext {

    public String getLoggedInUser() {
        return "Mr. Bean";
    }
}