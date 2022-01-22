package com.sk.rps.player;

import com.sk.rps.config.AppConfig;
import com.sk.rps.game.GameOptions;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Log4j2
@Data
@Component
@ComponentScan(value = "com.sk.rps")
public class Human implements Player {
    @Autowired
    private AppConfig appConfig;

    private String playerName;

    private int maxRetryInvalidArguments;

    @PostConstruct
    public void init() {
        maxRetryInvalidArguments = appConfig.getMaxRetryInvalidArguments();
    }

    @Setter(AccessLevel.NONE) @Getter(AccessLevel.NONE)
    private final Scanner sc = new Scanner(System.in,"utf-8");

    public void requestPlayerName() {
        log.info("Please enter your name");
        playerName = sc.next();
    }

    public GameOptions choose() {
        String input = null;
        for(int retryCount = 0; retryCount < maxRetryInvalidArguments + 1; retryCount++ ) {
            try {
                log.info("\nChoose one from below choices:\n\t \t r => ROCK \n\t\t p => PAPER \n\t\t s => SCISSOR");
                input = sc.next();
                return GameOptions.valueOf(input.charAt(0));
            } catch (IllegalArgumentException e) {
                log.error("Invalid Choice {}, Please Try One More Time, {} more chance left.",
                        input, (maxRetryInvalidArguments - retryCount) );
                if( retryCount == maxRetryInvalidArguments ) {
                    throw e;
                }
            }
        }
        throw new IllegalArgumentException(String.format("Entered choice is not supported %s", input));
    }

    public boolean repeat() {
        sc.nextLine();//Just to hold the line for next input
        log.info("\n\t\t To play again please enter (y) \n\t\t Otherwise Press ENTER to end the game");
        String userInput = sc.nextLine();
        if( null == userInput || userInput.trim().isEmpty() ) {//Capturing ENTER to exit
            return false;
        }
        userInput = userInput.toUpperCase();
        return userInput.charAt(0) == 'Y';
    }
}
