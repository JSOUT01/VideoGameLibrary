package com.company.Game;

import com.company.Menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Library {

    private Scanner input = new Scanner(System.in);
    private List<Game> gamesLibrary = new ArrayList<Game>();
    private List<Game> checkedOutGames = new ArrayList<Game>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
    private Menu menu;


    public Library(Menu menu) {
        this.menu = menu;
    }

    public void addGame() {

        System.out.println("What is the title of your game?");
        String title = input.nextLine();
        System.out.println("What type of game is this?");
        String type = input.nextLine();
        System.out.println("What is the Id number of this gamne?");
        int idNumber = input.nextInt();
        input.nextLine();

        Game game = new Game(title, type, idNumber);
        gamesLibrary.add(game);
        System.out.println("You have added " + game.getTitle() + " to your library, this game can now be checked out. \n");

        menu.startMenu();


    }

    public void removeGame(int index) {
        if (gamesLibrary.isEmpty()) {
            System.out.println("There are no games in your library, add a game to be able to remove.");

        } else {

            gamesLibrary.remove(index);
            System.out.println("This game has been removed from your library.");
        }


        menu.startMenu();
    }

    public void listGamesInLibrary(String location) {

        if (gamesLibrary.isEmpty()) {
            System.out.println("There are no games in your library.");

        } else {


            int index = 1;
            for (Game inLibrary : gamesLibrary) {
                System.out.println(index++ + ": " + inLibrary.getTitle());
            }
        }

        if (location.equals("inLibrary")) {
            menu.startMenu();
        }
    }

    public void checkOutGame(int index) {
        if (gamesLibrary.isEmpty()) {
            System.out.println("There are no games in your library, add some games to be able to check out.");
        } else {
            Game game = gamesLibrary.get(index);

            //Create an instance of the calendar object
            Calendar calendar = Calendar.getInstance();
            //Add 7 days to current date
            calendar.add(Calendar.DAY_OF_YEAR, 7);
            //Uses the line above to set a due date in the future to a variable
            String dueDate = dateFormat.format(calendar.getTime());
            //Tell user what their due date is
            System.out.println(game.getTitle() + " is due on" + dueDate);
            //Set dueDate for this game
            game.setDueDate(dueDate);
            //Add game to checked out list
            checkedOutGames.add(game);
            //remove game from library
            gamesLibrary.remove(game);
        }
        menu.startMenu();
    }

    public void checkInGame(int index) {
        Game game = checkedOutGames.get(index);
        gamesLibrary.add(game);
        try {
            Calendar calendar = Calendar.getInstance();
            if (dateFormat.parse(dateFormat.format(calendar.getTime())).before(dateFormat.parse(game.getDueDate()))) {
                System.out.println("Thanks for turning your game on time!");
            } else {
                System.out.println("Shame on your! You were late turning in your game >=(");
            }
        } catch (ParseException pe) {
        }
        checkedOutGames.remove(game);
        menu.startMenu();
    }

    public void listCheckedOut(String location) {
        // checks to see if our arrayList is empty
        if (checkedOutGames.isEmpty()) {
            System.out.println(" There are no games currently checked out.");
            menu.startMenu();
        } else {
            int index = 1;
            //iterate though checkedOutGames list
            for (Game game : checkedOutGames) {
                //Increment index by 1 and print out that number followed by the game title
                System.out.println(index++ + ": " + game.getTitle());
            }
        }
        if (location.equals("viewCheckedOut")) {
            menu.startMenu();
        }
    }

}
