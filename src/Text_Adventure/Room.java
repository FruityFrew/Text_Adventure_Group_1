package Text_Adventure;

public class Room {
    private int index;
    private boolean northDoor, eastDoor, southDoor, westDoor;

    public Room() {
        this(-1);
    }
    public Room(int index) {
        setIndex(index);
        setAllDoors(index);
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public void setNorthDoor(boolean doorState) { northDoor = doorState; }
    public void setEastDoor(boolean doorState) { eastDoor = doorState; }
    public void setSouthDoor(boolean doorState) { southDoor = doorState; }
    public void setWestDoor(boolean doorState) { westDoor = doorState; }

    public void setAllDoors(int index) {
        northDoor = (index >= 3) ? true: false;
        eastDoor = (index % 3 != 2) ? true: false;
        southDoor = (index <= 5) ? true: false;
        westDoor = (index % 3 != 0) ? true: false;
    }

    public int getIndex() { return index; }
    public boolean getNorthDoor() {return northDoor; }
    public boolean getSouthDoor() {return southDoor; }
    public boolean getWestDoor() {return westDoor; }
    public boolean getEastDoor() {return eastDoor; }

}
