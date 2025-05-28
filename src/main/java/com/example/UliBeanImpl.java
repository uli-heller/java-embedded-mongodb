package com.example;

import org.springframework.stereotype.Component;

@Component
public class UliBeanImpl implements UliBean {
    private String secret;
    
    public UliBeanImpl() {
	this.secret = "SECRET!";
    }

    public String getSecret() {
	return this.secret;
    }
}
