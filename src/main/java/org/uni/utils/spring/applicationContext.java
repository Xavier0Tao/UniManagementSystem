package org.uni.utils.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class applicationContext {
    public static ApplicationContext context;

    static {
        context = new AnnotationConfigApplicationContext("org.uni");
    }

}
