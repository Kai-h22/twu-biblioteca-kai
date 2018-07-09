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

    private LibraryItem item = new Book("Pretty Monsters", "Jack Schez", "1990");
    private LibraryItem item2 = new Movie("Die Hard", "IDK", "1990", "3");

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

    @Test
    public void bookTest(){
        GregorianCalendar currentDate = new GregorianCalendar();
        int testDate = currentDate.get(Calendar.DAY_OF_YEAR) + 7;
        item.setUser("123-1234");
        item.checkout("123-1234");
        assertEquals(testDate, item.getDueDate().get(Calendar.DAY_OF_YEAR));
        assertEquals("123-1234", item.getOwner());
    }

    @Test
    public void movieTest(){
        GregorianCalendar currentDate = new GregorianCalendar();
        int testDate = currentDate.get(Calendar.DAY_OF_YEAR) + 3;
        item2.setUser("123-1234");
        item2.checkout("123-1234");
        assertEquals(testDate, item2.getDueDate().get(Calendar.DAY_OF_YEAR));
        assertEquals("123-1234", item2.getOwner());
    }

}
