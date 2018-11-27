package Text_Adventure.Characters;

public class Character {
    private String name;
    private int roomIndex;

    //Set of constructors that are defined through setters (which show up later)
    public Character() {
        this(null, -1);
    }
    public Character(String name) {
        this(name, -1);
    }
    public Character(String name, int index) {
        setName(name);
        setRoomIndex(index);
    }

    //setters for name and roomIndex
    public void setName(String name) { this.name = name; }
    public void setRoomIndex(int index) { roomIndex = index; }

    //getters for name and roomIndex
    public String getName() { return name; }
    public int getRoomIndex() { return roomIndex; }
}
