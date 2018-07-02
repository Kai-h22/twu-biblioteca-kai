package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kai on 7/2/2018.
 */
public class MainScreenTest {

    private final ByteArrayOutputStream printValue = new ByteArrayOutputStream();
    private final BibliotecaApp app = new BibliotecaApp();
    private String[] args = null;


    @Before
    public void setUp() {
        System.setOut(new PrintStream(printValue));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void welcomeTest(){
        app.main(args);
        assertEquals("Welcome to Biblioteca!\n", printValue.toString());
    }

    @Test
    public void meniTest(){
        app.main(args);
        assertEquals("Welcome to Biblioteca!\n", printValue.toString());
    }
}
