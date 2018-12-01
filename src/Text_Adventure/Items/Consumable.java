package Text_Adventure.Items;

public class Consumable extends Item {
    private int healthModifier;
Consumable coffee = new Consumable("Coffee", 100);
    /**
     * Nemanja: This is the constructor of the Consumable object.
     *
     * @param HealthModifier - int: The amount of health increase when consumed by Hero object.
     */
    public Consumable(String Name, int HealthModifier) {
        super(Name);
        this.healthModifier = HealthModifier;
    }

    /**
     * Nemanja: This returns the value of the amount of Health to be restored.
     *
     * @return int
     */
    public int getHealth() {
        return healthModifier;
    }
}
