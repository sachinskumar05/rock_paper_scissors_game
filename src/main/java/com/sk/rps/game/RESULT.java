package com.sk.rps.game;

public enum RESULT {
    TIE(0), WON(1), LOST(-1);
    private final int value;

    RESULT(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static RESULT valueOf(int value) {
        switch(value) {
            case 0:
                return TIE;
            case 1:
                return WON;
            case -1:
                return LOST;
            default: throw new IllegalArgumentException("Choice Not Supported");
        }
    }
}
