package Text_Adventure;

import Text_Adventure.Characters.Monster;
import Text_Adventure.Items.Consumable;
import Text_Adventure.Items.Item;
import Text_Adventure.Items.Key;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Robert Alm RobertKristianAlm@gmail.com
 */
public class Room {
    Scanner in = new Scanner(System.in);
    SecureRandom random = new SecureRandom();
    private int[] position =  new int[2];
    public ArrayList<Door> doors = new ArrayList<>();
    private int[] doorPosition = new int[4];
    private int N;
    private int E;
    private int S;
    private int W;
    private Item item;
    private Monster monster;
    private String wall;
    private int spawnMonsterRate = 25;
    private int spawnItemRate = 75;
    private int index; //this is the way to reffer to the room, (the position does not works. this is not DataBase :) )
    private int dLevel; //Difficulty level. This takes the difficulty level of the Map object for practical reasons.

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
            if(dCheckNorth(x, y, level)){ this.N = random.nextInt(5); }
            if(dCheckEast(x, y, level)){ this.E = random.nextInt(5); }
            if(dCheckSouth(x, y, level)){ this.S = random.nextInt(5); }
            if(dCheckWest(x, y, level)){ this.W = random.nextInt(5); }
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
            if (n >= 75){
                this.item = new Key("Rusty key");
            } else {
                this.item = getRandomDrink();
            }
        }
        else {
            this.item = null;
        }
        generateDoors(x, y, level, N, E, S, W);
        generateWalls();
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
        System.out.println("You are in the room: " + getIndex());
        System.out.println("You entering the room as you are looking around carefully...");
        describeWalls();
        describeDoors(N, E, S, W);
        describeItem();
        describeMonster();
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
        System.out.println("you are looking out to find out how many doors they are...");
        if (N!=0) {
            System.out.println("One door stands on the North side of the room");
        }
        if (E!=0) {
            System.out.println("You can see one door on the East side of the room");
        }
        if (S!=0) {
            System.out.println("It seems that there is a room on the South side of the room");
        }
        if (W>=1) {
            System.out.println("and one door stands on the West side of the room as well");
        }
    }

    /**
     * Robert: This is the method that describes the item in the room
     */
    public void describeItem() {
        System.out.println("You are looking for items...");
        if (this.item != null) {
            System.out.println("In the corner seems to be an item,");
            System.out.println("It is a " + this.item.getName() + "!");
        } else {
            System.out.println("you didn't found something useful.");
        }
    }

    /**
     * Robert: This is the method that describes the monster in the room.
     */
    public void describeMonster() {
        System.out.println("You are checking if someone is in the room...");
        if (this.monster != null) {
            System.out.println("In the shadows you see a figure.");
            System.out.println("Oh no! It is a Monster!");
            //System.out.println("Oh no! It is a " + this.monster.getType() + "!");
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

    public int changeRoom(){
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
            System.out.println("Type 5 to stay at the same room");

            String choice1 = in.next();// the selected door will move the hero in the correct room


            switch(choice1){
                case "1":
                    if (doors.get(0).isActive()){
                        if (doors.get(0).isLocked()){
                            System.out.println("The door is locked and it is written on the lock the " +
                                    "number " + doors.get(0).getType());
                            System.out.println("I will unlock the door for you");
                            doors.get(0).setLocked(false);
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
                            System.out.println("I will unlock the door for you");
                            doors.get(1).setLocked(false);
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
                            System.out.println("I will unlock the door for you");
                            doors.get(2).setLocked(false);
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
                            System.out.println("I will unlock the door for you");
                            doors.get(3).setLocked(false);
                        } else {
                            index = doors.get(3).getRoom();
                            running = false;
                        }
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
