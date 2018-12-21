package Text_Adventure.menuDevelopment;

import Text_Adventure.Characters.Hero;
import Text_Adventure.Main;

import java.io.*;

public class ReadWriteObject  implements Serializable {
   public static save a = new save();
    //Write an object to a file (NOT text file!)
    public static void writeObject(Object myObject) {

        //We are naming the object ".data" just to be clear that it's not a text file.
        File file = new File("c:/dev/git/FileInOutExamples/myCoolObject.data");

        try (ObjectOutputStream oOut = new ObjectOutputStream(new FileOutputStream(file))) {
            oOut.writeObject(myObject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Read an object from a file.
    public static Object readObject() {
        Object objectFromFile = null;
        File file = new File("c:/dev/git/FileInOutExamples/myCoolObject.data");
        try (ObjectInputStream oIn = new ObjectInputStream(new FileInputStream(file))) {
            objectFromFile = oIn.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return objectFromFile;
    }
}
