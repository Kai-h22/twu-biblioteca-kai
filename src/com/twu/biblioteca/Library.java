package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.items.Book;
import com.twu.biblioteca.com.twu.biblioteca.items.LibraryItem;
import com.twu.biblioteca.com.twu.biblioteca.items.Materials;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Kai on 7/3/2018.
 */
public class Library {

    private ArrayList<LibraryItem> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private User logedInUser = null;
    private Scanner usrIn = new Scanner(System.in);

    public Library() {
        books.add(new Book("Pretty Monsters", "Jack Schez", "1990"));
        books.add(new Book("Slurp", "Wahzoo Film", "1992"));
        books.add(new Book("Slurp", "Wahzoo Film", "2003"));
        books.add(new Book("Washer", "Jim Slack", "1890"));
        books.add(new Book("Washer", "TKO", "1830"));

        User testUser = new User("123-1234");
        testUser.setName("Venus Willams");
        testUser.setEmail("washer12@gmail.com");
        testUser.setPhone("678-234-1234");
        users.add(testUser);

        User testUser2 = new User("999-9999");
        testUser2.setName("Serena Williams");
        testUser2.setEmail("winner26@gmail.com");
        testUser2.setPhone("423-431-2349");
        users.add(testUser2);

        books.add( new Movie("Die Hard", "IDK", "1990", "1"));
        books.add( new Movie("Die Hard", "IDK", "2003", "Unrated"));
        books.add( new Movie("Star Wars", "Whomp Masg", "1970", "10"));
        books.add( new Movie("G.I Joe", "Joe", "2012", "7"));
        books.add( new Movie("Star Wars", "Jimmy Boi", "1990", "9"));


    }

    public ArrayList<LibraryItem> getBooks() {
        return books;
    }

    public void listBooks(){
        String bookList = "NAME                    "+
                "AUTHOR                " + "PUBLISHING YEAR\n";
        for (LibraryItem item: books){
            if (item.getType() == Materials.BOOK){
                Book x = (Book) item;
                if (!x.isCheckedout()){
                    bookList += x.toString() + "\n";
                }
            }
        }
        System.out.println(bookList);
    }

    public void listMovies(){
        String movieList = "NAME    "+
                "DIRECTOR    " + "RELEASE YEAR    RATING\n";
        for (LibraryItem item: books){
            if (item.getType() == Materials.MOVIE){
                Movie x = (Movie) item;
                if (!x.isCheckedout()){
                    movieList += x.toString() + "\n";
                }
            }
        }
        System.out.println(movieList);
    }

    private void printMultipleOptions(ArrayList<LibraryItem> found, Materials type){
        System.out.println("Here are the items found, please select your item by typing the number of your selection");
        int count = 1;

        if (type == Materials.BOOK){
            System.out.println("#  Name         Author    Pub. Year    Due Date");
        }
        else{
            System.out.println("#  Name    Director  Release Year   Rating  Due Date");
        }

        for (LibraryItem bk : found) {
            if (bk.getType() == Materials.BOOK) {
                Book bkItem = (Book) bk;
                System.out.println(Integer.toString(count) +":  " + bkItem.getName()
                        + "    " + bkItem.getAuthor() + "       " + bkItem.getPub()+
                        "      " + bkItem.getDueDate().get(Calendar.MONTH) + "/" + bkItem.getDueDate().get(Calendar.DAY_OF_MONTH) + "/"+
                        bkItem.getDueDate().get(Calendar.YEAR));
            }
            else{
                Movie mvItem = (Movie) bk;
                System.out.println(Integer.toString(count) +": " +mvItem.toString() + "     " + mvItem.getDueDate().get(Calendar.MONTH) + "/" + mvItem.getDueDate().get(Calendar.DAY_OF_MONTH) + "/"+
                        mvItem.getDueDate().get(Calendar.YEAR));
            }
            count++;
        }

    }

