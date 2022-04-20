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


/*        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/*")
                *//**
                 * 放行 主页，swagger ,
                 *//*
                .excludePathPatterns("/swagger-resources/**"
                        , "/webjars/**"
                        , "/v2/**"
                        , "/swagger-ui.html/**",
                        "/index.html",
                        "/test.html",
                        "/pages-register.html",
                        "/pages-login.html",
                        //******放行了静态资源*********
                        "classpath:/static/**",
                        "classpath:/static/vuejs/**",
                        "classpath:/static/assets/**",
                        "classpath:/static/forms/**");*/
    }
}
