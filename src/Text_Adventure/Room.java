package Text_Adventure;

import Text_Adventure.Characters.Hero;
import Text_Adventure.Characters.Monster;
import Text_Adventure.Items.Consumable;
import Text_Adventure.Items.Item;
import Text_Adventure.Items.Key;
import Text_Adventure.Items.Weapon;
import Text_Adventure.menuDevelopment.ColorPrint;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Robert Alm RobertKristianAlm@gmail.com
 */
public class Room implements Serializable {
    transient Scanner in = new Scanner(System.in);
    SecureRandom random = new SecureRandom();
    private int[] position =  new int[2];
    public ArrayList<Door> doors = new ArrayList<>();
    private int[] doorPosition = new int[4];
    private int N;
    private int E;
    private int S;
    private int W;
    private Item item;
    public Monster monster;
    private String wall;
    private int spawnMonsterRate = 25;
    private int spawnItemRate = 90;
    private int index; //this is the way to reffer to the room, (the position does not works. this is not DataBase :) )
    private int dLevel; //Difficulty level. This takes the difficulty level of the Map object for practical reasons.
    private boolean exit = false; //this indicates if the room has a trap door exit or not.

    /**
     * Robert: This is the constructor for Room objects
     *
     * @param {int}     position[]      - int[]: The actual position of the room.
     * @param {boolean} doorPosition[] - boolean[]: The postion of the doors inside the room,( N, E, S, W).
     */
    public Room(int index, int level, int x, int y) {
        this.index = index;
        this.dLevel = level;
        this.position[0] = x;
        this.position[1] = y;
        while ((N < 1)&&(E < 1)&&(S < 1)&&(W < 1)){
            if(dCheckNorth(x, y, level)){ this.N = random.nextInt(10); }
            if(dCheckEast(x, y, level)){ this.E = random.nextInt(10); }
            if(dCheckSouth(x, y, level)){ this.S = random.nextInt(10); }
            if(dCheckWest(x, y, level)){ this.W = random.nextInt(10); }
        }
        int n = random.nextInt(100);
        if (n < spawnMonsterRate){
            this.monster = new Monster();
        }
        else {
            this.monster = null;
        }
        n = random.nextInt(100);
        if (n < spawnItemRate){
            n = random.nextInt(100);
            if (n > 50){
                this.item = new Key("Rusty key");
            } else {
                n = random.nextInt(100);
                if (n > 25){
                    this.item = getRandomDrink();
                } else {
                    this.item = getRandomWeapon();
                }
            }
        }
        else {
            this.item = null;
        }
        generateDoors(x, y, level, N, E, S, W);
        generateWalls();
        int exitFactor = random.nextInt(level * level);
        if (exitFactor >= ((level * level) - 5)){ //it gives more than one exit, for reasons of safety
            exit = true;
        }
    }

    /**
     * Robert: This is the constructor for Room objects
     * <p>
     * Selfgenerated boolean[]: The postion of the doors inside the room,( N, E, S, W).
     *
     * @param {int} position[]      - int[]: The actual position of the room.
     */
    public Room(int index, int x, int y, int N, int E, int S, int W) {
        this.index = index;
        this.position[0] = x;
        this.position[1] = y;
        this.N = N;
        this.E = E;
        this.S = S;
        this.W = W;
    }

    /**
     * Robert: This is the constructor for Room objects
     * <p>
     * Selfgenerated boolean[]: The postion of the doors inside the room,( N, E, S, W).
     *
     * @param {int} position[]      - int[]: The actual position of the room.
     * @param item  - Item: The item that can be found inside the room.
     */
    public Room(int index, int x, int y, Item item) {
        this.index = index;
        this.position[0] = x;
        this.position[1] = y;
        this.item = item;
        this.N = random.nextInt(2);
        this.E = random.nextInt(2);
        this.S = random.nextInt(2);
        this.W = random.nextInt(2);
    }

    /**
     * Robert: This is the constructor for Room objects
     * <p>
     * Selfgenerated boolean[]: The postion of the doors inside the room,( N, E, S, W).
     *
     * @param {int}   position[]      - int[]: The actual position of the room.
     * @param monster - Monster: The monster that can be found inside the room.
     */
    public Room(int index, int x, int y, Monster monster) {
        this.index = index;
        this.position[0] = x;
        this.position[1] = y;
        this.monster = monster;
        this.N = random.nextInt(2);
        this.E = random.nextInt(2);
        this.S = random.nextInt(2);
        this.W = random.nextInt(2);
    }

