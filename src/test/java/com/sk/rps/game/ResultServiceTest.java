package com.sk.rps.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class ResultServiceTest {

    @InjectMocks
    ResultService resultService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testExecuteHumanROCK_ComputerROCK_TIE() {
        RESULT result = resultService.execute(CHOICES.ROCK, CHOICES.ROCK);
        Assertions.assertEquals(RESULT.TIE, result);
    }

    @Test
    void testExecuteHumanROCK_ComputerSCISSORS_WON() {
        RESULT result = resultService.execute(CHOICES.ROCK, CHOICES.SCISSORS);
        Assertions.assertEquals(RESULT.WON, result);

    }

    @Test
    void testExecuteHumanROCK__ComputerPAPER_LOST() {
        RESULT result = resultService.execute(CHOICES.ROCK, CHOICES.PAPER);
        Assertions.assertEquals(RESULT.LOST, result);
    }

    @Test
    void testExecuteHumanPAPER_ComputerROCK_WON() {
        RESULT result = resultService.execute(CHOICES.PAPER, CHOICES.ROCK);
        Assertions.assertEquals(RESULT.WON, result);
    }

    @Test
    void testExecuteHumanPAPER_ComputerPAPER_TIE() {
        RESULT result = resultService.execute(CHOICES.PAPER, CHOICES.PAPER);
        Assertions.assertEquals(RESULT.TIE, result);
    }

    @Test
    void testExecuteHumanPAPER_ComputerSCISSORS_LOST() {
        RESULT result = resultService.execute(CHOICES.PAPER, CHOICES.SCISSORS);
        Assertions.assertEquals(RESULT.LOST, result);
    }

    @Test
    void testExecuteHumanSCISSORS_ComputerROCK_LOST() {
        RESULT result = resultService.execute(CHOICES.SCISSORS, CHOICES.ROCK);
        Assertions.assertEquals(RESULT.LOST, result);
    }

    @Test
    void testExecuteHumanSCISSORS_ComputerPAPER_WON() {
        RESULT result = resultService.execute(CHOICES.SCISSORS, CHOICES.PAPER);
        Assertions.assertEquals(RESULT.WON, result);
        result = resultService.execute(CHOICES.SCISSORS, CHOICES.SCISSORS);
        Assertions.assertEquals(RESULT.TIE, result);
    }

    @Test
    void testExecuteHumanSCISSORS_ComputerSCISSORS_TIE() {
        RESULT result = resultService.execute(CHOICES.SCISSORS, CHOICES.SCISSORS);
        Assertions.assertEquals(RESULT.TIE, result);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme