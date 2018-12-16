package Text_Adventure.Characters;

import Text_Adventure.Items.Consumable;
import Text_Adventure.Items.Item;
import Text_Adventure.Items.Key;

import java.util.ArrayList;

public class Hero extends Character {
    public static Item[] backpack = new Item[5];
    public ArrayList<Key> keyRing = new ArrayList<>(); //Robert: I had to implement a keyring. i hope it is ok :)

    public Hero(int heroNumber) {
        switch(heroNumber) {
            case 1://hero hunter
                setName("Ghost-Hunter");
                setRoomIndex(1);
                setHitChance(0.6);
                setMaxAttack(100);
                setHealth(300);
                break;
            case 2:
                setName("Thief");
                setRoomIndex(1);
                setHitChance(0.8);
                setMaxAttack(80);
                setHealth(300);
                break;
            case 3:
                setName("Priest");
                setRoomIndex(1);
                setHitChance(0.6);
                setMaxAttack(80);
                setHealth(400);
                break;
            case 4:
                setName("Tourist");
                setRoomIndex(1);
                setHitChance(0.7);
                setMaxAttack(80);
                setHealth(350);
                break;
            default:
                setName("Hero");
                setRoomIndex(1);
                setHitChance(0.6);
                setMaxAttack(80);
                setHealth(300);
                break;
        }
    }

    public void viewContentsOfBackpack() {
        System.out.println("Backpack:");
        for(Item a: backpack) {
            if(a != null) System.out.printf("[%s]%n", a.getName());
            else System.out.println("[-Empty slot-]");
        }
    }

    //Robert: I had to add this here. i know that I could use a setter for this one,
    // (ok it is bit more complex than a simple getter),
    //but I wish to make the inventory and keyring methods to follow the same naming conventions.
    public void viewContentsOfKeyRing() {
        System.out.println("Keyring:");
        int count = 1;
        for(Key a: keyRing) {
            System.out.println("[" +count + "]: " + a.getName2());
            count++;
        }
    }

    //Robert: This method picks the item and checks if the item is going to the keyring or to inventory
    public void pickItem(Item entity){
        if (entity instanceof Key ){
            //Key testKey = new Key("TestKey");
            addKeyToKeyRing((Key) entity);
        } else {
            addItemToBackpack(entity);
        }
    }

    public void addItemToBackpack(Item thing) {

        int countIndex = 0;

        for(Item slot: backpack) {
            if(slot == null) {
                backpack[countIndex] = thing;
                System.out.printf("Item %s has been added to your backpack (Slot %d)%n", thing.getName(), countIndex);
            }else {
                countIndex++;
            }
        }
        if(countIndex > 4) {
            System.out.println("Your backpack is full!!!");
        }
    }

    //Robert: I had to add this here. i know that I could use a setter for this one
    //but I wish to make the inventory and keyring methods to follow the same naming conventions.
    public void addKeyToKeyRing(Key key) {
        keyRing.add(key);
    }

    public void consumeItem(Consumable food) {
        setHealth(this.getHealth() + food.getHealthModifier());

        for(int i = 0; i < 5; i++) {
            if(backpack[i] == food) {
                backpack[i] = null;
                break;
            }
        }
    }

}