    /**
     * Robert: This is the constructor for Room objects
     * <p>
     * Selfgenerated boolean[]: The postion of the doors inside the room,( N, E, S, W).
     *
     * @param {int}   position[]      - int[]: The actual position of the room.
     * @param item    - Item: The item that can be found inside the room.
     * @param monster - Monster: The monster that can be found inside the room.
     */
    public Room(int index, int x, int y, Item item, Monster monster) {
        this.index = index;
        this.position[0] = x;
        this.position[1] = y;
        this.item = item;
        this.monster = monster;
        this.N = random.nextInt(2);
        this.E = random.nextInt(2);
        this.S = random.nextInt(2);
        this.W = random.nextInt(2);
    }

    /**
     * Robert: This is the constructor for Room objects
     *
     * @param {int}   position[]      - int[]: The actual position of the room.
     * @param item    - Item: The item that can be found inside the room.
     * @param monster - Monster: The monster that can be found inside the room.
     */
    public Room(int index, int x, int y, Monster monster, Item item) {
        this.index = index;
        this.position[0] = x;
        this.position[1] = y;
        this.monster = monster;
        this.item = item;
    }

    /**
     * Robert: This is the constructor for Room objects
     * <p>
     * Selfgenerated boolean[]: The postion of the doors inside the room,( N, E, S, W).
     *
     * @param {int}   position[]      - int[]: The actual position of the room.
     * @param item    - Item: The item that can be found inside the room.
     * @param monster - Monster: The monster that can be found inside the room.
     */
    public Room(int index, int x, int y, int N, int E, int S, int W, Monster monster, Item item) {
        this.index = index;
        this.position[0] = x;
        this.position[1] = y;
        this.N = N;
        this.E = E;
        this.S = S;
        this.W = W;
        this.monster = monster;
        this.item = item;
    }

    /**
     * Robert: This is the method that describes that prints the description of the room
     */
    public void describeRoom() {
        //System.out.println("You are in the room: " + getIndex());
        System.out.println("you are looking around carefully...");
        if(exit == false){if (item == null){describeWalls();}}
        if (item != null){describeItem();}
        System.out.println(" ");
        describeDoors(N, E, S, W);
        if (exit){
            System.out.println(" ");
            System.out.println("You are looking up. There is a trap door.");
            System.out.println("it seems to lead outside. However is locked with 3 different locks");
            System.out.println("The first lockpad writes the number 0 on it");
            System.out.println("The second lockpad writes the number 1 on it");
            System.out.println("The first lockpad writes the number 2 on it");
            System.out.println("It seems that it needs 3 different keys to open...");
        }
    }

    /**
     * Robert: This is the method that prints the description of the room
     */
    public void describeWalls() {
        System.out.println(this.wall);
        int n = random.nextInt(100);
        if (n <= 25){
            System.out.println("What even possible can go wrong?");
        }else if (n <= 50){
            System.out.println("This is definitely the best place to be.");
        }else if (n <= 75){
            System.out.println("This place seems safe enough.");
        } else {
            System.out.println("At least it is quiet here.");
        }
    }

    /**
     * Robert: This is the method that describes the doors of the room
     *
     * @param {boolean} - The postion of the doors inside the room,( N, E, S, W).
     */
    public void describeDoors(int N, int E, int S, int W) {
        System.out.println("Doors in this room:");
        if (N!=0) {
            System.out.print("| North |");
        }
        if (E!=0) {
            System.out.print("| East |");
        }
        if (S!=0) {
            System.out.print("| South |");
        }
        if (W>=1) {
            System.out.print("| West |");
        }
        System.out.println(" ");
    }

    /**
     * Robert: This is the method that describes the item in the room
     */
    public void describeItem() {
        System.out.println("Item on the ground: ");
        if (this.item != null) {
            //System.out.println("In the corner seems to be an item,");
            if (this.item instanceof Key ){
                System.out.println("It is a "  + ((Key) this.item).getName2() + "!");
            } else {
                System.out.println("It is a " + ColorPrint.ANSI_BLUE + this.item.getName()
                        +ColorPrint.ANSI_RESET+ "!");
            }
        } else {
            System.out.println("you didn't found something useful.");
        }
    }

