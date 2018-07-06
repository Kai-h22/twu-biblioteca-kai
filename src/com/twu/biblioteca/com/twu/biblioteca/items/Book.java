package com.twu.biblioteca.com.twu.biblioteca.items;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Kai on 7/3/2018.
 */
public class Book extends LibraryItem implements SystemItem {

    private String name;
    private String author;
    private String year;

    public Book(String name, String author, String year) {
        super(Materials.BOOK);
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString(){
        return name + "     " + author + "     " + year;
    }

    @Override
    public GregorianCalendar checkout() {
        GregorianCalendar date = new GregorianCalendar();
        date.roll(Calendar.DATE, 7);
        this.setDueDate(date);
        System.out.print("You have succefully checked out: " +
                this.name + " by " + this.author + " Published " + this.year + "\n");
        System.out.print("\tBelow is the book ID, please save this for book return: \n\t\t" + getCheckoutID() + '\n');
        this.checkoutItem();
        return date;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPub() {
        return this.year;
    }
}
