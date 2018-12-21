package Text_Adventure.menuDevelopment;

import Text_Adventure.Items.Consumable;
import Text_Adventure.Items.Key;

import java.io.Serializable;
import java.util.ArrayList;

public class save implements Serializable {
    public String PlayerName;
    public int PlayerHealth;
    public int PlayerScore;
    public Consumable [] PlayerBackpack;
    public ArrayList<Key>kayList;
}
