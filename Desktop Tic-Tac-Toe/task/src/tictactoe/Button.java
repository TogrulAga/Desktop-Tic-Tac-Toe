package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Button extends JButton {
    private boolean occupied = false;

    public Button(String name) {
        String className = this.getClass().getName();
        Logger logger = Logger.getLogger(className);
        logger.setLevel(Level.FINEST);

        this.setName(String.format("Button%s", name));
        this.setForeground(Color.BLACK);
        this.setBackground(Color.ORANGE);
        this.setText(" ");
        this.setFont(new Font("Arial", Font.BOLD, 48));
        this.setFocusPainted(false);
        this.setEnabled(false);

        this.addActionListener(e -> {
            logger.info(String.format("Button %s was clicked, Occupied = %b ", name, occupied));
            if (StatusBar.getGameState() == GameState.X_WINS ||
                    StatusBar.getGameState() == GameState.O_WINS ||
                    StatusBar.getGameState() == GameState.DRAW) {
                return;
            }
            if (!isOccupied()) {
                this.setText(Board.getCurrentPlayer());
                occupied = true;
            }

            Board.checkState();
        });
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void reset() {
        occupied = false;
        this.setText(" ");
    }

    public void setGameFinishedLook() {
        this.setBackground(Color.WHITE);
        this.setForeground(Color.GRAY);
    }

    public void setGameInProgressLook() {
        this.setBackground(Color.ORANGE);
        this.setForeground(Color.BLACK);
    }
}
