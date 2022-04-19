package org.uni.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.uni.Interceptors.LoginInterceptor;


@Configuration
public class interceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();

        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/index.html");
    }
}
