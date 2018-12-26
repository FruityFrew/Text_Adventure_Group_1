package Text_Adventure.menuDevelopment;

import Text_Adventure.Characters.Character;
import Text_Adventure.Characters.Hero;
import Text_Adventure.Characters.Monster;
import Text_Adventure.Items.Consumable;
import Text_Adventure.Items.Item;
import Text_Adventure.Items.Weapon;
import Text_Adventure.Main;
import Text_Adventure.Map;
import Text_Adventure.Room;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.*;

import static Text_Adventure.Main.myMethod;

public class Method implements Serializable {

    public transient Scanner in = new Scanner(System.in);
    Room myRoom = new Room(0, 5, 0, 0);
    public static List fileNamesList = new ArrayList();
    public static String[] fileNamesString = new String[10];
    public int diffLevel;
    public int gogo=99;
    public Sound_methods play = new Sound_methods();


    SecureRandom random = new SecureRandom();
    //public static Method myMethod = Main.myMethod;

    public Map myMap;
    public Hero hero1 = new Hero(1);
    public Room room1;
    public int newRoom;

    /**
     * Alex: this method is used in the beginning of the game
     * method chooseGameLevel
     */
    public void chooseGameLevel() {
        //Robert:I added the line of code below me
        diffLevel = 5;
        System.out.println("\nNow give me your hand to tell you your options! " +
                "\n\tYou have three paths ... " +
                "\n[1]\ta short path " +
                "\n[2]\tcrossroad with another, longer path" +
                "\n[3]\tAnd a last one, HA HA HA! This will hurt!  ");
        int choice = menuChoice();

        switch (choice) {
            case 1:
                diffLevel = 5;
                break;
            case 2:
                diffLevel = 7;
                break;
            case 3:
                diffLevel = 9;
            default:
                System.out.println("MAKE A CHOICE BETWEEN 1,2 AND 3!");
        }

        myMap = new Map(diffLevel);
    }

    /**
     * Alex: this method is used to get and store the player name in the beginning of the game
     */
    public void playerName() {

        System.out.println("The cellar of the Vicarage of Borgvattnet .." +
                " \nDarkness has possessed this lost space, " +
                " \nin between dimensions, on the border of the living and the dead. \n" +
                "\nThe space that once served the living is now home of the monsters.");
        System.out.println("What is your name traveler?");

        myMethod.hero1.setName(in.nextLine());
    }

    /**
     * Alex: This enum does not need to be used
     * It was created in the beginning as an item to be used in development
     * enum playerType
     */


    /**
     * Alex
     * method choosePlayerType
     */
    public void choosePlayerType() {

        System.out.println("Hmmm .." + hero1.getName() + ", an ordinary name, maybe fate brought you here ... or maybe just bad luck");
        System.out.println("What are you in this life .. " +
                "\n[1]\tA THIEF? " +
                "\n[2]\tA lost PRIEST in search of your lost faith?! HA HA HA!" +
                "\n[3]\tA haunted GHOST HUNTER ?" +
                "\n[4]\tOr maybe, just an annoying TOURIST?");
        Main.choice = menuChoice();
        /**
         * Alex:Sunday the Hero and Character was not functional, so I created this enum for use
         */
        switch (Main.choice) {

            case 1:
                hero1.setPlayerType("Thief");
                break;
            case 2:
                hero1.setPlayerType("Priest");
                break;
            case 3:
                hero1.setPlayerType("Ghost Hunter");
                break;
            case 4:
                hero1.setPlayerType("Tourist");
                break;
            default:
                System.out.println("You just started playing and already shaking your hand!" +
                        "\n\t MAKE A CHOICE BETWEEN 1,2,3 AND 4!");
        }
        System.out.println("OK... lets see how much a " + hero1.getPlayerType() + " is worth!");
    }

    /**
     * Alex: This method allows the player to save the game, upload a saved game, start a new game, or exit the game.
     * method gameOption
     *
     * @return int
     */
    public int gameOptions() {
        System.out.println("\t*** GAME OPTIONS ***" +
                "\n[1]\tStart Game\n[2]\tSave\n[3]\tLoad Game\n[4]\tExit");
        int gameOption = menuChoice();

        return gameOption;
    }

