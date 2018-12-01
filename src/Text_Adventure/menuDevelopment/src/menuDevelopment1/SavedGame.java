package menuDevelopment1;

public class SavedGame {
    private String saveGameName;

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
