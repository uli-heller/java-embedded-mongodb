package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class Application {
    public static void main(final String[] args) {
        System.out.println("Hello, World!"); 
	    SpringApplication.run(Application.class, args);
    }
}
