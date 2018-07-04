package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.items.Book;
import com.twu.biblioteca.com.twu.biblioteca.items.LibraryItem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kai on 7/3/2018.
 */
public class Library {

    ArrayList<Book> books = new ArrayList<Book>();
    public Library() {
        books.add(new Book("Pretty Monsters", "Jack Schez", "1990"));
        books.add(new Book("Slurp", "Wahzoo Film", "1992"));
        books.add(new Book("Slurp", "Wahzoo Film", "2003"));
        books.add(new Book("Washer", "Jim Slack", "1890"));
        books.add(new Book("Washer", "TKO", "1830"));

    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void returnBook(String returning){
        for (Book book : books){
            if (book.getCheckoutID().equals(returning)){
                book.checkin();
                System.out.println("\nYou have successfully checked in " + book.getName() + "(ID: "
                        + book.getCheckoutID() + ")");
                return;
            }
        }
        System.out.println("Id not Found. Please Try again.");

    }

    public void returnWithName(String name){

    }
}
