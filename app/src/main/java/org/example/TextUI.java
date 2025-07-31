package org.example;

import java.util.Scanner;

public class TextUI {
    Scanner scanner;

    public TextUI() {
        this.scanner = new Scanner(System.in);
//        scanner.nextLine();
    }

    void start() {

    }

    private void printMenu() {
        System.out.println("1. Log in as a manager");
    }

}
