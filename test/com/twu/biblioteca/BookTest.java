package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.items.Book;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kai on 7/2/2018.
 */
public class BookTest {

    Book testBook = new Book("Pretty Monsters", "Jack Schez", "1990");

    @Test
    public void nameTest(){
        assertEquals("Pretty Monsters", testBook.getName());
    }

    @Test
    public void authorTest(){
        assertEquals("Jack Schez", testBook.getAuthor());
    }

    @Test
    public void pubTest(){
        assertEquals("1990", testBook.getPub());
    }


}
