package Text_Adventure.Items;

public class Treasure extends Item {
    private int points;

    public Treasure(String name, int points) {
        super(name);
        this.points = points;
    }

    public int addPoints() {
        return points;
    }
}
