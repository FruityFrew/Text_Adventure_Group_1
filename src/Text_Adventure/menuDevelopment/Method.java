package Text_Adventure.menuDevelopment;

import Text_Adventure.Characters.Hero;
import Text_Adventure.Characters.Monster;
import Text_Adventure.Items.Consumable;
import Text_Adventure.Items.Item;
import Text_Adventure.Main;
import Text_Adventure.Room;

import java.security.SecureRandom;


public class Method {
    //Robert: I added this line below me
    SecureRandom random = new SecureRandom();
    public static Method myMethod = new Method();
    //Robert: I will add bit code here
    //================================
    Monster monster = new Monster();
    Item item1 = new Item("Greek coffee");
    Room room1 = new Room(1,1, monster, item1);
    Hero hero1 = new Hero(1);
    //================================
    //Robert: You will see bit code as well on the "go to a new room options"
    //I added some imports as well

    /**
     * method chooseGameLevel
     */
    public void chooseGameLevel() {
        System.out.println("\nNow give me your hand to tell your options! " +
                "\n\tYou have three lines ... " +
                "\n[1]\ta short one " +
                "\n[2]\tintersected with another, longer" +
                "\n[3]\tAnd a last one, HA HA HA! This will hurt!  ");
        int choice = Main.in.nextInt();
        switch (choice) {
// the game level settings needs to be implemented
            case 1:
//               gameLevel = level_easy;
                break;
            case 2:
//               gameLevel = level_normal;
                break;
            case 3:
//               gameLevel = level_hard;
                break;
            default:
                System.out.println("MAKE A CHOICE BETWEEN 1,2 AND 3!");
        }
    }

    /**
     * Alex: This method allows the player to save the game, upload a saved game, start a new game, or exit the game.
     * method gameOption
     * @return int
     */
    public int gameOptions() {
        System.out.println("\t*** GAME OPTIONS ***" +
                "\n[1]\tStart Game\n[2]\tSave\n[3]\tLoad Game\n[4]\tExit");
        int gameOption = Main.in.nextInt();
        return gameOption;
    }

    /**
     * Alex: This is a method that allows the player to stop the game during the session and exit the session.
     *       This method is followed by method gameOption
     */
    public int exitOptions(){
        System.out.println("Go to the game options?" +
                "\n[1]\tYES" +
                "\n[2]\tContinue to play");
        Main.choice = Main.in.nextInt();
        switch (Main.choice) {
            case 1:
                myMethod.gameOptions();
                break;
            case 2:
                break;
            default:
                System.out.println("Your fingers are shaking again?" +
                        "\nChose right!");
        }
        return Main.choice;
    }

    /**
     * Alex: This is a method that allows the player to stop the game during the session and exit the session.
     *       This method is followed by method gameOption
     * method playOption
     * used during the player session
     */
    public void playOptions(){
        System.out.println("\n[1]\tContinue\n[2]\tExit");
        Main.choice= Main.in.nextInt();
        switch(Main.choice){
            case 1:
                break;
            case 2:
                Main.choice=10;
                break;
            default:
                System.out.println("Your fingers are shaking again?" +
                        "\nChose right!");
        }
    }

