package tictactoe;

public enum Player {
    HUMAN("Human"),
    ROBOT("Robot");

    private final String name;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Player getOpposite() {
        if (this == Player.ROBOT) {
            return HUMAN;
        } else {
            return ROBOT;
        }
    }
}