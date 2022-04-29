package org.uni.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.uni.Interceptors.LoginInterceptor;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class interceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();

        List<String> patterns1 = new ArrayList<>();
//        patterns1.add("/");
//        registry.addInterceptor(loginInterceptor).addPathPatterns()

    }
}
