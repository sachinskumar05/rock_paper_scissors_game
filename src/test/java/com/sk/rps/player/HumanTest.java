package com.sk.rps.player;

import com.sk.rps.config.AppConfig;
import com.sk.rps.game.CHOICES;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static com.sk.rps.player.Player.UTF_8;
import static org.mockito.Mockito.when;

@Log4j2
class HumanTest {

    @Mock
    AppConfig appConfig;

    @InjectMocks
    Human human;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testInit() {
        int expectedValue = 3;
        when(appConfig.getMaxRetryInvalidArguments()).thenReturn(expectedValue);
        human.init();
        Assertions.assertEquals(expectedValue, human.getMaxRetryInvalidArguments());
    }

    @Test
    void testRequestPlayerName() {
        String expected = "SK";
        System.setIn(new ByteArrayInputStream(expected.getBytes(StandardCharsets.UTF_8)));
        Scanner scanner = new Scanner(System.in, UTF_8);
        human = new Human(scanner,appConfig);
        human.setName();
        Assertions.assertEquals(expected, human.getName());
    }

    @Test
    void testChooseROCK() {
        String expected = "r";
        System.setIn(new ByteArrayInputStream(expected.getBytes(StandardCharsets.UTF_8)));
        Scanner scanner = new Scanner(System.in, UTF_8);
        human = new Human(scanner,appConfig);
        CHOICES result = human.choose();
        Assertions.assertEquals(CHOICES.ROCK, result);
    }

    @Test
    void testChoosePAPER() {
        String expected = "p";
        System.setIn(new ByteArrayInputStream(expected.getBytes(StandardCharsets.UTF_8)));
        Scanner scanner = new Scanner(System.in, UTF_8);
        human = new Human(scanner,appConfig);
        CHOICES result = human.choose();

        Assertions.assertEquals(CHOICES.PAPER, result);
    }

    @Test
    void testChooseSCISSORS() {
        String expected = "s";
        System.setIn(new ByteArrayInputStream(expected.getBytes(StandardCharsets.UTF_8)));
        Scanner scanner = new Scanner(System.in, UTF_8);
        human = new Human(scanner,appConfig);
        CHOICES result = human.choose();
        Assertions.assertEquals(CHOICES.SCISSORS, result);
    }

    @Test
    void testRepeatYes() {
        String expected = "y";
        when(appConfig.getMaxRetryInvalidArguments()).thenReturn(3);
        System.setIn(new ByteArrayInputStream(expected.getBytes(StandardCharsets.UTF_8)));
        Scanner scanner = new Scanner(System.in, UTF_8);
        human = new Human(scanner,appConfig);
        boolean result = human.canRepeat();
        Assertions.assertTrue(result);
    }

    @Test
    void testRepeatNo() {
        String expected = "n";
        when(appConfig.getMaxRetryInvalidArguments()).thenReturn(3);
        System.setIn(new ByteArrayInputStream(expected.getBytes(StandardCharsets.UTF_8)));
        Scanner scanner = new Scanner(System.in, UTF_8);
        human = new Human(scanner,appConfig);
        boolean result = human.canRepeat();
        Assertions.assertFalse(result);
    }

    @Test
    void testGetScore(){
        Assertions.assertEquals(0, human.getScore());
    }

    @Test
    void testScoreIncrementAndGet(){
        Assertions.assertEquals(1, human.scoreIncrementAndGet());
    }

}

