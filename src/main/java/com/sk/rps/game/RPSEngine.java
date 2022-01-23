package com.sk.rps.game;

import com.sk.rps.player.Player;
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
    private DisplayService displayService;

    @Autowired
    private Player human;

    @Autowired
    private Player computer;

    private int totalGamesPlayed;


    public void startGame() {

        CHOICES humanChoice = human.choose();
        displayService.display(human.getName(), humanChoice);

        CHOICES computerInput = computer.choose();
        displayService.display(computer.getName(), computerInput);

        RESULT result = resultService.execute(humanChoice, computerInput);
        switch (result) {
            case TIE:
                log.info("TIE!");
                break;
            case WON:
                log.info("{} WINS against {}, new score is {}",
                        human.getName(), computer.getName(), human.scoreIncrementAndGet());
                break;
            case LOST:
                log.info("{} WINS against {}, new score is {}",
                        computer.getName(), human.getName(), computer.scoreIncrementAndGet());
                break;
            default: {
                throw new IllegalArgumentException(String.format("Unexpected Result Received %s", result));
            }
        }

        totalGamesPlayed++;

    }

    public boolean shouldRepeat() {

        if (human.canRepeat()) {
            return true;
        } else {
            log.info(" END OF THE GAME \n");
            displayService.printResult(totalGamesPlayed);
        }
        return false;
    }

    public void recordHumanPlayerName() {
        human.setName();
    }

}