package Text_Adventure.Characters;

import java.util.Random;

public class Character {
    private String name;
    private int roomIndex;
    private double hitChance;
    private int maxAttack;


    public Character() {
        this(null, -1, 0.5, 50);
    }

    public Character(String name) {
        this(name, -1, 0.5, 50);
    }

    public Character(String name, int index) { this(name, index, 0.5, 50); }

    public Character(String name, int index, double hitChance) { this(name, index, hitChance, 50); }

    public Character(String name, int index, double hitChance, int attack) {
        setName(name);
        setRoomIndex(index);
        setHitChance(hitChance);
        setMaxAttack(attack);
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
     * Method that every character has; during a fight hero will be exchanging strikes with a monster and their
     * dealt damage will be calculated with the following method.
     *
     * @return attackDamage
     */
    public int doAttack() {
        Random number = new Random();
        int attackDamage = (hitChance > number.nextDouble()) ? maxAttack - number.nextInt(maxAttack): 0;
        return attackDamage;
    }
}
