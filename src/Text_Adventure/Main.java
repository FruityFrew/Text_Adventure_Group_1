package Text_Adventure;

import Text_Adventure.Characters.Hero;
import Text_Adventure.Items.Consumable;
import Text_Adventure.menuDevelopment.Menu;
import Text_Adventure.menuDevelopment.Method;
import Text_Adventure.menuDevelopment.SavedGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Alex: A scanner object used throughout the game
     */
    public static Scanner in = new Scanner(System.in);
    /**
     * Alex: instances
     */
    private static Menu myMenu = new Menu();
    private static Method myMethod = new Method();

    /**
     * Alex: static variable tht are unique values during the game session.
     *       in this way i think is easier to control the values throughout the game
     */
    public static int choice; // choice is used as a unique variable that change values throughout the game.
    public static String playerName;//stores the name of the player
    public static int playerHealth;
    public static int nbrDoors;//stores during the game the number of available doors that the player has access to
    /**
     * Alex: This arrayList will store the saved games.
     *
     */
    public static ArrayList<SavedGame> savedGames = new ArrayList<>();

    /**
     * Alex: The game will run inside a do while loop.
     *
     */

    public static void main(String[] args) {
        do{
            playerHealth=200;
            myMenu.playerName();
            myMenu.choosePlayerType();
            myMethod.chooseGameLevel();
            myMethod.playGame(myMethod.gameOptions());

        }while(Main.choice!= 10);
    }
}
