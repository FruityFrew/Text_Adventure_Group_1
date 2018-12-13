package Text_Adventure.menuDevelopment;

import java.util.Scanner;
import Text_Adventure.Characters.Character;
import Text_Adventure.Characters.Hero;
import Text_Adventure.Characters.Monster;
import Text_Adventure.Items.Consumable;
import Text_Adventure.Items.Item;
import Text_Adventure.Main;
import Text_Adventure.Map;
import Text_Adventure.Room;
import java.security.SecureRandom;

public class Method  {

    public Scanner in = new Scanner(System.in);
    Room myRoom = new Room(0,5, 0,0);

    
    //Robert: I added this line below me
    SecureRandom random = new SecureRandom();
    public static Method myMethod = new Method();

    //Robert: I will add bit code here
    //================================
    Map myMap;
    Hero hero1 = new Hero(1);
    //================================
    //Robert: You will see bit code as well on the "go to a new room options"
    //I added some imports as well

    /**
     * Alex: this method is used in the beginning of the game
     * method chooseGameLevel
     */
    public void chooseGameLevel() {
        //Robert:I added the line of code below me
        int diffLevel = 5;
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

                //Robert: I will add bit code here
                //================================
                diffLevel = 5;
                //================================
                //Robert: You will see bit code as well on the "go to a new room options"
                //I added some imports as well
                break;
            case 2:
                //Robert: I will add bit code here
                //================================
                diffLevel = 7;
                //================================
                //Robert: You will see bit code as well on the "go to a new room options"
                //I added some imports as well

//               gameLevel = level_normal;
                break;
            case 3:
                //Robert: I will add bit code here
                //================================
                diffLevel = 10;
                //================================
                //Robert: You will see bit code as well on the "go to a new room options"
                //I added some imports as well

//               gameLevel = level_hard;
                break;
            default:
                System.out.println("MAKE A CHOICE BETWEEN 1,2 AND 3!");
        }

