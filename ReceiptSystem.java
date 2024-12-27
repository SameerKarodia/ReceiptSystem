import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReceiptSystem {
    public static double tax=13;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create a list to store receipts
        ArrayList<Receipt> receipts = new ArrayList<>();
        // Create a list to store customers
        ArrayList<Customer> customers = new ArrayList<>();
        // Create a list to store stores
        ArrayList<Store> stores = new ArrayList<>();
        
        // Main loop to interact with the user
        while (true) {
            System.out.println("1. Add Receipt");
            System.out.println("2. View Receipts");
            System.out.println("3. Generate Reports");
            System.out.println("4. Incorporate Tax? (default will be 13%)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = validateInteger(1, 2, 3, 4, 5);
            

            
            switch (choice) {
                case 1:
                    // Add a receipt
                    Receipt receipt = new Receipt();
                    System.out.println("Enter store name: ");
                    String storeName = scanner.next();
                    
                    
                    // Check if the store already exists before adding it
                    Store store = findStoreByName(stores, storeName);
                    if (store == null) {
                        System.out.println("Store type: (Grocery, Clothing, Electronics, Restaurant, Furniture or Miscellaneous) ");
                        String storeType = validateString("Grocery", "Clothing", "Electronics", "Restaurant", "Furniture", "Miscellaneous");
                        store = new Store(storeName, storeType);
                        stores.add(store);
                    }
                    receipt.setStore(store);
                    
                    System.out.println("Enter customer name: ");
                    String customerName = scanner.next();
                    
                    // Check if the customer already exists before adding it
                    Customer customer = findCustomerByName(customers, customerName);
                    if (customer == null) {
                        customer = new Customer(customerName);
                        customers.add(customer);
                    }
                    receipt.setCustomer(customer);
                    
                    // Add items to the receipt
                    while (true) {
                        System.out.println("Enter item name (or 'done' to finish): ");
                        String itemName = scanner.next();
                        if (itemName.equals("done")) {
                            break;
                        }
                        System.out.println("Enter item price: ");
                        double price = validateDouble();
                        System.out.println("Enter item quantity: ");
                        int quantity = validateInt();
                        Item item = new Item(itemName, price, quantity);
                        receipt.addItem(item);
                    }

                    //get payment method
                    System.out.println("Enter payment method (1 for Cash, 2 for Credit Card, 3 for Debit Card): ");
                    int paymentChoice = validateInteger(1, 2, 3);

                    //calculate total of receipt 
                    receipt.calculateTotal();
                    double amount=receipt.getTotalofReceipt();
    
                    Payment payment = null; 
                    
                    //for different methods of payment
                    switch (paymentChoice) {
                        case 1: // Cash Payment
                            
                            payment = new cashPayment(amount);
                            break;
                        
                        case 2: // Credit Card Payment
                            
                            System.out.println("Enter credit card number: ");
                            String creditCardNumber = scanner.next();
                            payment = new creditPayment(amount, creditCardNumber);
                            break;
                    
                        case 3: // Debit Card Payment
                            
                            System.out.println("Enter debit card number: ");
                            String debitCardNumber = scanner.next();
                            payment = new debitPayment(amount, debitCardNumber);
                            break;
                    
                        default:
                            System.out.println("Invalid payment method selected.");
                            break;
                    }

                    //adds payment to respective receipt
                    receipt.setPayment(payment);
                    
                    //add receipt to lists
                    receipts.add(receipt);
                    store.addReceipt(receipt);
                    customer.addReceipt(receipt);
                    break;
                    
                case 2:
                    // View receipts
                    System.out.println("View receipts by:");
                    System.out.println("1. Customer");
                    System.out.println("2. Store");
                    System.out.print("Enter your choice: ");
                    int viewChoice = validateInteger(1,2);
                    
                    if (viewChoice == 1) {
                        System.out.print("Enter customer name: ");
                        String customerNameToView = scanner.next();
                        Customer customerToView = findCustomerByName(customers, customerNameToView);
                        if (customerToView != null) {
                            customerToView.viewReceipts();
                        } else {
                            System.out.println("Customer not found.");
                        }
                    } else if (viewChoice == 2) {
                        System.out.print("Enter store name: ");
                        String storeNameToView = scanner.next();
                        Store storeToView = findStoreByName(stores, storeNameToView);
                        if (storeToView != null) {
                            storeToView.viewReceipts();
                        } else {
                            System.out.println("Store not found.");
                        }
                    }
                    break;
                    
                case 3: 
                    // Generate Reports
                    System.out.println("Generate Reports:");
                    System.out.println("1. Spending by Customer");
                    System.out.println("2. Spending by Store");
                    System.out.println("3. Spending by Item");
                    System.out.print("Enter your choice: ");
                    int reportChoice = validateInteger(1, 2, 3);
                    System.out.println("\n");


                    switch (reportChoice) {
                        case 1:
                            Report.spendingByCustomer(customers);
                            break;
                        case 2:
                            Report.spendingByStore(stores);
                            break;
                        case 3:
                            Report.spendingByItem(receipts);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                
                    
                case 4:
                    //calculates/sets tax
                    System.out.println("The current tax rate is: " + tax + "%");
                    System.out.println("Enter the new tax rate (%): ");
                    
                    while (true) {
                        try {
                            tax = validateDouble(); // Use the validateDouble method for input validation
                            System.out.println("Tax rate has been updated to " + tax + "%.");
                            break; // Exit the loop once a valid tax rate is entered
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid tax percentage.");
                        }
                    }
                    break;
                
                

                case 5:
                    // Exit
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }

    }

    
    // Helper methods
    private static int validateInteger(int... allowedValues) {
        Scanner inputscanner = new Scanner(System.in);
    
        while (true) {
            System.out.print("Please enter your choice: ");
            if (inputscanner.hasNextInt()) {
                int userInput = inputscanner.nextInt();
    
                // Verify if input is in the allowed list
                for (int value : allowedValues) {
                    if (value == userInput) {
                        return userInput;
                    }
                }
                System.out.println("Invalid selection. Options are: " + Arrays.toString(allowedValues));
            } else {
                System.out.println("Error: Please provide a valid integer.");
                inputscanner.next(); 
            }
        }
    }
    private static int validateInt() {
        Scanner inputscanner = new Scanner(System.in);
    
        while (true) {
            if (inputscanner.hasNextInt()) {
                return inputscanner.nextInt();
            } else {
                System.out.println("Invalid input. Please provide a valid integer."); 
                inputscanner.next(); 
            }
        }
    }

    private static double validateDouble() {
        Scanner inputscanner = new Scanner(System.in);
    
        while (true) {
            if (inputscanner.hasNextDouble()) {
                double userInput = inputscanner.nextDouble();
                inputscanner.nextLine(); 
                return userInput;
            } else {
                System.out.println("Invalid input. Please provide a valid decimal number."); 
                inputscanner.next(); 
            }
        }
    }
    
    
    

    private static String validateString(String... acceptableValues) {
        Scanner inputscanner = new Scanner(System.in);
    
        while (true) {
            System.out.print("Enter your input: ");
            String userInput = inputscanner.nextLine();
    
            // Checks if the input matches any of the acceptable values (case-insensitive)
            for (String value : acceptableValues) {
                if (value.equalsIgnoreCase(userInput)) {
                    return userInput;
                }
            }
    
            System.out.println("Invalid input. Please choose one of the following options:\n"  + Arrays.toString(acceptableValues));
        }
    }
    
    
    private static Store findStoreByName(ArrayList<Store> stores, String name) {
        // Loops through all the stores and returns respective store if found
        for (Store store : stores) {

            if (store.getName().equalsIgnoreCase(name)) {
                return store; 

            }
        }
        //returns null if none found
        return null;
    }

    private static Customer findCustomerByName(ArrayList<Customer> customers, String name) {
        // Loops through all the customers and returns respective customer if found
        for (Customer customer : customers) {
            
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer; 

            }
        }
        //returns null if none found
        return null;
    }
}
