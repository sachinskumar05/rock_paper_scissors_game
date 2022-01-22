package com.sk.rps.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RESULTTest {
    //Field TIE of type RESULT - was not mocked since Mockito doesn't mock enums
    //Field WON of type RESULT - was not mocked since Mockito doesn't mock enums
    //Field LOST of type RESULT - was not mocked since Mockito doesn't mock enums

    @Test
    void testValueOfTIE() {
        RESULT result = RESULT.valueOf(0);
        Assertions.assertEquals(RESULT.TIE, result);
    }
    @Test
    void testValueOfLOST() {
        RESULT result = RESULT.valueOf(-1);
        Assertions.assertEquals(RESULT.LOST, result);
    }
    @Test
    void testValueOfWON() {
        RESULT result = RESULT.valueOf(1);
        Assertions.assertEquals(RESULT.WON, result);
    }

    @Test
    void testValues() {
        RESULT[] result = RESULT.values();
        Assertions.assertArrayEquals(new RESULT[]{RESULT.TIE,RESULT.WON,RESULT.LOST}, result);
    }

    @Test
    void testValueOfThrowsException() {
        Assertions.assertThrows( IllegalArgumentException.class, ()->RESULT.valueOf("name") );
    }
}