    /**
     * Alex: This is a method that allows the player to stop the game during the session and exit the session.
     * This method is followed by method gameOption
     * Robert: The menu needs bit debugging and I lack of time so I had to improvise.
     * My solution to the problem is an autosave of the highscore when the player leaves the game.
     */
//    public int exitOptions() {
//        System.out.println("EXIT the game?" +
//                "\n[1]\tYES" +
//                "\n[2]\tNO, go back to menu");
//        Main.choice = Main.in.nextInt();
//        switch (Main.choice) {
//            case 1:
//                if (hero1 != null){
//                    System.out.println("You are leaving the game");
//                    System.out.println("Your name was: " + hero1.getName());
//                    System.out.println("Your score was: " + hero1.getHighscore());
//                    System.out.println("Your score will be saved to the list of highscores");
//                    highScore(hero1);
//                }
//                Main.choice = 10;
//                break;
//            case 2:
//                myMethod.gameOptions();
//                break;
//            default:
//                System.out.println("Your fingers are shaking again?" +
//                        "\nChose right!");
//        }
//        return Main.choice;
//    }

    /**
     * Alex: This is a method that allows the player to stop the game during the session and exit the session.
     * This method is followed by method gameOption
     * method playOption
     * used during the player session
     */
    public void playOptions() {
        System.out.println("\n\n*        *****         *\n\n[1]\tContinue\n[2]\tExit\n\n*         *****       *\n\n");
        Main.choice = menuChoice();
        switch (Main.choice) {
            case 1:
                break;
            case 2:
                Main.choice = 10;
                break;
            default:
                System.out.println("Your fingers are shaking again?" +
                        "\nChose right!\n");
        }
    }

