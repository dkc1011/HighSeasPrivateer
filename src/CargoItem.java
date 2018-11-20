public class CargoItem {
    private String name;
    private int quantity;
    private int basePrice;
    private int merchantBuyPrice;
    private int merchantSellPrice;

    //Setters

    public void setName(String name) {
        this.name = name;
    }//End setName()


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }//End setQuantity


    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }//End setBasePrice

    public void setMerchantBuyPrice(int merchantBuyPrice)
    {
        this.merchantBuyPrice = merchantBuyPrice;
    }//End setMerchantBuyPrice

    public void setMerchantSellPrice(int merchantSellPrice) {
        this.merchantSellPrice = merchantSellPrice;
    }

    //Getters

    public String getName() {
        return name;
    }//End getName()


    public int getQuantity() {
        return quantity;
    }//End getQuantity()


    public int getBasePrice() {
        return basePrice;
    }//End getBasePrice()

    public int getMerchantBuyPrice() {
        return merchantBuyPrice;
    }

    public int getMerchantSellPrice() {
        return merchantSellPrice;
    }

    //Constructors

    //No Args Constructor
    public CargoItem()
    {
        name = "Unknown";
        quantity = 0;
        basePrice = 0;
        merchantBuyPrice = 0;
        merchantSellPrice = 0;

    }//End No Args Constructor


    //3 Args Constructor
    public CargoItem(String name, int quantity, int basePrice, int merchantBuyPrice, int merchantSellPrice)
    {
        setName(name);
        setQuantity(quantity);
        setBasePrice(basePrice);
        setMerchantBuyPrice(merchantBuyPrice);
        setMerchantSellPrice(merchantSellPrice);
    }//End 3 Args Constructor

    @Override
    public String toString() {
        return "Name of Cargo: " + getName() +"\nQuantity of Cargo: " + getQuantity();
    }
}
