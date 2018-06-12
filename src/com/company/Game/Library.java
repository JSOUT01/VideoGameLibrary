package com.company.Game;

import com.company.Menu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Library {

    private Scanner input = new Scanner(System.in);
    private List<Game> gamesLibrary = new ArrayList<Game>();
    private Menu menu;


    public Library(Menu menu) {
        this.menu = menu;
    }

    public void addGame () {

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
        if(gamesLibrary.isEmpty()){
            System.out.println("There are no games in your library, add a game to be able to remove.");

        }else {

            gamesLibrary.remove(index);
            System.out.println("This game has been removed from your library.");
        }


        menu.startMenu();
    }

    public void listGamesInLibrary(String location) {

        if(gamesLibrary.isEmpty()){
            System.out.println("There are no games in your library.");

        }else {


            int index = 1;
            for (Game inLibrary : gamesLibrary) {
                System.out.println(index++ + ": " + inLibrary.getTitle());
            }
        }

        if (location.equals("inLibrary")) {
            menu.startMenu();
        }
    }
    public void checkOutGames(int index) {
        if(gamesLibrary.isEmpty()) {
            System.out.println("There are no games in your library, add some games to be able to check out.");
        }else {
            Game game = gamesLibrary.get(index);

            Calendar calendar = Calendar.getInstance();
            game.setDueDate();
        }


    }
}