    /**
     * Alex: Inside this method the game is happening
     * method playGame
     */
    public void playGame() {

        //System.out.println("\t*** GAME OPTIONS ***" +
        //        "\n[1]\tStart Game\n[2]\tSave\n[3]\tLoad Game\n[4]\tExit");
        //int gameOption = Main.in.nextInt();

        myMethod.room1 = myMap.rooms.get(0);

//        System.out.println("\nEven if nothing welcoming in the cellar,.. \n\n\t****    WELCOME!    ****" +
//                "\n\nAnytime you want to see your options\n\t\t<< ENTER [10] >>\n\n");

        boolean runningmenu = true;
        while (runningmenu) {
            System.out.println(" ");
            System.out.println("*** GAME OPTIONS ***");
            System.out.println("[1]Play Game");
            System.out.println("[2]Save Game");
            System.out.println("[3]Load Game");
            System.out.println("[4]View high-scores");
            System.out.println("[5]Exit");
            int gameOption = menuChoice();


//        System.out.println("\n\tHealth = " + hero1.getHealth()+ ".\n" +
//                "--------------------------------------------\n");
            switch (gameOption) {
                case 1: // START GAME
//                do {
//                    room1.describeRoom();
//                    System.out.println("\n\t***    Choose action   ***" +
//                            "\n[1]\tFight Monster"+
//                            "\n[2]\tAvoid fight" +
//                            "\n[3]\tOpen backpack" +
//                            "\n[4]\tGo to a new room" +
//                            "\n[5]\tPick +ITEM\n");
//                    System.out.println("\n----------------------------------------------\n" +
//                            "\tHealth = " + hero1.getHealth() + ".\n" +
//                            "--------------------------------------------");
//                    Main.choice = Main.in.nextInt();
//                    in.nextLine();
//                    switch (Main.choice) {
//                        case 1:
//                            myMethod.coinFight();
//                            break;
//                        case 2:
//                            hero1.setHealth(hero1.getHealth()-25);
//                            break;
//                        case 3:
//
//                            hero1.viewContentsOfBackpack();
//                            hero1.viewContentsOfKeyRing();
//                            break;
//                        case 4:
//                            newRoom = room1.changeRoom(hero1);
//                            room1 = myMap.rooms.get(newRoom);
//
//                            break;
//                        case 5:
//                            hero1.pickItem(room1.getItem());
//                            room1.setItem(null);
//                            System.out.println("\n----------------------------------------\n\tYour health is now " + hero1.getHealth() + "." +
//                                    "\n----------------------------------------");
//                            break;
//                        default:
//                            myMethod.playOptions();
//                    }
//                } while (Main.choice != 10);
//                myMethod.playGame(myMethod.gameOptions());
                    boolean running = true;
                    while (running) {
                        System.out.println("\n----------------------------------------------\n" +
                                "\tHealth = " + myMethod.hero1.getHealth() + " Highscore = "
                                + myMethod.hero1.getHighscore() + " Room: " + myMethod.room1.getIndex() +
                                ".\n" +
                                "--------------------------------------------");
                        //System.out.println("\n\tHealth = " + hero1.getHealth()+ ".\nHighscore = " + myMethod.hero1.getHighscore() +
                        //      "--------------------------------------------\n");
                        running = myMethod.gameInterface(myMap);
                    }

                    break;
                case 2:  // SAVE GAME
                    save a = new save();
                    a.PlayerBackpack = Hero.backpack;
                    a.PlayerHealth = hero1.getHealth();
                    a.PlayerName = hero1.getName();
                    a.PlayerScore = hero1.getHighscore();
                    a.keyList = hero1.keyRing;
                    a.PlayerType = hero1.getPlayerType();
                    a.SaveRooms = myMap.rooms;
                    a.roomIndex = room1.getIndex();
                    a.Level = diffLevel;
                    a.playerWeapon = hero1.getWeapon();
                    //Robert: i added 3 lines of code below this comment
                    a.playerMap = myMap;
                    a.playerRoom = room1;
                    a.playerHero = hero1;
                    ReadWriteObject.writeObject(a);


//                SavedGame saveGame = new SavedGame(Main.in.nextLine());
//                Main.savedGames.add(saveGame);
//                Main.choice = 10;
                    break;
                case 3:
                    loadGame();
                    break;

                case 4:
                    displayScore();


//                for (SavedGame x : Main.savedGames) {
//                    System.out.println(Main.savedGames.indexOf(x) + "]\t" + x);
//                }
//                System.out.println("***    Choose a saved game    ***");
//                myMethod.playGame(Main.savedGames.indexOf(Main.in.nextInt()));
//                ;
                    break;

                case 5: // EXIT
                    //Robert: I commended the line bellow me, because I replaced with exitOptions()
                    //Main.choice = 10;
                    System.out.println("EXIT the game?" +
                            "\n[1]\tYES" +
                            "\n[2]\tNO, go back to menu");
                    int choice = menuChoice();

                    if (choice == 1) {
                        runningmenu = false;
                    } else {
                        runningmenu = true;
                    }
                    break;

                default:
                    System.out.println("EXIT the game?" +
                            "\n[1]\tYES" +
                            "\n[2]\tNO, go back to menu");
                    int choice2 = menuChoice();

                    if (choice2 == 1) {
                        runningmenu = false;
                    } else {
                        runningmenu = true;
                    }
            }
        }

        if (hero1 != null) {
            System.out.println("You are leaving the game");
            System.out.println("Your name was: " + myMethod.hero1.getName());
            System.out.println("Your score was: " + myMethod.hero1.getHighscore());
            System.out.println("Your score will be saved to the list of highscores");
            highScore(myMethod.hero1);
            SortScore();
            System.exit(1);
        }
    }

