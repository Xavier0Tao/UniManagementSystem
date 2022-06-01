package org.uni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ServletComponentScan(basePackages = {"org.uni.Controller","org.uni.Interceptors"})
@EnableSwagger2
public class UniManaSysApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UniManaSysApplication.class, args);
    }

}
