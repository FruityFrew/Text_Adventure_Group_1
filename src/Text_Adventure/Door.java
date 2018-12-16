package Text_Adventure;

import java.util.Random;

/**
 * @author Nemanja Negovanovic
 */
public class Door {
    private int type;
    private int position;
    private int room;
    private boolean locked;
    private boolean active;

    /**
     * Nemanja: This creates Door object.
     *
     *
     * @param position   - int: This is position of the door in the room (0-North,1-East,2-South,3-West).
     * @param room       - int: This is position of the room object that contains this door object.
     */
    public Door(int position, int room) {
        this.type = randomType();
        this.position = position;
        this.room = room;
        this.locked = randomLocked();
    }

    /**
     * Robert: This is my version of a constructor.
     *
     *
     * @param active   - int: This is position of the door in the room (0-North,1-East,2-South,3-West).
     * @param room       - int: This is position of the room object that contains this door object.
     */
    public Door(boolean active, int room) {
        this.type = randomType();
        this.active = active;
        this.room = room;
        this.locked = randomLocked();
    }

    public Door(int room) {
        this.room = room;
        this.locked = randomLocked();
    } //In case of testing


    /**
     * Nemanja: This returns Door type. (0-5)
     *
     * @return int
     */
    public int getType() {
        return type;
    }

    /**
     * Nemanja: This returns Door position. (0-North,1-East,2-South,3-West)
     *
     * @return int
     */
    public int getPosition() {
        return position;
    }

    /**
     * Nemanja: This returns Room position of an object that Door object belongs to.
     *
     * @return int
     */
    public int getRoom() {
        return room;
    }

    /**
     * Nemanja: This returns Door status. (True-Locked,False-Unlocked)
     *
     * @return boolean
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Nemanja: This changes Door status from True-Locked to False-Unlocked.
     * @param locked
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     *
     * @return
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Nemanja: This creates random bollean at 5% chance for a Door object to be locked.
     *
     * @return boolean
     */
    //I modified the lockrate "randLock" from 19 to 18 to make the game bit more playable
    public boolean randomLocked() {
        boolean lockedBool = false;
        Random rand = new Random();
        int randLock = rand.nextInt(20) + 1;
        if (randLock > 18){
            lockedBool = true;
        }
        return lockedBool;
    }

    /**
     * Nemanja: This is going to be changed to fit the game's needs.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Door{" +
                "type=" + type +
                ", position=" + position +
                ", room=" + room +
                ", locked=" + locked +
                '}';
    }

    /**
     * Nemanja: This returns random int between 0 and 5. This int decides the type of the door.
     *
     * @return int
     */
    public int randomType(){
        Random rand = new Random();
        int randLevel = rand.nextInt(3);
        int doorType=randLevel;

        return doorType;
    }
}
