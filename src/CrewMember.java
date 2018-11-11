//CrewMember.java by Daragh Carroll t00201097

public class CrewMember {
    private String name;
    private int health;


    public void setName(String name)
    {
        this.name = name;
    }//End setName()


    public void setHealth(int health)
    {
        this.health = health;
    }//End setHealth()


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
        health = 10;
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
