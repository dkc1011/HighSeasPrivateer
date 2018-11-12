//CrewMember.java by Daragh Carroll t00201097

public class CrewMember {
    private String name;
    /*
    Health indicates how badly sick or injured a crewmember is
    5 = Perfectly Healthy
    4 = Slightly Unwell
    3 = Poorly
    2 = Badly Injured / Very Sick
    1 = Near-death
    0 = Dead
    */
    private int health;
    /*
    Status indicates whether a crewmember is Healthy, Sick, Injured or Dead.
    'H' = Healthy
    'I' = Injured
    'S' = Sick
    'D' = Deceased
    */
    private char status;


    public void setName(String name)
    {
        this.name = name;
    }//End setName()


    public void setHealth(int health)
    {
        this.health = health;
    }//End setHealth()
    
    
    public void setStatus(char status)
    {
        this.status = status;
    }//End setStatus

    public String getName()
    {
        return this.name;
    }//End getName()


    public int getHealth()
    {
        return this.health;
    }//End getHealth()

    //Constructors

    //No Args Constructor
    public CrewMember()
    {
        name = "Unknown";
        health = 5;
    }//End No Args Constructor


    //Two Args Constructor
    public CrewMember(String name, int health)
    {
        setName(name);
        setHealth(health);
    }//End Two Args Constructor


    public String toString()
    {
        return "Name: " + getName() + "\nHealth: " + getHealth();
    }//End toString
}
