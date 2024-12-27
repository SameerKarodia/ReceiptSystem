public class debitPayment extends Payment {
    private String cardNumber;

    public debitPayment(double amount, String cardNumber) {
        //for the parent class, calls constructor
        super(amount);
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return "Debit Card";
    }

    public String toString() {
        return super.toString() + ", Card Number: " + cardNumber;
    }
}
