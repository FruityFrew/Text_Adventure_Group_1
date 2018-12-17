package Text_Adventure;

import Text_Adventure.menuDevelopment.Method;
import Text_Adventure.menuDevelopment.SavedGame;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author: Alex Oachesu
 */
public class Main  {

    public static Scanner in = new Scanner( System.in);
    private static Method myMethod = new Method();

    /**
     * Alex: static variable tht are unique values during the game session.
     *       in this way i think is easier to control the values throughout the game
     */
    public static int choice; // choice is used as a unique variable that change values throughout the game.

    public static ArrayList<SavedGame> savedGames = new ArrayList<>();

    public static void main(String[] args) {

        //        Method.displayScore(); // Testing- this displays score
        //        Method.highScore();    // This enters score into the .txt file
        //        Method.SortScore();    // This puts highest score on top
        //        Method.displayScore(); // This displays score - again for testing to see if new entry works

        Map myMap = new Map(5);
        myMap.generateMap(5);
        myMap.printMap();

        do{
            myMethod.playerName();
            myMethod.choosePlayerType();
            myMethod.chooseGameLevel();
            myMethod.playGame(myMethod.gameOptions());

        }while(Main.choice!= 10);
    }
}
