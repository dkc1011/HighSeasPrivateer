//Crew.java by Daragh Carroll t00201097

import javax.swing.*;

public class Crew {
    CrewMember[] crewMembers = new CrewMember[5];
    private int money;
    private int shipHealth;

    public void createCrew()
    {
        crewMembers[0].setName(JOptionPane.showInputDialog("Please enter the name of your Captain: "));
        crewMembers[0].setHealth(10);

        for(int i = 1; i<5; i++)
        {
            crewMembers[i].setName(JOptionPane.showInputDialog("Please enter the name of crew member " + i + ":"));
        } //End For
    }//End createCrew()


    public void setMoney(int money)
    {
        this.money = money;
    }//End setMoney()


    public int getMoney()
    {
        return this.money;
    }//End getMoney()


    public void setShipHealth(int shipHealth)
    {
        this.shipHealth = shipHealth;
    }//End setShipHealth()


    public int getShipHealth()
    {
        return this.shipHealth;
    }//end getShipHealth()

    //Constructors

    //No Args Constructor
    public Crew()
    {
        setMoney(0);
        setShipHealth(100);
    }//End No Args Constructor


    //2 Args Constructor
    public Crew(int money, int shipHealth)
    {
        setMoney(money);
        setShipHealth(shipHealth);
    }//End 2 Args Constructor
}//End class
