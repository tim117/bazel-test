package com.bwe.hello.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.framework.spring.boot.autoconfigure",
    "com.bwe.hello"})
public class HelloApplication {
  public static void main(String[] args) {
    SpringApplication.run(HelloApplication.class, args);
  }
}
