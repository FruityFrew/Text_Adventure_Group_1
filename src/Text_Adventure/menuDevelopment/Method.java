package Text_Adventure.menuDevelopment;

import Text_Adventure.Characters.Character;
import Text_Adventure.Characters.Hero;
import Text_Adventure.Characters.Monster;
import Text_Adventure.DisplayMap;
import Text_Adventure.Items.Consumable;
import Text_Adventure.Items.Item;
import Text_Adventure.Items.Key;
import Text_Adventure.Items.Weapon;
import Text_Adventure.Main;
import Text_Adventure.Map;
import Text_Adventure.Room;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static Text_Adventure.Main.myMethod;

public class Method implements Serializable {

    public transient Scanner in = new Scanner(System.in);
    Room myRoom = new Room(0, 5, 0, 0);
    public static List fileNamesList = new ArrayList();
    public static String[] fileNamesString = new String[10];
    public int diffLevel;
    public int gogo = 99;
    public Sound_methods play = new Sound_methods();
    public long startTime;
    public long endTime;
    public long TIME;



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
        myMethod.slowPrint("\nNow give me your hand to tell you your options! \n" +
                "\n\tYou have three paths ... \n ",50);
        myMethod.threadSleep(1000);
        System.out.println(
                "\n[1]\ta short path " +
                "\n[2]\tcrossroad with another, longer path" +
                "\n[3]\tAnd a last one, HA HA HA! This will hurt!  ");
        int choice = menuChoice();

        switch (choice) {
            case 1:
                play.menuSound();
                diffLevel = 5;
                break;
            case 2:
                play.menuSound();
                diffLevel = 7;
                break;
            case 3:
                play.menuSound();
                diffLevel = 9;
            default:
                play.menuSound();
                System.out.println("MAKE A CHOICE BETWEEN 1,2 AND 3!");
        }

