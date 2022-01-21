package com.sk.rps.player;

import com.sk.rps.game.GameOptions;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Log4j2
@Component
@Data
public class Human implements Player {

    private String name;

    @Setter(AccessLevel.NONE) @Getter(AccessLevel.NONE)
    private final Scanner sc = new Scanner(System.in);

    public void requestPlayerName() {
        log.info("Please enter your name");
        name = sc.next();
    }

    public GameOptions choose() {
        log.info("Choose one from \t r => ROCK \n\t\t p => PAPER \n\t\t s => SCISSOR");
        String input = sc.next();
        return GameOptions.valueOf(input.charAt(0));

    }

    public boolean repeat() {
        // This function will ask if the user wants to play again and return true or false accordingly.
        log.info("To play again? \n\t enter (y) if yes  \n\t or any other character to end the game");
        String userInput = sc.nextLine();
        userInput = userInput.toUpperCase();
        return userInput.charAt(0) == 'Y';
    }
}
