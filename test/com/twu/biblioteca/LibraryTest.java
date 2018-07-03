package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.items.Book;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kai on 7/3/2018.
 */
public class LibraryTest {

    Library newLibrary = new Library();

    @Test
    public void listTest(){
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Pretty Monsters", "Jack Schez", "1990"));
        books.add(new Book("Slurp", "Wahzoo Film", "1992"));
        books.add(new Book("Washer", "Jim Slack", "1890"));

        ArrayList<Book> libraryBooks = newLibrary.getBooks();

        for (int i = 0; i < books.size(); i++){
            assertEquals(books.get(i).getAuthor(), libraryBooks.get(i).getAuthor());
            assertEquals(books.get(i).getName(), libraryBooks.get(i).getName());
            assertEquals(books.get(i).getPub(), libraryBooks.get(i).getPub());
        }
    }
}
