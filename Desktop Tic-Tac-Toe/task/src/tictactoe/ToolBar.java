package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToolBar extends JPanel {
    private static Logger logger;
    private static JButton resetStartButton;
    private static JButton buttonPlayer1;
    private static JButton buttonPlayer2;

    public ToolBar() {
        String name = this.getClass().getName();
        logger = Logger.getLogger(name);
        logger.setLevel(Level.FINEST);

        this.setLayout(new GridLayout(1, 3));

        buttonPlayer1 = new JButton();
        buttonPlayer1.setName("ButtonPlayer1");
        buttonPlayer1.setText(Board.getPlayer1().getName());
        buttonPlayer1.addActionListener(e -> {
            logger.info(String.format("Player 1 switched to %s player.", Board.getPlayer1().getOpposite().getName()));
            Board.setPlayer1(Board.getPlayer1().getOpposite());
            buttonPlayer1.setText(Board.getPlayer1().getName());
        });
        this.add(buttonPlayer1);

        resetStartButton = new JButton();
        resetStartButton.setName("ButtonStartReset");
        resetStartButton.setText("Start");
        resetStartButton.setForeground(Color.white);
        resetStartButton.setBackground(Color.BLACK);
        resetStartButton.addActionListener(e -> {
            Board.reset();
        });
        this.add(resetStartButton);

        buttonPlayer2 = new JButton();
        buttonPlayer2.setName("ButtonPlayer2");
        buttonPlayer2.setText(Board.getPlayer2().getName());
        buttonPlayer2.addActionListener(e -> {
            logger.info(String.format("Player 2 switched to %s player.", Board.getPlayer2().getOpposite().getName()));
            Board.setPlayer2(Board.getPlayer2().getOpposite());
            buttonPlayer2.setText(Board.getPlayer2().getName());
        });
        this.add(buttonPlayer2);
    }

    public static void setResetStartButtonState(GameState state) {
        switch (state) {
            case GAME_IN_PROGRESS, DRAW, O_WINS, X_WINS, X_PLAYS, O_PLAYS -> resetStartButton.setText("Reset");
            case GAME_IS_NOT_STARTED -> resetStartButton.setText("Start");
            default -> {
            }
        }
    }

    public static String getResetStartButtonState() {
        return resetStartButton.getText();
    }

    public static void disablePlayerButtons() {
        buttonPlayer1.setEnabled(false);
        buttonPlayer2.setEnabled(false);
    }

    public static void enablePlayerButtons() {
        buttonPlayer1.setEnabled(true);
        buttonPlayer2.setEnabled(true);
    }

    public static void setButtonPlayer1Text(Player player) {
        buttonPlayer1.setText(player.getName());
    }

    public static void setButtonPlayer2Text(Player player) {
        buttonPlayer2.setText(player.getName());
    }
}
