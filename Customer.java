import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Receipt> receipts= new ArrayList<>();

    public Customer(String name){
        this.name=name;
    }

    //getters
    public String getName(){
        return name;
    }
    public ArrayList<Receipt> getReceipts(){
        return receipts;
    }

    //setters
    public void setName(String name){
        this.name=name;
    }
    public void setReceipts(ArrayList<Receipt> receipts){
        this.receipts=receipts;
    }

    //add receipt to customer method
    public void addReceipt(Receipt receipt){
        receipts.add(receipt);
    }

    //view receipts based on customer
    public void viewReceipts() {
        for (Receipt receipt : receipts) {
            System.out.println(receipt); 
        }
    }
    

}
