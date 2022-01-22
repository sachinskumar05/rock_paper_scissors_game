package com.sk.rps.player;

import com.sk.rps.game.CHOICES;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Random;

@Log4j2
@Component
@ComponentScan(value = "com.sk.rps")
public class Computer implements Player {
    @Getter
    private String name = "Computer";

    private final Random random = new Random();

    @Override
    public CHOICES choose() {
        return CHOICES.valueOf(random.nextInt(3)+1);
    }
}
