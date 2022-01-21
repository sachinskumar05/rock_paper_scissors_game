package com.sk.rps.game;

public enum GameOptions {
    ROCK(1), PAPER(2), SCISSORS(3);
    private final int value;

    GameOptions(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static GameOptions valueOf(int value) {
        switch(value) {
            case 'r':
            case 'R':
            case 1:
                return ROCK;
            case 'p':
            case 'P':
            case 2:
                return PAPER;
            case 's':
            case 'S':
            case 3:
                return SCISSORS;
            default: throw new IllegalArgumentException("Not Supported");
        }
    }


}
