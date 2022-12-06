package tictactoe;

import java.util.Arrays;

public class GameLogic {
    public static GameState getGameState(String[] cells) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            int index = i * 3;
            if (!" ".equals(cells[index]) && cells[index].equals(cells[index + 1]) && cells[index].equals(cells[index + 2])) {
                if ("X".equals(cells[index])) {
                    return GameState.X_WINS;
                } else {
                    return GameState.O_WINS;
                }
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (!" ".equals(cells[i]) && cells[i].equals(cells[i + 3]) && cells[i].equals(cells[i + 6])) {
                if ("X".equals(cells[i])) {
                    return GameState.X_WINS;
                } else {
                    return GameState.O_WINS;
                }
            }
        }

        // Check main diagonal
        if (!" ".equals(cells[0]) && cells[0].equals(cells[4]) && cells[0].equals(cells[8])) {
            if ("X".equals(cells[0])) {
                return GameState.X_WINS;
            } else {
                return GameState.O_WINS;
            }
        }

        // Check side diagonal
        if (!" ".equals(cells[2]) && cells[2].equals(cells[4]) && cells[2].equals(cells[6])) {
            if ("X".equals(cells[2])) {
                return GameState.X_WINS;
            } else {
                return GameState.O_WINS;
            }
        }

        // Check draw
        if (Arrays.stream(cells).noneMatch(" "::equals)) {
            return GameState.DRAW;
        }

        // Check game not started
        if (Arrays.stream(cells).allMatch(" "::equals)) {
            return GameState.GAME_IS_NOT_STARTED;
        }

        // Check which player's turn it is
        long countX = Arrays.stream(cells).filter("X"::equals).count();
        long countO = Arrays.stream(cells).filter("O"::equals).count();

        if (countX == countO) {
            return GameState.X_PLAYS;
        } else {
            return GameState.O_PLAYS;
        }
    }
}
