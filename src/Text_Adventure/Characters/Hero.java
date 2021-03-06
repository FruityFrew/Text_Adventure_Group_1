package Text_Adventure.Characters;

import Text_Adventure.Items.Consumable;
import Text_Adventure.Items.Item;
import Text_Adventure.Items.Key;
import Text_Adventure.Items.Weapon;
import Text_Adventure.Room;
import Text_Adventure.menuDevelopment.ColorPrint;
import Text_Adventure.menuDevelopment.Method;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Hero extends Character implements Serializable {
    public static Consumable[] backpack = new Consumable[6];
    public ArrayList<Key> keyRing = new ArrayList<>(3); //Robert: I had to implement a keyring. i hope it is ok :)
    public int highscore = 0; //Robert: the highscore that the player collects.
    public Weapon weapon; //this the weapon's slot of the hero. something like inventory but with only one slot.
    public int asd=99;
    public int weaponDamageModifier; //this will modify the damage that a player deal, if the player has a weapon.
    transient Scanner input = new Scanner(System.in);
    public Method.Sound_methods play = new Method.Sound_methods();
    public boolean printed;



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
        play.backpackSound();
        Scanner input = new Scanner(System.in); //I added this line to overcome the conflict between
        // scanner and Serializable
        System.out.println("Backpack:");
        boolean running = true;
        while (running == true){
            int count = 0;
            for(Consumable a: backpack) {
                if(a != null) {
                    System.out.printf("[" + count + "]"+"["+ ColorPrint.ANSI_GREEN+ "%s"+ ColorPrint.ANSI_RESET
                            +"]%n", a.getName());
                }else { if(count < 5)System.out.println("["+ count + "][-Empty slot-]");}
                count++;
            }
            System.out.println("[6]close");
            System.out.println("Type the number of the item that you wish to interact: ");
            int choice = menuChoice();
            if (choice > 5){
                play.backpackSound();
                Method.clearScreen();
                running = false;
            } else {
                play.menuSound();
                Method.clearScreen();
                if(backpack[choice] != null) {
                    System.out.printf("[" + choice + "][%s]%n",
                           ColorPrint.ANSI_GREEN +(backpack[choice].getName())+ColorPrint.ANSI_RESET);
                    System.out.println("Choose an option");
                    System.out.println("================");
                    System.out.println("[1]Use the item");
                    System.out.println("[2]Drop the item");
                    System.out.println("[3]Do nothing (returns to the backpack)");
                    int choice2 = menuChoice();
                    switch (choice2){
                        case 1:
                            Method.clearScreen();
                            play.drinkPotionSound();
                            System.out.println("You are drinking "+
                                    ColorPrint.ANSI_GREEN +(backpack[choice].getName())+ColorPrint.ANSI_RESET);
                            //int healingPoints = backpack[choice].getHealthModifier();
                            addHealth(backpack[choice].getHealthModifier());
                            backpack[choice] = null;
                            break;
                        case 2:
                            Method.clearScreen();
                            play.dropPotionSound();
                            System.out.println("You are dropping "+
                                    ColorPrint.ANSI_GREEN +(backpack[choice].getName())+ColorPrint.ANSI_RESET);
                            backpack[choice] = null;
                            break;
                        default:
                            Method.clearScreen();
                           play.backpackSound();
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
        //int count = 1;
        boolean key0 = false;
        boolean key1 = false;
        boolean key2 = false;
        for(Key a: keyRing) {
            if(a.getType() == 0){key0 = true;}
            if(a.getType() == 1){key1 = true;}
            if(a.getType() == 2){key2 = true;}
        }
        if(key0){System.out.println("A key with the number 0 on it");}
        if(key1){System.out.println("A key with the number 1 on it");}
        if(key2){System.out.println("A key with the number 2 on it");}
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

    //Robert: I did bit debugging here.
    //I added a new if statement, and I rearrnged bit the structure in the second part of the method.
    //it was causing a stack overflow because of the new output, but it had to be fixed anyway.
    public void addItemToBackpack(Consumable thing) {

        int countIndex = 0;
        printed = false;



        for(Consumable slot: backpack) {
            if (slot == null) {
                if (countIndex <= 4) {
                    backpack[countIndex] = thing;
                }
                //backpack[countIndex] = thing;
                //System.out.println("Your backpack is full!!!");

            } else {
                countIndex++;
            }
            if (backpack[countIndex] != null) {
                if(countIndex > 4) {
                    System.out.println("Your backpack is full!!!");
                } else
                    while (!printed){
                    System.out.printf("Item %s has been added to your backpack (Slot %d)%n", ColorPrint.ANSI_GREEN+thing.getName()
                            +ColorPrint.ANSI_RESET, countIndex);
                    printed = true;
                }
        }

            }

    }


    //Robert: I had to add this here. i know that I could use a setter for this one
    //but I wish to make the inventory and keyring methods to follow the same naming conventions.
    public void addKeyToKeyRing(Key key) {
        keyRing.add(key);
        System.out.println("A "+ColorPrint.ANSI_GREEN+"key"+ColorPrint.ANSI_RESET + " has been added to keyring");
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
    //Nemanja: Coppied this from method to fix input mismatch

    public int menuChoice(){
        input.reset();
        boolean successfulinput = false;
        while(!successfulinput){
            try{
                asd = input.nextInt();
                successfulinput = true;
            } catch(InputMismatchException a){
                input.nextLine();
                System.out.println("Please use only given options!");
            }
        } return asd;

    }

    public void makeThief(){
        setPlayerType("Thief");
        setHitChance(0.8);
        setMaxAttack(80);
        setHealth(300);
    }

    public void makeTourist(){
        setPlayerType("Tourist");
        setHitChance(0.7);
        setMaxAttack(80);
        setHealth(350);
    }

    public void makePriest(){
        setPlayerType("Priest");
        setHitChance(0.6);
        setMaxAttack(80);
        setHealth(400);
    }

    public void makeGhostHunter(){
        setPlayerType("Ghost-Hunter");
        setHitChance(0.6);
        setMaxAttack(100);
        setHealth(300);
    }


}
