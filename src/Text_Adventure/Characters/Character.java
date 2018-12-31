package Text_Adventure.Characters;

import Text_Adventure.menuDevelopment.ColorPrint;

import java.io.Serializable;
import java.util.Random;

public class Character implements Serializable {
    private String name;
    private int roomIndex;
    private double hitChance;
    private int maxAttack;
    private int health;
    private String playerType;
    private boolean dead = false; //Robert: we need that to know when the hero or the monster dies


    public Character() {
        this(null, 0, 0.5, 50, 200," ");
    }

    public Character(String name, int index, double hitChance, int attack, int health, String playerType) {
        this.name = name;
        roomIndex = index;
        this.hitChance = hitChance;
        maxAttack = attack;
        this.health = health;
        this.playerType=playerType;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    /**
     * Setter for name
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Setter for roomIndex
     *
     * @param index
     */
    public void setRoomIndex(int index) { roomIndex = index; }

    /**
     * Setter for hitChance
     * @param hitChance
     */
    public void setHitChance(double hitChance) { this.hitChance = hitChance; }

    /**
     * Setter for maxAttack
     * @param attack
     */
    public void setMaxAttack(int attack) { maxAttack = attack; }

    /**
     * Setter for health
     * @param health
     */
    public void setHealth(int health) { this.health = health; }

    /**
     * Getter for name
     *
     * @return name
     */
    public String getName() { return name; }

    /**
     * Getter for roomIndex
     *
     * @return roomIndex
     */
    public int getRoomIndex() { return roomIndex; }

    /**
     * Getter for hitChance
     *
     * @return hitChance
     */
    public double getHitChance() { return hitChance; }

    /**
     * Getter for maxAttack
     *
     * @return
     */
    public int getMaxAttack() { return maxAttack; }

    /**
     * Getter for health
     *
     * @return
     */
    public int getHealth() { return health; }
    /**
     * Method that every character has; during a fight hero will be exchanging strikes with a monster and their
     * dealt damage will be calculated with the following method.
     * Robert: I added one more parameter to enable the weaponModifier to take place.
     *
     *
     * @return
     */
    public static int generateDamage(double hitChance, int maxAttack, int weaponModifier) {
        maxAttack = maxAttack + weaponModifier;
        Random number = new Random();
        return (hitChance > number.nextDouble()) ? maxAttack - number.nextInt(maxAttack): 0;
    }

    /**
     * Prints the info of the character
     *
     * @return
     */
    public String toString() {
        return String.format("Character: %s%n" +
                "Health: %d%n" +
                "Hit-Chance: %.2f%n" +
                "Max attack: %d%n", name, health, hitChance, maxAttack);
    }

    //Robert: when it is comming to heal a simple setter is not the best choice.
    public void addHealth(int points){
        System.out.println("Your health has been replenished by "+ColorPrint.ANSI_YELLOW+points+ColorPrint.ANSI_RESET +
                " health points!");
        health = health + points;
    }

    public  void subtractHealth(int points){
        System.out.println(points + " subtrackted from your health");
        health = health - points;
    }
}
