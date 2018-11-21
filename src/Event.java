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
        int triggerRoll = randomIntegerGenerator(1,6);

        if(triggerRoll == 1)
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

        int eventNo = randomIntegerGenerator(1,3);

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
        }
    }
}
