package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class MethodTicTacToe {
    JButton[] btnArray = new JButton[9];

    public void winnerCheck() {
        if (btnArray[0].getText().equals("X") && btnArray[1].getText().equals("X") && btnArray[2].getText().equals("X"))
            System.out.println("XWINNER");
        xWin(0, 1, 2);
    }

    public void xWin(int btn1, int btn2, int btn3) {
        btnArray[btn1].setBackground(Color.BLUE);
        btnArray[btn2].setBackground(Color.BLUE);
        btnArray[btn3].setBackground(Color.BLUE);
    }
}
