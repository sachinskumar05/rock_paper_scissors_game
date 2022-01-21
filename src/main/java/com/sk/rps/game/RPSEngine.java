package com.sk.rps.game;

import com.sk.rps.player.Computer;
import com.sk.rps.player.Human;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class RPSEngine {
    @Autowired
    ResultService resultService;

    private Human human;
    private Computer computer;

    private int humanScore;

    private int computerScore;

    // total number of games played
    private int totalGamesPlayed;

    //number of games tie
    private int tieGame;

    public RPSEngine(){
        human = new Human();
        computer = new Computer();
        humanScore = 0;
        computerScore = 0;
        totalGamesPlayed = 0;
        tieGame = 0;
    }

    //Start and play the game
    public void startGame() {

        GameOptions humanChosenGameOption = human.choose();
        resultService.display(human.getName(), humanChosenGameOption);

        GameOptions computerInput = computer.getInput();
        resultService.display("Computer", computerInput);

        // Compare moves to determine the winner of a round
        int result = resultService.execute(humanChosenGameOption, computerInput);
        switch (result) {
            case 0:
                log.info("This round is a TIE!");
                tieGame++;
                break;
            case 1:
                log.info(human.getName()+ " Beats Computer \n You WON this round ! ");
                humanScore++;
                break;
            case -1:
                log.info("Computer Beats "+ human.getName()+" \n Computer WON this round ! ");
                computerScore++;
                break;
            default: {
                throw new IllegalArgumentException(String.format("Unexpected result received %s",result));
            }
        }

        totalGamesPlayed++;

        if (human.repeat()) {
            startGame();
        }
         else {
            log.info(" EXITING THE GameOptions \n");
            showResults();
        }
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
        log.info(human.getName()+"'s score ---> " + humanScore);
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
