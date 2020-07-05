package com.sanjay;

import com.sanjay.config.AppConfig;
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

        // == get message bean
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("Called main message and it returned : {}", messageGenerator.getMainMessage());
        log.info("Called result message and it returned : {}", messageGenerator.getResultMessage());

        context.close();
    }
}
