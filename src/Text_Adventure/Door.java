package Text_Adventure;

/**
 * @author Nemanja Negovanovic
 */
public class Door {
    private int type;
    private int position;
    private int room;
    private boolean locked;

    /**
     * Nemanja: This creates Door object.
     * @param type       - int: This is type of the door that will look for same kay type if locked.
     * @param position   - int: This is position of the door in the room (0-North,1-East,2-South,3-West).
     * @param room       - int: This is position of the room object that contains this door object.
     * @param locked - boolean: This is locked/unlocked status.
     */
    public Door(int type, int position, int room, boolean locked) {
        this.type = type;
        this.position = position;
        this.room = room;
        this.locked = locked;
    }

    public Door(int room, boolean locked) {
        this.room = room;
        this.locked = locked;
    } //In case of testing

    public Door(int position, int room) {
        this.position = position;
        this.room = room;
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
}
