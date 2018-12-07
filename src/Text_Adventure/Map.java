package Text_Adventure;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Map {
    private ArrayList<Room> rooms = new ArrayList<Room>(100);
    private int level; //this is the number n when the map is n*n
    SecureRandom random = new SecureRandom();

    /**
     * Robert: this method helps to generate an index number from position
     *
     * @param x - An integer that gives the orizontal position. it does get multiplied by 10
     * @param y - An integer that gives the orizontal position. it doesn't get multiplied
     * @return - it returns the index of a room. index is useful in order to reffer to a room.
     */
    public int positionToIndex(int x, int y){
        return y + (x * 10);
    } //it works

    public int xFromIndex(int index){
        return index / 10;
    } // it works

    public int yFromIndex(int index){
        return index - ((index / 10) * 10);
    } //it works

    //it works as it seems.
    public void generateMap(int level){
        int n = positionToIndex(level, level);
        for (int i=0; i<=n; i++){
            Room room = new Room(i,xFromIndex(i),yFromIndex(i));
            rooms.add(i,room);
        }
    }

    //for testing purposes. it works
    public void printMap(){
        for (Room x:rooms){
            System.out.println("Room's index: " + x.getIndex() + " postion x: " + x.getPosition()[0]
                    + " postion y: " + x.getPosition()[1]);
        }
    }
}