        //Robert: I will add bit code here
        //================================
        myMap = new Map(diffLevel);
        //================================
        //Robert: You will see bit code as well on the "go to a new room options"
        //I added some imports as well
    }

    /**
     * Alex: this method is used to get and store the player name in the beginning of the game
     */
    public void playerName() {

        System.out.println("The cellar of the Vicarage of Borgvattnet .." +
                " \nAll over darkness has mastered this lost space, " +
                " \nbetween dimensions, on the border of the living and the dead. \n" +
                "\nThe space that once served life is now home of the monsters.");
        System.out.println("What is your name traveler?");
        Main.playerName= in.nextLine();
    }

    /**
     * Alex: This enum does not need to be used
     *       It was created in the beginning as an item to be used in development
     * enum playerType
     *
     */
    public enum playerType {
        THIEF("thief", 4, 0.5, 5,200), PRIEST("priest", 4, 0.5, 5,200
        ), GHOST_HUNTER("ghost hunter", 4, 0.5, 5,200), TOURIST("tourist", 4, 0.5, 5,200),
        PLAYER("player", 4, 0.5, 5,200);
        private String name;
        private int roomIndex;
        private double hitChance;
        private int maxAttack;
        private int health;



        /**
         * Alex
         * constructor playerType
         * @param name
         * @param roomIndex
         * @param hitChance
         * @param maxAttack
         */
        playerType(String name, int roomIndex, double hitChance, int maxAttack,int health) {
            this.name = name;
            this.roomIndex = roomIndex;
            this.hitChance = hitChance;
            this.maxAttack = maxAttack;
            this.health = health;
        }

        /**
         * Alex: getter for player health
         * @return
         */
        public int getHealth() {
            return health;
        }

         /**
         * Alex: sette for player health
         * @param health
         */
        public void setHealth(int health) {
            this.health = health;
        }
        /**
         * getter playerTypeName
         * @return name
         */
        public String getName() {
            return name;
        }


        /**
         * setter PlayerTypeName
         * @param name
         */
        public void setName(String name) {
            this.name = name;
        }


        /**
         * playerRoomIndex getter
         * @return int
         */
        public int getRoomIndex() {
            return roomIndex;
        }


        /**
         * playerRoomIndex setter
         * @param roomIndex
         */
        public void setRoomIndex(int roomIndex) {
            this.roomIndex = roomIndex;
        }

        /**
         * getter playerHitChance
         * @return double
         */
        public double getHitChance() {
            return hitChance;
        }

        /**
         * getter PlayerMaxAttack
         * @return int
         */
        public int getMaxAttack() {
            return maxAttack;
        }

        /**
         * PlayerMaxAttack setter
         * @param maxAttack
         */
        public void setMaxAttack(int maxAttack) {
            this.maxAttack = maxAttack;
        }

        /**
         *
         * @param hitChance
         */
        public void setHitChance(double hitChance) {
            this.hitChance = hitChance;
        }

        /**
         *
         * @return string
         */
        @Override
        public String toString() {
            return "playerType{}";
        }
    }

    /**
     * Alex
     * method choosePlayerType
     */
    public void choosePlayerType() {

        System.out.println("Hmmm .."+Main.playerName+", a household name, maybe fate brought you back .. or maybe just bad luck");
        System.out.println("What are you in this life .. " +
                "\n[1]\tA THIEF? " +
                "\n[2]\tA lost PRIEST in search of your lost faith?! HA HA HA!" +
                "\n[3]\tA haunted GHOST HUNTER ?" +
                "\n[4]\tOr maybe, just an annoying TOURIST?");
        Main.choice = in.nextInt();

        /**
         * Alex:Sunday the Hero and Character was not functional, so I created this enum for use
         */
        switch (Main.choice) {

            case 1:
                Method.playerType.PLAYER.name = Method.playerType.THIEF.name;
                Method.playerType.PLAYER.hitChance = Method.playerType.THIEF.hitChance;
                Method.playerType.PLAYER.maxAttack = Method.playerType.THIEF.maxAttack;
                Method.playerType.PLAYER.roomIndex = Method.playerType.THIEF.roomIndex;
                Method.playerType.PLAYER.health = Method.playerType.THIEF.health;
                break;
            case 2:
                Method.playerType.PLAYER.name = Method.playerType.PRIEST.name;
                Method.playerType.PLAYER.hitChance = Method.playerType.PRIEST.hitChance;
                Method.playerType.PLAYER.maxAttack = Method.playerType.PRIEST.maxAttack;
                Method.playerType.PLAYER.roomIndex = Method.playerType.PRIEST.roomIndex;
                Method.playerType.PLAYER.health = Method.playerType.PRIEST.health;
            break;
            case 3:
                Method.playerType.PLAYER.name = Method.playerType.GHOST_HUNTER.name;
                Method.playerType.PLAYER.hitChance = Method.playerType.GHOST_HUNTER.hitChance;
                Method.playerType.PLAYER.maxAttack = Method.playerType.GHOST_HUNTER.maxAttack;
                Method.playerType.PLAYER.roomIndex = Method.playerType.GHOST_HUNTER.roomIndex;
                Method.playerType.PLAYER.health = Method.playerType.GHOST_HUNTER.health;
                break;
            case 4:
                Method.playerType.PLAYER.name = Method.playerType.TOURIST.name;
                Method.playerType.PLAYER.hitChance = Method.playerType.TOURIST.hitChance;
                Method.playerType.PLAYER.maxAttack = Method.playerType.TOURIST.maxAttack;
                Method.playerType.PLAYER.roomIndex = Method.playerType.TOURIST.roomIndex;
                Method.playerType.PLAYER.health = Method.playerType.TOURIST.health;
                break;
            default:
                System.out.println("You just started playing and already shaking your hand!" +
                        "\n\t MAKE A CHOICE BETWEEN 1,2,3 AND 4!");
        }
        System.out.println("OK... lets see how much a " + Method.playerType.PLAYER.getName() + " worth!");
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
        System.out.println("EXIT the game?" +
                "\n[1]\tYES" +
                "\n[2]\tNO, go back to menu");
        Main.choice = Main.in.nextInt();
        switch (Main.choice) {
            case 1:
                Main.choice =10;
                break;
            case 2:
                myMethod.gameOptions();
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
        System.out.println("\n\n*        *****         *\n\n[1]\tContinue\n[2]\tExit\n\n*         *****       *\n\n");
        Main.choice= Main.in.nextInt();
        switch(Main.choice){
            case 1:
                break;
            case 2:
                Main.choice=10;
                break;
            default:
                System.out.println("Your fingers are shaking again?" +
                        "\nChose right!\n");
        }
    }

    /**
     * Alex: Inside this method the game is happening
     * method playGame
     * @param gameOption
     */
    public void playGame(int gameOption) {
        //Robert: I will add bit code here
        //================================
        Room room1 = myMap.rooms.get(0);//Alex: This should be in main when starting the game ?
        int newRoom = 0;//Alex: This should be in main when starting the game ?
        //================================
        //Robert: You will see bit code as well on the "go to a new room options"
        //I added some imports as well

        System.out.println("\nEven if nothing welcoming in the cellar,.. \n\n\t****    WELCOME!    ****" +
                "\n\nAnytime you want to see your options\n\t\t<< ENTER [10] >>\n\n");
        System.out.println("\n\tHealth = "+ Main.playerHealth+".\n" +
                "--------------------------------------------\n");
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
                    Main.nbrDoors=3;//example  Main.nbrDoors=myRoom.numberOfDoors(myRoom.describeRoom)
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
                            in.nextLine();
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
                            in.nextLine();
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
                                    newRoom = room1.changeRoom();
                                    room1 = myMap.rooms.get(newRoom);

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

    // Ahmed: Fight system that uses already exisisting damage generator in Character-class
    public void exchangeAttackWithMonster(Hero hero, Character monster) {
        //First hero attacks
        int damageHolder = Character.generateDamage(hero.getHitChance(), hero.getMaxAttack());
        monster.setHealth(monster.getHealth() - damageHolder);
        System.out.printf("You hit monster and monster looses %d health points.%n" +
                "Monster's health (updated): %d%n", damageHolder, monster.getHealth());

        //Then monster attacks...
        damageHolder = Character.generateDamage(monster.getHitChance(), monster.getMaxAttack());
        hero.setHealth(hero.getHealth() - damageHolder);
        System.out.printf("Monster hits you back and you loose %d health points.%n" +
                "Your current health: %d%n", damageHolder, hero.getHealth());
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
