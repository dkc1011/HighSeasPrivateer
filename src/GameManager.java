//GameManager.java by Daragh Carroll t00201097

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;

public class GameManager extends JPanel{
    public static char difficulty = 'd';
    public static Crew playerCrew = new Crew();
    private static int minMovespeed=2;
    private static int maxMovespeed=4;
    private static int dayCycle = 0;
    private static int hungerCounter = 0;
    private static String fileName = "out.txt";
    private static String difficultyString;
    public static void main(String[] args) {
        //d for default
        char choice = 'd';

        do
        {
            choice = JOptionPane.showInputDialog("~~~High Seas Privateer~~~\n1.Start\n2.Exit").charAt(0);

            switch (choice)
            {
                case '1':
                    selectDifficulty();
                    break;

                case '2':
                    System.exit(0);

                default :
                    JOptionPane.showMessageDialog(null,"Please enter another option!","High Seas Privateer", JOptionPane.ERROR_MESSAGE);
                    choice = 'd';
                    break;
            }
        }while(choice == 'd');

    }

    private static void selectDifficulty()
    {
        do
        {
            difficulty = JOptionPane.showInputDialog("Please select a difficulty!\nThe difficulty effects how much money for supplies you have in the begginning of the game." +
                 "\n\n1.Easy\n2.Moderate\n3.Hard").charAt(0);

            if(difficulty != '1' && difficulty != '2' && difficulty != '3')
            {
                JOptionPane.showMessageDialog(null,"Please enter a valid option.", "Error", JOptionPane.ERROR_MESSAGE);
                difficulty = 'd';
            }
            else
            {
                playerCrew.createCrew();
            
                if(difficulty == '1')
                {
                    playerCrew.setMoney(300);
                    difficultyString = "Easy";
                }
                else if(difficulty == '2')
                {
                    playerCrew.setMoney(200);
                    difficultyString = "Moderate";
                }
                else
                {
                    playerCrew.setMoney(100);
                    difficultyString = "Hard";
                }

                playerCrew.setDistanceTravelled(0);
            
                startGame();
            }
        }while(difficulty == 'd');
    }
    
    private static void startGame()
    {
        EnterTown.generateTowns();
        for(int i=0; i<EnterTown.towns.length; i++) {
            System.out.println(EnterTown.towns[i].getTownName());
            System.out.println(EnterTown.towns[i].getDistanceFromStart() + " Nautical Miles");
        }

        JOptionPane.showMessageDialog(null,"Gambling debts. You were always a sucker for a game of liars dice. \nNow your habit may well be your downfall.\n" +
                "The dread pirate Ashbeard now stalks your trail. \nYour last hope is to sail the " + EnterTown.towns[9].getDistanceFromStart() + " Nautical Miles to the Spanish blockade \nand into Spanish ruled territory where Ashbeard dare not follow you.\n" +
        "\nGod speed sailor!");

        travelling();
    }

