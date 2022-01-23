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
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import static org.mockito.Mockito.*;

@Log4j2
class HumanTest {
    private static final String UTF8_ENCODING = "utf-8";
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
        try {
            System.setIn(new ByteArrayInputStream(expected.getBytes(UTF8_ENCODING)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in,UTF8_ENCODING);
        human = new Human(scanner,appConfig);
        human.setName();
        Assertions.assertEquals(expected, human.getName());
    }

    @Test
    void testChooseROCK() {
        String expected = "r";
        try {
            System.setIn(new ByteArrayInputStream(expected.getBytes(UTF8_ENCODING)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in, UTF8_ENCODING);
        human = new Human(scanner,appConfig);
        CHOICES result = human.choose();
        Assertions.assertEquals(CHOICES.ROCK, result);
    }

    @Test
    void testChoosePAPER() {
        String expected = "p";
        try {
            System.setIn(new ByteArrayInputStream(expected.getBytes(UTF8_ENCODING)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in, UTF8_ENCODING);
        human = new Human(scanner,appConfig);
        CHOICES result = human.choose();

        Assertions.assertEquals(CHOICES.PAPER, result);
    }

    @Test
    void testChooseSCISSORS() {
        String expected = "s";
        try {
            System.setIn(new ByteArrayInputStream(expected.getBytes(UTF8_ENCODING)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in, UTF8_ENCODING);
        human = new Human(scanner,appConfig);
        CHOICES result = human.choose();
        Assertions.assertEquals(CHOICES.SCISSORS, result);
    }

    @Test
    void testRepeatYes() {
        String expected = "y";
        try {
            System.setIn(new ByteArrayInputStream(expected.getBytes(UTF8_ENCODING)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in, UTF8_ENCODING);
        human = new Human(scanner,appConfig);
        boolean result = human.canRepeat();
        Assertions.assertTrue(result);
    }

    @Test
    void testRepeatNo() {
        String expected = "n";
        try {
            System.setIn(new ByteArrayInputStream(expected.getBytes(UTF8_ENCODING)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in, UTF8_ENCODING);
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

