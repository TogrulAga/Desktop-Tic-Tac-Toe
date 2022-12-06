package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    public TicTacToe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setResizable(false);
        setSize(450, 450);


        this.setLayout(new BorderLayout());

        this.add(new ToolBar(), BorderLayout.NORTH);

        this.add(new Board(), BorderLayout.CENTER);

        this.add(new StatusBar(), BorderLayout.SOUTH);
        this.setJMenuBar(new MenuBar());

        setVisible(true);
    }
}