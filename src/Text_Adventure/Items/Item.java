package  Text_Adventure.Items;

import java.io.Serializable;

/**
 * @author Nemanja Negovanovic
 */
public class Item implements Serializable {
    private String Name;

    /**
     * Nemanja: This is the constructor for Item objects
     *
     * @param name - String: The name of the item.
     */
    public  Item(String name) {
        Name = name;
    }

    /**
     * Nemanja: This returns the name of an item object.
     *
     * @return String
     */
    public  String getName() {
        return Name;
    }

    public static class Treasure extends Item {
        private int points;

        public Treasure(String name, int points) {
            super(name);
            this.points = points;
        }

        public int addPoints() {
            return points;
        }
    }
}
