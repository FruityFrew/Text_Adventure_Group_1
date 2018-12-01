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
    }

    public Room(int x, int y, Monster monster){
        this.position[0] = x;
        this.position[1] = y;
        this.monster = monster;
    }

    public Room(int x, int y, Item item, Monster monster){
        this.position[0] = x;
        this.position[1] = y;
        this.item = item;
        this.monster = monster;
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
