import javax.swing.*;

public class EnterTown {
        public static Town[] towns = new Town[10];
        public static int nextTown = 0;
        private static char buyingOrSelling = 'N';
        public static void generateTowns()
        {
            for(int i=0; i<towns.length; i++) {
                Town town = new Town();
                town.setTownName(generateTownName());
                town.setDistanceFromStart(Event.randomIntegerGenerator(40,45) * i);
                town.setDistanceFromPlayer(town.getDistanceFromStart() - GameManager.playerCrew.getDistanceTravelled());
                town.generateMerchantStockNamesAndBasePrices();
                town.generateMerchantQuantities();
                town.generateMerchantPrices();
                towns[i] = town;
            }
        }

        public static void enterTown(int townIndex)
        {
            char option = 'd';

            do {
                option = JOptionPane.showInputDialog("You lay down your anchor at " + towns[townIndex].getTownName() + ". The docks are bustling with activity." +
                        "\nWhat would you like to do? : \n1. Trade for goods\n2. Inspect your cargo\n3. Inspect your crew\n4. Seek ship repairs\n5. Leave").charAt(0);

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
                    JTextArea jta = new JTextArea();
                    jta.setText(GameManager.playerCrew.inspectCrew());
                    JOptionPane.showMessageDialog(null,jta);
                }
                else if(option == '4')
                {
                    shipRepairs(GameManager.playerCrew.getShipHealth());
                }
                else if (option == '5') {
                    nextTown++;
                    GameManager.playerCrew.setDistanceTravelled(GameManager.playerCrew.getDistanceTravelled()+1);
                    break;
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
                choice = JOptionPane.showInputDialog("The Shopkeeper greets you -- \n\n \"Welcome to my store! are you buying or selling sailor?\"\n\n1.Buy goods\n2.Sell goods\n3.Leave store \n\nCaptain " + GameManager.playerCrew.crew[0].getName() + " has " + GameManager.playerCrew.getMoney() + " doubloons.").charAt(0);

                switch (choice)
                {
                    case '1':

                        char choice2 = 'd';
                        buyingOrSelling = 'B';

                        do
                        {
                            choice2 = JOptionPane.showInputDialog("\"So you're buyin'! I can show you my rates afore you make a decision!\"\n\n1.Select what you want to buy\n2.View rates\n3.Go back\n\nCaptain " + GameManager.playerCrew.crew[0].getName() + " has " + GameManager.playerCrew.getMoney() + " doubloons.").charAt(0);

                            switch (choice2)
                            {
                                case '1':
                                    buyingGoods();
                                    break;

                                case '2':
                                    displayRates();
                                    break;

                                case '3':
                                    enterTrader();
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null,"Please enter a valid option!","Invalid selection!",JOptionPane.ERROR_MESSAGE);
                                    choice2 ='d';
                                    break;
                            }
                        }while (choice2 == 'd');
                        break;

                    case '2':
                        buyingOrSelling = 'S';

                        do
                        {
                            choice2 = JOptionPane.showInputDialog("\"So you're Sellin'! I can show you my rates afore you make a decision!\"\n\n1.Select what you want to sell\n2.View rates\n3.Go back\n\nCaptain " + GameManager.playerCrew.crew[0].getName() + " has " + GameManager.playerCrew.getMoney() + " doubloons.").charAt(0);

                            switch (choice2)
                            {
                                case '1':
                                    sellingGoods();
                                    break;

                                case '2':
                                    displayRates();
                                    break;

                                case '3':
                                    enterTrader();
                                    break;

                                default:
                                    JOptionPane.showMessageDialog(null,"Please enter a valid option!","Invalid selection!",JOptionPane.ERROR_MESSAGE);
                                    choice2 ='d';
                                    break;
                            }
                        }while (choice2 == 'd');

                    case '3':
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
            char valid = 'd', valid2 = 'd';
            int buyingIndex;

            do {
                buyingIndex = Integer.parseInt(JOptionPane.showInputDialog("Input the item you would like to buy: \n1.Food Rations\n2.Timber\n3.Rum Barrels\n4.Fabric\n5.Guns\n6.Black Powder Keg\n7.Coffee Beans\n8.Tea Leaves"
                        + "\n9.Canons\n10.Canon Balls\n11.Silk\n12.Opium\n13.Tobacco\n14.Lemons\n\n15.Go Back"));

                if(buyingIndex > 0 && buyingIndex <15)
                {
                    valid = 'v';
                }
                else if (buyingIndex==15)
                {
                    break;
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please enter a valid option!","Invalid selection!",JOptionPane.ERROR_MESSAGE);
                    valid = 'd';
                }
            }while(valid == 'd');

            do {
                int buyingQuantity = Integer.parseInt(JOptionPane.showInputDialog("How many " + towns[nextTown].merchantStock[buyingIndex-1].getName() + " would you like to buy?"));

                if(buyingQuantity > towns[nextTown].merchantStock[buyingIndex-1].getQuantity())
                {
                    JOptionPane.showMessageDialog(null,"The trader does not have enough " + towns[nextTown].merchantStock[buyingIndex-1].getName() + " to sell to you! Please input a different quantity.","Invalid selection!",JOptionPane.ERROR_MESSAGE);
                    valid2 = 'd';
                }
                else if(buyingQuantity <= 0)
                {
                    JOptionPane.showMessageDialog(null,"Quantity must be a positive number, please enter a different quantity","Invalid selection!",JOptionPane.ERROR_MESSAGE);
                    valid2 = 'd';
                }
                else if(GameManager.playerCrew.getMoney() < towns[nextTown].merchantStock[buyingIndex-1].getMerchantBuyPrice() * buyingQuantity)
                {
                    JOptionPane.showMessageDialog(null,"You do not have enough doubloons to pay for this many " + towns[nextTown].merchantStock[buyingIndex-1].getName(),"Invalid selection!",JOptionPane.ERROR_MESSAGE);
                    valid2 = 'd';
                }
                else
                {
                    GameManager.playerCrew.setMoney(GameManager.playerCrew.getMoney() - towns[nextTown].merchantStock[buyingIndex-1].getMerchantBuyPrice() * buyingQuantity);
                    GameManager.playerCrew.alterCargoQuantity(buyingIndex-1, GameManager.playerCrew.cargo[buyingIndex-1].getQuantity() + buyingQuantity);
                    towns[nextTown].merchantStock[buyingIndex-1].setQuantity(towns[nextTown].merchantStock[buyingIndex-1].getQuantity() - buyingQuantity);

                    JOptionPane.showMessageDialog(null, "You have purchased " + buyingQuantity + " " + towns[nextTown].merchantStock[buyingIndex-1].getName() + " for " + towns[nextTown].merchantStock[buyingIndex-1].getMerchantBuyPrice() * buyingQuantity + " doubloons", "Transaction Successful", JOptionPane.INFORMATION_MESSAGE);
                    valid2 = 'v';
                }
            }while(valid2 == 'd');

            enterTrader();
        }

        private static void sellingGoods()
        {
            char valid = 'd', valid2 = 'd';
            int sellingIndex;

            do {
                sellingIndex = Integer.parseInt(JOptionPane.showInputDialog("Input the item you would like to sell: \n1.Food Rations\n2.Timber\n3.Rum Barrels\n4.Fabric\n5.Guns\n6.Black Powder Keg\n7.Coffee Beans\n8.Tea Leaves"
                        + "\n9.Canons\n10.Canon Balls\n11.Silk\n12.Opium\n13.Tobacco\n14.Lemons\n\n15.Go Back"));

                if(sellingIndex > 0 && sellingIndex < 15)
                {
                    valid = 'v';
                }
                else if (sellingIndex==15)
                {
                    enterTown(nextTown);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please enter a valid option!","Invalid selection!",JOptionPane.ERROR_MESSAGE);
                    valid = 'd';
                }
            }while(valid == 'd');

            do {
                int sellingQuantity = Integer.parseInt(JOptionPane.showInputDialog("How many " + towns[nextTown].merchantStock[sellingIndex-1].getName() + " would you like to sell?"));

                if(sellingQuantity > GameManager.playerCrew.cargo[sellingIndex-1].getQuantity())
                {
                    JOptionPane.showMessageDialog(null,"You do not have enough " + towns[nextTown].merchantStock[sellingIndex-1].getName() + " to sell to the merchant! Please input a different quantity.","Invalid selection!",JOptionPane.ERROR_MESSAGE);
                    valid2 = 'd';
                }
                else if(sellingQuantity <= 0)
                {
                    JOptionPane.showMessageDialog(null,"Quantity must be a positive number, please enter a different quantity","Invalid selection!",JOptionPane.ERROR_MESSAGE);
                    valid2 = 'd';
                }
                else
                {
                    GameManager.playerCrew.setMoney(GameManager.playerCrew.getMoney() + towns[nextTown].merchantStock[sellingIndex-1].getMerchantBuyPrice() * sellingQuantity);
                    GameManager.playerCrew.alterCargoQuantity(sellingIndex-1, GameManager.playerCrew.cargo[sellingIndex-1].getQuantity() -sellingQuantity);
                    towns[nextTown].merchantStock[sellingIndex-1].setQuantity(towns[nextTown].merchantStock[sellingIndex-1].getQuantity() + sellingQuantity);

                    JOptionPane.showMessageDialog(null, "You have sold " + sellingQuantity + " " + towns[nextTown].merchantStock[sellingIndex-1].getName() + " for " + towns[nextTown].merchantStock[sellingIndex-1].getMerchantBuyPrice() * sellingQuantity + " doubloons", "Transaction Successful", JOptionPane.INFORMATION_MESSAGE);
                    valid2 = 'v';
                }
            }while(valid2 == 'd');

            enterTrader();
        }

        private static void displayRates()
        {
            JTextArea jta = new JTextArea(towns[nextTown].merchantStockAsString(buyingOrSelling));
            JOptionPane.showMessageDialog(null, jta, "Merchant Stock", JOptionPane.PLAIN_MESSAGE);
            enterTrader();
        }

        private static void shipRepairs(int shipHealth)
        {
            char choice = 'd';
            int repairCost = 0;

            if(shipHealth >= 1 && shipHealth <= 3)
            {
                repairCost = 150;
            }
            else if(shipHealth >= 4 && shipHealth <= 7)
            {
                repairCost = 100;
            }
            else if(shipHealth >= 8 && shipHealth <= 9)
            {
                repairCost = 50;
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Your ship is in pristine condition and is not in need of repair.");
                choice = '2';
            }

            do {
                choice = JOptionPane.showInputDialog("You traverse the shipyard until you find a capable carpentry outlet.\n The carpenter informs you that the ship will cost " + repairCost + " to repair.\n" +
                        "\n1.Repair the ship\n2.Leave").charAt(0);

                switch (choice)
                {
                    case '1':
                        if(GameManager.playerCrew.getMoney() < repairCost)
                        {
                            JOptionPane.showMessageDialog(null,"You do not have enough money to repair your ship.","No Doubloons", JOptionPane.INFORMATION_MESSAGE);
                            shipRepairs(GameManager.playerCrew.getShipHealth());
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"The carpenter repairs your ship to pristine condition. You pay him " + repairCost + " doubloons");
                            GameManager.playerCrew.setShipHealth(10);
                            enterTown(nextTown);
                        }
                        break;

                    case '2':
                        enterTown(nextTown);
                        break;

                    default:
                        JOptionPane.showMessageDialog(null,"Please enter a valid choice!", "Error!", JOptionPane.ERROR_MESSAGE);
                        choice = 'd';
                }
            }while(choice == 'd');
        }


}

