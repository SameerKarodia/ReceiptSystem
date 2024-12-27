public class creditPayment extends Payment {
    private String cardNumber;

    public creditPayment(double amount, String cardNumber) {
        //calls parent constructor 
        super(amount);
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return "Credit Card";
    }

    public String toString() {
        return super.toString() + ", Card Number: " + cardNumber;
    }
}
