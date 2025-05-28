package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class UliBeanTest {
  @Autowired
  UliBean uliBean;

  @Test
  public void testUliBean() {
    uliBean.getSecret();
    assertEquals("SECRET!", uliBean.getSecret());
  }
  @TestConfiguration
  public static class ThisTestConfiguration {
    @Bean
    UliBean uliBean() {
      return new UliBeanImpl();
    }
  }
}