package com.sanjay.config;

import com.sanjay.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.sanjay")
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    @Value("${game.guessCount:20}")
    private int guessCount;
    @Value("${game.maxNumber:5}")
    private int maxNumber;

    @Value("${game.minNumber}")
    private int minNumber;

    @Bean
    public int guessCount() {
        return guessCount;
    }

    @Bean
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumbers() { return minNumber; }
}