    /**
     * Alex: Inside this method the game is happening
     * method playGame
     * @param gameOption
     */
    public void playGame(int gameOption) {
//        Menu myMenu = new Menu();

        System.out.println("Even is nothing welcoming in the cellar,.. \n\t****    WELCOME!    ****" +
                "\n\nAnytime you want to see your options\n\t\t<< ENTER [10] >>\n");
        System.out.println("\n\tHealth = "+ Main.playerHealth+".\n" +
                "--------------------------------------------");
        switch (gameOption) {
            case 1: // START GAME
                do {
                    //Robert: I will add bit code here
                    //================================
                    room1.describeRoom();
                    //================================
                    //Robert: You will see bit code as well on the "go to a new room options"
                    //I added some imports as well
                    //System.out.println("\n\n\tWalk carefully in your first room\n\nHm... In this room you have a coffee");
                    Main.nbrDoors=3;//example
                    switch (Main.nbrDoors) { //room = door(s)
                        case 1:  // room = door(s)
                            System.out.println(" \t***    Choose door    ***" +
                                    "\n[1]\tNorth door" +//if the north door exists
                                    "\n[2]\tSouth door" +//if the south door exists
                                    "\n[3]\tWest door" +// if the west door exists
                                    "\n[4]\tEast door");// if the est door exists
                            Main.choice = Main.in.nextInt();// the selected door will move the hero in the correct room
                            System.out.println("\n----------------------------------------------\n" +
                                    "\tHealth = "+ Main.playerHealth+".\n" +
                                    "--------------------------------------------");

                            switch(Main.choice){
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                default:
                                    myMethod.playOptions();
                            }
                            break;
                        case 2:  // room = door(s), monster
                            System.out.println("\t***    Choose action   ***" +
                                    "\n[1]\tFight +MONSTER_TYPE" +
                                    "\n[2]\tAvoid fight" +
                                    "\n[3]\tChange weapon" +
                                    "\n[4]\tGo to a new room");

                            Main.choice = Main.in.nextInt();
                            System.out.println("\n----------------------------------------------\n" +
                                    "\tHealth = "+ Main.playerHealth+".\n" +
                                    "--------------------------------------------");
                            switch (Main.choice) {
                                case 1:
                                    System.out.println("The fightMonster method will be called");
                                    //Robert: I added an advance fighting system here
                                    myMethod.coinFight();
                                    break;
                                case 2:
                                    System.out.println("The hero will lose health");
                                    //robert: I added this line bellow me.
                                    Main.playerHealth = Main.playerHealth - 25;
                                    break;
                                case 3:
                                    System.out.println("The inventory of the backpack will be shown" +
                                            "\nThe h=method change item will be called");
                                    //robert: I added this line bellow me.
                                    hero1.viewContentsOfBackpack();
                                    break;
                                case 4:
                                    System.out.println("The method changeRoom will be called");
                                    break;
                                default:
                                    myMethod.playOptions();
                            }

                            break;
                        case 3:  // room = door(s), monster, item
                            System.out.println("\n\t***    Choose action   ***" +
                                    "\n[1]\tFight +MONSTER_TYPE" +
                                    "\n[2]\tAvoid fight" +
                                    "\n[3]\tChange weapon" +
                                    "\n[4]\tGo to a new room" +
                                    "\n[5]\tPick +ITEM\n");
                            System.out.println("\n----------------------------------------------\n" +
                                    "\tHealth = "+ Main.playerHealth+".\n" +
                                    "--------------------------------------------");
                            Main.choice = Main.in.nextInt();
                            switch (Main.choice) {
                                case 1:
                                    System.out.println("The fightMonster method will be called");
                                    //Robert: I added an advance fighting system here
                                    myMethod.coinFight();
                                    break;
                                case 2:
                                    System.out.println("The hero will lose health");
                                    //robert: I added this line bellow me.
                                    Main.playerHealth = Main.playerHealth - 25;
                                    break;
                                case 3:
                                    System.out.println("The inventory of the backpack will be shown" +
                                            "\nThe h=method change item will be called");
                                    //robert: I added this line bellow me.
                                    hero1.viewContentsOfBackpack();
                                    break;
                                case 4:

                                    //System.out.println("the method changeRoom will be called");
                                    //Robert: I will add bit code here and I commented out a line of code
                                    //================================
                                    Monster monster2 = new Monster();
                                    Item item2 = new Item("french coffee");
                                    room1.setItem(item2);
                                    room1.setMonster(null);
                                    //room1.describeRoom();
                                    //================================
                                    //Robert: You will see bit code as well on the beginning of this function"
                                    //I added some imports as well

                                    break;
                                case 5:
                                    //System.out.println("\n--------------------------------------------------------------------------------------" +
                                    //        "\nYou just drunk this black coffee... hm, if you can call this dark liquid ..'coffee'!\n" +
                                    //        "---------------------------------------------------------------------------------------\n");

                                    //robert: I added this line bellow me.
                                    hero1.addItemToBackpack(room1.getItem());
                                    //Main.playerHealth += 50;// the Consumable Class is irrelevant in this form, it needs to be completed with different types of items, as we decided.
                                    // Coffee = 50 health points.
                                    System.out.println("\n----------------------------------------\n\tYour health is now "+ Main.playerHealth+"." +
                                            "\n----------------------------------------");
                                    break;
                                default:
                                    myMethod.playOptions();
                            }
                            break;
                        case 4: // room = item , door(s)
                            System.out.println("\t***    Choose action   ***" +
                                    "\n[1]\tPick +ITEM" +
                                    "\n[2]\tGo to a new room");
                            Main.choice = Main.in.nextInt();
                            switch (Main.choice) {
                                case 1:
                                    System.out.println("The method pickItem will be called");
                                    break;
                                case 2:
                                    System.out.println("the method changeRoom will be called");
                                    break;
                                default:
                                    myMethod.playOptions();
                            }
                            break;
                        default:
                            System.out.println("Go to the game options?" +
                                    "\n[1]\tYES" +
                                    "\n[2]\tContinue to play");
                            Main.choice = Main.in.nextInt();
                            switch (Main.choice) {
                                case 1:
                                    Main.choice= 10;
                                    break;
                                case 2:
                                    myMethod.playOptions();
                                default:
                                    System.out.println("Your fingers are shaking again?" +
                                            "\nChose right!");
                            }
                    }
                } while (Main.choice != 10);
                myMethod.playGame(myMethod.gameOptions());

                break;
            case 2:  // SAVE GAME
                System.out.println("Enter the name of the game: \n");
                SavedGame saveGame=new SavedGame(Main.in.nextLine());
                Main.savedGames.add(saveGame);
                Main.choice=10;
                break;
            case 3: // LOAD GAME
                for(SavedGame x: Main.savedGames){
                    System.out.println(Main.savedGames.indexOf(x)+"]\t"+ x);
                }
                System.out.println("***    Choose a saved game    ***");
                myMethod.playGame(Main.savedGames.indexOf(Main.in.nextInt()));;
                break;

            case 4: // EXIT
                Main.choice=10;
            default:
                myMethod.exitOptions();
        }
    }

    //Robert: I made this sorry excuse of fighting system;
    public void coinFight(){
        int coin = random.nextInt(2);
        if (coin == 0){
            System.out.println("the monster beat you in coins you loose 5 health");
            Main.playerHealth = Main.playerHealth - 5;
        } else {
            System.out.println("you beated the monster in coins. it gives you 5 of his health");
            Main.playerHealth = Main.playerHealth + 5;
        }
    }
}
