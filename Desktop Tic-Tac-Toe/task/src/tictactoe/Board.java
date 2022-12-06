package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Board extends JPanel {
    private static Logger logger;
    private static String currentPlayer = "X";
    private static final List<Button> buttons = new ArrayList<>();
    private static Player player1 = Player.HUMAN;
    private static Player player2 = Player.HUMAN;

    public Board() {
        String name = this.getClass().getName();
        logger = Logger.getLogger(name);
        logger.setLevel(Level.FINEST);

        this.setLayout(new GridLayout(3, 3));
        this.setFont(new Font("Arial", Font.BOLD, 32));

        for (ButtonEnum button: ButtonEnum.values()) {
            logger.info(String.format("Button with name %s was created", button.name()));
            Button jButton = new Button(button.name());
            buttons.add(jButton);
            this.add(jButton);
        }
    }

    public static String getCurrentPlayer() {
        if ("X".equals(currentPlayer)) {
            currentPlayer = "O";
            return "X";
        } else {
            currentPlayer = "X";
            return "O";
        }
    }

    public static void reset() {
        if ("Reset".equals(ToolBar.getResetStartButtonState())) {
            buttons.forEach(button -> button.setEnabled(false));
            for (Button button: buttons) {
                button.reset();
            }

            ToolBar.enablePlayerButtons();
            Board.checkState();
            currentPlayer = "X";

            logger.info("Game was reset.");
        } else {
            StatusBar.updateStatus(GameState.X_PLAYS);
            ToolBar.setResetStartButtonState(GameState.X_PLAYS);
            ToolBar.disablePlayerButtons();
            buttons.forEach(button -> button.setEnabled(true));
            logger.info("Game was started.");
        }
    }

    public static void start() {
        StatusBar.updateStatus(GameState.X_PLAYS);
        ToolBar.setResetStartButtonState(GameState.X_PLAYS);
        ToolBar.disablePlayerButtons();
        buttons.forEach(button -> button.setEnabled(true));
        logger.info("Game was started.");
    }

    public static void checkState() {
        String[] cells = new String[9];

        for (int i = 0; i < 9; i++) {
            cells[i] = buttons.get(i).getText();
        }

        GameState state = GameLogic.getGameState(cells);

        if (state != StatusBar.getGameState()) {
            StatusBar.updateStatus(state);

            switch (state) {
                case DRAW, O_WINS, X_WINS -> buttons.forEach(Button::setGameFinishedLook);
                case GAME_IN_PROGRESS, GAME_IS_NOT_STARTED -> buttons.forEach(Button::setGameInProgressLook);
                default -> {
                }
            }

            ToolBar.setResetStartButtonState(state);
        }
    }

    public static Player getPlayer1() {
        return player1;
    }

    public static void setPlayer1(Player player1) {
        Board.player1 = player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static void setPlayer2(Player player2) {
        Board.player2 = player2;
    }
}
