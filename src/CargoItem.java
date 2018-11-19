public class CargoItem {
    private String name;
    private int quantity;
    private int basePrice;

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

    //Constructors

    //No Args Constructor
    public CargoItem()
    {
        name = "Unknown";
        quantity = 0;
        basePrice = 0;

    }//End No Args Constructor


    //3 Args Constructor
    public CargoItem(String name, int quantity, int basePrice)
    {
        setName(name);
        setQuantity(quantity);
        setBasePrice(basePrice);
    }//End 3 Args Constructor

    @Override
    public String toString() {
        return "Name of Cargo: " + getName() +"\nQuantity of Cargo: " + getQuantity();
    }
}