    /**
     * Robert: This is the method that describes the monster in the room.
     */
    public void describeMonster() {
        System.out.println("Monster in the room:");
        if (this.monster != null) {
            //System.out.println("In the shadows you see a figure.");
            System.out.println("It is: " +ColorPrint.ANSI_RED+ monster.getMonsterType()
                    +ColorPrint.ANSI_RESET);
        } else {
            System.out.println("No one. Probably just the wind");
        }
    }

    /**
     * Robert: This is the method that is setting the position of the room.
     * I will probably change it with a more easy to use method.
     *
     * @param {int} position[]      - int[]: The actual position of the room.
     */
    public void setPosition(int[] position) {
        this.position = position;
    }

    /**
     * Robert: This is the method that is getting the position of the room.
     *
     * @return {int[]} position
     */
    public int[] getPosition() {
        return position;
    }

    /**
     * Robert: This is the method that is setting the position of the doors int the room.
     * I will probably change it with a more easy to use method.
     *
     * @param {boolean} doorPosition[] - boolean[]: The postion of the doors inside the room,( N, E, S, W).
     */
    public void setDoorPosition(int[] doorPosition) {
        this.doorPosition = doorPosition;
    }

    /**
     * Robert: This is the method that is getting the position of the doors of that room.
     *
     * @return {int[]} doorPosition
     */
    public int[] getDoorPosition() {
        return doorPosition;
    }

    /**
     * Robert: This is the method that is setting the item of the room.
     *
     * @param item - Item: The item that can be found inside the room.
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Robert: This is the method that is getting the item that can be found in the room.
     *
     * @return Item - The item that can be found inside the room.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Robert: This is the method that is setting the monster of the room.
     *
     * @param monster - Monster: The monster that can be found inside the room.
     */
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    /**
     * Robert: This is the method that is getting the monster that can be found in the room.
     *
     * @return Monster - The monster that can be found inside the room.
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * Robert: This is the method that is setting the item's spawnrate of the room.
     *
     * @param spawnItemRate - int: The spawnrate of the item that can be found inside the room.
     */
    public void setSpawnItemRate(int spawnItemRate) {
        this.spawnItemRate = spawnItemRate;
    }

    /**
     * Robert: This is the method that is getting the spawnrate of the item that can be found inside the room.
     *
     * @return int - The spawnrate of the item that can be found inside the room.
     */
    public int getSpawnItemRate() {
        return spawnItemRate;
    }

    /**
     * Robert: This is the method that is setting the monster's spawnrate of the room.
     *
     * @param spawnMonsterRate - int: The spawnrate of the monster that can be found inside the room.
     */
    public void setSpawnMonsterRate(int spawnMonsterRate) {
        this.spawnMonsterRate = spawnMonsterRate;
    }

    /**
     * Robert: This is the method that is getting the monster's spawnrate of the room.
     *
     * @return int - spawnMonsterRate - he spawnrate of the monster that can be found inside the room.
     */
    public int getSpawnMonsterRate() {
        return spawnMonsterRate;
    }

    /**
     * Robert: This is the method that is sets the index of the room.
     *
     * @param index - int: The index of the room. Is used for refering to the room.
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Robert: This is the method that returns the index of the room.
     *
     * @return int index - int: The index of the room. Is used for refering to the room.
     */
    public int getIndex() {
        return index;
    }


    public int getN() {
        return N;
    }

    public int getE() {
        return E;
    }

    public int getS() {
        return S;
    }

    public int getW() {
        return W;
    }

    public boolean isExit() {
        return exit;
    }

    //Robert: This method wes made by Nemo
    public Consumable getRandomDrink() {
        Consumable coffee = new Consumable("Coffee", 50);
        Consumable whiskey = new Consumable("Whiskey", 30);
        Consumable magic = new Consumable("Magic potion", 80);
        Consumable[] consumables = {coffee, whiskey, magic};
        Random rand = new Random();

        int i = rand.nextInt(3);
        Consumable randomDrink = consumables[i];

        return randomDrink;
    }

    //Robert: This method is a copycat of Nemo's method getRandomDrink()
    public Weapon getRandomWeapon() {
        Weapon cross = new Weapon("Cross", 50);
        Weapon knife = new Weapon("Knife", 100);
        Weapon rose = new Weapon("Rose", 25);
        Weapon shotgun = new Weapon("Shotgun", 200);
        Weapon[] weapons = {cross, knife, rose, shotgun};
        Random rand = new Random();

        int i = rand.nextInt(4);
        Weapon randomWeapon = weapons[i];

        return randomWeapon;
    }

