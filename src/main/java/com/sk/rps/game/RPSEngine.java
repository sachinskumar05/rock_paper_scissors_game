package com.sk.rps.game;

import com.sk.rps.player.Computer;
import com.sk.rps.player.Human;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@ComponentScan(value = "com.sk.rps")
public class RPSEngine {

    @Autowired
    private ResultService resultService;

    @Autowired
    private Human human;

    @Autowired
    private Computer computer;

    private int humanScore;

    private int computerScore;

    private int totalGamesPlayed;

    private int tieGame;

    public void startGame() {

        CHOICES humanChosenGameOption = human.choose();

        resultService.display(human.getName(), humanChosenGameOption);

        CHOICES computerInput = computer.choose();
        resultService.display(computer.getName(), computerInput);

        RESULT result = resultService.execute(humanChosenGameOption, computerInput);
        switch (result) {
            case TIE:
                log.info("TIE!");
                tieGame++;
                break;
            case WON:
                log.info(human.getName()+ " WINS against Computer");
                humanScore++;
                break;
            case LOST:
                log.info("Computer WINS against "+ human.getName());
                computerScore++;
                break;
            default: {
                throw new IllegalArgumentException(String.format("Unexpected Result Received %s", result));
            }
        }

        totalGamesPlayed++;

    }

    public boolean isRepeat() {
        if (human.repeat()) {
            return true;
        } else {
            log.info(" END Of The Game \n");
            printResult();
        }
        return false;
    }

    public void recordHumanPlayerName() {
        human.requestPlayerName();
    }

    private static final String RESULT_FORMAT = "%15s %15s";

    public void printResult() {
        log.info("Overall games played => {}\n", totalGamesPlayed);

        log.info(" ****** SCORE BOARD ****** ");
        log.info(String.format("%30s", "---------------------------------"));
        log.info(String.format(RESULT_FORMAT, "PLAYER", "SCORE"));
        log.info(String.format(RESULT_FORMAT, "------", "------"));
        log.info(String.format(RESULT_FORMAT, "Mr. "+human.getName(), humanScore));
        log.info(String.format(RESULT_FORMAT, "Computer", computerScore));
        log.info(String.format(RESULT_FORMAT, "TIE's", tieGame ));
        log.info(String.format("%30s", "---------------------------------"));

        log.info(" ****** FINAL RESULT ****** ");
        if( humanScore == computerScore ) {
            log.info("ITS A TIE !");
        } else {
            log.info("Final Winner is {}. {}",
                    ((humanScore > computerScore) ? human.getName() : "Computer"),
                    ((humanScore > computerScore) ? "\n!!! CONGRATULATIONS !!!":"")
            );
        }

    }
}