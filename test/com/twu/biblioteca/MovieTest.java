package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kai on 7/8/2018.
 */
public class MovieTest {

    Movie testMovie = new Movie("Die Hard", "IDK", "1990", "1");

    @Test
    public void infoTest(){
        assertEquals(testMovie.getName() + "    " + testMovie.getDirector() +
        "    " + testMovie.getYear(), testMovie.toString());
    }
}
