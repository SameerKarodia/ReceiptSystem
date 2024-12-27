public class cashPayment extends Payment {
    public cashPayment(double amount) {
        //calls parent constructor
        super(amount);
    }

    public String getType() {
        return "Cash";
    }
}
