package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatusBar extends JPanel {
    private static GameState gameState = GameState.GAME_IS_NOT_STARTED;
    private static Logger logger;
    private static JLabel statusLabel;
    public StatusBar() {
        String name = this.getClass().getName();
        logger = Logger.getLogger(name);
        logger.setLevel(Level.FINEST);

        this.setLayout(new BorderLayout());

        statusLabel = new JLabel();
        statusLabel.setName("LabelStatus");
        statusLabel.setText(GameState.GAME_IS_NOT_STARTED.getStateString());
        this.add(statusLabel, BorderLayout.WEST);
    }

    public static void updateStatus(GameState gameState) {
        setGameState(gameState);

        if (gameState.equals(GameState.X_PLAYS) || gameState.equals(GameState.X_WINS)) {
            statusLabel.setText(String.format(gameState.getStateString(), Board.getPlayer1().getName()));
        } else if (gameState.equals(GameState.O_PLAYS) || gameState.equals(GameState.O_WINS)) {
            statusLabel.setText(String.format(gameState.getStateString(), Board.getPlayer2().getName()));
        } else {
            statusLabel.setText(gameState.getStateString());
        }
    }

    public static GameState getGameState() {
        return gameState;
    }

    public static void setGameState(GameState gameState) {
        logger.info(String.format("Game state changed from '%s' to '%s'", StatusBar.gameState.getStateString(), gameState.getStateString()));
        StatusBar.gameState = gameState;
    }
}
