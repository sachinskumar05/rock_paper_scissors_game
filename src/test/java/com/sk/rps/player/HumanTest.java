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
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

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
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        human = new Human(scanner,appConfig);
        human.requestPlayerName();
        Assertions.assertEquals(expected, human.getName());
    }

    @Test
    void testChooseROCK() {
        String expected = "r";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        human = new Human(scanner,appConfig);
        CHOICES result = human.choose();
        Assertions.assertEquals(CHOICES.ROCK, result);
    }

    @Test
    void testChoosePAPER() {
        String expected = "p";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        human = new Human(scanner,appConfig);
        CHOICES result = human.choose();

        Assertions.assertEquals(CHOICES.PAPER, result);
    }

    @Test
    void testChooseSCISSORS() {
        String expected = "s";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        human = new Human(scanner,appConfig);
        CHOICES result = human.choose();
        Assertions.assertEquals(CHOICES.SCISSORS, result);
    }

    @Test
    void testRepeatYes() {
        String expected = "y";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        human = new Human(scanner,appConfig);
        boolean result = human.repeat();
        Assertions.assertTrue(result);
    }

    @Test
    void testRepeatNo() {
        String expected = "n";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(expected.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        human = new Human(scanner,appConfig);
        boolean result = human.repeat();
        Assertions.assertFalse(result);
    }

}

