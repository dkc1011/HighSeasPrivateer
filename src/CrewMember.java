public class CrewMember {
    private String name;
    private int health;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public String getName()
    {
        return this.name;
    }

    public int getHealth()
    {
        return this.health;
    }

    public CrewMember()
    {
        name = "Unknown";
    }

    public CrewMember(String name)
    {
        setName(name);
    }

    public String toString()
    {
        return "Name: " + getName() + "\nHealth: " + getHealth();
    }
}
