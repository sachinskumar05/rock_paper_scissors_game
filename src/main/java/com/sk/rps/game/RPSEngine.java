package com.sk.rps.game;

import com.sk.rps.config.AppConfig;
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

    // total number of games played
    private int totalGamesPlayed;

    //number of games tie
    private int tieGame;

    public RPSEngine(){
        humanScore = 0;
        computerScore = 0;
        totalGamesPlayed = 0;
        tieGame = 0;
    }

    public void startGame() {

        GameOptions humanChosenGameOption = human.choose();

        resultService.display(human.getPlayerName(), humanChosenGameOption);

        GameOptions computerInput = computer.getInput();
        resultService.display("Computer", computerInput);

        int result = resultService.execute(humanChosenGameOption, computerInput);
        switch (result) {
            case 0:
                log.info("TIE!");
                tieGame++;
                break;
            case 1:
                log.info(human.getPlayerName()+ " WINS against Computer");
                humanScore++;
                break;
            case -1:
                log.info("Computer WINS against "+ human.getPlayerName());
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
            log.info(" EXITING THE GameOptions \n");
            showResults();
        }
        return false;
    }

    // get the users name
    public void recordHumanPlayerName() {
        human.requestPlayerName();
    }

    //Print the stats and results
    public void showResults()
    {
        log.info("Total number of games played ---> " +totalGamesPlayed + "\n");

        log.info(" ---- INDIVIDUAL SCORES ---- ");
        log.info(human.getPlayerName()+"'s score ---> " + humanScore);
        log.info("Computer's score ---> " +computerScore);
        log.info("Number of games Tied ---> " +tieGame + "\n");

        log.info(" -------- RESULT -------- ");

        if (humanScore > computerScore) {
            log.info(" YOU WON !!!!");
        }
        else if (computerScore > humanScore) {
            log.info(" COMPUTER WON !!!");
        }
        else {
            log.info("ITS A TIE !");
        }
    }
}
