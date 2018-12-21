package Text_Adventure.menuDevelopment;

import Text_Adventure.Room;

import java.io.Serializable;

public class SavedGame implements Serializable {
    private String saveGameName;

    Room[] savedGames = new Room[10];

    public SavedGame(String saveGameName) {
        this.saveGameName = saveGameName;
    }

    public void setSaveGameName(String saveGameName) {
        this.saveGameName = saveGameName;
    }

    public String getSaveGameName() {
        return saveGameName;
    }
}