    public void checkoutItem(String name, Materials type){
        ArrayList<LibraryItem> found = new ArrayList<>();
        for (LibraryItem item: books){
            if (item.getName().equalsIgnoreCase(name) && !item.isCheckedout() && item.getType() == type){
                found.add(item);
            }
        }
        if (found.size() == 0){
            if (type == Materials.BOOK){
                System.out.println("That book is not available");
            }
            else if (type == Materials.MOVIE){
                System.out.println("That movie is not available");
            }

        }
        else if (found.size() > 1){
            printMultipleOptions(found, type);
            Integer select = -1;
            System.out.print("Selection: ");
            try {
                select = usrIn.nextInt();
                if (select > 0 && select <= found.size()){
                    found.get(select -1).checkout(logedInUser.getLibNum());

                    if (type == Materials.BOOK){
                        System.out.println("Thank you! Enjoy the book" );
                    }
                    else if (type == Materials.MOVIE){
                        System.out.println("Thank you! Enjoy the movie" );
                    }
                }else{
                    System.out.println("Not a valid selection");
                }

            } catch (InputMismatchException e) {
                System.out.println("Not a valid selection");
//                    System.out.print(e.getMessage()); //try to find out specific reason.
            }


        }
        else{
            found.get(0).checkout(logedInUser.getLibNum());
            if (type == Materials.BOOK){
                System.out.println("Thank you! Enjoy the book" );
            }
            else if (type == Materials.MOVIE){
                System.out.println("Thank you! Enjoy the movie" );
            }
        }
    }

    
    public void returnWithID(String returning, Materials type){
        for (LibraryItem book : books){
            if (book.getType() == type && book.getCheckoutID().equalsIgnoreCase(returning) && book.isCheckedout() && book.getOwner().equals(logedInUser.getLibNum())){
                book.checkin();
                if (type == Materials.BOOK){
                    System.out.println("\nYou have successfully checked in " + book.getName() + "(ID: "
                            + book.getCheckoutID() + ")\n“Thank you for returning the book.");
                }
                else if (type == Materials.MOVIE){
                    System.out.println("\nYou have successfully checked in " + book.getName() + "(ID: "
                            + book.getCheckoutID() + ")\n“Thank you for returning the movie.");
                }

                return;
            }
        }
        System.out.println("That is not a valid book to return.");

    }

    public void returnWithName(String name, Materials type){
        ArrayList<LibraryItem> found = new ArrayList<>();
        for (LibraryItem item : books){
            if (item.getType() == type && item.getType() == Materials.BOOK) {
                Book book = (Book) item;
                if (book.getName().equalsIgnoreCase(name) && book.isCheckedout() && book.getOwner().equals(logedInUser.getLibNum())) {
                    found.add(book);
                }
            }
            else if (item.getType() == type && item.getType() == Materials.MOVIE) {
                Movie movie = (Movie) item;
                if (movie.getName().equalsIgnoreCase(name) && movie.isCheckedout() && movie.getOwner().equals(logedInUser.getLibNum())) {
                    found.add(movie);
                }
            }
        }
        if (found.size() > 1){
            printMultipleOptions(found, type);
            Integer select = -1;


            try {
                select = usrIn.nextInt();
                if (select > 0 && select <= found.size()){
                    LibraryItem foundRtn = found.get(select -1);
                    foundRtn.checkin();
                    if (type == Materials.BOOK){
                        System.out.println("\nYou have successfully checked in " + foundRtn.getName() + "(ID: "
                                + foundRtn.getCheckoutID() + ")\nThank you for returning the book." );
                    }
                    else if (type == Materials.MOVIE){
                        System.out.println("\nYou have successfully checked in " + foundRtn.getName() + "(ID: "
                                + foundRtn.getCheckoutID() + ")\nThank you for returning the Movie." );
                    }
                }else{
                    System.out.println("Not a valid selection");
                }

            } catch (InputMismatchException e) {
                System.out.println("Not a valid selection");
//                    System.out.print(e.getMessage()); //try to find out specific reason.
            }
        }
        else if (found.size() == 0){
            System.out.println("That is not a valid book to return.");
        }
        else{
            LibraryItem toReturn = found.get(0);
            toReturn.checkin();
            if (type == Materials.BOOK){
                System.out.println("\nYou have successfully checked in " + toReturn.getName() + "(ID: "
                        + toReturn.getCheckoutID() + ")\nThank you for returning the book." );
            }
            else if (type == Materials.MOVIE){
                System.out.println("\nYou have successfully checked in " + toReturn.getName() + "(ID: "
                        + toReturn.getCheckoutID() + ")\nThank you for returning the Movie." );
            }
        }


    }

    public String getLogedInUser() {
        if (logedInUser != null){
            return logedInUser.getLibNum();
        }
        return "";
    }

    public Boolean login(String id, String pass) {
        for (User user: users){
            if (user.getLibNum().equals(id)){
                if (user.checkPassword(pass)){
                    logedInUser = user;
                    System.out.println("Welcome " + user.getName() + "!\n");
                    return true;
                }
                else{
                    System.out.println("Incorrect Password. Try again.");
                    return false;
                }
            }
        }
        System.out.println("Library Number Not Found.");
        return false;

    }

    public void logout(){this.logedInUser = null;}


}
