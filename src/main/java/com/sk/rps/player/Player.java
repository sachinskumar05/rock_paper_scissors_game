package com.sk.rps.player;

import com.sk.rps.game.CHOICES;

public interface Player {
    String UTF_8 = "UTF-8";
    CHOICES choose();

    String getName();

    void setName();

    boolean canRepeat();

    int getScore();

    int scoreIncrementAndGet();

}
