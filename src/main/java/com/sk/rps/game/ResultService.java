package com.sk.rps.game;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import static com.sk.rps.game.CHOICES.*;

@Log4j2
@Service
@ComponentScan(value = "com.sk.rps")
public class ResultService {

  public RESULT execute(CHOICES humanChosen, CHOICES computerChosen) {
    switch (humanChosen) {
      case ROCK:
        return (computerChosen == SCISSORS ? RESULT.WON : RESULT.LOST);
      case PAPER:
        return (computerChosen == ROCK ? RESULT.WON : RESULT.LOST);
      case SCISSORS:
        return (computerChosen == PAPER ? RESULT.WON : RESULT.LOST);
    }
    return RESULT.TIE;
  }
}
