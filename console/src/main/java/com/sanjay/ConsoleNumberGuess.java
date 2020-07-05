package com.sanjay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ConsoleNumberGuess {
    public static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // This method will be called whenever context refreshes
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start() -> Container read to use");
    }
}
