//GameManager.java by Daragh Carroll t00201097

import javax.swing.*;

public class GameManager {
    public static char difficulty;

    public static void main(String[] args) {
        char choice = JOptionPane.showInputDialog("~~~High Seas Privateer~~~\n1.Start\n2.Exit").charAt(0);

        switch (choice)
        {
            case '1':
                selectDifficulty();

            case '2':
                System.exit(0);

            default :
                JOptionPane.showMessageDialog(null,"Please enter another option!","High Seas Privateer", JOptionPane.ERROR_MESSAGE);
        }

    }

    private static void selectDifficulty()
    {
        difficulty = JOptionPane.showInputDialog("Please select a difficulty!\nThe difficulty effects how much money for supplies you have in the begginning of the game." +
                "\n\n1.Easy\n2.Moderate\n3.Hard").charAt(0);

        if(difficulty != '1' && difficulty != '2' && difficulty != '3')
        {
            JOptionPane.showMessageDialog(null,"Please enter a valid option.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
