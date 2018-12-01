package Text_Adventure;

import Text_Adventure.Characters.Monster;
import Text_Adventure.Items.Item;

import java.util.ArrayList;

public class Room {
    private int[] position = new int[2];
    //private ArrayList<Door> doors = new ArrayList<>();
    private boolean[] doorPosition = new boolean[4];
    private Item item;
    private Monster monster;
    private int spawnMonsterRate = 100;
    private int spawnItemRate = 100;

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
