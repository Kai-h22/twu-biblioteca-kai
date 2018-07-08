package com.twu.biblioteca;

import com.twu.biblioteca.com.twu.biblioteca.items.Book;
import com.twu.biblioteca.com.twu.biblioteca.items.LibraryItem;
import com.twu.biblioteca.com.twu.biblioteca.items.Materials;
import com.twu.biblioteca.com.twu.biblioteca.items.SystemItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by Kai on 7/3/2018.
 */
public class Library {

    private ArrayList<LibraryItem> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private User logedInUser = null;

    public Library() {
        books.add(new Book("Pretty Monsters", "Jack Schez", "1990"));
        books.add(new Book("Slurp", "Wahzoo Film", "1992"));
        books.add(new Book("Slurp", "Wahzoo Film", "2003"));
        books.add(new Book("Washer", "Jim Slack", "1890"));
        books.add(new Book("Washer", "TKO", "1830"));

        User testUser = new User("123-1234");
        testUser.setName("Jackie Willams");
        testUser.setEmail("washer12@gmail.com");
        testUser.setPhone("678-234-1234");
        users.add(testUser);


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

    private void printMultipleOptions(ArrayList<LibraryItem> found){
        System.out.println("Here are the items found, please select your book by typing the number of the book");
        int count = 1;
        System.out.println("#  Name         Author    Pub. Year    Due Date");
        for (LibraryItem bk : found) {
            if (bk.getType() == Materials.BOOK) {
                Book bkItem = (Book) bk;
                System.out.println(Integer.toString(count) +":  " + bkItem.getName()
                        + "    " + bkItem.getAuthor() + "       " + bkItem.getPub()+
                        "      " + bkItem.getDueDate().get(Calendar.MONTH) + "/" + bkItem.getDueDate().get(Calendar.DAY_OF_MONTH) + "/"+
                        bkItem.getDueDate().get(Calendar.YEAR));
            }
            count++;
        }

    }

    public void checkoutItem(String name){
        ArrayList<LibraryItem> found = new ArrayList<>();
        for (LibraryItem item: books){
            if (item.getName().equalsIgnoreCase(name) && !item.isCheckedout()){
                found.add(item);
            }
        }
        if (found.size() == 0){
            System.out.println("That book is not available");
        }
        else if (found.size() > 1){
            printMultipleOptions(found);
            System.out.print("Selection: ");
            Scanner usrIn = new Scanner(System.in);
            Integer select = usrIn.nextInt();
            found.get(select -1).checkout();
            System.out.println("Thank you! Enjoy the book" );

        }
        else{
            found.get(0).checkout();
            System.out.println("Thank you! Enjoy the book" );
        }
    }

    public void returnWithID(String returning){
        for (LibraryItem book : books){
            if (book.getCheckoutID().equalsIgnoreCase(returning)){
                book.checkin();
                System.out.println("\nYou have successfully checked in " + book.getName() + "(ID: "
                        + book.getCheckoutID() + ")\n“Thank you for returning the book.");
                return;
            }
        }
        System.out.println("That is not a valid book to return.");

    }

    public void returnWithName(String name){
        ArrayList<LibraryItem> found = new ArrayList<>();
        for (LibraryItem item : books){
            if (item.getType() == Materials.BOOK) {
                Book book = (Book) item;
                if (book.getName().equalsIgnoreCase(name) && book.isCheckedout()) {
                    found.add(book);
                }
            }
        }
        if (found.size() > 1){
            printMultipleOptions(found);
            System.out.print("Selection: ");
            Scanner usrIn = new Scanner(System.in);
            Integer select = usrIn.nextInt();
            LibraryItem foundRtn = found.get(select -1);
            foundRtn.checkin();
            System.out.println("\nYou have successfully checked in " + foundRtn.getName() + "(ID: "
                    + foundRtn.getCheckoutID() + ")\nThank you for returning the book." );
        }
        else if (found.size() == 0){
            System.out.println("That is not a valid book to return.");
        }
        else{
            LibraryItem toReturn = found.get(0);
            toReturn.checkin();
            System.out.println("\nYou have successfully checked in " + toReturn.getName() + "(ID: "
                    + toReturn.getCheckoutID() + ")\nThank you for returning the book.");
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
                    System.out.println("Welcome " + user.getName() + "!\n" + "Info:\n" +
                        "\temail: " + user.getEmail() + "\n\tphone: " + user.getPhone());
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
}
