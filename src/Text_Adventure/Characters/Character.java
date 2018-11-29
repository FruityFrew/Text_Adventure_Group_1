package Text_Adventure.Characters;

import java.util.Random;

public class Character {
    private String name;
    private int roomIndex;
    private double hitChance;
    private int maxAttack;

    //Set of constructors that are defined through setters (which show up later)
    public Character() {
        this(null, -1, 0.5, 50);
    }
    public Character(String name) {
        this(name, -1, 0.5, 50);
    }
    public Character(String name, int index, double hitChance) { this(name, -1, hitChance, 50); }
    public Character(String name, int index, double hitChance, int attack) {
        setName(name);
        setRoomIndex(index);
        setHitChance(hitChance);
        setMaxAttack(attack);
    }

    //setters for name and roomIndex
    public void setName(String name) { this.name = name; }
    public void setRoomIndex(int index) { roomIndex = index; }
    public void setHitChance(double chance) { hitChance = chance; }
    public void setMaxAttack(int attack) { maxAttack = attack; }

    //getters for name and roomIndex
    public String getName() { return name; }
    public int getRoomIndex() { return roomIndex; }
    public double getHitChance() { return hitChance; }
    public int getMaxAttack() { return maxAttack; }

    public int doAttack() {
        Random number = new Random();
        return (hitChance > number.nextDouble()) ? maxAttack - number.nextInt(maxAttack): 0;
    }



    public static void main(String[] args) {
    }
}
