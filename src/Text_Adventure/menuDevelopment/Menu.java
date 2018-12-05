package Text_Adventure.menuDevelopment;

import Text_Adventure.Main;

import java.util.Scanner;

public class Menu {
    private String menuName;// not sure it will be used
    private String playerName;// used along the game

    /**playerName getter
     *
     * @return String
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * playerName setter
     *@param playerName
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Scanner in used to use input
     *
     */
    public static Scanner in = new Scanner(System.in);

    /**
     *constructor Menu
     * @param menuName
     */
    public Menu(String menuName) {
        this.menuName = menuName;
    }

    /**
     * constructor Menu
     */
    public Menu() {
    }

    /**
     *menuName getter
     * @return menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     *menuName setter
     */
    public void setMenuName() {
        this.menuName = menuName;
    }

    /**
     * playerName method
     * used to set the player name
     */
    public void playerName() {

        System.out.println("The cellar of the Vicarage of Borgvattnet .." +
                " \nAll over darkness has mastered this lost space, " +
                " \nbetween dimensions, on the border of the living and the dead. \n" +
                "\nThe space that once served life is now home of the monsters.");
        System.out.println("What is your name traveler?");
        Main.playerName= in.nextLine();
    }


    /**
     * Alex: This enum does not need to be used
     *       It was created in the beginning as an item to be used in development
     * enum playerType
     *
     */
    public enum playerType {
        THIEF("thief", 4, 0.5, 5), PRIEST("priest", 4, 0.5, 5
        ), GHOST_HUNTER("ghost hunter", 4, 0.5, 5), TOURIST("tourist", 4, 0.5, 5),
        PLAYER("player", 4, 0.5, 5);
        private String name;
        private int roomIndex;
        private double hitChance;
        private int maxAttack;

        /**
         * constructor playerType
         * @param name
         * @param roomIndex
         * @param hitChance
         * @param maxAttack
         */
        playerType(String name, int roomIndex, double hitChance, int maxAttack) {
            this.name = name;
            this.roomIndex = roomIndex;
            this.hitChance = hitChance;
            this.maxAttack = maxAttack;
        }

        /**
         * getter playerTypeName
         * @return name
         */
        public String getName() {
            return name;
        }


        /**
         * setter PlayerTypeName
         * @param name
         */
        public void setName(String name) {
            this.name = name;
        }


        /**
         * playerRoomIndex getter
         * @return int
         */
        public int getRoomIndex() {
            return roomIndex;
        }


        /**
         * playerRoomIndex setter
         * @param roomIndex
         */
        public void setRoomIndex(int roomIndex) {
            this.roomIndex = roomIndex;
        }

        /**
         * getter playerHitChance
         * @return double
         */
        public double getHitChance() {
            return hitChance;
        }

        /**
         * getter PlayerMaxAttack
         * @return int
         */
        public int getMaxAttack() {
            return maxAttack;
        }

        /**
         * PlayerMaxAttack setter
         * @param maxAttack
         */
        public void setMaxAttack(int maxAttack) {
            this.maxAttack = maxAttack;
        }

        /**
         *
         * @param hitChance
         */
        public void setHitChance(double hitChance) {
            this.hitChance = hitChance;
        }

        /**
         *
         * @return string
         */
        @Override
        public String toString() {
            return "playerType{}";
        }
    }

    /**
     * method choosePlayerType
     */
    public void choosePlayerType() {

        System.out.println("Hmmm .."+Main.playerName+", a household name, maybe fate brought you back .. or maybe just bad luck");
        System.out.println("What are you in this life .. " +
                "\n[1]\tA THIEF? " +
                "\n[2]\tA lost PRIEST in search of your lost faith?! HA HA HA!" +
                "\n[3]\tA haunted GHOST HUNTER ?" +
                "\n[4]\tOr maybe, just an annoying TOURIST?");
        Main.choice = in.nextInt();

        /**
         * Alex:Sunday the Hero and Character was not functional
         */
        switch (Main.choice) {
/*            case 1:
                playerType.PLAYER.name = playerType.THIEF.name;
                playerType.PLAYER.hitChance = playerType.THIEF.hitChance;
                playerType.PLAYER.maxAttack = playerType.THIEF.maxAttack;
                playerType.PLAYER.roomIndex = playerType.THIEF.roomIndex;
                break;
            case 2:
                playerType.PLAYER.name = playerType.PRIEST.name;
                playerType.PLAYER.hitChance = playerType.PRIEST.hitChance;
                playerType.PLAYER.maxAttack = playerType.PRIEST.maxAttack;
                playerType.PLAYER.roomIndex = playerType.PRIEST.roomIndex;
                break;
            case 3:
                playerType.PLAYER.name = playerType.GHOST_HUNTER.name;
                playerType.PLAYER.hitChance = playerType.GHOST_HUNTER.hitChance;
                playerType.PLAYER.maxAttack = playerType.GHOST_HUNTER.maxAttack;
                playerType.PLAYER.roomIndex = playerType.GHOST_HUNTER.roomIndex;
                break;
            case 4:
                playerType.PLAYER.name = playerType.TOURIST.name;
                playerType.PLAYER.hitChance = playerType.TOURIST.hitChance;
                playerType.PLAYER.maxAttack = playerType.TOURIST.maxAttack;
                playerType.PLAYER.roomIndex = playerType.TOURIST.roomIndex;
                break;*/
            case 1:
                playerType.PLAYER.name = playerType.THIEF.name;
                playerType.PLAYER.hitChance = playerType.THIEF.hitChance;
                playerType.PLAYER.maxAttack = playerType.THIEF.maxAttack;
                playerType.PLAYER.roomIndex = playerType.THIEF.roomIndex;
                break;
            case 2:
                playerType.PLAYER.name = playerType.PRIEST.name;
                playerType.PLAYER.hitChance = playerType.PRIEST.hitChance;
                playerType.PLAYER.maxAttack = playerType.PRIEST.maxAttack;
                playerType.PLAYER.roomIndex = playerType.PRIEST.roomIndex;
                break;
            case 3:
                playerType.PLAYER.name = playerType.GHOST_HUNTER.name;
                playerType.PLAYER.hitChance = playerType.GHOST_HUNTER.hitChance;
                playerType.PLAYER.maxAttack = playerType.GHOST_HUNTER.maxAttack;
                playerType.PLAYER.roomIndex = playerType.GHOST_HUNTER.roomIndex;
                break;
            case 4:
                playerType.PLAYER.name = playerType.TOURIST.name;
                playerType.PLAYER.hitChance = playerType.TOURIST.hitChance;
                playerType.PLAYER.maxAttack = playerType.TOURIST.maxAttack;
                playerType.PLAYER.roomIndex = playerType.TOURIST.roomIndex;
                break;
            default:
                System.out.println("You just started playing and already shaking your hand!" +
                        "\n\t MAKE A CHOICE BETWEEN 1,2,3 AND 4!");
        }
        System.out.println("OK... lets see how much a " + playerType.PLAYER.getName() + " worth!");
    }
}
