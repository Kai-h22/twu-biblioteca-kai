package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.items.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kai on 7/2/2018.
 */
public class MainScreenTest {

    private final ByteArrayOutputStream printValue = new ByteArrayOutputStream();
    private final BibliotecaApp app = new BibliotecaApp();
    private String[] args = null;
    public ArrayList<Book> books = new ArrayList<Book>();

    @Before
    public void setup(){
        books.add(new Book("Pretty Monsters", "Jack Schez", "1990"));
        books.add(new Book("Slurp", "Wahzoo Film", "1992"));
        books.add(new Book("Slurp", "Wahzoo Film", "2003"));
        books.add(new Book("Washer", "Jim Slack", "1890"));
        books.add(new Book("Washer", "TKO", "1830"));
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

//    @Test
//    public void listBookTest(){
//        app.main(args);
//        assertEquals("Welcome to Biblioteca!\n", printValue.toString());
//    }
//
//    @Test
//    public void returnWithIdTest(){
//
//        Book returning = books.get(0);
//        returning.checkout();
//        assertEquals(true, returning.isCheckedout());
//        String input = "r";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
////        String input = returning.getCheckoutID();
////        InputStream in = new ByteArrayInputStream(input.getBytes());
////        System.setIn(in);
//        app.main(args);
//        assertEquals(false, returning.isCheckedout() );
//
//    }
//
//
//    @Test
//    public void returnWithNameTest(){
//        Book returning = books.get(0);
//        returning.checkout();
//        assertEquals(true, returning.isCheckedout());
//        String input = "no";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        String input2 = returning.getName();
//        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
//        System.setIn(in2);
////        app.returnWithID();
//        assertEquals(false, returning.isCheckedout() );
//    }

}
