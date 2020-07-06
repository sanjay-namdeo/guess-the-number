package com.sanjay;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Slf4j
@Getter
public class GameImpl implements Game {
    // == private fields ==
    @Getter(AccessLevel.NONE)
    private NumberGenerator numberGenerator;

    private int guessCount;
    private int number;
    @Setter
    private int guess;
    private int smallest;
    private int largest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    // == init ==
    @PostConstruct
    @Override
    public void reset() {
        guess = 0;
        largest = numberGenerator.getMaxNumber();
        smallest = numberGenerator.getMinNumber();
        number = numberGenerator.next();
        remainingGuesses = guessCount;
        log.info("Number is {}", number);
    }


    @PreDestroy
    public void onPreDestroy() {
        log.info("Before destroying");
    }
    // == public methods ==

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public void check() {
        if (isValidRange()) {
            if (guess < number) {
                smallest = guess + 1;
            }
            if (guess > number) {
                largest = guess - 1;
            }
        }
        remainingGuesses--;
    }


    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
    private boolean isValidRange() {
        validNumberRange = guess <= largest && guess >= smallest;
        return validNumberRange;
    }
}
