package com.sk.rps.game;

public enum CHOICES {
    ROCK(1), PAPER(2), SCISSORS(3);
    private final int value;

    CHOICES(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static CHOICES valueOf(int value) {
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
            default: throw new IllegalArgumentException("Choice Not Supported");
        }
    }


}
