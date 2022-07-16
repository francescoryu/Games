package util;

import home.Home;
import soccer.Soccer;
import tictactoe.TicTacToe;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author: Francesco Ryu
 * @date: 28.06.2022
 * @version: 1.0
 */

public class Main extends JFrame{
    JTabbedPane tabbedPane;
    TicTacToe ticTacToe;
    Soccer soccer;
    Home home;

    public Main() throws IOException {
        ticTacToe = new TicTacToe();
        home = new Home();
        soccer = new Soccer();

        tabbedPane = new JTabbedPane();
        tabbedPane.add("Home", home);
        tabbedPane.addTab("Tic-Tac-Toe", ticTacToe);
        tabbedPane.addTab("Soccer Sim", soccer);


        this.add(tabbedPane);
        this.setSize(new Dimension(900, 600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(150, 150);
        this.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        new Main();

    }
}
