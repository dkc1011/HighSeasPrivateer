import javax.swing.*;

public class EnterTown {
        public static Town[] towns = new Town[10];
        public static int nextTown = 0;

        public static void generateTowns()
        {
            for(int i=0; i<towns.length; i++) {
                Town town = new Town();
                town.setTownName(generateTownName());
                town.setDistanceFromStart(Event.randomIntegerGenerator(40,45) * i);
                town.setDistanceFromPlayer(town.getDistanceFromStart() - GameManager.playerCrew.getDistanceTravelled());
                towns[i] = town;
            }
        }

        public static void enterTown(int townIndex)
        {
            char option = 'd';

            do {
                option = JOptionPane.showInputDialog("You lay down your anchor at " + towns[townIndex].getTownName() + ". The docks are bustling with activity." +
                        "\nWhat would you like to do? : \n1. Trade for goods\n2. Inspect your cargo\n3. Inspect your crew\n4. Leave").charAt(0);

                if(option == '1')
                {
                    enterTrader();
                }
                else if(option == '2')
                {
                    JTextArea ledger = new JTextArea();
                    ledger.append(GameManager.playerCrew.inspectCargo());

                    JOptionPane.showMessageDialog(null, ledger,"Inspect Cargo",JOptionPane.PLAIN_MESSAGE);
                }
                else if(option == '3')
                {
                    //CrewScreen
                    System.out.println("Your Crew");
                }
                else if (option == '4') {
                    nextTown++;
                }
                else
                {
                    option = 'd';
                    System.out.println("Try again");
                }

            }while (option == 'd');
        }//End enterTown()

        private static String generateTownName()
        {
            String prefix = selectPrefix();
            String affix = selectAffix();

            return prefix + " " + affix;
        }//End generateTownName()

        private static String selectPrefix()
        {
            int prefixNum = Event.randomIntegerGenerator(1,7);
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

                case 7:
                    prefix = "Los";
                    break;
            }//End switch

            return prefix;
        }//End selectPrefix()

        private static String selectAffix()
        {
            int affixNum = Event.randomIntegerGenerator(1,20);
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

                case 16:
                    affix = "Baltimore";
                    break;

                case 17:
                    affix = "Hambourg";
                    break;

                case 18:
                    affix = "Badalon";
                    break;

                case 19:
                    affix = "Prescott";
                    break;

                case 20:
                    affix = "Ascott";
                    break;

                default:
                    affix = "Pittsburg";
                    break;
            }//End switch

            return affix;
        }//End selectAffix()

        private static void enterTrader()
        {
            char choice = 'd';

            do
            {
                choice = JOptionPane.showInputDialog("The Shopkeeper greets you -- \n\n \"Welcome to my store! are you buying or selling sailor?\"\n\n1.Buy goods\n2.Sell goods\n3.Leave store").charAt(0);

                switch (choice)
                {
                    case '1':
                        buyingGoods();
                        break;

                    case '2':
                        sellingGoods();
                        break;

                    case '3':
                        enterTown(nextTown);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,"Please enter a valid option!","Invalid selection!",JOptionPane.ERROR_MESSAGE);
                        choice='d';
                        break;
                }
            }while (choice == 'd');
        }

        private static void buyingGoods()
        {

        }

        private static void sellingGoods()
        {

        }


}

