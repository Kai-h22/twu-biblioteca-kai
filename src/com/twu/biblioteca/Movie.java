package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.items.LibraryItem;
import com.twu.biblioteca.com.twu.biblioteca.items.Materials;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Kai on 7/8/2018.
 */
public class Movie extends LibraryItem{
    private String director;
    private String year;
    private String rating;

    public Movie(String name, String director, String year, String rating) {
        super(Materials.MOVIE, name);
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    @Override
    public GregorianCalendar checkout(String user) {
        GregorianCalendar date = new GregorianCalendar();
        date.roll(Calendar.DATE, 3);
        this.setDueDate(date);
        System.out.print("Thank you! Enjoy the movie\nYou have succefully checked out: " +
                getName() + " by " + getDirector() + " Released " + getYear() + "\n" );
        System.out.print("\tBelow is the Movie ID, please save this for movie return: \n\t\t" + getCheckoutID() + '\n');
        this.checkoutItem();
        this.setUser(user);
        return date;
    }

    @Override
    public String toString() {
        return getName() + "    " + getDirector() +
                "    " + getYear() + "   " + getRating();
    }

    public String getDirector() {
        return director;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }
}
