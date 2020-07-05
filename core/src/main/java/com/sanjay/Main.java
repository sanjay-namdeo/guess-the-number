package com.sanjay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static final Logger log = LoggerFactory.getLogger(Main.class);
    public static final String CONTEXT_PATH = "beans.xml";

    public static void main(String[] args) {
        log.info("Number generated");
        // == get spring context from beans.xml ==
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_PATH);
        // == get number generator bean
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);
        // == get next number ==
        int number = numberGenerator.next();
        log.info("Next number is {}", number);

        // == get game bean
        Game game = context.getBean(Game.class);
        game.reset();

        context.close();
    }
}
