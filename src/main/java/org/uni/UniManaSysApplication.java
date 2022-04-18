package org.uni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"org.uni.Controller"})
public class UniManaSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniManaSysApplication.class, args);
    }

}
