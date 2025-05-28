package com.example;

import com.example.UliBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
class Main implements CommandLineRunner {
    @Autowired
    UliBean uliBean;
    
    @Override
    public void run(String... args) throws Exception {
        main(args);
    }
    
    public void main(final String[] args) {
        System.out.println("Main - main: Hello, World!"); 
	    System.out.println("Secret: "+uliBean.getSecret());
        System.exit(0);
    }
}
