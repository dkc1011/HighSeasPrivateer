//Town.java by Daragh Carroll t00201097
public class Town
{
    private String townName;
    private int distanceFromStart;
    private int distanceFromPlayer;
    public CargoItem[] merchantStock = new CargoItem[14];


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

    //Additional Methods

    public void alterStockQuantity(int stockIndex, int newQuantity)
    {
        merchantStock[stockIndex].setQuantity(newQuantity);
    }

    public void generateMerchantStockNamesAndBasePrices()
    {
        for (int i = 0; i < merchantStock.length; i++)
        {
            CargoItem stock = new CargoItem();
            stock.setName(GameManager.playerCrew.cargo[i].getName());
            stock.setBasePrice(GameManager.playerCrew.cargo[i].getBasePrice());
            merchantStock[i] = stock;
        }
    }

    public void generateMerchantQuantities()
    {
        for (int i = 0; i<merchantStock.length; i++)
        {
            if(merchantStock[i].getBasePrice() >= 0 && merchantStock[i].getBasePrice() <= 5)
            {
                merchantStock[i].setQuantity(Event.randomIntegerGenerator(75, 110));
            }
            else if(merchantStock[i].getBasePrice() >= 6 && merchantStock[i].getBasePrice() <= 11)
            {
                merchantStock[i].setQuantity(Event.randomIntegerGenerator(45, 80));
            }
            else if(merchantStock[i].getBasePrice() >= 12 && merchantStock[i].getBasePrice() <= 18)
            {
                merchantStock[i].setQuantity(Event.randomIntegerGenerator(25, 60));
            }
            else if(merchantStock[i].getBasePrice() >=19 && merchantStock[i].getBasePrice() <= 25)
            {
                merchantStock[i].setQuantity(Event.randomIntegerGenerator(15, 45));
            }
            else if(merchantStock[i].getBasePrice() >=26 && merchantStock[i].getBasePrice() <= 50)
            {
                merchantStock[i].setQuantity(Event.randomIntegerGenerator(10, 35));
            }
            else if(merchantStock[i].getBasePrice() >=51 && merchantStock[i].getBasePrice() <= 100)
            {
                merchantStock[i].setQuantity(Event.randomIntegerGenerator(10, 30));
            }

        }//End for
    }//End generateMerchantQuantities()

    public void generateMerchantPrices()
    {
        for (int i = 0; i<merchantStock.length; i++)
        {
            if(merchantStock[i].getQuantity() >= 0 && merchantStock[i].getQuantity() <= 20)
            {
                merchantStock[i].setMerchantBuyPrice(merchantStock[i].getBasePrice() + Event.randomIntegerGenerator(10, 20) * 5);
                merchantStock[i].setMerchantSellPrice(merchantStock[i].getBasePrice() + Event.randomIntegerGenerator(10, 15) * 5);
            }
            else if(merchantStock[i].getQuantity() >= 21 && merchantStock[i].getQuantity() <= 40)
            {
                merchantStock[i].setMerchantBuyPrice(merchantStock[i].getBasePrice() + Event.randomIntegerGenerator(8, 18) * 4);
                merchantStock[i].setMerchantSellPrice(merchantStock[i].getBasePrice() + Event.randomIntegerGenerator(8, 13) * 4);
            }
            else if(merchantStock[i].getQuantity() >= 41 && merchantStock[i].getQuantity() <= 60)
            {
                merchantStock[i].setMerchantBuyPrice(merchantStock[i].getBasePrice() + Event.randomIntegerGenerator(6, 16) * 3);
                merchantStock[i].setMerchantSellPrice(merchantStock[i].getBasePrice() + Event.randomIntegerGenerator(6, 11) * 3);
            }
            else if(merchantStock[i].getQuantity() >= 61 && merchantStock[i].getQuantity() <= 80)
            {
                merchantStock[i].setMerchantBuyPrice(merchantStock[i].getBasePrice() + Event.randomIntegerGenerator(4, 14) * 2);
                merchantStock[i].setMerchantSellPrice(merchantStock[i].getBasePrice() + Event.randomIntegerGenerator(4, 9) * 2);
            }
            else if(merchantStock[i].getQuantity() >= 81 && merchantStock[i].getQuantity() <= 100)
            {
                merchantStock[i].setMerchantBuyPrice(merchantStock[i].getBasePrice() + Event.randomIntegerGenerator(2, 8));
                merchantStock[i].setMerchantSellPrice(merchantStock[i].getBasePrice() + Event.randomIntegerGenerator(1, 4));
            }
            else
            {
                merchantStock[i].setMerchantBuyPrice(merchantStock[i].getBasePrice());
                merchantStock[i].setMerchantSellPrice(merchantStock[i].getBasePrice() - Event.randomIntegerGenerator(2, 6));
            }


            if (merchantStock[i].getMerchantBuyPrice() < 0)
            {
                merchantStock[i].setMerchantBuyPrice(0);
            }

            if(merchantStock[i].getMerchantSellPrice() < 0)
            {
                merchantStock[i].setMerchantSellPrice(0);
            }
        }//End for
    }//End generateMerchantPrices()

    public String merchantStockAsString(char buyingOrSelling)
    {
        String stockSheet="~~~~~ Price List ~~~~~\n\n";

        if(buyingOrSelling == 'B')
        {
            for (int i = 0; i < merchantStock.length; i++)
            {
                stockSheet += "Item: " + merchantStock[i].getName() + "\n" +
                        "Available Stock: " + merchantStock[i].getQuantity() + "\n" +
                        "Buy Price: " + merchantStock[i].getMerchantBuyPrice() + "\n\n";
            }
        }
        else if(buyingOrSelling == 'S')
        {
            for (int i = 0; i < merchantStock.length; i++)
            {
                stockSheet += "Item: " + merchantStock[i].getName() + "\n" +
                        "Available Stock: " + merchantStock[i].getQuantity() + "\n" +
                        "Sell Price: " + merchantStock[i].getMerchantSellPrice() + "\n\n";
            }
        }

        return stockSheet;
    }
}