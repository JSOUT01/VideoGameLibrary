package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);

    //Menu to prompt users for Library options.
    public void startMenu () {

        System.out.println("What would you like to do?" +
                "\n1. Add a game to the Library" +
                "\n2. Remove a game from the library" +
                "\n3. View what is currently in the library" +
                "\n4. Check out a game" +
                "\n5. Check in a game" +
                "\n6. View checked out games" +
                "\n7. Exit the program");

        try {

            switch (input.nextInt()) {
                case 1:
                    // Add a game
                    break;
                case 2:
                    // Remove a game
                    break;
                case 3:
                    // View what is currently in library
                    break;
                case 4:
                    // Check out a game
                    break;
                case 5:
                    // Check in a game
                    break;
                case 6:
                    // View checked out games
                    break;
                case 7:
                    System.out.println("Thank you for using the Game Library Program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("That is not a vailid entry. Please enter a number between 1 and 7.");
                    startMenu()
                    break;



            }

        } catch (InputMismatchException ime) {
            input.nextLine();
            System.out.println("That is not a vailid entry. Please enter a number between 1 and 7.");
            startMenu();
        }
    }
}
