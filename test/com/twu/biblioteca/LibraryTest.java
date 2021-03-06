package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.items.Book;
import com.twu.biblioteca.com.twu.biblioteca.items.LibraryItem;
import com.twu.biblioteca.com.twu.biblioteca.items.Materials;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kai on 7/3/2018.
 */
public class LibraryTest {

    public Library newLibrary = new Library();
    public ArrayList<Book> books = new ArrayList<Book>();

    @Before
    public void setup(){
        books.add(new Book("Pretty Monsters", "Jack Schez", "1990"));
        books.add(new Book("Slurp", "Wahzoo Film", "1992"));
        books.add(new Book("Slurp", "Wahzoo Film", "2003"));
        books.add(new Book("Washer", "Jim Slack", "1890"));
        books.add(new Book("Washer", "TKO", "1830"));
    }

    @Test
    public void loginTest(){
        newLibrary.login("123-1234", "password123");
        assertEquals("123-1234", newLibrary.getLogedInUser());
        assertEquals(false, newLibrary.login("123-1234", "password12"));
        assertEquals(false, newLibrary.login("123-1235", "password12"));
    }

    @Test
    public void listBooksTest(){
        ArrayList<LibraryItem> libraryBooks = newLibrary.getBooks();
        newLibrary.listBooks();
        for (int i = 0; i < books.size(); i++){
//            System.out.println(books.get(i).getID());
            Book item = (Book) libraryBooks.get(i);
            assertEquals(books.get(i).getAuthor(), item.getAuthor());
            assertEquals(books.get(i).getName(), item.getName());
            assertEquals(books.get(i).getPub(), item.getPub());
        }
    }

    @Test
    public void returnWithIdTest(){

        Book returning = (Book) newLibrary.getBooks().get(0);
        newLibrary.login("123-1234", "password123");
        returning.checkout("123-1234");
        assertEquals(true, returning.isCheckedout());
        newLibrary.returnWithID(returning.getCheckoutID(), Materials.BOOK);
        assertEquals(false, returning.isCheckedout() );

    }


    @Test
    public void returnWithNameTest(){
        Book returning = (Book) newLibrary.getBooks().get(0);
        newLibrary.login("123-1234", "password123");
        returning.checkout("123-1234");
        assertEquals(true, returning.isCheckedout());
        newLibrary.returnWithName(returning.getName(), Materials.BOOK);
        assertEquals(false, returning.isCheckedout() );
    }

    @Test
    public void returnWithMultipleNameTest(){
        Book returning = (Book) newLibrary.getBooks().get(1);
        Book returning2 = (Book) newLibrary.getBooks().get(2);
        newLibrary.login("123-1234", "password123");
        returning.checkout("123-1234");
        returning2.checkout("123-1234");
        String input =  "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        newLibrary.returnWithName(returning.getName(), Materials.BOOK);
        assertEquals(false, returning.isCheckedout() );
    }


}
