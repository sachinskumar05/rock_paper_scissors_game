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
    void testGetInput() {
        Assertions.assertDoesNotThrow(()->computer.choose());
        CHOICES result = computer.choose();
        Assertions.assertNotNull(result);
    }
}
