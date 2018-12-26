package  Text_Adventure.Items;

import Text_Adventure.menuDevelopment.ColorPrint;

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
}
