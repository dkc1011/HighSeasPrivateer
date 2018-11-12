import javax.swing.*;

//Town.java by Daragh Carroll t00201097
public class Town {
    static String townName;

    public static void enterTown()
    {
        townName = generateTownName();

        char option = JOptionPane.showInputDialog("You lay down your anchor at " + townName + ". The docks are bustling with activity." +
                "\nWhat would you like to do? : \n1.Trade for goods\n2.Ask around for tips\n3.Inspect your crew\n4.Leave").charAt(0);

        switch (option)
        {
            case '1':
                tradeGoods();
                break;

            default: System.out.print("no");
        }

    }//End enterTown()

    private static void tradeGoods()
    {
        char option1 = JOptionPane.showInputDialog("You enter the " + townName + " Trading post. The patron greets you.\n\"Welcome to my store! Are you buying or selling?\"" +
                "\n1.Buy Goods\n2.Sell Goods\n3. Leave the post").charAt(0);

    }

    private static String generateTownName()
    {
        String prefix = selectPrefix();
        String affix = selectAffix();

        return prefix + " " + affix;
    }//End generateTownName()

    private static String selectPrefix()
    {
        int prefixNum = Event.randomIntegerGenerator(1,6);
        String prefix = "";

        switch (prefixNum)
        {
            case 1:
                prefix = "San";
                break;

            case 2:
                prefix = "Saint";
                break;

            case 3:
                prefix = "Fort";
                break;

            case 4:
                prefix = "Port";
                break;

            case 5:
                prefix = "New";
                break;

            case 6:
                prefix = "Old";
                break;
        }

        return prefix;
    }

    private static String selectAffix()
    {
        int affixNum = Event.randomIntegerGenerator(1,15);
        String affix = "Town";

        switch (affixNum)
        {
            case 1:
                affix = "York";
                break;

            case 2:
                affix = "Angelo";
                break;

            case 3:
                affix = "Royal";
                break;

            case 4:
                affix = "Wexford";
                break;

            case 5:
                affix = "Prince";
                break;

            case 6:
                affix = "Berry";
                break;

            case 7:
                affix = "Kansas";
                break;

            case 8:
                affix = "Bethlehem";
                break;

            case 9:
                affix = "Trafford";
                break;

            case 10:
                affix = "Clancy";
                break;

            case 11:
                affix = "Dublin";
                break;

            case 12:
                affix = "Lisbon";
                break;

            case 13:
                affix = "Valencia";
                break;

            case 14:
                affix = "Chester";
                break;

            case 15:
                affix = "Quincy";
                break;

            default:
                affix = "Baile";
                break;
        }

        return affix;
    }

}
