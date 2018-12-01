package Text_Adventure;

import Text_Adventure.Characters.Monster;
import Text_Adventure.Items.Item;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Room {
    SecureRandom random = new SecureRandom();
    private int[] position = new int[2];
    //private ArrayList<Door> doors = new ArrayList<>();
    private boolean[] doorPosition = new boolean[4];
    private Item item;
    private Monster monster;
    private int spawnMonsterRate = 100;
    private int spawnItemRate = 100;

    public Room(int x, int y){
        this.position[0] = x;
        this.position[1] = y;
        this.doorPosition[0] = random.nextBoolean();
        this.doorPosition[1] = random.nextBoolean();
        this.doorPosition[2] = random.nextBoolean();
        this.doorPosition[3] = random.nextBoolean();
    }

    //, boolean N, boolean E, boolean S, boolean w
    public Room(int x, int y, boolean N, boolean E, boolean S, boolean W){
        this.position[0] = x;
        this.position[1] = y;
        this.doorPosition[0] = N;
        this.doorPosition[1] = E;
        this.doorPosition[2] = S;
        this.doorPosition[3] = W;
    }

    public Room(int x, int y, Item item){
        this.position[0] = x;
        this.position[1] = y;
        this.item = item;
        this.doorPosition[0] = random.nextBoolean();
        this.doorPosition[1] = random.nextBoolean();
        this.doorPosition[2] = random.nextBoolean();
        this.doorPosition[3] = random.nextBoolean();
    }

    public Room(int x, int y, Monster monster){
        this.position[0] = x;
        this.position[1] = y;
        this.monster = monster;
        this.doorPosition[0] = random.nextBoolean();
        this.doorPosition[1] = random.nextBoolean();
        this.doorPosition[2] = random.nextBoolean();
        this.doorPosition[3] = random.nextBoolean();
    }

    public Room(int x, int y, Item item, Monster monster){
        this.position[0] = x;
        this.position[1] = y;
        this.item = item;
        this.monster = monster;
        this.doorPosition[0] = random.nextBoolean();
        this.doorPosition[1] = random.nextBoolean();
        this.doorPosition[2] = random.nextBoolean();
        this.doorPosition[3] = random.nextBoolean();
    }

    public Room(int x, int y, Monster monster, Item item){
        this.position[0] = x;
        this.position[1] = y;
        this.monster = monster;
        this.item = item;
    }

    public Room(int x, int y, boolean N, boolean E, boolean S, boolean W, Monster monster, Item item){
        this.position[0] = x;
        this.position[1] = y;
        this.doorPosition[0] = N;
        this.doorPosition[1] = E;
        this.doorPosition[2] = S;
        this.doorPosition[3] = W;
        this.monster = monster;
        this.item = item;
    }

    public void describeRoom(){
        System.out.println("You entering the room as you are looking around carefully...");
        describeWalls();
        describeDoors(doorPosition[0], doorPosition[1], doorPosition[2], doorPosition[3]);
        describeItem();
        describeMonster();
    }

    public void describeWalls(){
        System.out.println("The walls are looking like walls right now.");
    }

    public void describeDoors(boolean N, boolean E, boolean S, boolean W){
        System.out.println("you are looking out to find out how many doors they are...");
        if (N){
            System.out.println("One door stands on the North side of the room");
        }if (E){
            System.out.println("you can see one door on the East side of the room");
        }if (N){
            System.out.println("It seems that there is a room on the South side of the room");
        }if (N){
            System.out.println("and one door stands on the West side of the room as well");
        }
    }

    public void describeItem(){
        System.out.println("You are looking for items...");
        if(this.item != null){
            System.out.println("In the corner seems to be an item,");
            System.out.println("It is a " + this.item.getName() + "!");
        } else {
            System.out.println("you didn't found something useful.");
        }
    }

    public void describeMonster(){
        System.out.println("You are checking if someone is in the room...");
        if(this.monster != null){
            System.out.println("In the shadows you see a figure.");
            System.out.println("Oh no! It is a Monster!");
            //System.out.println("Oh no! It is a " + this.monster.getType() + "!");
        } else {
            System.out.println("No one. Probably just the wind");
        }
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int[] getPosition() {
        return position;
    }

    public void setDoorPosition(boolean[] doorPosition) {
        this.doorPosition = doorPosition;
    }

    public boolean[] getDoorPosition() {
        return doorPosition;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setSpawnItemRate(int spawnItemRate) {
        this.spawnItemRate = spawnItemRate;
    }

    public int getSpawnItemRate() {
        return spawnItemRate;
    }

    public void setSpawnMonsterRate(int spawnMonsterRate) {
        this.spawnMonsterRate = spawnMonsterRate;
    }

    public int getSpawnMonsterRate() {
        return spawnMonsterRate;
    }
}
