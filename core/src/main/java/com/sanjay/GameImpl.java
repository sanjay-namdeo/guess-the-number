package com.sanjay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GameImpl implements Game {
    // == Constants ==
    public static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == private fields ==
    @Autowired
    private NumberGenerator numberGenerator;

    @Autowired
    private int guessCount;
    private int number;
    private int guess;
    private int smallest;
    private int largest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

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
    public int getGuessCount() {
        return guessCount;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getLargest() {
        log.info("Largest number is {}", largest);
        return largest;
    }

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
    public boolean isValidNumberRange() {
        return validNumberRange;
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
