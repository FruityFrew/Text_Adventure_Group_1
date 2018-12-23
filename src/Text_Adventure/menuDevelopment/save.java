package Text_Adventure.menuDevelopment;

import Text_Adventure.Items.Consumable;
import Text_Adventure.Items.Key;
import Text_Adventure.Items.Weapon;
import Text_Adventure.Room;

import java.io.Serializable;
import java.util.ArrayList;

public class save implements Serializable {
    public String PlayerName;
    public String PlayerType;
    public int PlayerHealth;
    public int PlayerScore;
    public Consumable [] PlayerBackpack;
    public ArrayList<Key> keyList;
    public ArrayList<Room> SaveRooms;
    public int roomIndex;
    public int Level;
    public Weapon playerWeapon;
}
