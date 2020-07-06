package com.sanjay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Slf4j
public class ConsoleNumberGuess {
    private final Game game;

    private final MessageGenerator messageGenerator;

    @Autowired
    public ConsoleNumberGuess(final Game game, final MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // This method will be called whenever context refreshes
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(number);
            game.check();

            if(game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());

                System.out.println("Do you want to play again y/n?");

                String continueGame = scanner.nextLine();
                if(!"y".equalsIgnoreCase(continueGame)) {
                    break;
                }
                game.reset();
            }
        }
    }
}
