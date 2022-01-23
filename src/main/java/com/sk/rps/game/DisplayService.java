package com.sk.rps.game;

import com.sk.rps.player.Computer;
import com.sk.rps.player.Human;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@ComponentScan(value = "com.sk.rps")
public class DisplayService {

    @Autowired
    private Human human;

    @Autowired
    private Computer computer;

    public void display(String player, CHOICES s) {
        switch (s) {
            case ROCK:
                log.info(player + " selected => ROCK ");
                break;
            case PAPER:
                log.info(player + " selected => PAPER ");
                break;
            case SCISSORS:
                log.info(player + " selected => SCISSORS ");
                break;
            default:
                break;
        }
    }

    private static final String RESULT_FORMAT = "%15s %15s";
    private static final String LINE = "---------------------------------";

    public void printResult(int totalGamesPlayed) {
        int humanScore = human.getScore();
        int computerScore = computer.getScore();
        log.info("Overall games played => {}\n", totalGamesPlayed);

        log.info(" ****** SCORE BOARD ****** ");
        log.info(String.format("%30s", LINE ));
        log.info(String.format(RESULT_FORMAT, "PLAYER", "SCORE"));
        log.info(String.format(RESULT_FORMAT, "------", "------"));
        log.info(String.format(RESULT_FORMAT, human.getName(), humanScore));
        log.info(String.format(RESULT_FORMAT, computer.getName(), computerScore));
        log.info(String.format(RESULT_FORMAT, "Game TIE's", (totalGamesPlayed - (humanScore + computerScore))));
        log.info(String.format("%30s", LINE));

        log.info("");
        log.info("");
        log.info(String.format("%30s", LINE));
        log.info(" ****** FINAL RESULT ****** ");
        if( humanScore == computerScore ) {
            log.info("ITS A TIE !");
        } else {
            log.info("Final Winner is {}. {}",
                    ((humanScore > computerScore) ? human.getName() : "Computer"),
                    ((humanScore > computerScore) ? " !!! CONGRATULATIONS !!!":"")
            );
        }
        log.info(String.format("%30s", LINE));

    }
}
