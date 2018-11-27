package Text_Adventure.Items;

public class Item {
    private String Name;

    /**
     * Nemanja: This is the constructor for Item objects
     *
     * @param name - String: The name of the item.
     */
    public Item(String name) {
        Name = name;
    }

    /**
     * Nemanja: This returns the name of an item object.
     *
     * @return String
     */
    public String getName() {
        return Name;
    }
}}
