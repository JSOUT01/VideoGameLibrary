package com.company;

import com.company.Game.Library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);
    private Library library = new Library(this);

    //Menu to prompt users for Library options.
    public void startMenu() {

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
                    input.nextLine();
                    // Add a game
                    System.out.println("You have chosen to add a game");
                    library.addGame();
                    break;
                case 2:
                    System.out.println("You have chosen to remove a game");
                    // Remove a game
                    System.out.println("Which number would you like to remove?");
                    library.listGamesInLibrary("forRemoval");
                    library.removeGame(input.nextInt() - 1);
                    break;
                case 3:
                    input.nextLine();
                    // View what is currently in library
                    library.listGamesInLibrary("inLibrary");
                    break;
                case 4:
                    input.nextLine();
                    // Check out a game
                    System.out.println("You have chose to check out a game." +
                            "\n Here is a list of all games available to check out.");
                    library.listGamesInLibrary("checkOut");
                    System.out.println("Choose a number for the game you like: ");
                    library.checkOutGame(input.nextInt() - 1);
                    break;
                case 5:
                    input.nextLine();
                    // Check in a game
                    System.out.println("What game are you checking in?");
                    library.listCheckedOut("CheckIn");
                    library.checkInGame(input.nextInt() - 1);
                    break;
                case 6:
                    // View checked out games
                    library.listCheckedOut("viewCheckedOut");
                    break;
                case 7:
                    System.out.println("Thank you for using the Game Library Program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("That is not a vailid entry. Please enter a number between 1 and 7.");
                    startMenu();
                    break;


            }

        } catch (InputMismatchException ime) {
            input.nextLine();
            System.out.println("That is not a vailid entry. Please enter a number between 1 and 7.");
            startMenu();
        } catch (IndexOutOfBoundsException Ioobe) {
            input.nextLine();
            System.out.println("You have not entered a correct number. You will be sent back to the main menu");
            startMenu();
        }
    }
}
