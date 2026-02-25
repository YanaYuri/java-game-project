package rushHour_v7;

public class Player {
    private int playerID;
    private String playerName;

    public Player(int playerID, String playerName) {
        this.playerID = playerID;
        this.playerName = playerName;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String toString() {
        return String.format("PlayerID: %d, PlayerName: %s", playerID, playerName);
    }
}
