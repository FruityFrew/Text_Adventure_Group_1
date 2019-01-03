package Text_Adventure.Characters;

import Text_Adventure.menuDevelopment.ColorPrint;

import java.io.Serializable;
import java.security.SecureRandom;

public class Monster extends Character implements Serializable {

    private int monsterHealth;
    private int monsterAttack;
    private String monsterType;
    private int roomIndex;
    private double monsterHitChance;
    //Robert: If you wander why the fighting system works is because I did a patch
    //that solves the problem. The patch is located in the main constructor of the room class

    SecureRandom random = new SecureRandom();
    int [] monsterHealthValues = {150,200};
    int [] monsterAttackValues = {50,75,90,110};
    double[] monsterHitValues = {0.3, 0.4, 0.5};
    String [] monsterTypeValues = {"Ghost","Zombie","Chuncky", "Evil Spirit"};

    public Monster(){

        int monsterValueHealth = random.nextInt(monsterHealthValues.length);
        int monsterValueAttack = random.nextInt(monsterAttackValues.length);
        int monsterValueType = random.nextInt(monsterTypeValues.length);
        int monsterValueHitChance = random.nextInt(monsterHitValues.length);


        this.monsterHealth= monsterHealthValues[monsterValueHealth];
        this.monsterType=monsterTypeValues[monsterValueType];
        this.monsterAttack= monsterAttackValues[monsterValueAttack];
        this.monsterHitChance= monsterHitValues[monsterValueHitChance];
        this.roomIndex=roomIndex;
    }

    public int getMonsterAttack() {
        return monsterAttack;
    }

    public void setMonsterAttack(int monsterAttack) {
        this.monsterAttack = monsterAttack;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public String getMonsterType() {
        return monsterType;

    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public int getRoomIndex() {
        return roomIndex;
    }

    public void setRoomIndex(int roomIndex) {
        this.roomIndex = roomIndex;
    }

    public double getMonsterHitChance() {
        return monsterHitChance;
    }
}
