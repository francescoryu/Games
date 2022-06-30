package home;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

/**
 * @author: Francesco Ryu
 * @date: 28.06.2022
 * @version: 1.0
 */

public class Home extends JPanel {

    JPanel labelPanel;
    JPanel contentPanel;
    JPanel buttonPanel;

    JButton exitButton;
    JButton linkButton;
    JButton submitButton;

    JTextField inputUser;
    JTextArea questionSuggestions;

    JTextField outputAI;
    JLabel welcomeLabel;
    JLabel imgLabel;

    public Home() {
        this.setLayout(new BorderLayout());

        Font welcomeFont = new Font(Font.SERIF, Font.PLAIN, 40);
        Font contentFont = new Font(Font.SERIF, Font.PLAIN, 20);

        labelPanel = new JPanel();
        labelPanel.setBackground(Color.decode("#75adbe"));
        welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setFont(welcomeFont);
        labelPanel.add(welcomeLabel);
        //labelPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));


        contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(200, 0));
        contentPanel.setBackground(Color.decode("#75adbe"));
        //contentPanel.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));

        inputUser = new JTextField(33);
        inputUser.setFont(contentFont);
        inputUser.requestFocus();

        submitButton = new JButton("Submit");
        submitButton.setFont(contentFont);

        outputAI = new JTextField("Bob");
        outputAI.setEditable(false);
        outputAI.setBackground(Color.WHITE);
        outputAI.setPreferredSize(new Dimension(400, 50));
        outputAI.setBorder(new MatteBorder(5, 5, 5, 5, Color.BLACK));
        outputAI.setFont(contentFont);
        outputAI.setHorizontalAlignment(JTextField.CENTER);



        submitButton.addActionListener(e -> {
            inputUser.requestFocus();
            if (
                            inputUser.getText().equals("hello") ||
                            inputUser.getText().equals("hi") ||
                            inputUser.getText().equals("hey")
            ) {
                outputAI.setText("hello, welcome!");
            }
            if (inputUser.getText().equals("how are you?")) {
                outputAI.setText("I am good, thank you for asking, and you?");
            }
            if (
                            inputUser.getText().equals("excellent") ||
                            inputUser.getText().equals("good") ||
                            inputUser.getText().equals("alright")
            ) {
                outputAI.setText("that is good to hear!");
            }
            if (
                            inputUser.getText().equals("not so good") ||
                            inputUser.getText().equals("bad") ||
                            inputUser.getText().equals("shits")
            ) {
                outputAI.setText("oh no, it will be alright!!!");
            }
            if (inputUser.getText().equals("what is your name?")) {
                outputAI.setText("My name is Bob, it's my pleasure");
            }
            if (inputUser.getText().equals("what is your occupation?")) {
                outputAI.setText("I am currently a student. I study at the KSH");
            }
            if (inputUser.getText().equals("goodnight bob")) {
                outputAI.setText("goodnight, sleep well!!!");
            }
            if (inputUser.getText().equals("how old are you?")) {
                outputAI.setText("I'm very young, I was born on the 18.06.2021!");
            }
            if (inputUser.getText().equals("what are you doing?")) {
                outputAI.setText("I'm talking to you, of course");
            }
            if (inputUser.getText().equals("why are you gae?")) {
                outputAI.setText("who says I'm gae?");
            }
            if (inputUser.getText().equals("who made you?")) {
                outputAI.setText("I'm a child from Francesco and Dianyra");
            }
            if (inputUser.getText().equals("rickroll")) {
                outputAI.setText("I trolled you");
                try {
                    Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ").toURI());
                } catch (Exception ev) {}
            }
            inputUser.setText("");
        });


        questionSuggestions = new JTextArea();
        questionSuggestions.setPreferredSize(new Dimension(565, 170));
        questionSuggestions.setFont(contentFont);
        questionSuggestions.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
        imgLabel = new JLabel();
        ImageIcon imgIcon = new ImageIcon("C:\\Users\\franc\\Games\\src\\util\\robot.png");

        imgLabel.setIcon(imgIcon);

        contentPanel.add(inputUser);
        contentPanel.add(submitButton);
        contentPanel.add(questionSuggestions);
        contentPanel.add(outputAI);
        contentPanel.add(imgLabel);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#75adbe"));

        this.add(contentPanel, BorderLayout.CENTER);
        this.add(labelPanel, BorderLayout.NORTH);
        this.setBackground(Color.decode("#75adbe"));
    }
}
