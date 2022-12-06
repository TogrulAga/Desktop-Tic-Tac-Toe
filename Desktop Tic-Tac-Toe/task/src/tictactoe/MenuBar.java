package tictactoe;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuBar extends JMenuBar {
    private static Logger logger;
    public MenuBar() {
        String name = this.getClass().getName();
        logger = Logger.getLogger(name);
        logger.setLevel(Level.FINEST);

        JMenu menuGame = new JMenu("Game");
        menuGame.setName("MenuGame");

        JMenuItem menuHumanHuman = new JMenuItem("Human vs Human");
        menuHumanHuman.setName("MenuHumanHuman");
        menuHumanHuman.addActionListener(e -> {
            Board.setPlayer1(Player.HUMAN);
            ToolBar.setButtonPlayer1Text(Player.HUMAN);
            Board.setPlayer2(Player.HUMAN);
            ToolBar.setButtonPlayer2Text(Player.HUMAN);
            logger.info(String.format("Game mode was changed to %s vs %s", Board.getPlayer1().getName(), Board.getPlayer2().getName()));

            Board.start();
        });
        menuGame.add(menuHumanHuman);

        JMenuItem menuHumanRobot = new JMenuItem("Human vs Robot");
        menuHumanRobot.setName("MenuHumanRobot");
        menuHumanRobot.addActionListener(e -> {
            Board.setPlayer1(Player.HUMAN);
            ToolBar.setButtonPlayer1Text(Player.HUMAN);
            Board.setPlayer2(Player.ROBOT);
            ToolBar.setButtonPlayer2Text(Player.ROBOT);
            logger.info(String.format("Game mode was changed to %s vs %s", Board.getPlayer1().getName(), Board.getPlayer2().getName()));

            Board.start();
        });
        menuGame.add(menuHumanRobot);

        JMenuItem menuRobotHuman = new JMenuItem("Robot vs Human");
        menuRobotHuman.setName("MenuRobotHuman");
        menuRobotHuman.addActionListener(e -> {
            Board.setPlayer1(Player.ROBOT);
            ToolBar.setButtonPlayer1Text(Player.ROBOT);
            Board.setPlayer2(Player.HUMAN);
            ToolBar.setButtonPlayer2Text(Player.HUMAN);
            logger.info(String.format("Game mode was changed to %s vs %s", Board.getPlayer1().getName(), Board.getPlayer2().getName()));

            Board.start();
        });
        menuGame.add(menuRobotHuman);

        JMenuItem menuRobotRobot = new JMenuItem("Robot vs Robot");
        menuRobotRobot.setName("MenuRobotRobot");
        menuRobotRobot.addActionListener(e -> {
            Board.setPlayer1(Player.ROBOT);
            ToolBar.setButtonPlayer1Text(Player.ROBOT);
            Board.setPlayer2(Player.ROBOT);
            ToolBar.setButtonPlayer2Text(Player.ROBOT);
            logger.info(String.format("Game mode was changed to %s vs %s", Board.getPlayer1().getName(), Board.getPlayer2().getName()));

            Board.start();
        });
        menuGame.add(menuRobotRobot);

        menuGame.addSeparator();

        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.setName("MenuExit");
        menuGame.add(menuExit);

        this.add(menuGame);
    }
}
