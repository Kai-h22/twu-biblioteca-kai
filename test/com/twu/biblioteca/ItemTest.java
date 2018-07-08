package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.items.Book;
import com.twu.biblioteca.com.twu.biblioteca.items.LibraryItem;
import com.twu.biblioteca.com.twu.biblioteca.items.Materials;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kai on 7/2/2018.
 */
public class ItemTest {

    private LibraryItem item = new LibraryItem(Materials.BOOK, "Pretty Monsters");
//    private LibraryItem item = new Book("Pretty Monsters", "Jack Schez", "1990");

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
