package Text_Adventure;

import Text_Adventure.menuDevelopment.ASCII;

import Text_Adventure.menuDevelopment.Method;
import Text_Adventure.menuDevelopment.Play_Sound;
import Text_Adventure.menuDevelopment.SavedGame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Author: Alex Oachesu
 */
public class Main  implements Serializable {

    public static transient Scanner in = new Scanner( System.in);

    public static Method myMethod = new Method();

    /**
     * Alex: static variable tht are unique values during the game session.
     *       in this way i think is easier to control the values throughout the game
     */
    public static int choice; // choice is used as a unique variable that change values throughout the game.
    public static boolean running = true;
    public static ArrayList<SavedGame> savedGames = new ArrayList<>();
    private static final long serialVersionUID = 1347891374;
    public static void main(String[] args) {

        //        Method.displayScore(); // Testing- this displays score
        //        Method.highScore();    // This enters score into the .txt file
        //        Method.SortScore();    // This puts highest score on top
        //        Method.displayScore(); // This displays score - again for testing to see if new entry works

//        Map myMap = new Map(5);
//        myMap.generateMap(5);
//        myMap.printMap();

        //Robert: Here I did a big change as I took all the methods outside the loop.
        //it is because of debugging.
        Play_Sound music = new Play_Sound();

        ExecutorService Thread = Executors.newFixedThreadPool(4);
        Thread.submit(new Runnable() {public void run() { music.playSound("sounds/music.wav"); }});

        ASCII.printGroup1();
        ASCII.printGameName();
        myMethod.pressEnter();
        Method.clearScreen();
        myMethod.playerName();
        Method.clearScreen();
        myMethod.choosePlayerType();
        Method.clearScreen();
        myMethod.chooseGameLevel();
        Method.clearScreen();
        myMethod.playGame();
//        do{
//            myMethod.playGame();
//
//        }while(Main.choice!= 10);
        System.out.println("Thank you for playing");

    }
}
