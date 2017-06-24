
public class Transaction {
    String name;
    double quantity;
    String date;
    String accountId;
    Integer paycheckSignalStrength = 0;


    public Transaction(String name, String quantity, String date, String accountId) {
        this.name = name;
        this.quantity = Double.parseDouble(quantity);
        this.date = date;
        this.accountId = accountId;
    }
}
