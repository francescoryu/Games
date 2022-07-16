package soccer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * @author: Francesco Ryu
 * @date: 16.07.2022
 * @version: 1.0
 */

public class Soccer extends JPanel {

    JPanel teamLabelPanel;
    JPanel inputPanel1;
    JPanel inputPanel2;
    JPanel wholeInputPanel;

    JLabel team1Label;
    JLabel team2Label;

    JTextField teamInput1;
    JTextField teamInput2;
    public Soccer() {

        Font teamLabelFont = new Font(Font.SERIF, Font.PLAIN, 35);

        inputPanel1 = new JPanel();
        inputPanel1.setBackground(Color.decode("#75adbe"));
        inputPanel1.setBorder(new EmptyBorder(0, 20, 0, 20));
        //inputPanel1.setLayout(new BoxLayout(inputPanel1, BoxLayout.Y_AXIS));
        team1Label = new JLabel("Team 1");
        team1Label.setFont(teamLabelFont);
        teamInput1 = new JTextField(15);
        teamInput1.setFont(teamLabelFont);
        inputPanel1.add(team1Label);
        inputPanel1.add(teamInput1);

        inputPanel2 = new JPanel();
        inputPanel2.setBackground(Color.decode("#75adbe"));
        inputPanel2.setBorder(new EmptyBorder(0, 20, 0, 20));
        //inputPanel2.setLayout(new BoxLayout(inputPanel2, BoxLayout.Y_AXIS));
        team2Label = new JLabel("Team 2");
        team2Label.setFont(teamLabelFont);
        teamInput2 = new JTextField(15);
        teamInput2.setFont(teamLabelFont);
        inputPanel2.add(team2Label);
        inputPanel2.add(teamInput2);

        wholeInputPanel = new JPanel();
        wholeInputPanel.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        wholeInputPanel.setLayout(new GridLayout(1, 2));
        wholeInputPanel.add(inputPanel1);
        wholeInputPanel.add(inputPanel2);

        this.setLayout(new BorderLayout());
        this.add(wholeInputPanel, BorderLayout.CENTER);
        this.setBackground(Color.decode("#75adbe"));
        this.setVisible(true);
    }
    public String getTeamName1() {
        return teamInput1.getText();
    }
    public String getTeamName2() {
        return teamInput2.getText();
    }
}
