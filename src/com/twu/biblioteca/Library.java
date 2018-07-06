package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.items.Book;
import com.twu.biblioteca.com.twu.biblioteca.items.LibraryItem;

import java.util.ArrayList;
import java.util.Calendar;
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

    public void listBooks(){
        String bookList = "NAME     "+
                "AUTHOR     " + "PUBLISHING YEAR\n";
        for (Book x: books){
            if (!x.isCheckedout()){
                bookList += x.toString();
            }
        }
        System.out.println(bookList);
    }

    public void returnBook(String returning){
        for (Book book : books){
            if (book.getCheckoutID().equalsIgnoreCase(returning)){
                book.checkin();
                System.out.println("\nYou have successfully checked in " + book.getName() + "(ID: "
                        + book.getCheckoutID() + ")");
                return;
            }
        }
        System.out.println("Id not Found. Please Try again.");

    }

    public void returnWithName(String name){
        ArrayList<Book> found = new ArrayList<Book>();
        for (Book book : books){
            if (book.getName().equalsIgnoreCase(name) && book.isCheckedout()){
                found.add(book);
            }
        }
        if (found.size() > 1){
            System.out.println("Here are the items found, please select your book by typing the number of the book");
            int count = 1;
            System.out.println("#  Name   Author   Author    Pub. Year    Due Date");
            for (Book bk : found){
                System.out.println(Integer.toString(count) +":  " + bk.getName()
                        + "    " + bk.getAuthor() + "       " + bk.getPub()+
                "      " + bk.getDueDate().get(Calendar.MONTH) + "/" + bk.getDueDate().get(Calendar.DAY_OF_MONTH) + "/"+
                        bk.getDueDate().get(Calendar.YEAR));
                count++;
            }
            Scanner usrIn = new Scanner(System.in);
            Integer select = usrIn.nextInt();
            Book foundRtn = found.get(select -1);
            foundRtn.checkin();
            System.out.println("\nYou have successfully checked in " + foundRtn.getName() + "(ID: "
                    + foundRtn.getCheckoutID() + ")");
            return;
        }
        else if (found.size() == 0){
            System.out.println("Name not Found. Please Try again.");
            return;
        }
        else{
            Book toReturn = found.get(0);
            toReturn.checkin();
            System.out.println("\nYou have successfully checked in " + toReturn.getName() + "(ID: "
                    + toReturn.getCheckoutID() + ")");
            return;
        }


    }
}
