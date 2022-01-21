package com.sk.rps.game;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static com.sk.rps.game.GameOptions.*;

@Log4j2
@Service
public class ResultService {

    public void display(String who, GameOptions s) {
        switch (s) {
            case ROCK:
                log.info(who + " selected ---> ROCK ");
                break;
            case PAPER:
                log.info(who + " selected ---> PAPER ");
                break;
            case SCISSORS:
                log.info(who + " selected ---> SCISSORS ");
                break;
            default:
                break;
        }
    }

    public int execute(GameOptions humanChosen, GameOptions computerChosen) {
        if ( humanChosen == computerChosen ) return 0;
        switch (humanChosen) {
            case ROCK:
                return (computerChosen == SCISSORS ? 1 : -1);
            case PAPER:
                return (computerChosen == ROCK ? 1 : -1);
            case SCISSORS:
                return (computerChosen == PAPER ? 1 : -1);
        }
        return 0;
    }
}
