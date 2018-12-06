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
    private int[] position = new int[2];
    //private ArrayList<Door> doors = new ArrayList<>();
    private boolean[] doorPosition = new boolean[4];
    private Item item;
    private Monster monster;
    private int spawnMonsterRate = 100;
    private int spawnItemRate = 100;

    /**
     * Robert: This is the constructor for Room objects
     *
     * @param {int}     position[]      - int[]: The actual position of the room.
     * @param {boolean} doorPosition[] - boolean[]: The postion of the doors inside the room,( N, E, S, W).
     */
    public Room(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
        this.doorPosition[0] = random.nextBoolean();
        this.doorPosition[1] = random.nextBoolean();
        this.doorPosition[2] = random.nextBoolean();
        this.doorPosition[3] = random.nextBoolean();
    }

    /**
     * Robert: This is the constructor for Room objects
     * <p>
     * Selfgenerated boolean[]: The postion of the doors inside the room,( N, E, S, W).
     *
     * @param {int} position[]      - int[]: The actual position of the room.
     */
    public Room(int x, int y, boolean N, boolean E, boolean S, boolean W) {
        this.position[0] = x;
        this.position[1] = y;
        this.doorPosition[0] = N;
        this.doorPosition[1] = E;
        this.doorPosition[2] = S;
        this.doorPosition[3] = W;
    }

    /**
     * Robert: This is the constructor for Room objects
     * <p>
     * Selfgenerated boolean[]: The postion of the doors inside the room,( N, E, S, W).
     *
     * @param {int} position[]      - int[]: The actual position of the room.
     * @param item  - Item: The item that can be found inside the room.
     */
    public Room(int x, int y, Item item) {
        this.position[0] = x;
        this.position[1] = y;
        this.item = item;
        this.doorPosition[0] = random.nextBoolean();
        this.doorPosition[1] = random.nextBoolean();
        this.doorPosition[2] = random.nextBoolean();
        this.doorPosition[3] = random.nextBoolean();
    }

    /**
     * Robert: This is the constructor for Room objects
     * <p>
     * Selfgenerated boolean[]: The postion of the doors inside the room,( N, E, S, W).
     *
     * @param {int}   position[]      - int[]: The actual position of the room.
     * @param monster - Monster: The monster that can be found inside the room.
     */
    public Room(int x, int y, Monster monster) {
        this.position[0] = x;
        this.position[1] = y;
        this.monster = monster;
        this.doorPosition[0] = random.nextBoolean();
        this.doorPosition[1] = random.nextBoolean();
        this.doorPosition[2] = random.nextBoolean();
        this.doorPosition[3] = random.nextBoolean();
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
    public Room(int x, int y, Item item, Monster monster) {
        this.position[0] = x;
        this.position[1] = y;
        this.item = item;
        this.monster = monster;
        this.doorPosition[0] = random.nextBoolean();
        this.doorPosition[1] = random.nextBoolean();
        this.doorPosition[2] = random.nextBoolean();
        this.doorPosition[3] = random.nextBoolean();
    }

    /**
     * Robert: This is the constructor for Room objects
     *
     * @param {int}   position[]      - int[]: The actual position of the room.
     * @param item    - Item: The item that can be found inside the room.
     * @param monster - Monster: The monster that can be found inside the room.
     */
    public Room(int x, int y, Monster monster, Item item) {
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
    public Room(int x, int y, boolean N, boolean E, boolean S, boolean W, Monster monster, Item item) {
        this.position[0] = x;
        this.position[1] = y;
        this.doorPosition[0] = N;
        this.doorPosition[1] = E;
        this.doorPosition[2] = S;
        this.doorPosition[3] = W;
        this.monster = monster;
        this.item = item;
    }

    /**
     * Robert: This is the method that describes that prints the description of the room
     */
    public void describeRoom() {
        System.out.println("You entering the room as you are looking around carefully...");
        describeWalls();
        //describeDoors(doorPosition[0], doorPosition[1], doorPosition[2], doorPosition[3]);
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
    public void describeDoors(boolean N, boolean E, boolean S, boolean W) {
        System.out.println("you are looking out to find out how many doors they are...");
        if (N) {
            System.out.println("One door stands on the North side of the room");
        }
        if (E) {
            System.out.println("you can see one door on the East side of the room");
        }
        if (N) {
            System.out.println("It seems that there is a room on the South side of the room");
        }
        if (N) {
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
    public void setDoorPosition(boolean[] doorPosition) {
        this.doorPosition = doorPosition;
    }

    /**
     * Robert: This is the method that is getting the position of the doors of that room.
     *
     * @return {int[]} doorPosition
     */
    public boolean[] getDoorPosition() {
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
}
