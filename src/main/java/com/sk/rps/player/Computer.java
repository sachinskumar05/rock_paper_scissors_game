package com.sk.rps.player;

import com.sk.rps.game.CHOICES;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Log4j2
@Component
@ComponentScan(value = "com.sk.rps")
public class Computer implements Player {

    private static final String NAME = "Computer";

    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    private AtomicInteger score = new AtomicInteger(0);

    @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
    private final Random random = new Random();

    @Override
    public CHOICES choose() {
        return CHOICES.valueOf(random.nextInt(3)+1);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void setName() {
        throw new UnsupportedOperationException("Can't set Computer Name");
    }

    @Override
    public int getScore() {
        return score.get();
    }

    @Override
    public int scoreIncrementAndGet() {
        return score.incrementAndGet();
    }

    @Override
    public boolean canRepeat() {
        throw new UnsupportedOperationException("Computer can't ask to repeat the game");
    }
}
