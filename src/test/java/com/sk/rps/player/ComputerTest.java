package com.sk.rps.player;

import com.sk.rps.game.CHOICES;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class ComputerTest {

    @InjectMocks
    Computer computer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testChoose() {
        Assertions.assertDoesNotThrow(()->computer.choose());
        CHOICES result = computer.choose();
        Assertions.assertNotNull(result);
    }

    @Test
    void testSetName(){
        Assertions.assertThrows(UnsupportedOperationException.class, ()->computer.setName());
    }
    @Test
    void testCanRepeat(){
        Assertions.assertThrows(UnsupportedOperationException.class, ()->computer.canRepeat());
    }

    @Test
    void testGetScore(){
        Assertions.assertEquals(0, computer.getScore());
    }

    @Test
    void testScoreIncrementAndGet(){
        Assertions.assertEquals(1, computer.scoreIncrementAndGet());
    }

}
