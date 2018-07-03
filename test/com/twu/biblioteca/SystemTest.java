package com.twu.biblioteca;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kai on 7/3/2018.
 */
public class SystemTest {

    Book testBook = new Book("Pretty Monsters", "Jack Schez", "1990");

    @Test
    public void bookTest(){
        GregorianCalendar currentDate = new GregorianCalendar();
        int testDate = currentDate.get(Calendar.DAY_OF_YEAR) + 7;
        testBook.checkout();
        assertEquals(testDate, testBook.getDueDate().get(Calendar.DAY_OF_YEAR));
    }

}