    public boolean doorToFreedom(Hero hero){
        boolean result = false;
        boolean lock0 = false;
        boolean lock1 = false;
        boolean lock2 = false;
        for (Key key:hero.keyRing){
            if ((key.getType()== 0)){
                lock0 = true;
            }
            if ((key.getType()== 1)){
                lock1 = true;
            }
            if ((key.getType()== 2)){
                lock2 = true;
            }
        }
        if(lock0){
            System.out.println("You succeded to unlock the lockpad with the number 0");
        }

        if(lock1){
            System.out.println("You succeded to unlock the lockpad with the number 1");
        }

        if(lock2){
            System.out.println("You succeded to unlock the lockpad with the number 2");
        }

        if (lock0 && lock1 && lock2){
            System.out.println("You unlocked all the lockpads");
            result = true;
            System.out.println("You won the game");
        }
        return result;
    }

    public int changeRoom(Hero hero){
        Scanner in = new Scanner(System.in); //I added this line to overcome the conflict between
        // scanner and Serializable
        boolean running = true;
        int x = this.position[0];
        int y = this.position[1];
        int N = this.N;
        int E = this.E;
        int S = this.S;
        int W = this.W;
        int index = 0;
        while(running){
            System.out.println(" ");
            System.out.println("Changing room");
            System.out.println("-------------");
            if (N!=0) {
                System.out.println("Type 1 to use the North door");
            }
            if (E!=0) {
                System.out.println("Type 2 to use the East door");
            }
            if (S!=0) {
                System.out.println("Type 3 to use the South door");
            }
            if (W>=1) {
                System.out.println("Type 4 to use the West door");
            }
            if (exit == true) {
                System.out.println("Type 5 to try to use the trap door and escape");
            }
            System.out.println("Type 6 to stay at the same room");

            String choice1 = in.next();// the selected door will move the hero in the correct room


            switch(choice1){
                case "1":
                    if (doors.get(0).isActive()){
                        if (doors.get(0).isLocked()){
                            System.out.println("The door is locked and it is written on the lock the " +
                                    "number " + doors.get(0).getType());
                            System.out.println("You are looking on your keys to finding a suitable key");
                            for (Key key:hero.keyRing){
                                if (doors.get(0).getType() == key.getType()){
                                    doors.get(0).setLocked(false);
                                    System.out.println("You found a suitable key!");
                                    System.out.println("You are unlocking the door...");
                                    hero.addHighScore(100);
                                    break;
                                }
                            }
                        } else {
                            index = doors.get(0).getRoom();
                            running = false;
                        }
                    }

                    break;
                case "2":
                    if (doors.get(1).isActive()){
                        if (doors.get(1).isLocked()){
                            System.out.println("The door is locked and it is written on the lock the " +
                                    "number " + doors.get(1).getType());
                            System.out.println("You are looking on your keys to finding a suitable key");
                            for (Key key:hero.keyRing){
                                if (doors.get(1).getType() == key.getType()){
                                    doors.get(1).setLocked(false);
                                    System.out.println("You found a suitable key!");
                                    System.out.println("You are unlocking the door...");
                                    hero.addHighScore(100);
                                    break;
                                }
                            }
                        } else {
                            index = doors.get(1).getRoom();
                            running = false;
                        }
                    }

                    break;
                case "3":
                    if (doors.get(2).isActive()){
                        if (doors.get(2).isLocked()){
                            System.out.println("The door is locked and it is written on the lock the " +
                                    "number " + doors.get(2).getType());
                            System.out.println("You are looking on your keys to finding a suitable key");
                            for (Key key:hero.keyRing){
                                if (doors.get(2).getType() == key.getType()){
                                    doors.get(2).setLocked(false);
                                    System.out.println("You found a suitable key!");
                                    System.out.println("You are unlocking the door...");
                                    hero.addHighScore(100);
                                    break;
                                }
                            }
                        } else {
                            index = doors.get(2).getRoom();
                            running = false;
                        }
                    }

                    break;
                case "4":
                    if (doors.get(3).isActive()){
                        if (doors.get(3).isLocked()){
                            System.out.println("The door is locked and it is written on the lock the " +
                                    "number " + doors.get(3).getType());
                            System.out.println("You are looking on your keys to finding a suitable key");
                            for (Key key:hero.keyRing){
                                if (doors.get(3).getType() == key.getType()){
                                    doors.get(3).setLocked(false);
                                    System.out.println("You found a suitable key!");
                                    System.out.println("You are unlocking the door...");
                                    hero.addHighScore(100);
                                    break;
                                }
                            }
                        } else {
                            index = doors.get(3).getRoom();
                            running = false;
                        }
                    }

                    break;

                case "5":
                    if (doorToFreedom(hero) == true){
                        hero.addHighScore(1500);
                        System.out.println(" ");
                        System.out.println(" =============== ");
                        System.out.println("You won the game!");
                        System.out.println("You can stay around if you wish but you beat up the game" +
                                "and you can leave whenever you wish");
                        System.out.println("Thank you for playing");
                        System.out.println(" =============== ");
                        System.out.println(" ");
                    }
                    break;
                default:
                    index = positionToIndex(x,y);
                    running = false;
            }


        }
        return index;
    }