    // Ahmed: Fight system that uses already exisisting damage generator in Character-class
    public int exchangeAttackWithMonster(Hero hero, Monster monster) {
        //First hero attacks
        int damageHolder = Character.generateDamage(hero.getHitChance(), hero.getMaxAttack(), hero1.weaponDamageModifier);
        monster.setHealth(monster.getHealth() - damageHolder);
        if (monster.getHealth() > 0) {
            if (damageHolder>1) {
                play.kickSound();
                System.out.printf("You hit "+ColorPrint.ANSI_RED+myMethod.room1.monster.getMonsterType()+ColorPrint.ANSI_RESET+" and "
                        +ColorPrint.ANSI_RED+myMethod.room1.monster.getMonsterType()
                        +ColorPrint.ANSI_RESET+" looses %d health points.%n" +
                        "Monster's health (updated): %d%n", damageHolder, monster.getHealth());

            }else {
                play.missSound();
                System.out.printf("You attacked " +ColorPrint.ANSI_RED+myMethod.room1.monster.getMonsterType()
                        +ColorPrint.ANSI_RESET+ ", but you missed!!! Try again!!!%n"
                        +ColorPrint.ANSI_RED+myMethod.room1.monster.getMonsterType()
                        +ColorPrint.ANSI_RESET+"'s health (updated): %d%n", monster.getHealth());
            }
            //Then monster attacks...
            damageHolder = Character.generateDamage(monster.getHitChance(), monster.getMaxAttack(), 0);
            hero.setHealth(hero.getHealth() - damageHolder);
            if (damageHolder>1) {
                play.kickSound();
                System.out.printf(ColorPrint.ANSI_RED+myMethod.room1.monster.getMonsterType()
                        +ColorPrint.ANSI_RESET+" hits you back and you loose %d health points.%n" +
                        "Your current health: %d%n", damageHolder, hero.getHealth());
            }else{
                play.missSound();
                System.out.printf(ColorPrint.ANSI_RED+myMethod.room1.monster.getMonsterType()
                        +ColorPrint.ANSI_RESET+" attacks you but misses you by millimeters! You were lucky this time!%n" +
                        "Your current health: %d%n",hero.getHealth());
            }

        } else {
            play.monsterDeathSound();
            System.out.printf("You hit monster and monster looses %d health points.%n" +
                    "Monster is dead!\n", damageHolder, monster.getHealth());
        }
        return hero.getHealth();
    }

    //Robert: I made this sorry excuse of fighting system;
    public void coinFight() {
        int coin = random.nextInt(2);
        if (coin == 0) {
            System.out.println("the monster beat you in coins you loose 5 health");
            hero1.setHealth(hero1.getHealth() - 15);
        } else {
            System.out.println("you beat the monster in coins. it gives you 5 of his health");
            hero1.setHealth(hero1.getHealth() + 15);
        }
    }

    public void useItem(Item item) {
        System.out.println("\n[1]\tUse " + item.getName() + "\n[2]\tThrow " + item.getName());
        Main.choice = menuChoice();

        switch (Main.choice) {
            case 1:
                if (item instanceof Consumable) {
//                    hero1.consumeItem(item);
                } else if (item instanceof Weapon) {
//                    hero1.weapon(item);
                } else {
//                    hero1.key(item);
                }
                break;
            case 2:
                //               Hero.backpack.remove(item);
        }
    }

    public int backpackMenu(Item[] backpack) {
        int i = 0;
        for (Item x : Hero.backpack) {
            i++;
            System.out.print(i);
            System.out.println(x);
        }
        System.out.println("\nChoose the item you want to use:");
        return Main.choice = menuChoice();

        //public static void main(String[] args) {
        //   Hero newHunter = new Hero(1);
        //    System.out.println(newHunter.toString());

        //    Character newMonster = new Character();

        //    Method actions = new Method();
        //    for(int i = 0; i<10; i++) actions.exchangeAttackWithMonster(newHunter, newMonster);

        //    System.out.println(newHunter.toString());
        //    System.out.println(newHunter);
        //}
    }

    /**
     * Nemanja: This creates the HighScoresList.txt file if the file does not exist.
     * It also enters new scores into the HighScoresList.txt file and stores it.
     * Robert: Now the name and the highscore are taken directly from the Hero class.
     */
    public static void highScore(Hero hero) {

        PrintWriter scoreExport = null;

        int highScore;
        String playerName;
        String fileName = ("HighScoresList.txt");
        try {
            scoreExport = new PrintWriter(new FileWriter(fileName, true));
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Could not find file " + fileName);
        }
        //System.out.println("Congratulations, your score was the highest!\n");

        //Robert: I did few changes here in order to make this thing work.
        //System.out.print("DEBUG: Enter score ");
        //highScore = input.nextInt();
        highScore = hero.getHighscore();
        //System.out.print("DEBUG: Enter name: ");
        playerName = hero.getName();

        scoreExport.println(highScore + " - " + playerName);
        scoreExport.close();

    }

