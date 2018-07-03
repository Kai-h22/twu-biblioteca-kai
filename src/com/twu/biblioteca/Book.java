package com.twu.biblioteca;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Kai on 7/3/2018.
 */
public class Book extends LibraryItem implements SystemItem{

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
    public GregorianCalendar checkout() {
        GregorianCalendar date = new GregorianCalendar();
        date.roll(Calendar.DATE, 7);
        this.setDueDate(date);
        return date;
    }
}
