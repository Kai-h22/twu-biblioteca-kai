package com.twu.biblioteca;

import java.util.GregorianCalendar;

/**
 * Created by Kai on 7/3/2018.
 */
public class Book implements SystemItem{

    private String name;
    private String author;
    private String year;

    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public GregorianCalendar checkout() {
        return null;
    }
}
