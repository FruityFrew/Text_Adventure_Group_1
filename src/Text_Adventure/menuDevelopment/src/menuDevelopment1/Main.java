package menuDevelopment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Menu myMenu = new Menu();
    public static int choice; // choice is used as a unique variable that change values throughout the game.
    public static ArrayList<SavedGame> savedGames = new ArrayList<>();
    public static Method myMethod = new Method();
    //    private static int menuChoice;// I'm thinking to use this static variable
    public static Scanner in = new Scanner(System.in); // it will be used
    public static void main(String[] args) {
        do{
            myMenu.playerName();
            myMenu.choosePlayerType();
            myMethod.chooseGameLevel();
            myMethod.playGame(myMethod.gameOptions());

        }while(Main.choice!= 10);
    }
}
