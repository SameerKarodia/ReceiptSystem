import java.text.NumberFormat;
import java.util.ArrayList;


public class Report {

    // Spending by customer
    public static void spendingByCustomer(ArrayList<Customer> customers) {
        NumberFormat currency = NumberFormat.getCurrencyInstance(); 
        System.out.println("-----Spending by Customer-----");

        for (Customer customer : customers) {
            double totalSpent = 0;
            for (Receipt receipt : customer.getReceipts()) {
                totalSpent += receipt.getTotalofReceipt();
            }
            System.out.println("Customer: " + customer.getName() + ", Total Spent: " + currency.format(totalSpent));
        }
        System.out.println("\n");

    }

    // Spending by store
    public static void spendingByStore(ArrayList<Store> stores) {
        NumberFormat currency = NumberFormat.getCurrencyInstance(); 

        System.out.println("-----Spending by Store-----");

        for (Store store : stores) {
            double totalSpent = 0;

            for (Receipt receipt : store.getReceipts()) {
                totalSpent += receipt.getTotalofReceipt();
            }
            System.out.println("Store: " + store.getName() + " (" + store.getType() + "), Total Spent: " + currency.format(totalSpent));
        }
        System.out.println("\n");
    }

    //Spending by item
    public static void spendingByItem(ArrayList<Receipt> receipts) {
        System.out.println("-----Spending by Item----- ");
        NumberFormat currency = NumberFormat.getCurrencyInstance(); 

        ArrayList<String> processedItems = new ArrayList<>(); // To keep track of already processed items

        //iterates through all receipts and items
        for (Receipt receipt : receipts) {

            for (Item item : receipt.getItems()) {
                
                //checks if item has already been seen/processed, skips if it is to avoid dupllicates
                if (!processedItems.contains(item.getName())) {

                    // If the item hasn't been processed yet, calculate its total spending
                    double totalSpentOnItem = 0;
                    
                    //iterates through all receipts again to calculate spendinf for each item
                    for (Receipt innerReceipt : receipts) {
                        
                        //if item is in the receipt add up the total costs
                        for (Item innerItem : innerReceipt.getItems()) {
                            //
                            if (innerItem.getName().equalsIgnoreCase(item.getName())) {
                                totalSpentOnItem += innerItem.getPrice() * innerItem.getQuantity();
                            }
                        }
                    }
                    // Print the result and mark the item as processed
                    System.out.println("Item: " + item.getName() + ", Total Spent: " + currency.format(totalSpentOnItem));
                    processedItems.add(item.getName());
                }
            }
        }
        System.out.println("\n");

    }
}
