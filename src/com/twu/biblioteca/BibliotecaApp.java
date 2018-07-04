package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.print("Welcome to Biblioteca!\n");

        System.out.print("");

        System.out.println("Please input the ID number of the book you are returning, if you cannot" +
                " find the id, type no");
        System.out.print("ID: ");
        Scanner userInput = new Scanner(System.in);
        String returning = userInput.next();
    }
}
