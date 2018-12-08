package Text_Adventure.Items;
/**
 * @author Nemanja Negovanovic
 */
public class Consumable extends Item {
    private int healthModifier;

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
    public int getHealthModifier() {
        return healthModifier;
    }


//    public enum potion{
//        COFFEE ("French Coffee", 50),
//        WHISKEY ("A Bottle of Whiskey", 20),
//        MAGIC_POTION ("Magic potion", 80);
//
//        private String potionName;
//        private int healthModifier;
//
//        /**
//         * Nemanja: This is the constructor for an Enum potion
//         *
//         * @param potionName - String: Name of a potion.
//         * @param healthModifier - int: Amount of replenished health.
//         */
//        potion(String potionName, int healthModifier) {
//            this.potionName = potionName;
//            this.healthModifier = healthModifier;
//        }
//
//        /**
//         * Nemanja: This returns Name of a potion
//         *
//         * @return returns String
//         */
//        public String getPotionName() {
//            return potionName;
//        }
//
//        /**
//         * Nemanja: This returns Amount of replenished health.
//         *
//         * @return returns int
//         */
//        public int getHealthModifier() {
//            return healthModifier;
//        }
//    }

}
