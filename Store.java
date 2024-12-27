import java.util.ArrayList;

public class Store {
    private String name;
    private ArrayList <Receipt> receipts = new ArrayList<>();
    private String type;
    
    //constructor
    public Store(String name,String type){
        this.name=name;
        this.receipts= new ArrayList<>();
        this.type=type;

    }

    //getters
    public String getName(){
        return name;
    }
    public ArrayList<Receipt> getReceipts(){
        return receipts;
    }
    public String getType(){
        return type;
    }

    //setters
    public void setName(String name){
        this.name=name;
    }
    public void setReceipts(ArrayList<Receipt> receipts){
        this.receipts=receipts;
    }
    public void setType(String type){
        this.type=type;
    }


    //add receipt to store method
    public void addReceipt(Receipt receipt){
        receipts.add(receipt);

    }
    //view receipts based on store
    public void viewReceipts() {
        for (Receipt receipt : receipts) {
            System.out.println(receipt); 
        }
    }
    
}
