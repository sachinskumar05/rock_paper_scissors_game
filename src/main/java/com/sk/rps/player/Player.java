package com.sk.rps.player;

import com.sk.rps.game.CHOICES;

public interface Player {

    CHOICES choose();

    String getName();

    void setName();

    boolean canRepeat();

    int getScore();

    int scoreIncrementAndGet();

}
