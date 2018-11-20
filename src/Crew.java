//Crew.java by Daragh Carroll t00201097

import javax.swing.*;

public class Crew {
    CrewMember[] crew = new CrewMember[5];
    private int money;
    private int shipHealth;
    private int distanceTravelled;
    CargoItem[] cargo = new CargoItem[14];

    public void createCrew()
    {
        CrewMember captain = new CrewMember();
        captain.setName(JOptionPane.showInputDialog("Please enter the name of your Captain: "));
        captain.setHealth(5);
        captain.setStatus('H');
        crew[0] = captain;
        for(int i = 1; i<crew.length; i++)
        {
            CrewMember crewMember = new CrewMember();
            crewMember.setName(JOptionPane.showInputDialog("Please enter the name of crew member " + i + ":"));
            crewMember.setHealth(5);
            crewMember.setStatus('H');
            crew[i] = crewMember;
        } //End For

        //Initializes all of the different cargo a crew can have
        cargo[0] = new CargoItem("Food Rations", 0, 2, 0, 0);
        cargo[1] = new CargoItem("Timber", 0, 20,0, 0);
        cargo[2] = new CargoItem("Rum", 0, 6,0, 0);
        cargo[3] = new CargoItem("Fabric", 0, 8,0, 0);
        cargo[4] = new CargoItem("Guns", 0,19,0, 0);
        cargo[5] = new CargoItem("Black Powder", 0,2,0, 0);
        cargo[6] = new CargoItem("Coffee Beans", 0, 3, 0, 0);
        cargo[7] = new CargoItem("Tea Leaves", 0, 3, 0, 0);
        cargo[8] = new CargoItem("Canons", 0, 85, 0, 0);
        cargo[9] = new CargoItem("Canon balls", 0, 18, 0, 0);
        cargo[10] = new CargoItem("Silk", 0, 15, 0, 0);
        cargo[11] = new CargoItem("Opium",0,30, 0, 0);
        cargo[12] = new CargoItem("Tobacco", 0, 12, 0, 0);
        cargo[13] = new CargoItem("Lemons", 0, 3, 0, 0);
    }//End createCrew()


    public void alterCargoQuantity(int cargoIndex, int newQuantity)
    {
        cargo[cargoIndex].setQuantity(newQuantity);
    }

    public void setMoney(int money)
    {
        this.money = money;
    }//End setMoney()

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

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

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    //Constructors

    //No Args Constructor
    public Crew()
    {
        setMoney(0);
        setShipHealth(10);
    }//End No Args Constructor


    //2 Args Constructor
    public Crew(int money, int shipHealth)
    {
        setMoney(money);
        setShipHealth(shipHealth);
    }//End 2 Args Constructor

    //Additional Methods

    public String inspectCargo()
    {
        String cargoLedger = "";

        for(int i = 0; i<cargo.length; i++)
        {
            cargoLedger += cargo[i].toString() + "\n\n";
        }

        return cargoLedger;
    }

}//End class
