package com.pollra.pudding;

import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=PuddingBackApplication.class)
@EncryptablePropertySource({"classpath:application.yml"})
public class PuddingBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PuddingBackApplication.class, args);
    }
}
