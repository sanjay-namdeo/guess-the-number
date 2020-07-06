package com.sanjay;

import com.sanjay.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // == get spring context ==
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // == close context ==
        context.close();
    }
}
