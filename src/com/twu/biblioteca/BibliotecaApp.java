package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private static Library library = new Library();
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        Boolean running = true;
        while (running){
            System.out.print("Welcome to Biblioteca!\n");
            System.out.print("What would you like to do?\n list books(L)  return books(R)  quit(Q)");
            System.out.print("Type the letter of your selected choice: ");

            String selection = userInput.next();

            if (selection.equalsIgnoreCase("L")){
                listBooks();
            }
            else if (selection.equalsIgnoreCase("R")){
                returnBook();
            }
        }
    }

    private static void returnBook() {
        System.out.println("Please input the ID number of the book you are returning, if you cannot" +
                " find the id, type no");
        System.out.print("ID: ");

        String returning = userInput.next();

        if (returning.equalsIgnoreCase("no")){
            System.out.print("Please Type Book Name: ");
            String name = userInput.next();
            library.returnWithName(name);
        }
        else{
            library.returnBook(returning);
        }
    }

    private static void listBooks() {
        Boolean booking = true;
        library.listBooks();

        while (booking){
            System.out.print("\n What Would you like to do?  Checkout(C)  Quit(Q)");
            String bSelection = userInput.next();
            if (bSelection.equalsIgnoreCase("C")){
                checkoutBook();
            }
        }
    }

    private static void checkoutBook() {
        System.out.print("What book would you like to check out?\n Name: ");
        String checkout = userInput.next();
    }
}
