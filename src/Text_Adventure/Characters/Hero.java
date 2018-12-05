package Text_Adventure.Characters;

import Text_Adventure.Items.Consumable;
import Text_Adventure.Items.Item;

public class Hero extends Character {
    Item[] backpack = new Item[5];

    public Hero(int heroNumber) {
        switch(heroNumber) {
            case 1://hero hunter
                setName("Ghost-Hunter");
                setRoomIndex(1);
                setHitChance(0.6);
                setMaxAttack(100);
                break;
            default:
                setName("Hero");
                setRoomIndex(1);
                setHitChance(0.6);
                setMaxAttack(80);
                break;
        }

    }

    public void viewContentsOfBackpack() {
        System.out.println("Backpack:");
        for(Item a: backpack) {
            if(a != null) System.out.printf("[%s]%n", a.getName());
            else System.out.println("[-Empty slot-]");
        }
    }

    public void addItemToBackpack(Item thing) {

        int countIndex = 0;

        for(Item slot: backpack) {
            if(slot == null) {
                backpack[countIndex] = thing;
                System.out.printf("Item %s has been added to your backpack (Slot %d)%n", thing.getName(), countIndex);
            }else {
                countIndex++;
            }
        }
        if(countIndex > 4) {
            System.out.println("Your backpack is full!!!");
        }
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

    public static void main(String[] args) {
        Hero newHero = new Hero(1);

        System.out.println(newHero.toString());
        System.out.println("------------------------");
        newHero.viewContentsOfBackpack();

        Consumable potion = new Consumable("Cup of tea", 100);

        newHero.addItemToBackpack(potion);
        System.out.println("------------------------");
        newHero.viewContentsOfBackpack();
        System.out.println("------------------------");

        System.out.println(newHero.toString());
        System.out.println("------------------------");

        newHero.consumeItem(potion);
        System.out.println(newHero.toString());
    }
}
