import javax.swing.*;

public class GameManager {
    public static void main(String[] args) {
        char choice = JOptionPane.showInputDialog("~~~High Seas Privateer~~~\n1.Start\n2.Exit").charAt(0);

        switch (choice)
        {
            case '1':
                JOptionPane.showMessageDialog(null, "GAME");

            case '2':
                System.exit(0);

            default :
                JOptionPane.showMessageDialog(null,"Please enter another option!","Trail to Tombstone", JOptionPane.ERROR_MESSAGE);
        }

    }
}
