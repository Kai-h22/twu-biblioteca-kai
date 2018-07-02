package com.twu.biblioteca;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kai on 7/2/2018.
 */
public class ItemTest {

    private LibraryItem item = new LibraryItem(Materials.BOOK);

    @Test
    public void checkedOutTest(){
        assertEquals(false, item.isCheckedout());
    }

    @Test
    public void dueDateTest(){
        int testDate = new GregorianCalendar().get(Calendar.DAY_OF_YEAR);
        assertEquals(testDate, item.getDueDate().get(Calendar.DAY_OF_YEAR));
    }

    @Test
    public void typeTest(){
        Materials testType = Materials.BOOK;
        assertEquals(testType, item.getType());
    }

    @Test
    public void idTest(){
        UUID id = UUID.randomUUID();
        item.changeID(id);
        assertEquals(id, item.getID());
    }

}