    //Information source for Timers -- : https://stackoverflow.com/questions/17397259/how-to-do-an-action-in-periodic-intervals-in-java
    public static void travelling()
    {
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea jta = new JTextArea(15,55);
        gui.add(jta);
        gui.setVisible(true);


        // Day / Night cycle code
        String[] timeOfDayString = new String[5];


        timeOfDayString[0] = "Morning\nTravelling";
        timeOfDayString[1] = "Noon\nTravelling.";
        timeOfDayString[2] = "Afternoon\nTravelling..";
        timeOfDayString[3] = "Evening\nTravelling...";
        timeOfDayString[4] = "Night\nTravelling....";

        Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                if(playerCrew.getLivingCrew() <= 0)
                {
                    int difficultyModifier=0;

                    if(difficulty == '1')
                    {
                        difficultyModifier = 1;
                    }
                    else if(difficulty == '2')
                    {
                        difficultyModifier = 2;
                    }
                    else if(difficulty =='3')
                    {
                        difficultyModifier = 3;
                    }

                    int finalScore = difficultyModifier*(playerCrew.getMoney() + playerCrew.getDistanceTravelled());
                    JOptionPane.showMessageDialog(null,"The last of your crew falls, emaciated and sick, dead on the deck. \nYour ship floats aimlessly, unmanned. A ghostly remnant waiting to be swallowed by the waves.", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);

                    try{
                        PrintWriter outputStream = new PrintWriter(fileName);
                        outputStream.println("Captain " + playerCrew.crew[0].getName() + ":\n" + finalScore);
                        outputStream.close();
                        System.out.println("Final score written to out.txt");
                        JOptionPane.showMessageDialog(null, "GAME OVER\n\nYou completed the game with " + playerCrew.getMoney() + " doubloons and no remaining crew members.\n" +
                                "You travelled " + playerCrew.getDistanceTravelled() + " Nautical Miles and your difficulty was " + difficultyString +".\n\nYour final score is: " + finalScore);

                    } catch (FileNotFoundException e){
                        e.printStackTrace();
                        System.out.println("File not found");
                    }

                    System.exit(0);
                }

                if(playerCrew.getShipHealth() <= 0)
                {
                    int difficultyModifier=0;
                    if(difficulty == '1')
                    {
                        difficultyModifier = 1;
                    }
                    else if(difficulty == '2')
                    {
                        difficultyModifier = 2;
                    }
                    else if(difficulty =='3')
                    {
                        difficultyModifier = 3;
                    }

                    int finalScore = difficultyModifier*(playerCrew.getMoney()+playerCrew.getDistanceTravelled());
                    JOptionPane.showMessageDialog(null, "Your ship sustains far too much damage and sinks beneath the salty surf. Your crew lay to rest in a watery grave, forever trapped in davy jones' locker.", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);

                    try{
                        PrintWriter outputStream = new PrintWriter(fileName);
                        outputStream.println("Captain " + playerCrew.crew[0].getName() + ":\n" + finalScore);
                        outputStream.close();
                        System.out.println("Final score written to out.txt");
                        JOptionPane.showMessageDialog(null, "GAME OVER\n\nYou completed the game with " + playerCrew.getMoney() + " doubloons and no remaining crew members.\n" +
                                "You travelled " + playerCrew.getDistanceTravelled() + " Nautical Miles and your difficulty was " + difficultyString +".\n\nYour final score is: " + finalScore);

                    } catch (FileNotFoundException e){
                        e.printStackTrace();
                        System.out.println("File not found");
                    }

                    System.exit(0);
                }

                for(int i = 0; i < playerCrew.crew.length; i++)
                {
                    if(playerCrew.crew[i].getHealth() <= 0)
                    {
                        if(playerCrew.crew[i].getStatus() == 'H') {
                            playerCrew.setLivingCrew(playerCrew.getLivingCrew() - 1);
                            JOptionPane.showMessageDialog(null, playerCrew.crew[i].getName() + " has died!", "A Death has occurred!", JOptionPane.INFORMATION_MESSAGE);
                        }

                        playerCrew.crew[i].setStatus('D');
                        playerCrew.crew[i].setHealth(0);

                    }
                }

                if(EnterTown.towns[EnterTown.nextTown].getDistanceFromPlayer() == 0)
                {
                    if(EnterTown.nextTown <10) {
                        EnterTown.enterTown(EnterTown.nextTown);
                    }
                    else if(EnterTown.nextTown == 10)
                    {
                        int difficultyModifier=0;
                        if(difficulty == '1')
                        {
                            difficultyModifier = 1;
                        }
                        else if(difficulty == '2')
                        {
                            difficultyModifier = 2;
                        }
                        else if(difficulty =='3')
                        {
                            difficultyModifier = 3;
                        }

                        int finalScore = ((playerCrew.getMoney() + playerCrew.getDistanceTravelled())*playerCrew.getLivingCrew())*difficultyModifier;
                        JOptionPane.showMessageDialog(null, "You show your papers and cross through the safety of the Spanish blockade.\n"
                        + "As the line of Spanish ships fade into the horizon and you prepare to lay anchor in a new territory, having travelled " +
                        playerCrew.getDistanceTravelled() + " Nautical Miles, you let out a sigh of relief.");

                        //Information source https://www.youtube.com/watch?v=WEZRc0GoP3E

                        try{
                            PrintWriter outputStream = new PrintWriter(fileName);
                            outputStream.println("Captain " + playerCrew.crew[0].getName() + ":\n" + finalScore);
                            outputStream.close();
                            System.out.println("Final score written to out.txt");

                        } catch (FileNotFoundException e){
                            e.printStackTrace();
                            System.out.println("File not found");
                        }

                        JOptionPane.showMessageDialog(null, "Congratulations!\n\nYou completed the game with " + playerCrew.getMoney() + " doubloons and " + playerCrew.getLivingCrew() + " crew members left alive!\n" +
                                "You travelled " + playerCrew.getDistanceTravelled() + "Nautical Miles and your difficulty was " + difficultyString +".\n\nYour final score is: \" + finalScore);\n\nYour final score is: " + finalScore);
                        JOptionPane.showMessageDialog(null, "Thanks for playing!");
                        System.exit(0);
                    }
                }
                else
                {
                    playerCrew.setDistanceTravelled(playerCrew.getDistanceTravelled()+Event.randomIntegerGenerator(minMovespeed, maxMovespeed));
                    jta.setText("Distance Travelled: " + playerCrew.getDistanceTravelled() + " Nautical Miles\n");
                    EnterTown.towns[EnterTown.nextTown].setDistanceFromPlayer(EnterTown.towns[EnterTown.nextTown].getDistanceFromStart() - playerCrew.getDistanceTravelled());
                    if(EnterTown.towns[EnterTown.nextTown].getDistanceFromPlayer() < 0)
                    {
                        EnterTown.towns[EnterTown.nextTown].setDistanceFromPlayer(0);
                    }



                    jta.append("Distance to next town: " + EnterTown.towns[EnterTown.nextTown].getDistanceFromPlayer() + " Nautical Miles\n");

                    jta.append(timeOfDayString[dayCycle] + "\n\n");

                    dayCycle++;

                    Event.eventOccurs(Event.eventTrigger());
                    if(dayCycle == 4)
                    {
                        minMovespeed = 1;
                        maxMovespeed = 2;
                    }
                    else if(dayCycle == 3)
                    {
                        //Crew eats food in evening
                        if(playerCrew.cargo[0].getQuantity() >= playerCrew.getLivingCrew())
                        {
                            playerCrew.alterCargoQuantity(0, playerCrew.cargo[0].getQuantity()-playerCrew.getLivingCrew());
                            jta.append("The Crew consumes " + playerCrew.getLivingCrew() + " Food rations\n");
                            hungerCounter = 0;
                        }
                        else
                        {
                            jta.append("There were not enough rations to feed the crew today\n");
                            playerCrew.cargo[0].setQuantity(0);
                            hungerCounter++;

                            if(hungerCounter >= 3)
                            {
                                for(int i = 0; i<playerCrew.crew.length; i++)
                                {
                                    if(playerCrew.crew[i].getStatus() == 'H') {
                                        playerCrew.crew[i].setHealth(playerCrew.crew[i].getHealth() - 1);
                                        jta.append(playerCrew.crew[i].getName() + " is starving.\n");
                                    }
                                }
                            }
                        }
                    }
                    else if(dayCycle > 4)
                    {
                        dayCycle = 0;
                    }
                    else
                    {
                        minMovespeed = 2;
                        maxMovespeed = 4;
                    }

                }
            }
        }, 3000, 3000);
    }//End Travelling
}