    /**
     * Nemanja: This sorts entries in the HighScoresList.txt file.
     * It puts highest score on top.
     */
    public static void SortScore() {
        BufferedReader BR = null;
        BufferedWriter BW = null;
        String fileName = ("HighScoresList.txt");
        //Arraylist that holds scores
        ArrayList<String> scores = new ArrayList<String>();
        try {
            //BR reads entries from the file "HighScoresList.txt"
            BR = new BufferedReader(new FileReader("HighScoresList.txt"));

            String entry = BR.readLine(); //Reads each line and enters into an arrayList
            while (entry != null) {
                scores.add(entry);
                entry = BR.readLine();  //Reads next line
            }
            //Score sorting in an arraylist
            Collections.sort(scores, Collections.reverseOrder());
            //BW writes changes to the "HighScoresList.txt". Changes being sorted entries in descending order.
            BW = new BufferedWriter(new FileWriter("HighScoresList.txt"));
            for (String line : scores) {
                BW.write(line);
                BW.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            System.out.println("Could not find file " + fileName);
        } finally {
            // Buffer Reader/Writer close and exception handling
            try {
                if (BR != null) {
                    BR.close();
                }
                if (BW != null) {
                    BW.close();
                }
            } catch (IOException e) {
                System.out.println("Opps! Something went wrong!");
                System.out.println(e.toString());
            }
        }
    }

    /**
     * Nemanja: This prints HighScoresList.txt file content in the console.
     * It is used if user wants to see current score table.
     */
    public static void displayScore() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("HighScoresList.txt"));
            String scoreDisplay;
            int i = 1;
            while ((scoreDisplay = in.readLine()) != null) {
                System.out.println(i + ". " + scoreDisplay);
                i++;
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e.toString());
            System.out.println("Could not find file HighScoresList.txt");
        }
    }

    public boolean gameInterface(Map myMap) {
        boolean result = true;
        //int newRoom = 0;
        if (myMethod.room1.monster != null) {
            myMethod.room1.describeMonster();
        }
        if (myMethod.room1.monster == null) {
            myMethod.room1.describeRoom();
        }
        System.out.println(" ");
        System.out.println("***    Choose action   ***");
        if (myMethod.room1.monster != null) {
            System.out.print("[1] Fight " +
                    ColorPrint.ANSI_RED+myMethod.room1.monster.getMonsterType()+ColorPrint.ANSI_RESET);
        }
        //Same as pick item. The concept is cool.
        if (myMethod.room1.monster != null) {
            System.out.print("| [2] Avoid fight ");
        }
        System.out.print("|[3] Open backpack| ");
        if (myMethod.room1.monster == null) {
            System.out.print("| [4] Go to a new room ");
        }
        if (myMethod.room1.monster == null) {
            if (myMethod.room1.monster == null) {
                if (myMethod.room1.getItem() != null) {
                    System.out.print("| [5] Pick up " +ColorPrint.ANSI_BLUE
                            +myMethod.room1.getItem().getName()
                    +ColorPrint.ANSI_RESET);
                }
                //Robert: Everyone asked for this modification.
            }
        }
        System.out.println(" | [6] Go to the menu");
        int choice = menuChoice();

        switch (choice) {
            case 1:
                if (myMethod.room1.monster != null) {
                    hero1.addHighScore(100);
                    myMethod.hero1.setHealth(myMethod.exchangeAttackWithMonster(myMethod.hero1, room1.monster));
                    if (room1.monster.getHealth() < 1) {
                        myMethod.room1.setMonster(null);
                        hero1.addHighScore(50);
                        System.out.println("You killed the monster.");
                    }
                }
                break;
            case 2:
                if (myMethod.room1.monster != null) {
                    myMethod.hero1.setHealth(hero1.getHealth() - (hero1.getHealth() / 2));
                    System.out.println("You lost your half health but you avoided the monster");
                    myMethod.room1.setMonster(null);
                    hero1.addHighScore(50);
                }
                break;
            case 3:
                hero1.viewContentsOfKeyRing();
                if (hero1.weapon != null) hero1.viewConstentofWeaponSlot();
                hero1.viewContentsOfBackpack();
                break;
            case 4:
                if (myMethod.room1.monster == null) {
                    newRoom = myMethod.room1.changeRoom(hero1);
                    System.out.println("You new room is: " + newRoom);
                    myMethod.room1 = myMap.rooms.get(newRoom);
                    myMethod.hero1.addHighScore(100);
                }
                break;
            case 5:
                if (myMethod.room1.getItem() != null) {
                    if (myMethod.room1.monster == null) {
                        hero1.pickItem(myMethod.room1.getItem(), myMethod.room1);
                        myMethod.room1.setItem(null);
                        hero1.addHighScore(100);
                    }
                }
                break;

            case 6:
                result = false;
                //myMethod.playOptions();
                break;

            default:
                result = true;
                //myMethod.playOptions();
        }
        if (myMethod.hero1.getHealth() < 1) {
            System.out.println(" ");
            System.out.println("=========");
            System.out.println("Game Over");
            myMethod.hero1.setHealth(300);
            System.out.println("========");
            System.out.println(" ");
            result = false;
        }
        return result;
    } //method gameInterface ends here

    public static void ShowSaves() {

        fileNamesList.clear();
        try {
            Files.newDirectoryStream(Paths.get("saves"),
                    path -> path.toString().endsWith(".save")).forEach(filePath -> fileNamesList.add(filePath.toString()));
        } catch (Exception e) {
            System.out.println("Ooops!");

        }
        for (int i = 0; i < fileNamesList.size(); i++) {
            fileNamesString[i] = fileNamesList.get(i).toString();
        }
        int number = 0;
        for (String saveName : fileNamesString) {
            if (saveName != null) {
                number++;
                System.out.println(number + ") " + saveName);

            } else {
                number++;
                System.out.println(number + ") Empty slot");

            }
        }
    }

    public void loadGame() {
        Method.ShowSaves();
        System.out.println("ENTER [0] TO GO BACK TO MENU");
        System.out.print("Choose line number to load: ");
        int chooseSave = menuChoice();

        if (chooseSave != 0) {
            System.out.println(fileNamesString[chooseSave - 1]);
            save b = (save) ReadWriteObject.readObject(fileNamesString[chooseSave - 1]);
            myMethod.hero1 = b.playerHero;
            Hero.backpack = b.PlayerBackpack;
            hero1.setHealth(b.PlayerHealth);
            hero1.setName(b.PlayerName);
            hero1.addHighScore(b.PlayerScore);
            hero1.keyRing = b.keyList;
            hero1.setPlayerType(b.PlayerType);
            myMap.rooms = b.SaveRooms;
            //Robert:I added  one line of code below this comment
            myMethod.myMap = b.playerMap;
            room1.setIndex(b.roomIndex);
            //Robert:I added  one line of code below this comment
            myMethod.room1 = b.playerRoom;
            hero1.setWeapon(b.playerWeapon);
            diffLevel = b.Level;

        }
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (Exception e) {
            System.out.println("Something went wrong!!! ");
            e.printStackTrace();
        }
    }

    public int menuChoice(){
        boolean successfulinput = false;
        while(!successfulinput){
            try{
                gogo = in.nextInt();
                successfulinput = true;
            } catch(InputMismatchException a){
                in.nextLine();
                System.out.println("Please use integer digits");
            }
        } return gogo;

    }
    public void pressEnter(){
        String catchEnter;
        System.out.println(ColorPrint.Background_WHITE+"---------------------------------------------------------------------------------------------------------------------"+ColorPrint.ANSI_RESET);
        System.out.println("                                            Press ENTER to start");
        System.out.println(ColorPrint.Background_WHITE+"---------------------------------------------------------------------------------------------------------------------"+ColorPrint.ANSI_RESET);
        catchEnter=in.nextLine();

    }



}