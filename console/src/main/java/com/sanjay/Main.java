package com.sanjay;

import com.sanjay.config.GameConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // == get spring context ==
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);

        // == close context ==
        context.close();
    }
}
