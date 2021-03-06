package Text_Adventure;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;

public class Map  implements Serializable {
    public ArrayList<Room> rooms = new ArrayList<Room>(100);
    private int level; //this is the number n when the map is n*n
    SecureRandom random = new SecureRandom();

    public Map(int level){
        this.level = level;
        generateMap(level);
    }

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

    public int yFromIndex(int index){   //Robert:it works
        return index - ((index / 10) * 10);
    }

        //                  Alex: It might not work. n/10*10 is always n. THEN n-n is ALWAYS 0.
    //                      Alex:I wrote the correct formula to get the y from index, which is index%10
    //    return index%10;// Alex: I hope you dont mind Robert for giving you a bit of help
    //}

    //it works as it seems.
    public void generateMap(int level){
        int n = positionToIndex(level, level);
        boolean hasExit = false;
        for (int i=0; i<=n; i++){
            Room room = new Room(i, level, xFromIndex(i),yFromIndex(i));
            rooms.add(i,room);
            //I commended the code below because I found a better exit spawning system but I will keep the code
            //bit more for safety reasons.
//            if ((rooms.get(i).getPosition()[0] < (level - 1))
//                    && (rooms.get(i).getPosition()[0] < (level - 1)) ){
//                if(rooms.get(i).isExit()){
//                    hasExit = true;
//                }
//            }
        }

        //I commended the code below because I found a better exit spawning system but I will keep the code
        //bit more for safety reasons.
        //Robert: The code below ensures that there will be always an exit door in the map.
//        if(hasExit != true){
//            rooms.get(positionToIndex(random.nextInt(level), random.nextInt(level))).setExit(true);
//        }
        rooms.get(positionToIndex(random.nextInt(level), random.nextInt(level))).setExit(true);

    }

    //for testing purposes. it works
    public void printMap(){
        for (Room x:rooms){
            System.out.println(" ");
            System.out.println("==========");
            System.out.println("Room's index: " + x.getIndex());
            System.out.println("postion x: " + x.getPosition()[0]);
            System.out.println("postion y: " + x.getPosition()[1]);
            x.printDoors();
            System.out.println("Can I go North? " + checkNorth(x.getPosition()[0], x.getPosition()[1]));
            System.out.println("Can I go East? " + checkEast(x.getPosition()[0], x.getPosition()[1]));
            System.out.println("Can I go South? " + checkSouth(x.getPosition()[0], x.getPosition()[1]));
            System.out.println("Can I go West? " + checkWest(x.getPosition()[0], x.getPosition()[1]));
            x.describeRoom();
            System.out.println(" ");
            System.out.println("===========");
        }
    }

    //it works only for map objects. not exactly helpful
    public boolean checkPostion(int x, int y){
        if ((x >= 0 && x < level)&&(y >= 0 && y < level)){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkNorth(int x, int y){
        y = y + 1;
        //System.out.println("checkN(X) " + x);
        //System.out.println("checkN(Y): " + y);
        if ((y >= 0) && (y < level)){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSouth(int x, int y){
        y = y - 1;
        //System.out.println("checkS(X) " + x);
        //System.out.println("checkS(Y): " + y);
        if ((y >= 0) && (y < level)){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkEast(int x, int y){
        x = x + 1;
        //System.out.println("checkE(X) " + x);
        //System.out.println("checkE(Y): " + y);
        if ((x >= 0) && (x < level)){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkWest(int x, int y){
        x = x - 1;
        //System.out.println("checkW(X) " + x);
        //System.out.println("checkW(Y): " + y);
        if ((x >= 0) && (x < level)){
            return true;
        } else {
            return false;
        }
    }

    public int moveNorth(int x, int y){
        if (checkNorth(x,y)){
            y = y + 1;
        }
        return positionToIndex(x,y);
    }

    public int moveSouth(int x, int y){
        if (checkSouth(x,y)){
            y = y - 1;
        }
        return positionToIndex(x,y);
    }

    public int moveEast(int x, int y){
        if (checkEast(x,y)){
            x = x + 1;
        }
        return positionToIndex(x,y);
    }

    public int moveWest(int x, int y){
        if (checkWest(x,y)){
            x = x - 1;
        }
        return positionToIndex(x,y);
    }
}
