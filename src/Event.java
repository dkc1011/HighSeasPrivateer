import javax.swing.*;

//Event.java by Daragh Carroll t00201097
public class Event {
    //source : https://stackoverflow.com/questions/7961788/math-random-explanation
    public static int randomIntegerGenerator(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public static boolean eventTrigger()
    {
        int triggerRoll = randomIntegerGenerator(1,7);

        if(triggerRoll == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void eventOccurs(boolean triggered)
    {
        if(triggered)
        {
            selectEvent();
        }
    }

    private static void selectEvent()
    {
        int afflictedCrewMember = randomIntegerGenerator(0,4);
        while(GameManager.playerCrew.crew[afflictedCrewMember].getStatus() == 'D')
        {
            afflictedCrewMember = randomIntegerGenerator(0,4);
        }

        int eventNo = randomIntegerGenerator(1,6);

        switch (eventNo)
        {
            case 1:
                int driftwood = randomIntegerGenerator(1, 4);
                JOptionPane.showMessageDialog(null,"The crew spots some in-tact driftwood. " + GameManager.playerCrew.crew[afflictedCrewMember].getName() + " fishes it out.\n\nYou gain " + driftwood + " Timber.", "Event", JOptionPane.INFORMATION_MESSAGE);
                GameManager.playerCrew.alterCargoQuantity(1,GameManager.playerCrew.cargo[1].getQuantity() + driftwood);
                break;

            case 2:
                JOptionPane.showMessageDialog(null,"While swabbing the deck, " + GameManager.playerCrew.crew[afflictedCrewMember].getName() + " slips and falls in their bucket, injuring themselves.", "Event", JOptionPane.INFORMATION_MESSAGE);
                GameManager.playerCrew.crew[afflictedCrewMember].setHealth(GameManager.playerCrew.crew[afflictedCrewMember].getHealth() - 1);
                break;

            case 3:
                int fish = randomIntegerGenerator(2,6);
                JOptionPane.showMessageDialog(null,GameManager.playerCrew.crew[afflictedCrewMember].getName() + " spends the day fishing. With their catch of the day, they can make a further " + fish + " food rations.", "Event", JOptionPane.INFORMATION_MESSAGE);
                GameManager.playerCrew.alterCargoQuantity(0,GameManager.playerCrew.cargo[0].getQuantity() + fish);
                break;

            case 4:
                if(GameManager.playerCrew.cargo[13].getQuantity() <= 0)
                {
                    JOptionPane.showMessageDialog(null, GameManager.playerCrew.crew[afflictedCrewMember].getName() + " has contracted scurvy!", "Scurvy", JOptionPane.INFORMATION_MESSAGE);
                    GameManager.playerCrew.crew[afflictedCrewMember].setHealth(GameManager.playerCrew.crew[afflictedCrewMember].getHealth() - 1);
                    GameManager.playerCrew.cargo[13].setQuantity(0);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, GameManager.playerCrew.crew[afflictedCrewMember].getName() + " eats a lemon to stop the rapid onset of scurvy.");
                    GameManager.playerCrew.cargo[13].setQuantity(GameManager.playerCrew.cargo[13].getQuantity() - 1);
                }

                break;

            case 5:
                int englishSearch = randomIntegerGenerator(1, 3);

                if(englishSearch == 1)
                {
                    if(GameManager.playerCrew.cargo[11].getQuantity() > 0 || GameManager.playerCrew.cargo[12].getQuantity() > 0)
                    {
                        JOptionPane.showMessageDialog(null, "English marines board your ship to search for illegal cargo.\nThey find " + GameManager.playerCrew.cargo[11].getQuantity() + " Opium and " + GameManager.playerCrew.cargo[12].getQuantity() + " Tobacco. They take it all back to their ship as confiscate.", "British Raid!", JOptionPane.INFORMATION_MESSAGE);
                        GameManager.playerCrew.cargo[11].setQuantity(0);
                        GameManager.playerCrew.cargo[12].setQuantity(0);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "English marines board your ship to search for illegal cargo.\nThey find none, and return to their ship.","British Raid!",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "English marines board your ship to search for illegal cargo.\nThey find none, and return to their ship.","British Raid!",JOptionPane.INFORMATION_MESSAGE);
                }

                break;

            case 6:
                int pirateSpawn = randomIntegerGenerator(1,5);

                if(pirateSpawn == 1)
                {
                    int shipDamage;
                    int stolenGoods1=randomIntegerGenerator(0,13);
                    int numberSG1 = randomIntegerGenerator(1,8);
                    int numberSG2 = randomIntegerGenerator(2,4);
                    int stolenGoods2=randomIntegerGenerator(0,13);
                    char choice = 'd';
                    do {
                        choice = JOptionPane.showInputDialog("Pirates head off your ship and attempt to board! What do you do?\n\n1. Attempt to fight off the pirates!\n2. Attempt to flee!\n3. Bribe the pirates!").charAt(0);
                        switch (choice)
                        {
                            case '1':
                                if(GameManager.playerCrew.cargo[4].getQuantity() >= GameManager.playerCrew.getLivingCrew() && GameManager.playerCrew.cargo[5].getQuantity() >= 25)
                                {
                                    shipDamage = randomIntegerGenerator(1,4);
                                    JOptionPane.showMessageDialog(null,"After a lengthy battle, your superior fire power lends you victory.\n"
                                    + "You vanquish the pirates. You raid their ship an gain " + numberSG1 + " " + GameManager.playerCrew.cargo[stolenGoods1].getName() + " and " + numberSG2 + " " + GameManager.playerCrew.cargo[stolenGoods1].getName() + ".\n"
                                    + "\nThe fighting has left " + GameManager.playerCrew.crew[afflictedCrewMember] + " slightly wounded and the pirates' sustained canon fire only moderately damaged the ship.", "Pirate Attack!", JOptionPane.INFORMATION_MESSAGE);

                                    GameManager.playerCrew.cargo[stolenGoods1].setQuantity(GameManager.playerCrew.cargo[stolenGoods1].getQuantity() + numberSG1);
                                    GameManager.playerCrew.cargo[stolenGoods1].setQuantity(GameManager.playerCrew.cargo[stolenGoods1].getQuantity() + numberSG2);
                                    GameManager.playerCrew.crew[afflictedCrewMember].setHealth(GameManager.playerCrew.crew[afflictedCrewMember].getHealth()-1);
                                    GameManager.playerCrew.setShipHealth(GameManager.playerCrew.getShipHealth() - randomIntegerGenerator(1,3));
                                }
                                else if(GameManager.playerCrew.cargo[4].getQuantity() >= GameManager.playerCrew.getLivingCrew() && GameManager.playerCrew.cargo[5].getQuantity() >= 10 && GameManager.playerCrew.cargo[5].getQuantity()<= 24)
                                {
                                    shipDamage = randomIntegerGenerator(2,6);
                                    JOptionPane.showMessageDialog(null,"After a lengthy battle with what little firepower you have, the pirates turn tail and flee.\n"
                                    + "As the smoke clears you inspect your crew and ship.\nThe fighting has left " + GameManager.playerCrew.crew[afflictedCrewMember] + " wounded and the pirates' sustained canon fire left the ship fairly damaged.", "Pirate Attack!", JOptionPane.INFORMATION_MESSAGE);

                                    GameManager.playerCrew.crew[afflictedCrewMember].setHealth(GameManager.playerCrew.crew[afflictedCrewMember].getHealth() - randomIntegerGenerator(1,2));
                                    GameManager.playerCrew.setShipHealth(GameManager.playerCrew.getShipHealth() - shipDamage);
                                }
                                else
                                {
                                    shipDamage = randomIntegerGenerator(4,9);
                                    JOptionPane.showMessageDialog(null, "Your complete lack of firepower leaves you nearly defenseless against the pirates' guns and canons.\n" +
                                            "after sustained shelling you turn tail and flee. " + GameManager.playerCrew.crew[afflictedCrewMember].getName() + " is badly wounded in the fighting and the ship is left in a shambles.", "Pirate Attack!", JOptionPane.INFORMATION_MESSAGE);

                                    GameManager.playerCrew.crew[afflictedCrewMember].setHealth(GameManager.playerCrew.crew[afflictedCrewMember].getHealth() - randomIntegerGenerator(2,4));
                                }

                                break;

                            case '2':
                                shipDamage = randomIntegerGenerator(2,4);

                                JOptionPane.showMessageDialog(null, "You spin your bearing and flea the pirates! They shell you as you sail full sails away.\n" +
                                        GameManager.playerCrew.crew[afflictedCrewMember].getName() + " is wounded in the escape and the ship sustains some damage, but with time you lose the pirates", "Pirate Attack!", JOptionPane.INFORMATION_MESSAGE);

                                GameManager.playerCrew.crew[afflictedCrewMember].setHealth(GameManager.playerCrew.crew[afflictedCrewMember].getHealth() - randomIntegerGenerator(1,2));
                                GameManager.playerCrew.setShipHealth(GameManager.playerCrew.getShipHealth() - shipDamage);

                                break;

                            case '3':
                                int bribeSum = (int)Math.round(GameManager.playerCrew.getMoney() * 0.75);
                                JOptionPane.showMessageDialog(null, "Under terms of parley, you meet with the pirate captain and offer him a sum of " + bribeSum + " doubloons for safe passage.\nHe reluctantly accepts, and lets you on your way.");
                                GameManager.playerCrew.setMoney(GameManager.playerCrew.getMoney() - bribeSum);
                                break;

                            default:
                                JOptionPane.showMessageDialog(null,"Please enter a valid option!", "Error!", JOptionPane.ERROR_MESSAGE);
                                choice = 'd';

                        }

                    }while(choice == 'd');

                }

        }
    }
}
