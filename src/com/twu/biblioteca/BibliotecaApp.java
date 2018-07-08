package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private static Library library = new Library();
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        Boolean running = true;
        while (running){
            System.out.print("Welcome to Biblioteca!\n");
            System.out.print("What would you like to do?\n Type the letter of your selected choice\n \tlist books(L)  quit(Q)\n");
            System.out.print("Selection: ");

            String selection = userInput.nextLine();

            if (selection.equalsIgnoreCase("L")){
                listBooks();
            }

            else if (selection.equalsIgnoreCase("q")){
                running = false;
            }
            else {
                System.out.println("Select a valid option!");
            }
        }
    }

    private static void returnBook() {
        System.out.println("Please input the ID number of the book you are returning, if you cannot" +
                " find the id, type no");
        System.out.print("ID: ");

        String returning = userInput.nextLine();

        if (returning.equalsIgnoreCase("no")){
            System.out.print("Please Type Book Name: ");
            String name = userInput.nextLine();
            library.returnWithName(name);
        }
        else{
            library.returnWithID(returning);
        }
    }

    private static void listBooks() {
        Boolean booking = true;
        while (booking){
            library.listBooks();
            System.out.print("\nWhat Would you like to do?\n\tCheckout(C)  return books(R)  Quit(Q)\n");
            System.out.print("Selection: ");
            String bSelection = userInput.nextLine();
            if (bSelection.equalsIgnoreCase("C")){
                checkoutBook();
            }
            else if (bSelection.equalsIgnoreCase("R")){
                returnBook();
            }
            else if (bSelection.equalsIgnoreCase("q")){
                booking = false;
            }
            else {
                System.out.println("Select a valid option!");
            }
        }
    }

    private static void checkoutBook() {
        System.out.print("What book would you like to check out?\nNmae: ");
        String checkout = userInput.nextLine();
        library.checkoutItem(checkout);
        return;
    }
}
