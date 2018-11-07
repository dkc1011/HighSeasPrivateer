public class CrewMember {
    private String name;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public CrewMember()
    {
        name = "Unknown";
    }

    public CrewMember(String name)
    {
        setName(name);
    }
}
