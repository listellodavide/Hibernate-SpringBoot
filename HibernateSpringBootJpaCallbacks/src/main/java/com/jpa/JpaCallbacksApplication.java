package com.jpa;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaCallbacksApplication {

    private static final Logger logger = Logger.getLogger(JpaCallbacksApplication.class.getName());

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(JpaCallbacksApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            userService.insertUser();
            userService.selectUpdateDeleteUser();

        };
    }
}
