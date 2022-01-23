package com.sk.rps.game;

import com.sk.rps.player.Computer;
import com.sk.rps.player.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class RPSEngineTest {
    @Mock
    ResultService resultService;
    @Mock
    Human human;
    @Mock
    Computer computer;

    @InjectMocks
    RPSEngine rPSEngine;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testIsRepeat() {
        when(human.canRepeat()).thenReturn(true);
        when(human.getName()).thenReturn("TEST");

        boolean result = rPSEngine.shouldRepeat();
        Assertions.assertTrue(result);
    }

}
