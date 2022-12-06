package tictactoe;

public enum GameState {
    GAME_IS_NOT_STARTED("Game is not started"),
    GAME_IN_PROGRESS("Game in progress"),
    X_PLAYS("The turn of %s Player (X)"),
    O_PLAYS("The turn of %s Player (O)"),
    X_WINS("The %s Player (X) wins"),
    O_WINS("The %s Player (O) wins"),
    DRAW("Draw");

    private final String stateString;

    GameState(String stateString) {
        this.stateString = stateString;
    }

    public String getStateString() {
        return stateString;
    }
}
