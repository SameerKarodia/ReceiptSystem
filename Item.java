public class Item {
    private String name;
    private double price;
    private int quantity;

    //constructor
    public Item(String name, double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;

    }
    @Override
    public String toString() {
    return " Item { Name= " + name + ", Price= " + price + ", Quantity= " + quantity + "} \n \t";
    }

    //getters
    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }


    //setters
    public void setName( String name){
        this.name=name;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    
}
