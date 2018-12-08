package Text_Adventure;

import Text_Adventure.Characters.Monster;
import Text_Adventure.Items.Item;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * @author Robert Alm RobertKristianAlm@gmail.com
 */
public class Room {
    SecureRandom random = new SecureRandom();
    private int[] position =  new int[2];
    //private ArrayList<Door> doors = new ArrayList<>();
    private int[] doorPosition = new int[4];
    private int N;
    private int E;
    private int S;
    private int W;
    private Item item;
    private Monster monster;
    private int spawnMonsterRate = 25;
    private int spawnItemRate = 75;
    private int index; //this is the way to reffer to the room, (the position does not works. this is not DataBase :) )

    /**
     * Robert: This is the constructor for Room objects
     *
     * @param {int}     position[]      - int[]: The actual position of the room.
     * @param {boolean} doorPosition[] - boolean[]: The postion of the doors inside the room,( N, E, S, W).
     */
    public Room(int index, int x, int y) {
        this.index = index;
        this.position[0] = x;
        this.position[1] = y;
        this.N = random.nextInt(2);
        this.E = random.nextInt(2);
        this.S = random.nextInt(2);
        this.W = random.nextInt(2);
        int n = random.nextInt(100);
        if (n < spawnMonsterRate){
            this.monster = new Monster();
        }
        else {
            this.monster = null;
        }
        if (n < spawnItemRate){
            this.item = new Item("Generic Item");
        }
        else {
            this.item = null;
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
        System.out.println("The walls are looking like walls right now.");
    }

    /**
     * Robert: This is the method that describes the doors of the room
     *
     * @param {boolean} - The postion of the doors inside the room,( N, E, S, W).
     */
    public void describeDoors(int N, int E, int S, int W) {
        System.out.println("you are looking out to find out how many doors they are...");
        if (N==1) {
            System.out.println("One door stands on the North side of the room");
        }
        if (E==1) {
            System.out.println("you can see one door on the East side of the room");
        }
        if (N==1) {
            System.out.println("It seems that there is a room on the South side of the room");
        }
        if (N==1) {
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
}
