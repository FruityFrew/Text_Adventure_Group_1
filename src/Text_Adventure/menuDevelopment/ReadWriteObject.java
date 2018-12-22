package Text_Adventure.menuDevelopment;

import Text_Adventure.Characters.Hero;
import Text_Adventure.Main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReadWriteObject  implements Serializable {
    public static save a = new save();
    public static String saveName;
    public static String fileExtension = ".save";
    public static transient Scanner input = new Scanner(System.in);


    //Write an object to a file (NOT text file!)
    public static void writeObject(Object myObject) {

        //We are naming the object ".data" just to be clear that it's not a text file.
        System.out.print("Enter name of save file without spaces: ");
        saveName = input.nextLine();
        File file = new File("saves/" + saveName + fileExtension);

        try (ObjectOutputStream oOut = new ObjectOutputStream(new FileOutputStream(file))) {
            oOut.writeObject(myObject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //Read an object from a file.
    public static Object readObject(String string) {
        Object objectFromFile = null;
        File file = new File(string);
        try (ObjectInputStream oIn = new ObjectInputStream(new FileInputStream(file))) {
            objectFromFile = oIn.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return objectFromFile;
    }


}

