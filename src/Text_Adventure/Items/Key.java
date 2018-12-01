package Text_Adventure.Items;

public class Key extends Item {
    private int level ;
    //private int doorId;// More advanced ( if it belongs only to one door)

    /**
     * Nemanja: This is the constructor of the Key object.
     *
     * @param level - int: The level of a key object that opens the door object of the same level.
     */
    public Key(String name, int level) {
        super(name);
        this.level = level;
    }

    /**
     * Nemanja: This returns the level of the key object.
     *
     * @return - int: Level of a key object
     */
    public int getLevel() {
        return level;
    }

   /* public int getDoorId() {              // Getter and setter for doorId
        return doorId;
    }

    public void setDoorId(int doorId) {
        this.doorId = doorId;
    }
    */
}
