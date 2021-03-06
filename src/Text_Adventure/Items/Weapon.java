package Text_Adventure.Items;

import java.io.Serializable;
import java.security.SecureRandom;

/**
 * @author Nemanja Negovanovic
 */
public class Weapon extends Item implements Serializable {
    private int damage;
    private String HeroType;
    private int favoriteEnemy;
    SecureRandom random = new SecureRandom();
//    Weapon cross = new Weapon("Cross", 100);
//    Weapon knife = new Weapon("Knife", 100);
//    Weapon rose = new Weapon("Rose", 100);
//    Weapon shotgun = new Weapon("Shotgun", 100);
    
    /**
     * Nemanja: This is the constructor of the Weapon object.
     *
     * @param damage - int: The amount of health damage dealt to an enemy object.
     */
    public Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
        this.favoriteEnemy = random.nextInt(3);

    }

    /**
     * Nemanja: This returns the amount of health damage dealt to an enemy object.
     *
     * @return int
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Nemanja: This returns hero type (Thief, Priest, Tourist and GhostHunter)
     *
     * @return - String: The type of Hero that carries weapon.
     */
    public String getHeroType() {
        return HeroType;
    }

    /**
     * Nemanja: This sets HeroType String to the value of a Hero type.
     *
     * @param heroType - String: The type of a Hero
     */

    public void setHeroType(String heroType) {
        HeroType = heroType;
    }

    public int getFavoriteEnemy() {
        return favoriteEnemy;
    }
}