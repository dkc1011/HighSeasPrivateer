import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI {
    public static JFrame gameWindow = new JFrame("High Seas Privateer");

    public static void createGUI()
    {
        gameWindow.setVisible(true);
        gameWindow.setSize(800, 600);
        gameWindow.setResizable(false);
        gameWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameWindow.setLayout(new FlowLayout());
    }

    public static void createButton(String buttonText, int buttonWidth, int buttonHeight)
    {
        JButton button = new JButton(buttonText);

        button.setSize(buttonWidth, buttonHeight);

        gameWindow.add(button);
    }
}
