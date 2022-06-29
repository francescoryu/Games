import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: Francesco Ryu
 * @date: 28.06.2022
 * @version: 1.0
 */

public class TicTacToe extends JFrame {

    JPanel infoPanel;
    JPanel playGroundPanel;
    JButton[] btnArray = new JButton[9];

    boolean player1Turn;

    public TicTacToe() {

        infoPanel = new JPanel();
        infoPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
        infoPanel.setPreferredSize(new Dimension(0, 47));

        playGroundPanel = new JPanel();
        playGroundPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            btnArray[i] = new JButton();
            btnArray[i].addActionListener(this::actionPerformed);
            playGroundPanel.add(btnArray[i]);
        }



        this.add(infoPanel, BorderLayout.NORTH);
        this.add(playGroundPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(333, 380);
        this.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == btnArray[i]) {
                if (player1Turn) {
                    if (btnArray[i].getText().equals("")) {
                        btnArray[i].setText("X");
                        player1Turn = false;
                    }
                } else {
                    if (btnArray[i].getText().equals("")) {
                        btnArray[i].setText("O");
                        player1Turn = true;
                    }
                }
            }
        }
    }

}
