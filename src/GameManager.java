//GameManager.java by Daragh Carroll t00201097

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager {
    public static char difficulty = 'd';
    public static Crew playerCrew = new Crew();
    private static int minMovespeed=2;
    private static int maxMovespeed=4;
    private static int dayCycle = 0;
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
                    playerCrew.setMoney(400);
                }
                else if(difficulty == '2')
                {
                    playerCrew.setMoney(300);
                }
                else
                {
                    playerCrew.setMoney(200);
                }

                playerCrew.setDistanceTravelled(0);
            
                startGame();
            }
        }while(difficulty == 'd');
    }
    
    private static void startGame()
    {
        EnterTown.generateTowns();
        for(int i=0; i<9; i++) {
            System.out.println(EnterTown.towns[i].getTownName());
            System.out.println(EnterTown.towns[i].getDistanceFromStart() + " Nautical Miles");
        }
        travelling();
    }

    //Information source for Timers -- : https://stackoverflow.com/questions/17397259/how-to-do-an-action-in-periodic-intervals-in-java
    public static void travelling()
    {
        // Day / Night cycle code
        String[] timeOfDayString = new String[5];


        timeOfDayString[0] = "Morning";
        timeOfDayString[1] = "Noon";
        timeOfDayString[2] = "Afternoon";
        timeOfDayString[3] = "Evening";
        timeOfDayString[4] = "Night";

        Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                if(EnterTown.towns[EnterTown.nextTown].getDistanceFromPlayer() == 0)
                {
                    EnterTown.enterTown(EnterTown.nextTown);
                }
                else
                {
                    if(dayCycle == 4)
                    {
                        minMovespeed = 1;
                        maxMovespeed = 2;
                    }
                    else
                    {
                        minMovespeed = 2;
                        maxMovespeed = 4;
                    }


                    playerCrew.setDistanceTravelled(playerCrew.getDistanceTravelled()+Event.randomIntegerGenerator(minMovespeed, maxMovespeed));
                    System.out.println("Distance Travelled: " + playerCrew.getDistanceTravelled() + " Nautical Miles");
                    EnterTown.towns[EnterTown.nextTown].setDistanceFromPlayer(EnterTown.towns[EnterTown.nextTown].getDistanceFromStart() - playerCrew.getDistanceTravelled());
                    if(EnterTown.towns[EnterTown.nextTown].getDistanceFromPlayer() < 0)
                    {
                        EnterTown.towns[EnterTown.nextTown].setDistanceFromPlayer(0);
                    }

                    System.out.println("Distance to next town: " + EnterTown.towns[EnterTown.nextTown].getDistanceFromPlayer() + " Nautical Miles");

                    System.out.println(timeOfDayString[dayCycle] + "\n\n");

                    dayCycle++;

                    Event.eventOccurs(Event.eventTrigger());

                    if(dayCycle > 4)
                    {
                        dayCycle = 0;
                    }

                }
            }
        }, 3500, 3500);
    }//End Travelling
    
}
