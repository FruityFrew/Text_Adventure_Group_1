package Text_Adventure.Characters;

import Text_Adventure.Items.Consumable;
import Text_Adventure.Items.Item;
import Text_Adventure.Items.Key;
import Text_Adventure.Items.Weapon;
import Text_Adventure.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class Hero extends Character {
    public static Consumable[] backpack = new Consumable[5];
    public ArrayList<Key> keyRing = new ArrayList<>(); //Robert: I had to implement a keyring. i hope it is ok :)
    public int highscore = 0; //Robert: the highscore that the player collects.
    public Weapon weapon; //this the weapon's slot of the hero. something like inventory but with only one slot.
    public int weaponDamageModifier; //this will modify the damage that a player deal, if the player has a weapon.
    Scanner input = new Scanner(System.in);

    public Hero(int heroNumber) {
        switch(heroNumber) {
            case 1://hero hunter
                setPlayerType("Ghost-Hunter");
                setRoomIndex(1);
                setHitChance(0.6);
                setMaxAttack(100);
                setHealth(300);
                break;
            case 2:
                setPlayerType("Thief");
                setRoomIndex(1);
                setHitChance(0.8);
                setMaxAttack(80);
                setHealth(300);
                break;
            case 3:
                setPlayerType("Priest");
                setRoomIndex(1);
                setHitChance(0.6);
                setMaxAttack(80);
                setHealth(400);
                break;
            case 4:
                setPlayerType("Tourist");
                setRoomIndex(1);
                setHitChance(0.7);
                setMaxAttack(80);
                setHealth(350);
                break;
            default:
                setPlayerType("Hero");
                setRoomIndex(1);
                setHitChance(0.6);
                setMaxAttack(80);
                setHealth(300);
                break;
        }
    }



    public void viewContentsOfBackpack() {
        System.out.println("Backpack:");
        boolean running = true;
        while (running == true){
            int count = 0;
            for(Consumable a: backpack) {
                if(a != null) System.out.printf("["+ count + "][%s]%n", a.getName());
                else System.out.println("["+ count + "][-Empty slot-]");
                count++;
            }
            System.out.println("[6]close");
            System.out.println("Type the number of the item that you wish to interact: ");
            int choice = input.nextInt();
            if (choice > 5){
                running = false;
            } else {
                if(backpack[choice] != null) {
                    System.out.printf("[" + choice + "][%s]%n", backpack[choice].getName());
                    System.out.println("Choose an option");
                    System.out.println("================");
                    System.out.println("[1]Use the item");
                    System.out.println("[2]Drop the item");
                    System.out.println("[3]Do nothing (returns to the backpack)");
                    String choice2 = input.next();
                    switch (choice2){
                        case "1":
                            System.out.println("You are drinking the item");
                            //int healingPoints = backpack[choice].getHealthModifier();
                            addHealth(backpack[choice].getHealthModifier());
                            backpack[choice] = null;
                            break;
                        case "2":
                            System.out.println("You are dropping the item");
                            backpack[choice] = null;
                            break;
                        default:
                            System.out.println("Returning to the backpack");
                    }
                }
            }
        }

    }

    //Robert: I had to add this here. i know that I could use a setter for this one,
    // (ok it is bit more complex than a simple getter),
    //but I wish to make the inventory and keyring methods to follow the same naming conventions.
    public void viewContentsOfKeyRing() {
        System.out.println("Keyring:");
        int count = 1;
        for(Key a: keyRing) {
            System.out.println(a.getName2());
            count++;
        }
    }

    //Robert: This method returns the weapon that is inside the weapon slot.
    public void viewConstentofWeaponSlot(){
        System.out.println("Your weapon: " +weapon.getName());
    }

    //Robert: This method picks the item and checks if the item is going to the keyring or to inventory
    //The method takes the parameter room1 in order to be able to leave his old weapon to the ground
    public void pickItem(Item entity, Room room1){
        if (entity instanceof Key ){
            addKeyToKeyRing((Key) entity);
        } else if (entity instanceof Consumable ){
                addItemToBackpack((Consumable) entity);
        } else {
            pickUpWeapon((Weapon) entity, room1);
        }
    }

    public void addItemToBackpack(Consumable thing) {

        int countIndex = 0;

        for(Consumable slot: backpack) {
            if(slot == null) {
                backpack[countIndex] = thing;

            }else {
                countIndex++;
            }
        }
        if (backpack[countIndex] != null) {
            System.out.printf("Item %s has been added to your backpack (Slot %d)%n", thing.getName(), countIndex);
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

    //Robert: This a pick up method for a weapon.
    //if the hero has already a weapon he swaps it with the one on the ground.
    public void pickUpWeapon(Weapon weapon1, Room room){
        if (this.weapon == null){
            this.weapon = weapon1;
            room.setItem(null);
            this.weaponDamageModifier = weapon1.getDamage();
            System.out.println("The hero now is equipped with: " + weapon1.getName());
            System.out.println("The hero can deal now: " + this.weaponDamageModifier + " extra damage");

        } else {
            Weapon weapon2 = this.weapon;
            this.weapon = weapon1;
            room.setItem(weapon2);
            this.weaponDamageModifier = weapon1.getDamage();
            System.out.println("The hero now is equipped with: " + weapon1.getName());
            System.out.println("The hero just dropped to the ground a: " + weapon2.getName());
            System.out.println("The hero can deal now: " + this.weaponDamageModifier + " extra damage");
        }
    }

    //Robert: instead of normal setter for the highscore attribute
    //it adds points to the current highscore. it does not set/reset the highscore
    public void addHighScore(int points){
        int currentHighscore = this.highscore;
        this.highscore = currentHighscore + points;
    }

    //Robert: A normal Getter that I need for the highscore feature
    public int getHighscore() {
        return this.highscore;
    }

    //Robert: A setter for the weapon. Probably I will use a more advance method for that
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    //Robert: A getter for the weapon. I will totally use it.
    public Weapon getWeapon() {
        return weapon;
    }
}
