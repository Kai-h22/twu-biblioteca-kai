package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.items.Book;
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
    public void listTest(){
        ArrayList<Book> libraryBooks = newLibrary.getBooks();

        for (int i = 0; i < books.size(); i++){
            System.out.println(books.get(i).getID());
            assertEquals(books.get(i).getAuthor(), libraryBooks.get(i).getAuthor());
            assertEquals(books.get(i).getName(), libraryBooks.get(i).getName());
            assertEquals(books.get(i).getPub(), libraryBooks.get(i).getPub());
        }
    }

    @Test
    public void returnWithIdTest(){
        Book returning = newLibrary.getBooks().get(0);
        returning.checkout();
        assertEquals(true, returning.isCheckedout());
        String input = returning.getCheckoutID();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        newLibrary.returnBook();
        assertEquals(false, returning.isCheckedout() );

    }


    @Test
    public void returnWithNameTest(){
        Book returning = newLibrary.getBooks().get(0);
        returning.checkout();
        assertEquals(true, returning.isCheckedout());
        String input = "no";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        newLibrary.returnBook();
        assertEquals(false, returning.isCheckedout() );
    }

    @Test

    public void returnWithNameMultipleTest(){

    }
}
