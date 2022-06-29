import TicTacToe.TicTacToe;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    JTabbedPane tabbedPane;
    TicTacToe ticTacToe;
    public Main() {
        ticTacToe = new TicTacToe();
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("TicTacToe", ticTacToe);

        this.add(tabbedPane);
        this.setSize(new Dimension(900, 600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        new Main();

    }
}
