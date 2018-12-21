package Text_Adventure.Items;

import java.util.Random;

/**
 * @author Nemanja Negovanovic
 */
public class Key extends Item {
    private int type ;
    private boolean active;
    private String name2; //Robert: I added this attribute
    //private int doorId;// More advanced ( if it belongs only to one specific door)

    /**
     * Nemanja: This is the constructor of the Key object.
     */
    //Robert: I added a line of code in the constructor. I had to do so.
    public Key(String name) {
        super(name);
        this.type = randomType();
        //Robert: I added this line below
        this.name2 = "small rusty key with the number " + this.type + " written on it";
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
        int randLevel = rand.nextInt(3);
        int keyType=randLevel;

        return keyType;
    }

    //Robert: I added this getter because I needed it
    public int getType() {
        return type;
    }

    /* public int getDoorId() {              // Getter and setter for doorId
        return doorId;
    }

    public void setDoorId(int doorId) {
        this.doorId = doorId;
    }
    */

    //Robert: I added this getter because I need it.
    public String getName2() {
        return name2;
    }

    //setter for type. mostly debugging reasons

    public void setType(int type) {
        this.type = type;
    }
}
