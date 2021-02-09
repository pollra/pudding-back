package com.pollra.pudding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=PuddingBackApplication.class)
public class PuddingBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PuddingBackApplication.class, args);
    }
}
