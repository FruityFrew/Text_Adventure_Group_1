package Text_Adventure.Items;

import java.util.Random;

/**
 * @author Nemanja Negovanovic
 */
public class Key extends Item {
    private int type ;
    private boolean active;
    //private int doorId;// More advanced ( if it belongs only to one specific door)

    /**
     * Nemanja: This is the constructor of the Key object.
     */
    public Key(String name) {
        super(name);
        this.type = randomType();
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

    public int randomType(){
        Random rand = new Random();
        int randLevel = rand.nextInt(6);
        int keyType=randLevel;

        return keyType;
    }

    /* public int getDoorId() {              // Getter and setter for doorId
        return doorId;
    }

    public void setDoorId(int doorId) {
        this.doorId = doorId;
    }
    */
}
