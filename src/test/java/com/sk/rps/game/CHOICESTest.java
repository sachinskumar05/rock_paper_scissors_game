package com.sk.rps.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CHOICESTest {
    //Field ROCK of type CHOICES - was not mocked since Mockito doesn't mock enums
    //Field PAPER of type CHOICES - was not mocked since Mockito doesn't mock enums
    //Field SCISSORS of type CHOICES - was not mocked since Mockito doesn't mock enums

    @Test
    void testValueOfROCKNumber() {
        CHOICES result = CHOICES.valueOf(1);
        Assertions.assertEquals(CHOICES.ROCK, result);
    }
    @Test
    void testValueOfROCKChar() {
        CHOICES result = CHOICES.valueOf('r');
        Assertions.assertEquals(CHOICES.ROCK, result);
    }
    @Test
    void testValueOfPAPERNumber() {
        CHOICES result = CHOICES.valueOf(2);
        Assertions.assertEquals(CHOICES.PAPER, result);
    }
    @Test
    void testValueOfPAPERChar() {
        CHOICES result = CHOICES.valueOf('p');
        Assertions.assertEquals(CHOICES.PAPER, result);
    }
    @Test
    void testValueOfSCISSORSNumber() {
        CHOICES result = CHOICES.valueOf(3);
        Assertions.assertEquals(CHOICES.SCISSORS, result);
    }

    @Test
    void testValueOfSCISSORSChar() {
        CHOICES result = CHOICES.valueOf('s');
        Assertions.assertEquals(CHOICES.SCISSORS, result);
    }

    @Test
    void testValues() {
        CHOICES[] result = CHOICES.values();
        Assertions.assertArrayEquals(new CHOICES[]{CHOICES.ROCK, CHOICES.PAPER, CHOICES.SCISSORS}, result);
    }

    @Test
    void testValueOfThrowsException() {
        Assertions.assertThrows( IllegalArgumentException.class, ()->RESULT.valueOf("name") );
    }

}
