package Text_Adventure.menuDevelopment;

import Text_Adventure.Characters.Monster;
import Text_Adventure.Items.Item;
import Text_Adventure.Main;
import Text_Adventure.Room;

public class Method {
    public static Method myMethod = new Method();

    /**
     * method chooseGameLevel
     */
    public void chooseGameLevel() {
        System.out.println("\nNow give me your hand to tell your options! " +
                "\n\tYou have three lines ... " +
                "\n\ta short one (press 1) " +
                "\n\tintersected with another, longer (press2)" +
                "\n\tAnd a last one, HA HA HA! This will hurt! (press 3) ");
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
     * method gameOption
     * @return int
     */
    public int gameOptions() {
        System.out.println("\t*** GAME OPTIONS ***" +
                "\n1]\tStart Game\n2]\tSave\n3]\tLoad Game\n4]\tExit");
        int gameOption = Main.in.nextInt();
        return gameOption;
    }
    public int exitOptions(){
        System.out.println("Go to the game options?" +
                "\n1]\tYES" +
                "\n2]\tContinue to play");
        Main.choice = Main.in.nextInt();
        switch (Main.choice) {
            case 1:
                Main.choice= 10;
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
     * method playOption
     * used during the player session
     */
    public void playOptions(){
        System.out.println("\n1]\tContinue\n2]\tExit");
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
     * method playGame
     * @param gameOption
     */
    public void playGame(int gameOption) {
        Menu myMenu = new Menu();

        System.out.println("Even is nothing welcoming in the cellar,.. \n\t****    WELCOME!    ****" +
                "\n\nAnytime you want to see your options\n\t\t<< ENTER 10 >>\n");
        switch (gameOption) {
            case 1: // START GAME
                do {

                    System.out.println("\n\n\tWalk carefully in your first room\n\nHm... in this room you have +INVENTORY(monster, item, door(s))");

                    //Robert: I will add bit code here
                    //================================
                    Monster monster = new Monster();
                    Item item1 = new Item("irish coffee");
                    Room room1 = new Room(1,1, monster, item1);
                    room1.describeRoom();
                    //================================
                    //Robert: You will see bit code as well on the "go to a new room options"
                    //I added some imports as well

                    int room = 3; // room will be an object with attributes
                    // room value will be from 1 to 4

                    switch (room) { //room = door(s)
                        case 1:  // room = door(s)
                            System.out.println(" \t***    Choose door    ***" +
                                    "\n1]\tNorth door" +//if the north door exists
                                    "\n2]\tSouth door" +//if the south door exists
                                    "\n3]\tWest door" +// if the west door exists
                                    "\n4]\tEast door");// if the est door exists
                            Main.choice = Main.in.nextInt();     // the selected door will move the hero in the correct room
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
                                    "\n1]\tFight +MONSTER_TYPE" +
                                    "\n2]\tAvoid fight" +
                                    "\n3]\tChange weapon" +
                                    "\n4]\tGo to a new room");
                            Main.choice = Main.in.nextInt();
                            switch (Main.choice) {
                                case 1:
                                    System.out.println("The fightMonster method will be called");
                                    break;
                                case 2:
                                    System.out.println("The hero will lose health");
                                    break;
                                case 3:
                                    System.out.println("The inventory of the backpack will be shown" +
                                            "\nThe h=method change item will be called");
                                    break;
                                case 4:
                                    System.out.println("the method changeRoom will be called");
                                    break;
                                default:
                                    myMethod.playOptions();
                            }

                            break;
                        case 3:  // room = door(s), monster, item
                            System.out.println("\t***    Choose action   ***" +
                                    "\n1]\tFight +MONSTER_TYPE" +
                                    "\n2]\tAvoid fight" +
                                    "\n3]\tChange weapon" +
                                    "\n4]\tGo to a new room" +
                                    "\n5]\tPick +ITEM");
                            Main.choice = Main.in.nextInt();
                            switch (Main.choice) {
                                case 1:
                                    System.out.println("The fightMonster method will be called");
                                    break;
                                case 2:
                                    System.out.println("The hero will lose health");
                                    break;
                                case 3:
                                    System.out.println("The inventory of the backpack will be shown" +
                                            "\nThe h=method change item will be called");
                                    break;
                                case 4:

                                    //System.out.println("the method changeRoom will be called");
                                    //Robert: I will add bit code here and I commented out a line of code
                                    //================================
                                    Monster monster2 = new Monster();
                                    Item item2 = new Item("french coffee");
                                    Room room2 = new Room(1,1, monster, item2);
                                    room2.describeRoom();
                                    //================================
                                    //Robert: You will see bit code as well on the beginning of this function"
                                    //I added some imports as well

                                    break;
                                case 5:
                                    System.out.println("The method pickItem will be called");
                                    break;
                                default:
                                    myMethod.playOptions();
                            }
                            break;
                        case 4: // room = item , door(s)
                            System.out.println("\t***    Choose action   ***" +
                                    "\n1]\tPick +ITEM" +
                                    "\n2]\tGo to a new room");
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
                                    "\n1]\tYES" +
                                    "\n2]\tContinue to play");
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
}
