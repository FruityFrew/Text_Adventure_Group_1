package Text_Adventure;


import Text_Adventure.menuDevelopment.Method;

import java.io.Serializable;
import java.util.Scanner;

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
public class DisplayMap implements Serializable {
    public static Method.Sound_methods play = new Method.Sound_methods();

    // === BASIC BUILDING BLOCKS OF THE MAP ==========================================================

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


    // === ROW GENERATORS ====================================================================

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

    //Robert: There is a reason why I call this method primitive. It just shows all the exits in the map
    //All the rooms in the row are checked if they have an exit. Those that they have an exit
    //Are being displayed with the symbol E.
    // This method generates a row when the player is displayed in one in the rooms of the row.
    //the concept is simple. if the playrer is in the room that is displayed
    //Then the room is displayed with an X inside it.
    public static void primitiveExitXRowDisplay(int level, int i, int posX, Map map){
        //--- --- --- ---....
        rowBorderDisplay(level);

        //| | | | | | | | ...
        System.out.print("|" + i + " ");
        //System.out.print("|  ");
        for (int x =0; x < level; x++){
            if(x == posX){
                cellPlayer();
            } else {
                if (map.rooms.get(positionToIndex(x, i)).isExit()){
                    cellExit();
                } else {
                    cellEmpty();
                }
            }
        }
        System.out.println(" |");

        //--- --- --- ---....
        rowBorderDisplay(level);
    }

    //Robert: There is a reason why I call this method primitive. It just shows all the exits in the map
    //All the rooms in the row are checked if they have an exit. Those that they have an exit
    //Are being displayed with the symbol E.
    //No player is displayed in this row.
    public static void primitiveExitXRowWithoutPlayer(int level, int i, Map map){
        //--- --- --- ---....
        rowBorderDisplay(level);

        //| | | | | | | | ...
        System.out.print("|" + i + " ");
        //System.out.print("|  ");
        for (int x =0; x < level; x++){
                if (map.rooms.get(positionToIndex(x, i)).isExit()){
                    cellExit();
                } else {
                    cellEmpty();
                }
            }
        System.out.println(" |");

        //--- --- --- ---....
        rowBorderDisplay(level);
    }

    //=== FUNCTIONAL MAPS BUT WITHOUT DECORATION OR MENU ==============================================

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

    // This method generates a row when the player is displayed in one in the rooms of the row.
    //the concept is simple. if the playrer is in the room that is displayed
    //Then the room is displayed with an X inside it.
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

    //Robert: There is a reason why I call this method primitive. It just shows all the exits in the map
    //All the rooms in each row are checked if they have an exit. Those that they have an exit
    //Are being displayed with the symbol E.
    // This method generates a row when the player is displayed in one in the rooms of the row.
    //the concept is simple. if the playrer is in the room that is displayed
    //Then the room is displayed with an X inside it.
    public static void MapDisplayPrimitiveExit(int level, int posX, int posY, Map map){
        edgeLine(level);
        for (int x =0; x < level; x++){
            int i = level - x - 1;
            if (i == posY){
                primitiveExitXRowDisplay(level, i, posX, map);
            } else {
                primitiveExitXRowWithoutPlayer(level, i, map);
            }
        }
        XNumbersDisplay(level);
        edgeLine(level);
    }


    //=== COMPLETE SOLUTIONS WITH MENU ===========================================================

    //Robert: Complete solution for a map with a menu.
    //This version does not shown anything else thatn the rooms
    public static void displayMapMenuEmpty(int level){
        Scanner input = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Your current map:");
        System.out.println("=================");
        MapDisplayEmpty(level);
        System.out.println(" ");
        System.out.println(" | [7] Close the map");
        String choice = input.next();
        Method.clearScreen();
        if (choice.equalsIgnoreCase("`")){
            System.out.println("Winner, winner, chicken dinner!");
        }
    }

    //Robert: Complete solution for a map with a menu.
    //This version displays the position of the player.
    public static void displayMapMenuPlayer(int level, int posX, int posY){
        Scanner input = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Your current map:");
        System.out.println("=================");
        MapDisplayPlayer(level, posX, posY);
        System.out.println("X = your current position");
        System.out.println(" ");
        System.out.println(" | [7] Close the map");
        String choice = input.next();
        Method.clearScreen();
        if (choice.equalsIgnoreCase("`")){
            System.out.println("Winner, winner, chicken dinner!");
        }
    }

    //Robert: Complete solution for a map with a menu.
    //This version displays the position of the player and the exit doors.
    public static void displayMapMenuPrimitiveExit(int level, int posX, int posY, Map map){
        Scanner input = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Your current map:");
        System.out.println("=================");
        MapDisplayPrimitiveExit(level, posX, posY, map);
        System.out.println("X = Your current position, E = The exit door");
        System.out.println(" ");
        System.out.println(" | [7] Close the map");
        String choice = input.next();
            play.mapSound();
        Method.clearScreen();
        if (choice.equalsIgnoreCase("`")){
            System.out.println("Winner, winner, chicken dinner!");
        }
    }

    // === USEFUL METHODS =========================================================================

    /**
     * Robert: this method helps to generate an index number from position
     *
     * @param x - An integer that gives the orizontal position. it does get multiplied by 10
     * @param y - An integer that gives the orizontal position. it doesn't get multiplied
     * @return - it returns the index of a room. index is useful in order to reffer to a room.
     */
    public static int positionToIndex(int x, int y){
        return y + (x * 10);
    } //it works

    public static int xFromIndex(int index){
        return index / 10;
    } // it works

    public static int yFromIndex(int index){
        return index - ((index / 10) * 10);//Robert: it works
    }
}
