import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Francesco Ryu
 * @date: 28.06.2022
 * @version: 1.0
 */

public class TicTacToe extends JFrame {

    JPanel infoPanel;
    JPanel playGroundPanel;
    List<JButton> buttonList;

    public TicTacToe() {

        infoPanel = new JPanel();
        infoPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
        infoPanel.setPreferredSize(new Dimension(0, 47));

        playGroundPanel = new JPanel();
        playGroundPanel.setLayout(new GridLayout(3, 3));

        this.add(infoPanel, BorderLayout.NORTH);
        this.add(playGroundPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(333, 380);
        this.setVisible(true);
    }
}
