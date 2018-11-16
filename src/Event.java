//Event.java by Daragh Carroll t00201097
public class Event {
    //source : https://stackoverflow.com/questions/7961788/math-random-explanation
    public static int randomIntegerGenerator(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    

}
