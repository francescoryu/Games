package TicTacToe;

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

    JLabel label;

    boolean player1Turn;

    public TicTacToe() {

        Font labelFont = new Font("Monaco", Font.BOLD, 20);


        infoPanel = new JPanel();
        infoPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
        infoPanel.setPreferredSize(new Dimension(0, 47));

        label = new JLabel("Welcome");
        label.setFont(labelFont);
        infoPanel.add(label);

        playGroundPanel = new JPanel();
        playGroundPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            btnArray[i] = new JButton();
            btnArray[i].addActionListener(this::actionPerformed);
            btnArray[i].setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
            playGroundPanel.add(btnArray[i]);
        }


        this.add(infoPanel, BorderLayout.NORTH);
        this.add(playGroundPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(333, 380);
        this.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        Font buttonFont = new Font("Monaco", Font.BOLD, 50);
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == btnArray[i]) {
                if (player1Turn) {
                    if (btnArray[i].getText().equals("")) {
                        btnArray[i].setText("X");
                        btnArray[i].setFont(buttonFont);
                        label.setText("O Turn");
                        player1Turn = false;
                        //btnArray[i].setEnabled(false);
                        btnArray[i].setForeground(Color.BLACK);
                        winnerCheck();
                    }
                } else {
                    if (btnArray[i].getText().equals("")) {
                        btnArray[i].setText("O");
                        btnArray[i].setFont(buttonFont);
                        player1Turn = true;
                        label.setText("X Turn");
                        btnArray[i].setForeground(Color.RED);
                        //btnArray[i].setEnabled(false);

                    }
                }
            }
        }
    }
    public void winnerCheck() {
        if (btnArray[0].getText().equals("X") && btnArray[1].getText().equals("X") && btnArray[2].getText().equals("X")) {
            xWin(0, 1, 2);
        }

    }

    public void xWin(int btn1, int btn2, int btn3) {
        btnArray[btn1].setBackground(Color.BLUE);
        btnArray[btn2].setBackground(Color.BLUE);
        btnArray[btn3].setBackground(Color.BLUE);

        for (int i = 0; i < 9; i++) {
            btnArray[i].setEnabled(false);
        }
    }

}
