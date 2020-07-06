package com.sanjay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {
    // Private fields
    private final Random random = new Random();
    private final int maxNumber;

    private final int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MinNumber int minNumber, int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    // public methods
    @Override
    public int next() {
        return random.nextInt(maxNumber);
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }


}
