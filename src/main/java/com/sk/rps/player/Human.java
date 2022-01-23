package com.sk.rps.player;

import com.sk.rps.config.AppConfig;
import com.sk.rps.game.CHOICES;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
@Component
@ComponentScan(value = "com.sk.rps")
public class Human implements Player {
    @Autowired
    private AppConfig appConfig;

    @Getter
    private String name;

    @Getter
    private int maxRetryInvalidArguments;

    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    private AtomicInteger score = new AtomicInteger(0);

    @Setter(AccessLevel.NONE) @Getter(AccessLevel.NONE)
    private Scanner sc ;

    public Human(){
    }

    Human(Scanner sc, AppConfig appConfig) {//For the test cases
        this.sc = sc;
        this.appConfig = appConfig;
    }

    @PostConstruct
    public void init() {
        maxRetryInvalidArguments = appConfig.getMaxRetryInvalidArguments();
        if( null== sc ){
            sc = new Scanner(System.in,"utf-8");
        }
    }

    public void setName() {
        log.info("Please enter your name");
        name = sc.next();
    }

    @Override
    public CHOICES choose() {
        String input = null;
        for(int retryCount = 0; retryCount < maxRetryInvalidArguments + 1; retryCount++ ) {
            try {
                log.info("\nWelcome \t{}", name);
                log.info("\n\tChoose one from below choices:\n\t\t r => ROCK \n\t\t p => PAPER \n\t\t s => SCISSOR");
                input = sc.next();
                return CHOICES.valueOf(input.charAt(0));
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

    @Override
    public int getScore() {
        return score.get();
    }

    @Override
    public int scoreIncrementAndGet() {
        return score.incrementAndGet();
    }

    public boolean canRepeat() {
        String userInput = null;
        for( int retryCount=0; retryCount < maxRetryInvalidArguments; retryCount++ ) {
            log.info("\n\tTo Try Again:\n\t\t y => NEW GAME\n\t\t n => END The Game");
            userInput = sc.next();
            while( null == userInput || userInput.trim().isEmpty() ) {//Capturing ENTER to exit the game
                userInput = sc.next();
            }
            userInput = userInput.toUpperCase();
            if( userInput.charAt(0) == 'Y' ) {
                return true;
            } else if(userInput.charAt(0) == 'N') {
                return false;
            }
            log.info("Please retry: Valid entries expected are, y or n ");
        }
        throw new IllegalArgumentException(String.format("Invalid instruction received %s", userInput));
    }
}
