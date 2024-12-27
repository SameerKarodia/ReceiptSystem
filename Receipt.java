import java.text.NumberFormat;
import java.util.ArrayList;

public class Receipt {
    private int id;
    private static int idCounter = 1; 
    private Store store;
    private Customer customer;
    private ArrayList<Item> items= new ArrayList<>();
    private double totalofReceipt;
    private Payment payment;

    //constructor
    Receipt(Store store, Customer customer, double totalofReceipt, Payment payment){
        this.id = idCounter++; 
        this.store=store;
        this.totalofReceipt=totalofReceipt;
        this.payment=payment;

    }
    //default constructor 
    public Receipt() {
        this.id = idCounter++; 
        this.store = null; 
        this.customer = null; 
        this.totalofReceipt = 0.0; 
        this.payment = null; 
    }

    //Makes sure that address of receipt isnt shown when viewing receipts
    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(); 

        double taxAmount = totalofReceipt * (ReceiptSystem.tax / 100); // Calculate tax based on the total
        double totalWithTax = totalofReceipt + taxAmount;    // Add tax to the total


        return "---------------Receipt ID= "+id +"---------------\n { "  +  "Store= " + store.getName()+ ", Customer= "  + customer.getName()+  ", Total (no tax)= " + currency.format(totalofReceipt) +  ", Tax (" + ReceiptSystem.tax + "%)= " + currency.format(taxAmount) + ", Total (with tax)= " + currency.format(totalWithTax) +", Payment Method= "+payment.getType() +" }" + 
        " \n \t"  + items + '\n';
    }



    

    //getters
    public int getId(){
        return id;
    }
    public Store getStore(){
        return store;
    }
    public Customer getCustomer(){
        return customer;
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    public double getTotalofReceipt(){
        return totalofReceipt;
    }
    public Payment getPayment(){
        return payment;
    }

    //setters
    public void setId(int id){
        this.id=id;
    }
    public void setStore(Store store){
        this.store=store;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }
    public void setItems(ArrayList<Item> items){
        this.items=items;
    }
    public void setTotalofReceipt(double totalofReceipt){
        this.totalofReceipt=totalofReceipt;
    }
    public void setPayment(Payment payment){
        this.payment=payment;
    }

    //add item to receipt method
    public void addItem(Item item){
        items.add(item);
    }    

    //calculate total for receipt method
    public void calculateTotal(){
        totalofReceipt=0.0;
        for(int i=0;i<items.size();i++){
            Item itemCounter= items.get(i);
            totalofReceipt+=(itemCounter.getPrice()*itemCounter.getQuantity());
        }
    }
    
}
