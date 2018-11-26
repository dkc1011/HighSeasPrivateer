//GUI.java by Daragh Carroll t00201097

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;


public class GUI extends JFrame {


    private int sourceNum;
    private JLabel label;
    private JTextArea area;
    private JTextField textField;
    private JButton Crew;
    private JButton Cargo;
    eventHandler handler = new eventHandler();

    public GUI()
    {
        super("High Seas Privateer");
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        setResizable(false);
        setSize(640, 340);




        Crew = new JButton("Crew");
        add(Crew);

        Cargo = new JButton("Cargo");
        add(Cargo);

        Crew.addActionListener(handler);
        Cargo.addActionListener(handler);

    }
    private class eventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            if(e.getSource() == Crew)
            {
                JTextArea jta = new JTextArea();
                jta.setText(GameManager.playerCrew.inspectCrew());
                JOptionPane.showMessageDialog(null,jta);
            }
            else if(e.getSource() == Cargo)
            {
                JTextArea jta = new JTextArea();
                jta.setText(GameManager.playerCrew.inspectCargo());
                JOptionPane.showMessageDialog(null,jta);

            }

        }
    }
}
