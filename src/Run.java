import java.util.List;

public class Run {
    public static void main(String[] args) {
        System.out.println("hello charlie!");
        // read file 1 and create transaction list
        List<List<String>> transactionsTable = CsvReader.readFile("data/transactions.csv");
        List<Transaction> transactions = TransactionParser.readTransactionTable(transactionsTable);

        // read file 2 and create account type mapping
        List<List<String>> accounts = CsvReader.readFile("data/accounts.csv");
        AccountManager accountManager = AccountManager.getAccountManager();
        accountManager.loadAccounts(accounts);

        // evaluate transactions
        PayrollStrengthEvaluator.evaluate(transactions, accountManager);

        for (Transaction t: transactions) {
            System.out.println(String.format("Transaction name: \'%s\" - Signal Strength: %d", t.name, t.paycheckSignalStrength));
        }
    }
}
