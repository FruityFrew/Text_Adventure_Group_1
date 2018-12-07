package Text_Adventure.Items;
/**
 * @author Nemanja Negovanovic
 */
public class Key extends Item {
    private int type ;
    private boolean active;
    //private int doorId;// More advanced ( if it belongs only to one specific door)

    /**
     * Nemanja: This is the constructor of the Key object.
     *
     *
     *
     * @param Type - int: The type of a key object that opens the door object of the same type.
     */
    public Key(String name, int Type) {
        super(name);
        this.type = Type;
    }

    /**
     * Nemanja: This returns the type of the Key object.
     *
     * @return - int
     */
    public int getLevel() {
        return type;
    }

    /**
     * Nemanja: This makes Key object usable by player.
     *
     * @return boolean
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Nemanja: This "Destroys" Key object. (Makes it invisible to player)
     *
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /* public int getDoorId() {              // Getter and setter for doorId
        return doorId;
    }

    public void setDoorId(int doorId) {
        this.doorId = doorId;
    }
    */
}
