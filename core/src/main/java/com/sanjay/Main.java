package com.sanjay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Number generated");
        // == get spring context ==
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // == get number generator bean
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        // == get next number ==
        int number = numberGenerator.next();
        log.info("Next number is {}", number);

        // == get game bean
        Game game = context.getBean(Game.class);

        context.close();
    }
}