    public void generateDoors(int x, int y, int level, int N, int E, int S, int W){
        if (N!=0) {
            Door a = new Door(true, moveNorth(x,y,level));
            doors.add(0, a);
        } else {
            Door a = new Door(false, positionToIndex(x,y));
            doors.add(0, a);
        }

        if (E!=0) {
            Door a = new Door(true, moveEast(x,y,level));
            doors.add(1, a);
        }else {
            Door a = new Door(false, positionToIndex(x,y));
            doors.add(1, a);
        }

        if (S!=0) {
            Door a = new Door(true,moveSouth(x,y,level));
            doors.add(2, a);
        }else {
            Door a = new Door(false, positionToIndex(x,y));
            doors.add(2, a);
        }

        if (W>=1) {
            Door a = new Door(true,moveWest(x,y,level));
            doors.add(3, a);
        }else {
            Door a = new Door(false, positionToIndex(x,y));
            doors.add(3, a);
        }
    }

    public void generateWalls(){
        int n = random.nextInt(100);
        if (n <= 25){
            this.wall = "The walls are made by gray stone, and they look old.";
        }else if (n <= 50){
            this.wall = "The walls are seem to be decorated by human skulls.";
        }else if (n <= 75){
            this.wall = "The walls have shelves with old books and idols of Cthulu.";
        } else {
            this.wall = "The walls are looking dirty and smelly.";
        }
    }

    //for testing purposes. it works
    public void printDoors(){
        for (Door x:doors){
            System.out.println(x.getRoom());
        }
    }

    public boolean dCheckNorth(int x, int y, int level){
        int a = y + 1;
        if ((a >= 0) && (a < level)){
            return true;
        } else {
            return false;
        }
    }

    public boolean dCheckSouth(int x, int y, int level){
        int a = y - 1;
        if ((a >= 0) && (a < level)){
            return true;
        } else {
            return false;
        }
    }

    public boolean dCheckEast(int x, int y, int level){
        int a = x + 1;
        if ((a >= 0) && (a < level)){
            return true;
        } else {
            return false;
        }
    }

    public boolean dCheckWest(int x, int y, int level){
        int a = x - 1;
        if ((a >= 0) && (a < level)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Robert: this method helps to generate an index number from position
     *
     * @param x - An integer that gives the orizontal position. it does get multiplied by 10
     * @param y - An integer that gives the orizontal position. it doesn't get multiplied
     * @return - it returns the index of a room. index is useful in order to reffer to a room.
     */
    public int positionToIndex(int x, int y){
        return y + (x * 10);
    } //it works

    public int xFromIndex(int index){
        return index / 10;
    } // it works

    public int yFromIndex(int index){
        return index - ((index / 10) * 10);//Robert: it works
    }

 //   public int yFromIndex(int index){ return index%10; //Alex: I apologize Robert for making this change. your formula is always 0.
  //              index - ((index / 10) * 10);//Robert: it works
  //  }


    public int moveNorth(int x, int y, int level){
        if (dCheckNorth(x,y,level)){
            y = y + 1;
        }
        return positionToIndex(x,y);
    }

    public int moveSouth(int x, int y, int level){
        if (dCheckSouth(x,y,level)){
            y = y - 1;
        }
        return positionToIndex(x,y);
    }

    public int moveEast(int x, int y, int level){
        if (dCheckEast(x,y,level)){
            x = x + 1;
        }
        return positionToIndex(x,y);
    }

    public int moveWest(int x, int y, int level){
        if (dCheckWest(x,y,level)){
            x = x - 1;
        }
        return positionToIndex(x,y);
    }
}
