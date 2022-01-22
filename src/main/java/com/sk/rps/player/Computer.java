package com.sk.rps.player;

import com.sk.rps.game.GameOptions;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Random;

@Log4j2
@Component
@ComponentScan(value = "com.sk.rps")
public class Computer implements Player {
    private final Random random = new Random();

    public GameOptions getInput() {
        return GameOptions.valueOf(random.nextInt(3)+1);
    }
}
