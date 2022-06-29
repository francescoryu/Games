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
    JPanel playPanel;
    JPanel playerNamePanel;
    JPanel emptyPanel;

    JCheckBox reversePlayer;

    JTextField inputPlayer1;
    JTextField inputPlayer2;

    JButton[] btnArray = new JButton[9];
    JButton restartButton;

    JLabel label;
    JLabel player1Label;
    JLabel player2Label;

    boolean player1Turn = false;

    public TicTacToe() {
        Font labelFont = new Font("Monaco", Font.BOLD, 20);
        Font nameFont = new Font("Monaco", Font.BOLD, 14);

        emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(200, 200));

        playerNamePanel = new JPanel();
        inputPlayer1 = new JTextField();
        inputPlayer1.setColumns(15);
        inputPlayer1.setFont(nameFont);
        inputPlayer2 = new JTextField();
        inputPlayer2.setColumns(15);
        inputPlayer2.setFont(nameFont);
        player1Label = new JLabel("Player 1");
        player1Label.setFont(nameFont);
        player2Label = new JLabel("Player 2");
        player2Label.setFont(nameFont);
        reversePlayer = new JCheckBox("Change starting player");
        reversePlayer.setFont(nameFont);


        playerNamePanel.add(player1Label);
        playerNamePanel.add(inputPlayer1);
        playerNamePanel.add(player2Label);
        playerNamePanel.add(inputPlayer2);
        playerNamePanel.add(reversePlayer);
        playerNamePanel.setPreferredSize(new Dimension(200, 200));

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
            /**
             * Checks if the checkbox is selected. This will decide who will start the game
             */
            if (reversePlayer.isSelected()) {
                player1Turn = false;
                label.setText(inputPlayer2.getText() + " starts");
            }
            else {
                player1Turn = true;
                label.setText(inputPlayer1.getText() + " starts");
            }
        });

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(333, 47));
        buttonPanel.add(restartButton);

        playPanel = new JPanel();

        playPanel.add(infoPanel);
        playPanel.add(playGroundPanel);
        playPanel.add(buttonPanel);
        playPanel.setPreferredSize(new Dimension(333, 470));


        this.add(playerNamePanel, BorderLayout.WEST);
        this.add(playPanel);
        this.add(emptyPanel);

    }

    //Checks who's turn it is
    public void actionPerformed(ActionEvent e) {
        Font buttonFont = new Font("Monaco", Font.BOLD, 50);
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == btnArray[i]) {
                if (player1Turn) {
                    if (btnArray[i].getText().equals("")) {
                        btnArray[i].setText("X");
                        btnArray[i].setFont(buttonFont);
                        label.setText(inputPlayer2.getText() + "'s turn");
                        player1Turn = false;
                        //btnArray[i].setEnabled(false);
                        btnArray[i].setForeground(Color.BLACK);
                        winnerCheck();
                    }
                } else {
                    if (btnArray[i].getText().equals("")) {
                        btnArray[i].setText("O");
                        btnArray[i].setFont(buttonFont);
                        label.setText(inputPlayer1.getText() + "'s turn");
                        player1Turn = true;
                        btnArray[i].setForeground(Color.RED);
                        winnerCheck();

                    }
                }
            }
        }
    }

    /**
     * This method goes through every possible combination for O and X to show the winner
     */
    public void winnerCheck() {
            //Checks X for rows
            if (btnArray[0].getText().equals("X") && btnArray[1].getText().equals("X") && btnArray[2].getText().equals("X")) {
                xWin(0, 1, 2);
                label.setText(inputPlayer1.getText() + " Wins!");
            }
            if (btnArray[3].getText().equals("X") && btnArray[4].getText().equals("X") && btnArray[5].getText().equals("X")) {
                xWin(3, 4, 5);
                label.setText(inputPlayer1.getText() + " Wins!");
            }
            if (btnArray[6].getText().equals("X") && btnArray[7].getText().equals("X") && btnArray[8].getText().equals("X")) {
                xWin(6, 7, 8);
                label.setText(inputPlayer1.getText() + " Wins!");
            }
            //Checks X for columns
            if (btnArray[0].getText().equals("X") && btnArray[3].getText().equals("X") && btnArray[6].getText().equals("X")) {
                xWin(0, 3, 6);
                label.setText(inputPlayer1.getText() + " Wins!");
            }
            if (btnArray[1].getText().equals("X") && btnArray[4].getText().equals("X") && btnArray[7].getText().equals("X")) {
                xWin(1, 4, 7);
                label.setText(inputPlayer1.getText() + " Wins!");
            }
            if (btnArray[2].getText().equals("X") && btnArray[5].getText().equals("X") && btnArray[8].getText().equals("X")) {
                xWin(2, 5, 8);
                label.setText(inputPlayer1.getText() + " Wins!");
            }
            //Checks X for diagonale
            if (btnArray[0].getText().equals("X") && btnArray[4].getText().equals("X") && btnArray[8].getText().equals("X")) {
                xWin(0, 4, 8);
                label.setText(inputPlayer1.getText() + " Wins!");
            }
            if (btnArray[2].getText().equals("X") && btnArray[4].getText().equals("X") && btnArray[6].getText().equals("X")) {
                xWin(2, 4, 6);
                label.setText(inputPlayer1.getText() + " Wins!");
            }

            //Checks O for rows
            if (btnArray[0].getText().equals("O") && btnArray[1].getText().equals("O") && btnArray[2].getText().equals("O")) {
                Owin(0, 1, 2);
                label.setText(inputPlayer2.getText() + " Wins!");
            }
            if (btnArray[3].getText().equals("O") && btnArray[4].getText().equals("O") && btnArray[5].getText().equals("O")) {
                Owin(3, 4, 5);
                label.setText(inputPlayer2.getText() + " Wins!");
            }
            if (btnArray[6].getText().equals("O") && btnArray[7].getText().equals("O") && btnArray[8].getText().equals("O")) {
                Owin(6, 7, 8);
                label.setText(inputPlayer2.getText() + " Wins!");
            }
            //Checks O for columns
            if (btnArray[0].getText().equals("O") && btnArray[3].getText().equals("O") && btnArray[6].getText().equals("O")) {
                Owin(0, 3, 6);
                label.setText(inputPlayer2.getText() + " Wins!");
            }
            if (btnArray[1].getText().equals("O") && btnArray[4].getText().equals("O") && btnArray[7].getText().equals("O")) {
                Owin(1, 4, 7);
                label.setText(inputPlayer2.getText() + " Wins!");
            }
            if (btnArray[2].getText().equals("O") && btnArray[5].getText().equals("O") && btnArray[8].getText().equals("O")) {
                Owin(2, 5, 8);
                label.setText(inputPlayer2.getText() + " Wins!");
            }
            //Checks O for diagonale
            if (btnArray[0].getText().equals("O") && btnArray[4].getText().equals("O") && btnArray[8].getText().equals("O")) {
                Owin(0, 4, 8);
                label.setText(inputPlayer2.getText() + " Wins!");
            }
            if (btnArray[2].getText().equals("O") && btnArray[4].getText().equals("O") && btnArray[6].getText().equals("O")) {
                Owin(2, 4, 6);
                label.setText(inputPlayer2.getText() + " Wins!");
            }

        }

    /**
     * This method sets the winner's button red
     */



    public void xWin(int btn1, int btn2, int btn3) {
        btnArray[btn1].setBackground(Color.RED);
        btnArray[btn2].setBackground(Color.RED);
        btnArray[btn3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            btnArray[i].setEnabled(false);
        }
    }

    /**
     * This method sets the winner's button red
     */

    public void Owin(int btn1, int btn2, int btn3) {
        btnArray[btn1].setBackground(Color.RED);
        btnArray[btn2].setBackground(Color.RED);
        btnArray[btn3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            btnArray[i].setEnabled(false);
        }
    }

}
