package Text_Adventure.Items;

public class Weapon extends Item {
    private int damage;

    /**
     * Nemanja: This is the constructor of the Weapon object.
     *
     * @param damage - int: The amount of health damage dealt to an enemy object.
     */
    public Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    /**
     * Nemanja: This returns the amount of health damage dealt to an enemy object.
     *
     * @return int
     */
    public int getDamage() {
        return damage;
    }
}