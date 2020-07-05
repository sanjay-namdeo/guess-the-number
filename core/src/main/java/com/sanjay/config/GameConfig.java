package com.sanjay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    private int guessCount = 10;
    private int maxNumber = 100;

    @Bean
    public int guessCount() {
        return guessCount;
    }

    @Bean
    public int maxNumber() {
        return maxNumber;
    }
}
