package TicTacToe;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: Francesco Ryu
 * @date: 28.06.2022
 * @version: 1.0
 */

public class TicTacToe extends JPanel {

    JPanel infoPanel;
    JPanel playGroundPanel;
    JPanel buttonPanel;
    JPanel wholePanel;

    JButton[] btnArray = new JButton[9];
    JButton restartButton;

    JLabel label;

    boolean player1Turn = false;

    public TicTacToe() {
        Font labelFont = new Font("Monaco", Font.BOLD, 20);


        infoPanel = new JPanel();
        infoPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
        infoPanel.setPreferredSize(new Dimension(333, 47));

        label = new JLabel("Welcome");
        label.setFont(labelFont);
        infoPanel.add(label);

        playGroundPanel = new JPanel();
        playGroundPanel.setLayout(new GridLayout(3, 3));
        playGroundPanel.setPreferredSize(new Dimension(333, 333));
        for (int i = 0; i < 9; i++) {
            btnArray[i] = new JButton();
            btnArray[i].addActionListener(this::actionPerformed);
            playGroundPanel.add(btnArray[i]);
            btnArray[i].setEnabled(false);
        }

        restartButton = new JButton("Restart");
        restartButton.setFont(labelFont);
        restartButton.addActionListener(e -> {
            for (int i = 0; i < 9; i++) {
                btnArray[i].setText("");
                btnArray[i].setBackground(null);
                label.setText("Welcome");
                btnArray[i].setEnabled(true);
            }
        });

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(333, 47));
        buttonPanel.add(restartButton);

        wholePanel = new JPanel();

        wholePanel.add(infoPanel);
        wholePanel.add(playGroundPanel);
        wholePanel.add(buttonPanel);
        wholePanel.setPreferredSize(new Dimension(333, 470));

        this.add(wholePanel, BorderLayout.CENTER);

    }
    public void actionPerformed(ActionEvent e) {
        Font buttonFont = new Font("Monaco", Font.BOLD, 50);
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == btnArray[i]) {
                if (player1Turn == true) {
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
                        winnerCheck();

                    }
                }
            }
        }
    }
    public void winnerCheck() {
            //Checks X for rows
            if (btnArray[0].getText().equals("X") && btnArray[1].getText().equals("X") && btnArray[2].getText().equals("X")) {
                xWin(0, 1, 2);
                label.setText("X Wins!");
            }
            if (btnArray[3].getText().equals("X") && btnArray[4].getText().equals("X") && btnArray[5].getText().equals("X")) {
                xWin(3, 4, 5);
                label.setText("X Wins!");
            }
            if (btnArray[6].getText().equals("X") && btnArray[7].getText().equals("X") && btnArray[8].getText().equals("X")) {
                xWin(6, 7, 8);
                label.setText("X Wins!");
            }
            //Checks X for columns
            if (btnArray[0].getText().equals("X") && btnArray[3].getText().equals("X") && btnArray[6].getText().equals("X")) {
                xWin(0, 3, 6);
                label.setText("X Wins!");
            }
            if (btnArray[1].getText().equals("X") && btnArray[4].getText().equals("X") && btnArray[7].getText().equals("X")) {
                xWin(1, 4, 7);
                label.setText("X Wins!");
            }
            if (btnArray[2].getText().equals("X") && btnArray[5].getText().equals("X") && btnArray[8].getText().equals("X")) {
                xWin(2, 5, 8);
                label.setText("X Wins!");
            }
            //Checks X for diagonale
            if (btnArray[0].getText().equals("X") && btnArray[4].getText().equals("X") && btnArray[8].getText().equals("X")) {
                xWin(0, 4, 8);
                label.setText("X Wins!");
            }
            if (btnArray[2].getText().equals("X") && btnArray[4].getText().equals("X") && btnArray[6].getText().equals("X")) {
                xWin(2, 4, 6);
                label.setText("X Wins!");
            }

            //Checks O for rows
            if (btnArray[0].getText().equals("O") && btnArray[1].getText().equals("O") && btnArray[2].getText().equals("O")) {
                Owin(0, 1, 2);
                label.setText("O Wins!");
            }
            if (btnArray[3].getText().equals("O") && btnArray[4].getText().equals("O") && btnArray[5].getText().equals("O")) {
                Owin(3, 4, 5);
                label.setText("O Wins!");
            }
            if (btnArray[6].getText().equals("O") && btnArray[7].getText().equals("O") && btnArray[8].getText().equals("O")) {
                Owin(6, 7, 8);
                label.setText("O Wins!");
            }
            //Checks O for columns
            if (btnArray[0].getText().equals("O") && btnArray[3].getText().equals("O") && btnArray[6].getText().equals("O")) {
                Owin(0, 3, 6);
                label.setText("O Wins!");
            }
            if (btnArray[1].getText().equals("O") && btnArray[4].getText().equals("O") && btnArray[7].getText().equals("O")) {
                Owin(1, 4, 7);
                label.setText("O Wins!");
            }
            if (btnArray[2].getText().equals("O") && btnArray[5].getText().equals("O") && btnArray[8].getText().equals("O")) {
                Owin(2, 5, 8);
                label.setText("O Wins!");
            }
            //Checks O for diagonale
            if (btnArray[0].getText().equals("O") && btnArray[4].getText().equals("O") && btnArray[8].getText().equals("O")) {
                Owin(0, 4, 8);
                label.setText("O Wins!");
            }
            if (btnArray[2].getText().equals("O") && btnArray[4].getText().equals("O") && btnArray[6].getText().equals("O")) {
                Owin(2, 4, 6);
                label.setText("O Wins!");
            }

        }



    public void xWin(int btn1, int btn2, int btn3) {
        btnArray[btn1].setBackground(Color.RED);
        btnArray[btn2].setBackground(Color.RED);
        btnArray[btn3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            btnArray[i].setEnabled(false);
        }
    }

    public void Owin(int btn1, int btn2, int btn3) {
        btnArray[btn1].setBackground(Color.RED);
        btnArray[btn2].setBackground(Color.RED);
        btnArray[btn3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            btnArray[i].setEnabled(false);
        }
    }

}
