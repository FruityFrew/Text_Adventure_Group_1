package Text_Adventure;



/**
 * @author Robert Alm RobertKristianAlm@gmail.com
 *
 * This class is a generator class. Every method in this class should be static.
 * It generates a map display. A feature that have been asked to be added to the game.
 * Feel free to come with your own versions.
 * But...
 * Do not touch the content inside the methods. feel free to copy the methods and implement there
 * you changes. This the best way to changes to someone else's code.
 */
public class DisplayMap {

    //Robert: generates an empty cell, (room), in the map displayment
    public static void cellEmpty(){
        System.out.print("| |  ");
    }

    //Robert: generates the cell, (room), where the player is located in the map displayment
    public static void cellPlayer(){
        System.out.print("|X|  ");
    }

    //Robert: generates a cell with an exit in the map displayment
    public static void cellExit(){
        System.out.print("|E|  ");
    }

    //Robert: generates a cell with a monster in the map displayment
    public static void cellMonster(){
        System.out.print("|M|  ");
    }

    //Robert: This method is meant to be used to generate the ceil or the floor of each cell, (room).
    public static void cellBorder(){
        System.out.print("---  ");
    }

    //Robert: This method created in order to reduce the redudancy on creating the ceiling and the floow
    //of each room in a row.
    //it helps the emptyRowDisplay to generate its displayed content, (namely, a row of rooms).
    public static void rowBorderDisplay(int level){
        //--- --- --- ---....
        System.out.print("|  ");
        for (int x =0; x < level; x++){
            cellBorder();
        }
        System.out.println(" |");
    }

    public static void edgeLine(int level){
        //---------------....
        System.out.print("|  ");
        for (int x =0; x < level; x++){
            System.out.print("-----");
        }
        System.out.println(" |");
    }

    public static void XNumbersDisplay(int level){
        //|0|  |1|  |2|  |3|....
        System.out.print("|  ");
        for (int x =0; x < level; x++){
            System.out.print("|" + x + "|  ");
        }
        System.out.println(" |");
    }

    //Robert: This method generates an empty row.
    //The method displays the row fully with its ceiling and floor.
    //this version does not show where the player is or anything else.
    //it just shows how many room they are and how they are allocated in the row.
    public static void emptyRowDisplay(int level, int i){
        //--- --- --- ---....
        rowBorderDisplay(level);

        //| | | | | | | | ...
        System.out.print("|" + i + " ");
        //System.out.print("|  ");
        for (int x =0; x < level; x++){
            cellEmpty();
        }
        System.out.println(" |");

        //--- --- --- ---....
        rowBorderDisplay(level);
    }

    //Robert: This method generates a row when the player is displayed in one in the rooms of the row.
    //the concept is simple. if the playrer is in the room that is displayed
    //Then the room is displayed with an X inside it.
    public static void playerXRowDisplay(int level, int i, int posX){
        //--- --- --- ---....
        rowBorderDisplay(level);

        //| | | | | | | | ...
        System.out.print("|" + i + " ");
        //System.out.print("|  ");
        for (int x =0; x < level; x++){
            if(x == posX){
                cellPlayer();
            } else {
                cellEmpty();
            }
        }
        System.out.println(" |");

        //--- --- --- ---....
        rowBorderDisplay(level);
    }

    //Robert: This method generates an empty map.
    //this version does not show where the player is or anything else.
    //it just shows how many room they are and how they are allocated.
    public static void MapDisplayEmpty(int level){
        edgeLine(level);
        for (int x =0; x < level; x++){
            int i = level - x - 1;
            emptyRowDisplay(level, i);
        }
        XNumbersDisplay(level);
        edgeLine(level);
    }

    public static void MapDisplayPlayer(int level, int posX, int posY){
        edgeLine(level);
        for (int x =0; x < level; x++){
            int i = level - x - 1;
            if (i == posY){
                playerXRowDisplay(level, i, posX);
            } else {
                emptyRowDisplay(level, i);
            }
        }
        XNumbersDisplay(level);
        edgeLine(level);
    }

    public static void displayMapMenuEmpty(int level){
        System.out.println(" ");
        System.out.println("Your current map:");
        System.out.println("=================");
        MapDisplayEmpty(level);
        System.out.println(" ");
    }
}
