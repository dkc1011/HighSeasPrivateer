//Town.java by Daragh Carroll t00201097
public class Town
{
    private String townName;
    private int distanceFromStart;
    private int distanceFromPlayer;

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public void setDistanceFromStart(int distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }

    public void setDistanceFromPlayer(int distanceFromPlayer) {
        this.distanceFromPlayer = distanceFromPlayer;
    }

    public String getTownName() {
        return townName;
    }

    public int getDistanceFromStart() {
        return distanceFromStart;
    }

    public int getDistanceFromPlayer() {
        return distanceFromPlayer;
    }

    public Town()
    {
        setTownName("Unknown");
        setDistanceFromStart(1);
        setDistanceFromPlayer(1);
    }

    public Town(String townName, int distanceFromStart, int distanceFromPlayer)
    {
        setTownName(townName);
        setDistanceFromStart(distanceFromStart);
        setDistanceFromPlayer(distanceFromPlayer);
    }
}