        myMap = new Map(diffLevel);
    }

    /**
     * Alex: this method is used to get and store the player name in the beginning of the game
     * Nemanja: I modified Alex's method (implemented typewriter effect)
     */
    public void playerName() {
        myMethod.slowPrint("The cellar of the Vicarage of Borgvattnet ..\n", 50);
        myMethod.threadSleep(500);
        myMethod.slowPrint(" \nDarkness has possessed this lost space, " +
                " \nin between dimensions, on the border of the living and the dead. \n", 50);
        myMethod.threadSleep(500);
        myMethod.slowPrint("\nThe space that once served the living is" +
                " now home of the monsters.\n", 50);
        myMethod.threadSleep(1000);
        myMethod.slowPrint("\nWhat is your name traveler?\n",50);

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
        myMethod.slowPrint("Hmmm .. " + hero1.getName(), 50);
        myMethod.threadSleep(500);
        myMethod.slowPrint(", what un-ordinary name, ",50);
        myMethod.threadSleep(500);
        myMethod.slowPrint(" maybe fate brought you here ... ",50);
        myMethod.threadSleep(500);
        myMethod.slowPrint("or maybe just bad luck\n",50);
        myMethod.threadSleep(1000);
        myMethod.slowPrint("\nWhat are you in this life .. \n",50);
        myMethod.threadSleep(1000);
        System.out.println(
                "\n[1]\tA "+ColorPrint.ANSI_CYAN+"THIEF"+ColorPrint.ANSI_RESET+ " ?"  +
                "\n[2]\tA lost "+ColorPrint.ANSI_CYAN+"PRIEST"+ColorPrint.ANSI_RESET+ " in search of your lost faith?! HA HA HA!" +
                "\n[3]\tA haunted " +ColorPrint.ANSI_CYAN+"GHOST HUNTER"+ColorPrint.ANSI_RESET+ " ?" +
                "\n[4]\tOr maybe, just an annoying "+ColorPrint.ANSI_CYAN+"TOURIST"+ColorPrint.ANSI_RESET+" ?");
        Main.choice = menuChoice();
        /**
         * Alex:Sunday the Hero and Character was not functional, so I created this enum for use
         */
        //Robert: in the Hero Class there were stats that are meant for each different player type.
        //The problem was that those stats were set only through the constructor.
        //I bypassed the problem by creating 4 methods one for each class that are arranging the stats
        //based on the type of the player.
        //I didn't touch the statistics yet, I am more focused to the constext now
        //The content can be taken care later.
        switch (Main.choice) {

            case 1:
                play.menuSound();
                //hero1.setPlayerType("Thief");
                hero1.makeThief();
                break;
            case 2:
                play.menuSound();
                //hero1.setPlayerType("Priest");
                hero1.makePriest();
                break;
            case 3:
                play.menuSound();
                //hero1.setPlayerType("Ghost Hunter");
                hero1.makeGhostHunter();
                break;
            case 4:
                play.menuSound();
                //hero1.setPlayerType("Tourist");
                hero1.makeTourist();
                break;
            default:
                play.menuSound();
                System.out.println("You just started playing and already shaking your hand!" +
                        "\n\t MAKE A CHOICE BETWEEN 1,2,3 AND 4!");
        }
        myMethod.slowPrint("OK... lets see how much a " + hero1.getPlayerType() + " is worth!",60);
        threadSleep(2000);
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
                play.menuSound();
                break;
            case 2:
                play.menuSound();
                Main.choice = 10;
                break;
            default:
                play.menuSound();
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
                case 1:
                    play.menuSound();
                    startTime = System.nanoTime();
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
                case 2:
                    play.menuSound();
                    // SAVE GAME
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
                    play.menuSound();
                    loadGame();
                    break;

                case 4:
                    play.menuSound();
                    displayScore();


//                for (SavedGame x : Main.savedGames) {
//                    System.out.println(Main.savedGames.indexOf(x) + "]\t" + x);
//                }
//                System.out.println("***    Choose a saved game    ***");
//                myMethod.playGame(Main.savedGames.indexOf(Main.in.nextInt()));
//                ;
                    break;

                case 5:
                    play.menuSound();
                    // EXIT
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
                    play.menuSound();
                    System.out.println("EXIT the game?" +
                            "\n[1]\tYES" +
                            "\n[2]\tNO, go back to menu");
                    int choice2 = menuChoice();

                    if (choice2 == 1) {
                        play.menuSound();
                        runningmenu = false;

                    } else {
                        play.menuSound();
                        runningmenu = true;
                    }
            }
        }

        if (hero1 != null) {
            endTime = System.nanoTime();
            TIME = endTime - startTime;
            System.out.println("You are leaving the game");
            System.out.printf("Time played (HH:MM:SS):  %s %n", time());
            System.out.println("Your name was: " + myMethod.hero1.getName());
            System.out.println("Your score was: " + myMethod.hero1.getHighscore());
            System.out.println("Your score will be saved to the list of highscores");
            highScore(myMethod.hero1);
            SortScore();
            System.out.println("Enter any string to EXIT");
            String anyString = in.next();
            System.exit(1);
        }
    }

    // Ahmed: Fight system that uses already exisisting damage generator in Character-class
    //Robert: If you wander why the fighting system works is because I did a 5 line patch
    //that solves the problem. The patch is located in the main constructor of the room class
    public int exchangeAttackWithMonster(Hero hero, Monster monster) {
        //First hero attacks

        int damageHolder = Character.generateDamage(hero.getHitChance(), hero.getMaxAttack(), hero1.weaponDamageModifier);
        monster.setHealth(monster.getHealth() - damageHolder);
        if (monster.getHealth() > 0) {
            if (hero.getWeapon() != null){
                //Robert: The following 5 lines of code are implementing the favorite enemy feature.
                if (hero.getWeapon().getFavoriteEnemy() == monster.getHatedWeapon()){
                    System.out.println("Your weapon attacks " + ColorPrint.ANSI_RED + monster.getMonsterType() + " successfully.");
                    monster.setHealth(monster.getHealth() - 20);
                    System.out.println(ColorPrint.ANSI_RED + monster.getMonsterType() + " loses 20 points of health");
                }
            }
            if (damageHolder > 1) {
                play.kickSound();
                System.out.printf("You hit " + ColorPrint.ANSI_RED + myMethod.room1.monster.getMonsterType() + ColorPrint.ANSI_RESET + " and "
                        + ColorPrint.ANSI_RED + myMethod.room1.monster.getMonsterType()
                        + ColorPrint.ANSI_RESET + " looses %d health points.%n" +
                        "Monster's health (updated): %d%n", damageHolder, monster.getHealth());

            } else {
                play.missSound();
                System.out.printf("You attacked " + ColorPrint.ANSI_RED + myMethod.room1.monster.getMonsterType()
                        + ColorPrint.ANSI_RESET + ", but you missed!!! Try again!!!%n"
                        + ColorPrint.ANSI_RED + myMethod.room1.monster.getMonsterType()
                        + ColorPrint.ANSI_RESET + "'s health (updated): %d%n", monster.getHealth());
            }
            //Nemanja. I added this line in order to separate monster and hero attack.
            // Monster waits one second before it attacks hero.
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("wow");
            }
            //Then monster attacks...
            damageHolder = Character.generateDamage(monster.getHitChance(), monster.getMaxAttack(), 0);
            hero.setHealth(hero.getHealth() - damageHolder);
            if (damageHolder > 1) {
                play.kickSound();
                System.out.printf(ColorPrint.ANSI_RED + myMethod.room1.monster.getMonsterType()
                        + ColorPrint.ANSI_RESET + " hits you back and you loose %d health points.%n" +
                        "Your current health: %d%n", damageHolder, hero.getHealth());
            } else {
                play.missSound();
                System.out.printf(ColorPrint.ANSI_RED + myMethod.room1.monster.getMonsterType()
                        + ColorPrint.ANSI_RESET + " attacks you but misses you by millimeters! You were lucky this time!%n" +
                        "Your current health: %d%n", hero.getHealth());
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
                play.menuSound();
                if (item instanceof Consumable) {
//                    hero1.consumeItem(item);
                } else if (item instanceof Weapon) {
//                    hero1.weapon(item);
                } else {
//                    hero1.key(item);
                }
                break;
            case 2:
                play.menuSound();
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
            myMethod.room1.describeMonster(myMethod.hero1);
        }
        if (myMethod.room1.monster == null) {
            myMethod.room1.describeRoom();
        }
        System.out.println(" ");
        System.out.println("***    Choose action   ***");
        if (myMethod.room1.monster != null) {
            System.out.print("[1] Fight " +
                    ColorPrint.ANSI_RED + myMethod.room1.monster.getMonsterType() + ColorPrint.ANSI_RESET
            + " ");
        }

        if(myMethod.hero1.getHealth() >= 50 ){
            if (myMethod.room1.monster != null) {
                System.out.print("| [2] Avoid fight ");
            }
        }
        System.out.print("| [3] Open backpack| ");
        if (myMethod.room1.monster == null) {
            System.out.print("| [4] Go to a new room ");
        }
        if (myMethod.room1.monster == null) {
            if (myMethod.room1.monster == null) {
                if (myMethod.room1.getItem() != null) {
                    System.out.print("| [5] Pick up " + ColorPrint.ANSI_GREEN
                            + myMethod.room1.getItem().getName()
                            + ColorPrint.ANSI_RESET);
                }
                //Robert: Everyone asked for this modification.
            }
        }
        System.out.print(" | [6] Go to the menu");
        System.out.print(" | [7] Open the map");
        System.out.print(" | [0] DEBUG menu\n");



        int choice = menuChoice();

        switch (choice) {
            case 0:
                myMethod.debugMenu();
                break;
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

                play.menuSound();
                if (myMethod.room1.monster != null) {
                    if(myMethod.hero1.getHealth() >= 50 ){
                        myMethod.hero1.setHealth(hero1.getHealth() - (hero1.getHealth() / 2));
                        play.avoidFight();
                        System.out.println("You lost your half health but you avoided the monster");
                        myMethod.room1.setMonster(null);
                        hero1.addHighScore(50);
                    }
                }
                break;
            case 3:
                play.menuSound();
                hero1.viewContentsOfKeyRing();
                if (hero1.weapon != null) hero1.viewConstentofWeaponSlot();
                hero1.viewContentsOfBackpack();
                break;
            case 4:
                play.menuSound();
                if (myMethod.room1.monster == null) {
                    newRoom = myMethod.room1.changeRoom(hero1);
                    System.out.println("You new room is: " + newRoom);
                    myMethod.room1 = myMap.rooms.get(newRoom);
                    myMethod.hero1.addHighScore(100);
                }
                break;
            case 5:
                if (myMethod.room1.getItem() != null) {
                    play.pickUp();
                    if (myMethod.room1.monster == null) {
                        hero1.pickItem(myMethod.room1.getItem(), myMethod.room1);
                        myMethod.room1.setItem(null);
                        hero1.addHighScore(100);
                    }
                }
                break;

            case 6:
                play.menuSound();
                result = false;
                //myMethod.playOptions();
                break;


            case 7:
                play.mapSound();
                DisplayMap.displayMapMenuPrimitiveExit(diffLevel, room1.getPosition()[0],
                        room1.getPosition()[1], myMap);


            default:
                play.menuSound();
                result = true;
                //myMethod.playOptions();
        }
        if (myMethod.hero1.getHealth() < 1) {
            play.playerDeathSound();
            play.loseSound();
            for (int i=0;i<5;i++) {
                ASCII.gameOverLogo();
            }

            playAgain();

            result = false;
        }
        return result;
    } //method gameInterface ends here
    public void playAgain(){
        System.out.println("===========");
        System.out.println("Play again?");
        System.out.println("===========");
        System.out.printf("%n%n%n%n");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
        int playAgain = menuChoice();
        if (playAgain==2){
            System.exit(1);
        }else {
            myMethod.hero1.setHealth(300);
            myMethod.hero1.highscore = 0;
            myMethod.startTime = System.nanoTime();
        }
    }

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
    public void debugMenu(){
        System.out.println("ENTER OPTIONS");
        if (myMethod.room1.monster == null) {
            System.out.println("[1] GENERATE MONSTER");
        }
        System.out.println("[2] ADD ALL KEYS");
        System.out.println("[3] SET HEALTH TO 1");
        System.out.println("[4] SET HEALTH TO 999");
        System.out.println("[5] go back");
        int asdfg = menuChoice();
        switch (asdfg){
            case 1:
                System.out.println("MONSTER GENERATED");
                myMethod.room1.monster = new Monster();
                break;
            case 2:
                Key rusty0=new Key("Rusty key 0");
                Key rusty1=new Key("Rusty key 1");
                Key rusty2=new Key("Rusty key 2");
                rusty0.setType(0);
                rusty1.setType(1);
                rusty2.setType(2);
                rusty0.setActive(true);
                rusty1.setActive(true);
                rusty2.setActive(true);
                myMethod.hero1.addKeyToKeyRing(rusty0);
                myMethod.hero1.addKeyToKeyRing(rusty1);
                myMethod.hero1.addKeyToKeyRing(rusty2);
                System.out.println("KEYS ADDED TO KEYRING !!!");
                break;
            case 3:
                System.out.println("HEALTH SET TO 1 !!!");
                myMethod.hero1.setHealth(1);
                break;
            case 4:
                System.out.println("HEALTH SET TO 999 !!!");
                myMethod.hero1.setHealth(999);
                break;
            case 5:
                break;
                default:
                    System.out.println("USE ONLY AVAILABLE OPTIONS !!!");

        }


    }
   /**switch (choice) {
            case 1:
                myMethod.room1.monster = new Monster();
                break;
            case 2:
                Key rusty0=new Key("Rusty key 0");
                myMethod.hero1.addKeyToKeyRing(rusty0);
                break;
            case 3:

                break;
            case 4:

                break;

        }**/

    public void loadGame() {
        Method.ShowSaves();
        System.out.println("ENTER [0] TO GO BACK TO MENU");
        System.out.print("Choose line number to load: ");
        int chooseSave = menuChoice();

        if (chooseSave != 0) {
            play.menuSound();
            System.out.println("Savegame: " + fileNamesString[chooseSave - 1] + " successfully loaded");
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

    public int menuChoice() {
        in.reset();
        boolean successfulinput = false;
        while (!successfulinput) {
            try {
                gogo = in.nextInt();
                successfulinput = true;
                clearScreen();
            } catch (InputMismatchException a) {
                in.nextLine();
                System.out.println("Please use only given options!");
            }

        }
        return gogo;

    }

    public void pressEnter() {
        String catchEnter;
        System.out.println(ColorPrint.Background_WHITE + "--------------------------------------------------------------------------------------------------------" + ColorPrint.ANSI_RESET);
        System.out.println("                                    Press ENTER to start");
        System.out.println(ColorPrint.Background_WHITE + "--------------------------------------------------------------------------------------------------------" + ColorPrint.ANSI_RESET);
        catchEnter = in.nextLine();
        play.laughSound();

    }

    public void slowPrint(String message, long millisPerChar) {
        for (int i = 0; i < message.length(); i++) {
            play.typeWriter();
            System.out.print(message.charAt(i));

            try {
                Thread.sleep(millisPerChar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String time() {
        long NanoSec = TIME;

        String timeSpent = String.format("%02d:%02d:%02d", TimeUnit.NANOSECONDS.toHours(NanoSec),
                TimeUnit.NANOSECONDS.toMinutes(NanoSec)
                        - TimeUnit.HOURS.toMinutes(TimeUnit.NANOSECONDS.toHours(NanoSec)),
                TimeUnit.NANOSECONDS.toSeconds(NanoSec)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(NanoSec)));
        return timeSpent;
    }

    public void threadSleep(int Milliseconds) {
        try {
            Thread.sleep(Milliseconds);
        } catch (Exception e) {
            System.out.println("wow");
        }
    }

    public static class Sound_methods implements Serializable {
        public static Play_Sound soundFX = new Play_Sound();
        public transient ExecutorService Thread = Executors.newFixedThreadPool(4);
        public transient ExecutorService Threads = Executors.newFixedThreadPool(4);

        public void kickSound() {
            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/kick.wav");
                }
            });
        }

        public void missSound() {
            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/miss.wav");
                }
            });
        }

        public void winSound() {

            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/gameWon.wav");
                }
            });
        }

        public void loseSound() {
            ExecutorService Thread = Executors.newFixedThreadPool(6);
            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/loseGame.wav");
                }
            });
        }

        public void treasureSound() {

            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/treasure.wav");
                }
            });
        }

        public void playerDeathSound() {
            soundFX.playSound("sounds/playerDeath.wav");
        }

        public void monsterDeathSound() {
            ExecutorService Thread = Executors.newFixedThreadPool(6);
            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/monsterDeath.wav");
                }
            });
        }

        public void laughSound() {

            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/laugh.wav");
                }
            });
        }

        public void backpackSound() {

            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/openBackPack.wav");
                }
            });
        }

        public void drinkPotionSound() {

            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/drinkPotion.wav");
                }
            });
        }

        public void dropPotionSound() {

            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/dropItem.wav");
                }
            });
        }

        public void walkSound() {

            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/walking.wav");
                }
            });
            ASCII.walking();
            clearScreen();
        }

        public void menuSound() {

            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/click.wav");
                }
            });
        }

        public void pickUp() {

            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/pickUp.wav");
                }
            });
        }

        public void avoidFight() {

            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/flee.wav");
                }
            });
        }

        public void doorLocked() {

            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/locked.wav");
                }
            });
        }

        public void unlockingDoor() {
            Threads.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/unlocking.wav");
                }
            });
            ASCII.unlocking();
        }

        public void mapSound() {
            Threads.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/map.wav");
                }
            });
        }

        public void typeWriter(){
            Thread.submit(new Runnable() {
                public void run() {
                    soundFX.playSound("sounds/typewriter.wav");
                }
            });
        }

    }
}